-- ========================================================
-- 1. SCHÉMA DE BASE : PROFILS, CLASSEMENT ET BANNIÈRES
-- ========================================================

-- Ajouter le rôle, le statut de bannissement et le classement ELO aux profils
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS role TEXT DEFAULT 'player' CHECK (role IN ('player', 'admin', 'super-admin'));
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS is_banned BOOLEAN DEFAULT false;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS elo_rating INT DEFAULT 1000;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS tournaments_won INT DEFAULT 0;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS current_streak INT DEFAULT 0;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS max_streak INT DEFAULT 0;

-- ========================================================
-- 2. TABLES POUR LE SYSTÈME DE CHAMPIONNAT / TOURNOI
-- ========================================================

-- Table des tournois
CREATE TABLE IF NOT EXISTS public.tournaments (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  name TEXT NOT NULL,
  status TEXT DEFAULT 'upcoming' NOT NULL CHECK (status IN ('upcoming', 'active', 'finished')),
  max_participants INT DEFAULT 8 NOT NULL CHECK (max_participants IN (4, 8, 16, 32)),
  target_score INT DEFAULT 100 NOT NULL,
  winner_id UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL
);

-- Inscriptions aux tournois
CREATE TABLE IF NOT EXISTS public.tournament_participants (
  tournament_id UUID REFERENCES public.tournaments(id) ON DELETE CASCADE NOT NULL,
  player_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
  registered_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL,
  PRIMARY KEY (tournament_id, player_id)
);

-- Index pour accélérer les jointures
CREATE INDEX IF NOT EXISTS idx_participants_player ON public.tournament_participants(player_id);

-- Matchs de tournois
CREATE TABLE IF NOT EXISTS public.tournament_matches (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  tournament_id UUID REFERENCES public.tournaments(id) ON DELETE CASCADE NOT NULL,
  round_number INT NOT NULL, -- 1: Quarts (si 8 joueurs), 2: Demis, 3: Finale
  match_index INT NOT NULL,  -- Index du match dans ce round (ex: 0, 1, 2, 3)
  player1_id UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
  player2_id UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
  room_id UUID REFERENCES public.rooms(id) ON DELETE SET NULL,
  winner_id UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
  status TEXT DEFAULT 'scheduled' NOT NULL CHECK (status IN ('scheduled', 'ongoing', 'finished')),
  created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_matches_tournament ON public.tournament_matches(tournament_id);
CREATE INDEX IF NOT EXISTS idx_matches_room ON public.tournament_matches(room_id);

-- ========================================================
-- 3. JOURNALISATION ADMINISTRATIVE (LOGS)
-- ========================================================

-- Table de journalisation des actions admin
CREATE TABLE IF NOT EXISTS public.admin_logs (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  admin_id UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
  action TEXT NOT NULL, -- ex: 'BAN_USER', 'UNBAN_USER', 'PROMOTE_USER', 'CREATE_TOURNAMENT', 'START_TOURNAMENT'
  target_type TEXT NOT NULL, -- 'player', 'tournament', 'system'
  target_id TEXT,
  details TEXT,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL
);

-- ========================================================
-- 4. SUCCÈS (ACHIEVEMENTS)
-- ========================================================

-- Catalogue des succès (statique)
CREATE TABLE IF NOT EXISTS public.achievements (
  id TEXT PRIMARY KEY,
  title TEXT NOT NULL,
  description TEXT NOT NULL,
  icon TEXT NOT NULL -- ex: 'Trophy', 'Award', 'Zap'
);

INSERT INTO public.achievements (id, title, description, icon) VALUES
  ('first_win', 'Première Victoire', 'Gagnez votre premier match en ligne', 'Award'),
  ('ten_wins', 'Grand Compétiteur', 'Gagnez 10 matchs en ligne', 'Trophy'),
  ('hundred_wins', 'Légende vivante', 'Gagnez 100 matchs en ligne', 'Crown'),
  ('tournament_champion', 'Champion de Tournoi', 'Remportez un championnat officiel', 'Trophy'),
  ('streak_5', 'En Feu !', 'Atteignez une série de 5 victoires consécutives', 'Zap')
ON CONFLICT (id) DO UPDATE SET title = EXCLUDED.title, description = EXCLUDED.description, icon = EXCLUDED.icon;

-- Succès débloqués par les joueurs
CREATE TABLE IF NOT EXISTS public.user_achievements (
  player_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
  achievement_id TEXT REFERENCES public.achievements(id) ON DELETE CASCADE NOT NULL,
  unlocked_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL,
  PRIMARY KEY (player_id, achievement_id)
);

CREATE INDEX IF NOT EXISTS idx_user_achievements_player ON public.user_achievements(player_id);

-- ========================================================
-- 5. POLITIQUES DE SÉCURITÉ RLS
-- ========================================================

ALTER TABLE public.tournaments ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.tournament_participants ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.tournament_matches ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.admin_logs ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.achievements ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.user_achievements ENABLE ROW LEVEL SECURITY;

-- Nettoyage des politiques existantes si présentes (pour ré-exécutabilité)
DROP POLICY IF EXISTS "Public Read Tournaments" ON public.tournaments;
DROP POLICY IF EXISTS "Public Read Participants" ON public.tournament_participants;
DROP POLICY IF EXISTS "Public Read Matches" ON public.tournament_matches;
DROP POLICY IF EXISTS "Public Read Achievements" ON public.achievements;
DROP POLICY IF EXISTS "Public Read User Achievements" ON public.user_achievements;
DROP POLICY IF EXISTS "Admin Write Tournaments" ON public.tournaments;
DROP POLICY IF EXISTS "Admin Write Matches" ON public.tournament_matches;
DROP POLICY IF EXISTS "Admin Read Logs" ON public.admin_logs;
DROP POLICY IF EXISTS "Admin Insert Logs" ON public.admin_logs;
DROP POLICY IF EXISTS "User Register Participant" ON public.tournament_participants;
DROP POLICY IF EXISTS "User Unregister Participant" ON public.tournament_participants;
DROP POLICY IF EXISTS "Profiles insert policy" ON public.profiles;

-- Politiques de lecture publique
CREATE POLICY "Public Read Tournaments" ON public.tournaments FOR SELECT USING (true);
CREATE POLICY "Public Read Participants" ON public.tournament_participants FOR SELECT USING (true);
CREATE POLICY "Public Read Matches" ON public.tournament_matches FOR SELECT USING (true);
CREATE POLICY "Public Read Achievements" ON public.achievements FOR SELECT USING (true);
CREATE POLICY "Public Read User Achievements" ON public.user_achievements FOR SELECT USING (true);

-- Politiques d'écriture administrateur
CREATE POLICY "Admin Write Tournaments" ON public.tournaments FOR ALL USING (
  EXISTS (SELECT 1 FROM public.profiles WHERE id = auth.uid() AND role IN ('admin', 'super-admin'))
);

CREATE POLICY "Admin Write Matches" ON public.tournament_matches FOR ALL USING (
  EXISTS (SELECT 1 FROM public.profiles WHERE id = auth.uid() AND role IN ('admin', 'super-admin'))
);

CREATE POLICY "Admin Read Logs" ON public.admin_logs FOR SELECT USING (
  EXISTS (SELECT 1 FROM public.profiles WHERE id = auth.uid() AND role IN ('admin', 'super-admin'))
);

CREATE POLICY "Admin Insert Logs" ON public.admin_logs FOR INSERT WITH CHECK (
  EXISTS (SELECT 1 FROM public.profiles WHERE id = auth.uid() AND role IN ('admin', 'super-admin'))
);

-- Inscriptions joueurs (L'utilisateur lui-même ou l'admin)
CREATE POLICY "User Register Participant" ON public.tournament_participants FOR INSERT WITH CHECK (
  (auth.uid() = player_id AND NOT EXISTS (SELECT 1 FROM public.profiles WHERE id = auth.uid() AND is_banned = true))
  OR EXISTS (SELECT 1 FROM public.profiles WHERE id = auth.uid() AND role IN ('admin', 'super-admin'))
);

CREATE POLICY "User Unregister Participant" ON public.tournament_participants FOR DELETE USING (
  auth.uid() = player_id 
  OR EXISTS (SELECT 1 FROM public.profiles WHERE id = auth.uid() AND role IN ('admin', 'super-admin'))
);

-- Auto-heal : Autoriser les utilisateurs à insérer leur propre profil si absent lors de la connexion
CREATE POLICY "Profiles insert policy" ON public.profiles FOR INSERT WITH CHECK (auth.uid() = id);

-- ========================================================
-- 6. DÉCLENCHEURS ET FONCTIONS AUTOMATIQUES (TRIGGERS / RPC)
-- ========================================================

-- RPC : Inscription / Désinscription aux tournois
CREATE OR REPLACE FUNCTION public.register_to_tournament(p_tournament_id UUID)
RETURNS VOID AS $$
DECLARE
  t_row public.tournaments%ROWTYPE;
  p_count INT;
  is_banned_user BOOLEAN;
BEGIN
  SELECT * INTO t_row FROM public.tournaments WHERE id = p_tournament_id;
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Tournoi introuvable.';
  END IF;

  IF t_row.status <> 'upcoming' THEN
    RAISE EXCEPTION 'Le tournoi a déjà commencé ou est terminé.';
  END IF;

  SELECT is_banned INTO is_banned_user FROM public.profiles WHERE id = auth.uid();
  IF is_banned_user = true THEN
    RAISE EXCEPTION 'Vous êtes banni de la plateforme.';
  END IF;

  SELECT COUNT(*) INTO p_count FROM public.tournament_participants WHERE tournament_id = p_tournament_id;
  IF p_count >= t_row.max_participants THEN
    RAISE EXCEPTION 'Le tournoi est complet.';
  END IF;

  INSERT INTO public.tournament_participants (tournament_id, player_id)
  VALUES (p_tournament_id, auth.uid())
  ON CONFLICT DO NOTHING;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

CREATE OR REPLACE FUNCTION public.unregister_from_tournament(p_tournament_id UUID)
RETURNS VOID AS $$
DECLARE
  t_row public.tournaments%ROWTYPE;
BEGIN
  SELECT * INTO t_row FROM public.tournaments WHERE id = p_tournament_id;
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Tournoi introuvable.';
  END IF;

  IF t_row.status <> 'upcoming' THEN
    RAISE EXCEPTION 'Impossible de se désinscrire une fois le tournoi lancé.';
  END IF;

  DELETE FROM public.tournament_participants
  WHERE tournament_id = p_tournament_id AND player_id = auth.uid();
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;


-- RPC : Lancement de tournoi (Administration)
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
  END LOOP;

  -- Journaliser
  INSERT INTO public.admin_logs (admin_id, action, target_type, target_id, details)
  VALUES (auth.uid(), 'START_TOURNAMENT', 'tournament', p_tournament_id::text, 'Tournoi démarré avec ' || p_count || ' participants.');
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;


-- RPC : Bannissement et Administration Joueurs
CREATE OR REPLACE FUNCTION public.admin_set_banned(p_player_id UUID, p_banned BOOLEAN, p_reason TEXT)
RETURNS VOID AS $$
BEGIN
  IF NOT EXISTS (SELECT 1 FROM public.profiles WHERE id = auth.uid() AND role IN ('admin', 'super-admin')) THEN
    RAISE EXCEPTION 'Non autorisé.';
  END IF;

  UPDATE public.profiles SET is_banned = p_banned WHERE id = p_player_id;

  INSERT INTO public.admin_logs (admin_id, action, target_type, target_id, details)
  VALUES (auth.uid(), CASE WHEN p_banned THEN 'BAN_USER' ELSE 'UNBAN_USER' END, 'player', p_player_id::text, p_reason);
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

CREATE OR REPLACE FUNCTION public.admin_update_role(p_player_id UUID, p_role TEXT)
RETURNS VOID AS $$
BEGIN
  IF NOT EXISTS (SELECT 1 FROM public.profiles WHERE id = auth.uid() AND role = 'super-admin') THEN
    RAISE EXCEPTION 'Seul un super-admin peut modifier les rôles.';
  END IF;

  IF p_role NOT IN ('player', 'admin', 'super-admin') THEN
    RAISE EXCEPTION 'Rôle invalide.';
  END IF;

  UPDATE public.profiles SET role = p_role WHERE id = p_player_id;

  INSERT INTO public.admin_logs (admin_id, action, target_type, target_id, details)
  VALUES (auth.uid(), 'PROMOTE_USER', 'player', p_player_id::text, 'Nouveau rôle : ' || p_role);
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

-- ========================================================
-- 7. REFACTORISATION DU DÉCLENCHEUR DE STATISTIQUES (AVEC ELO & BRACKETS)
-- ========================================================

CREATE OR REPLACE FUNCTION public.update_profiles_stats()
RETURNS TRIGGER AS $$
DECLARE
  winner_uuid UUID;
  loser_uuid UUID;
  
  -- Variables ELO
  w_elo INT;
  l_elo INT;
  exp_w NUMERIC;
  exp_l NUMERIC;
  k_factor INT := 32;
  w_new_elo INT;
  l_new_elo INT;

  -- Variables Tournois
  tm_row public.tournament_matches%ROWTYPE;
  t_row public.tournaments%ROWTYPE;
  round_unresolved INT;
  next_round_num INT;
  next_match_idx INT;
  partner_winner_id UUID;
  partner_match_idx INT;
  next_m_id UUID;
  next_room_id UUID;
  creator_name TEXT;
  opponent_name TEXT;
BEGIN
  IF NEW.status = 'finished' AND OLD.status <> 'finished' AND NEW.winner_id IS NOT NULL THEN
    winner_uuid := NEW.winner_id;
    IF winner_uuid = NEW.creator_id THEN
      loser_uuid := NEW.opponent_id;
    ELSE
      loser_uuid := NEW.creator_id;
    END IF;

    -- 1. CLASSEMENT ELO & SÉRIES DE VICTOIRES (STREAKS)
    IF winner_uuid IS NOT NULL AND loser_uuid IS NOT NULL THEN
      -- Récupérer les classements actuels
      SELECT elo_rating INTO w_elo FROM public.profiles WHERE id = winner_uuid;
      SELECT elo_rating INTO l_elo FROM public.profiles WHERE id = loser_uuid;

      -- Formule ELO Standard
      exp_w := 1.0 / (1.0 + pow(10.0, (l_elo - w_elo)::numeric / 400.0));
      exp_l := 1.0 / (1.0 + pow(10.0, (w_elo - l_elo)::numeric / 400.0));

      w_new_elo := ROUND(w_elo + k_factor * (1.0 - exp_w));
      l_new_elo := ROUND(l_elo + k_factor * (0.0 - exp_l));
      
      IF l_new_elo < 100 THEN
        l_new_elo := 100;
      END IF;

      -- Mettre à jour le vainqueur (matchs, victoires, ELO, séries)
      UPDATE public.profiles
      SET games_played = games_played + 1,
          games_won = games_won + 1,
          elo_rating = w_new_elo,
          current_streak = current_streak + 1,
          max_streak = GREATEST(max_streak, current_streak + 1),
          win_rate = ROUND(((games_won + 1)::numeric / (games_played + 1)::numeric) * 100.0, 2)
      WHERE id = winner_uuid;

      -- Mettre à jour le perdant (matchs, défaites, ELO, reset série)
      UPDATE public.profiles
      SET games_played = games_played + 1,
          games_lost = games_lost + 1,
          elo_rating = l_new_elo,
          current_streak = 0,
          win_rate = ROUND((games_won::numeric / (games_played + 1)::numeric) * 100.0, 2)
      WHERE id = loser_uuid;

      -- 2. DÉBLOCAGE AUTOMATIQUE DES SUCCÈS (ACHIEVEMENTS)
      -- Premier match gagné
      INSERT INTO public.user_achievements (player_id, achievement_id)
      VALUES (winner_uuid, 'first_win')
      ON CONFLICT DO NOTHING;

      -- 10 victoires
      IF EXISTS (SELECT 1 FROM public.profiles WHERE id = winner_uuid AND games_won >= 10) THEN
        INSERT INTO public.user_achievements (player_id, achievement_id)
        VALUES (winner_uuid, 'ten_wins')
        ON CONFLICT DO NOTHING;
      END IF;

      -- 100 victoires
      IF EXISTS (SELECT 1 FROM public.profiles WHERE id = winner_uuid AND games_won >= 100) THEN
        INSERT INTO public.user_achievements (player_id, achievement_id)
        VALUES (winner_uuid, 'hundred_wins')
        ON CONFLICT DO NOTHING;
      END IF;

      -- Série de 5 victoires
      IF EXISTS (SELECT 1 FROM public.profiles WHERE id = winner_uuid AND max_streak >= 5) THEN
        INSERT INTO public.user_achievements (player_id, achievement_id)
        VALUES (winner_uuid, 'streak_5')
        ON CONFLICT DO NOTHING;
      END IF;
    END IF;

    -- 3. GESTION ET PROGRESSION DU CHAMPIONNAT (SI LE SALON ÉTAIT UN MATCH DE TOURNOI)
    SELECT * INTO tm_row FROM public.tournament_matches WHERE room_id = NEW.id;
    IF FOUND THEN
      -- Mettre à jour le statut du match de tournoi
      UPDATE public.tournament_matches 
      SET winner_id = winner_uuid, status = 'finished'
      WHERE id = tm_row.id;

      SELECT * INTO t_row FROM public.tournaments WHERE id = tm_row.tournament_id;
      
      -- Vérifier s'il reste des matchs non terminés dans cette manche (round_number)
      SELECT COUNT(*) INTO round_unresolved 
      FROM public.tournament_matches
      WHERE tournament_id = tm_row.tournament_id 
        AND round_number = tm_row.round_number
        AND status <> 'finished';

      -- Si tous les matchs du round en cours sont terminés
      IF round_unresolved = 0 THEN
        -- S'il n'y avait qu'un seul match dans ce round, c'est la finale!
        IF tm_row.match_index = 0 AND NOT EXISTS (
          SELECT 1 FROM public.tournament_matches 
          WHERE tournament_id = tm_row.tournament_id 
            AND round_number = tm_row.round_number 
            AND match_index > 0
        ) THEN
          -- Déclarer le vainqueur du tournoi
          UPDATE public.tournaments 
          SET status = 'finished', winner_id = winner_uuid 
          WHERE id = t_row.id;

          -- Créditer le profil
          UPDATE public.profiles 
          SET tournaments_won = tournaments_won + 1 
          WHERE id = winner_uuid;

          -- Débloquer le succès champion
          INSERT INTO public.user_achievements (player_id, achievement_id)
          VALUES (winner_uuid, 'tournament_champion')
          ON CONFLICT DO NOTHING;

        ELSE
          -- Sinon, générer la manche suivante
          next_round_num := tm_row.round_number + 1;
          
          -- Pour chaque paire de matchs du round précédent, créer le match du round suivant
          -- Matchs appariés : Match 2k et Match 2k+1 se retrouvent dans le Match k du round suivant.
          -- Nous devons trouver tous les gagnants du round précédent.
          -- Pour ce faire, nous itérons sur les indices de match pairs.
          FOR partner_match_idx IN 0..(t_row.max_participants / (2 ^ next_round_num) - 1) LOOP
            
            -- Récupérer les gagnants des deux matchs associés
            SELECT winner_id INTO winner_uuid FROM public.tournament_matches 
            WHERE tournament_id = tm_row.tournament_id 
              AND round_number = tm_row.round_number 
              AND match_index = 2 * partner_match_idx;

            SELECT winner_id INTO partner_winner_id FROM public.tournament_matches 
            WHERE tournament_id = tm_row.tournament_id 
              AND round_number = tm_row.round_number 
              AND match_index = (2 * partner_match_idx) + 1;

            -- Obtenir les pseudos pour le nom du salon
            SELECT username INTO creator_name FROM public.profiles WHERE id = winner_uuid;
            SELECT username INTO opponent_name FROM public.profiles WHERE id = partner_winner_id;

            -- Créer le salon
            INSERT INTO public.rooms (name, creator_id, opponent_id, status, visibility, target_score, deal_option, game_state)
            VALUES (
              'Tournoi - ' || t_row.name || ' (R' || next_round_num || ' - M' || partner_match_idx || ')',
              winner_uuid,
              partner_winner_id,
              'active',
              'private',
              t_row.target_score,
              'auto',
              '{"matchStatus": "not-started"}'::jsonb
            ) RETURNING id INTO next_room_id;

            -- Créer le match du round suivant
            INSERT INTO public.tournament_matches (tournament_id, round_number, match_index, player1_id, player2_id, room_id, status)
            VALUES (tm_row.tournament_id, next_round_num, partner_match_idx, winner_uuid, partner_winner_id, next_room_id, 'scheduled');
          END LOOP;
        END IF;
      END IF;
    END IF;
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

-- S'assurer que le trigger est recréé proprement
DROP TRIGGER IF EXISTS on_room_finished_update_stats ON public.rooms;
CREATE TRIGGER on_room_finished_update_stats
  AFTER UPDATE ON public.rooms
  FOR EACH ROW EXECUTE FUNCTION public.update_profiles_stats();

-- Déclencheur pour créer automatiquement le profil lors de l'inscription auth.users
CREATE OR REPLACE FUNCTION public.handle_new_user()
RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO public.profiles (id, username, avatar_url, role, is_banned, elo_rating)
  VALUES (
    new.id,
    COALESCE(new.raw_user_meta_data->>'username', 'User_' || substring(new.id::text from 1 for 8)),
    new.raw_user_meta_data->>'avatar_url',
    'player',
    false,
    1000
  )
  ON CONFLICT (id) DO NOTHING;
  RETURN new;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

DROP TRIGGER IF EXISTS on_auth_user_created ON auth.users;
CREATE TRIGGER on_auth_user_created
  AFTER INSERT ON auth.users
  FOR EACH ROW EXECUTE FUNCTION public.handle_new_user();
