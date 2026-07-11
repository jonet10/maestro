-- ========================================================
-- MIGRATION: 022_internationalization.sql
-- OBJECTIF : Système de langues (i18n), pays, fuseaux horaires, disponibilités extensibles et préférences
-- DEPENDANCES : profiles
-- ========================================================

-- A. Ajout des colonnes d'internationalisation à la table profiles
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS country_code TEXT;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS preferred_language TEXT;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS timezone TEXT;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS accept_game_invites BOOLEAN DEFAULT true NOT NULL;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS preferred_match_language TEXT;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS featured_player_id UUID;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS onboarding_completed BOOLEAN DEFAULT false NOT NULL;

-- B. Extension extensible de la table user_availabilities
ALTER TABLE public.user_availabilities ADD COLUMN IF NOT EXISTS created_at TIMESTAMPTZ DEFAULT NOW() NOT NULL;
ALTER TABLE public.user_availabilities ADD COLUMN IF NOT EXISTS type TEXT DEFAULT 'regular' CHECK (type IN ('regular', 'temporary', 'event'));

-- C. Activation et configuration des politiques RLS pour user_availabilities
ALTER TABLE public.user_availabilities ENABLE ROW LEVEL SECURITY;

DROP POLICY IF EXISTS "Availabilities view policy" ON public.user_availabilities;
CREATE POLICY "Availabilities view policy" ON public.user_availabilities
  FOR SELECT USING (true);

DROP POLICY IF EXISTS "Availabilities insert policy" ON public.user_availabilities;
CREATE POLICY "Availabilities insert policy" ON public.user_availabilities
  FOR INSERT WITH CHECK (auth.uid() = user_id);

DROP POLICY IF EXISTS "Availabilities update policy" ON public.user_availabilities;
CREATE POLICY "Availabilities update policy" ON public.user_availabilities
  FOR UPDATE USING (auth.uid() = user_id) WITH CHECK (auth.uid() = user_id);

DROP POLICY IF EXISTS "Availabilities delete policy" ON public.user_availabilities;
CREATE POLICY "Availabilities delete policy" ON public.user_availabilities
  FOR DELETE USING (auth.uid() = user_id);

-- D. Création d'index de performance
CREATE INDEX IF NOT EXISTS idx_user_availabilities_user_id ON public.user_availabilities(user_id);
CREATE INDEX IF NOT EXISTS idx_user_availabilities_day_of_week ON public.user_availabilities(day_of_week);

-- E. Mise à jour de la fonction trigger handle_new_user
CREATE OR REPLACE FUNCTION public.handle_new_user()
RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO public.profiles (
    id, 
    username, 
    avatar_url, 
    role, 
    is_banned, 
    elo_rating,
    country_code,
    preferred_language,
    timezone,
    accept_game_invites,
    preferred_match_language,
    onboarding_completed
  )
  VALUES (
    new.id,
    COALESCE(new.raw_user_meta_data->>'username', 'User_' || substring(new.id::text from 1 for 8)),
    new.raw_user_meta_data->>'avatar_url',
    'player',
    false,
    1000,
    new.raw_user_meta_data->>'country_code',
    new.raw_user_meta_data->>'preferred_language',
    new.raw_user_meta_data->>'timezone',
    COALESCE((new.raw_user_meta_data->>'accept_game_invites')::boolean, true),
    new.raw_user_meta_data->>'preferred_match_language',
    COALESCE((new.raw_user_meta_data->>'onboarding_completed')::boolean, false)
  )
  ON CONFLICT (id) DO NOTHING;
  RETURN new;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

-- F. Initialisation de la configuration des langues activées dans system_settings
INSERT INTO public.system_settings (key, value, description)
VALUES (
  'enabled_languages',
  '["fr", "ht", "en", "es", "pt"]'::jsonb,
  'Liste des langues activées sur la plateforme'
)
ON CONFLICT (key) DO UPDATE
SET value = EXCLUDED.value;

-- G. Configuration RLS pour la table system_settings
ALTER TABLE public.system_settings ENABLE ROW LEVEL SECURITY;

DROP POLICY IF EXISTS "System settings read policy" ON public.system_settings;
CREATE POLICY "System settings read policy" ON public.system_settings
  FOR SELECT USING (true);

DROP POLICY IF EXISTS "System settings write policy" ON public.system_settings;
CREATE POLICY "System settings write policy" ON public.system_settings
  FOR ALL TO authenticated
  USING (
    EXISTS (
      SELECT 1 FROM public.profiles
      WHERE id = auth.uid() AND role IN ('admin', 'super-admin')
    )
  )
  WITH CHECK (
    EXISTS (
      SELECT 1 FROM public.profiles
      WHERE id = auth.uid() AND role IN ('admin', 'super-admin')
    )
  );

-- H. Modification de la contrainte CHECK sur tournaments.max_participants pour autoriser 2 joueurs
ALTER TABLE public.tournaments DROP CONSTRAINT IF EXISTS tournaments_max_participants_check;
ALTER TABLE public.tournaments ADD CONSTRAINT tournaments_max_participants_check CHECK (max_participants IN (2, 4, 8, 16, 32));

-- I. Mise à jour de start_tournament pour notifier les joueurs lors du lancement
CREATE OR REPLACE FUNCTION public.start_tournament(p_tournament_id UUID)
RETURNS VOID AS $$
DECLARE
  t_row public.tournaments%ROWTYPE;
  p_ids UUID[];
  p_count INT;
  m_count INT;
  r_id UUID;
  creator_name TEXT;
  opponent_name TEXT;
BEGIN
  -- Vérifier si l'utilisateur est admin
  IF NOT EXISTS (SELECT 1 FROM public.profiles WHERE id = auth.uid() AND role IN ('admin', 'super-admin')) THEN
    RAISE EXCEPTION 'Non autorisé.';
  END IF;

  SELECT * INTO t_row FROM public.tournaments WHERE id = p_tournament_id;
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Tournoi introuvable.';
  END IF;

  IF t_row.status <> 'upcoming' THEN
    RAISE EXCEPTION 'Ce tournoi a déjà démarré.';
  END IF;

  -- Récupérer la liste des participants
  SELECT ARRAY(
    SELECT player_id FROM public.tournament_participants 
    WHERE tournament_id = p_tournament_id
    ORDER BY random() -- Shuffling
  ) INTO p_ids;

  p_count := array_length(p_ids, 1);
  IF p_count IS NULL OR p_count <> t_row.max_participants THEN
    RAISE EXCEPTION 'Le nombre de participants inscrit (% ) ne correspond pas à la taille du tournoi (%).', COALESCE(p_count, 0), t_row.max_participants;
  END IF;

  -- Mettre à jour le statut du tournoi
  UPDATE public.tournaments SET status = 'active' WHERE id = p_tournament_id;

  -- Générer les matchs du Round 1 (Index 0 .. N/2 - 1)
  m_count := t_row.max_participants / 2;
  FOR i IN 0..(m_count - 1) LOOP
    
    -- Récupérer les noms d'utilisateurs pour nommer le salon
    SELECT username INTO creator_name FROM public.profiles WHERE id = p_ids[2 * i + 1];
    SELECT username INTO opponent_name FROM public.profiles WHERE id = p_ids[2 * i + 2];

    -- Créer la room privée
    INSERT INTO public.rooms (name, creator_id, opponent_id, status, visibility, target_score, deal_option, game_state)
    VALUES (
      'Tournoi - ' || t_row.name || ' (R1 - M' || i || ')',
      p_ids[2 * i + 1],
      p_ids[2 * i + 2],
      'active',
      'private',
      t_row.target_score,
      'auto',
      '{"matchStatus": "not-started"}'::jsonb
    ) RETURNING id INTO r_id;

    -- Créer le match lié
    INSERT INTO public.tournament_matches (tournament_id, round_number, match_index, player1_id, player2_id, room_id, status)
    VALUES (p_tournament_id, 1, i, p_ids[2 * i + 1], p_ids[2 * i + 2], r_id, 'scheduled');

    -- Notifier le Joueur 1 (creator)
    INSERT INTO public.notifications (user_id, type, payload)
    VALUES (
      p_ids[2 * i + 1],
      'invite',
      jsonb_build_object(
        'sender_id', auth.uid(),
        'room_id', r_id,
        'message', 'Votre match de tournoi "' || t_row.name || '" a commencé ! Rejoignez le salon.'
      )
    );

    -- Notifier le Joueur 2 (opponent)
    INSERT INTO public.notifications (user_id, type, payload)
    VALUES (
      p_ids[2 * i + 2],
      'invite',
      jsonb_build_object(
        'sender_id', auth.uid(),
        'room_id', r_id,
        'message', 'Votre match de tournoi "' || t_row.name || '" a commencé ! Rejoignez le salon.'
      )
    );
  END LOOP;

  -- Journaliser
  INSERT INTO public.admin_logs (admin_id, action, target_type, target_id, details)
  VALUES (auth.uid(), 'START_TOURNAMENT', 'tournament', p_tournament_id::text, 'Tournoi démarré avec ' || p_count || ' participants.');
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;
