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
  END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

-- J. Attribution des droits sur la table moves
GRANT ALL ON public.moves TO anon, authenticated, service_role;

-- K. Correction de la fonction handle_move_insert (typo ->>> corrigée en ->>)
CREATE OR REPLACE FUNCTION public.handle_move_insert()
RETURNS TRIGGER AS $$
DECLARE
  r_row public.rooms%ROWTYPE;
  p_hand_row public.room_hands%ROWTYPE;
  o_hand_row public.room_hands%ROWTYPE;
  p_id UUID := NEW.player_id;
  o_id UUID;
  g_state JSONB;
  placed_tiles JSONB;
  open_ends JSONB;
  boneyard JSONB;
  p_hand JSONB;
  o_hand JSONB;
  p_hand_len INT;
  o_hand_len INT;
  b_count INT;
  new_placed_tile JSONB;
  action_type TEXT := NEW.action_type;
  payload JSONB := NEW.payload;
  tile JSONB;
  side TEXT;
  rotation JSONB;
  sum_ends INT;
  points INT := 0;
  cur_player UUID;
  round_winner_id UUID;
  round_score INT := 0;
  reveal_phase TEXT := 'none';
  reveal_data JSONB := NULL;
  next_round_starter UUID;
  target_score INT;
  creator_score INT;
  opponent_score INT;
  deck JSONB;
  idx INT;
  drawn_tile JSONB;
  i INT;
  p_can_play BOOLEAN;
  o_can_play BOOLEAN;
  p_pips INT;
  o_pips INT;
  tie_explain TEXT := '';
  next_turn UUID;
  
  -- Local variables for round reset checking
  prev_creator_score INT;
  prev_opponent_score INT;
  new_score_creator INT;
  new_score_opponent INT;
  consecutive_passes INT := 0;
BEGIN
  -- Permettre la mutation de room via le trigger système
  PERFORM set_config('app.game_mutation_authorized', 'true', true);

  -- 1. Verrouiller la room pour éviter les spams de clics
  SELECT * INTO r_row FROM public.rooms WHERE id = NEW.room_id FOR UPDATE;
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Salon introuvable.';
  END IF;

  target_score := r_row.target_score;
  IF p_id = r_row.creator_id THEN
    o_id := r_row.opponent_id;
  ELSE
    o_id := r_row.creator_id;
  END IF;

  prev_creator_score := COALESCE((r_row.game_state->>'score_creator')::int, 0);
  prev_opponent_score := COALESCE((r_row.game_state->>'score_opponent')::int, 0);
  new_score_creator := prev_creator_score;
  new_score_opponent := prev_opponent_score;

  -- 2. Démarrage de manche
  IF action_type = 'START_ROUND' THEN
    IF r_row.status = 'finished' THEN
      RAISE EXCEPTION 'La partie est terminée.';
    END IF;
    IF p_id <> r_row.creator_id THEN
      RAISE EXCEPTION 'Seul le créateur peut démarrer la manche.';
    END IF;
    IF r_row.opponent_id IS NULL THEN
      RAISE EXCEPTION 'Impossible de démarrer sans adversaire.';
    END IF;

    -- Reset scores if the previous round (manche) ended
    IF prev_creator_score >= target_score OR prev_opponent_score >= target_score THEN
      new_score_creator := 0;
      new_score_opponent := 0;
    END IF;

    deck := public.generate_shuffled_deck();

    p_hand := '[]'::jsonb;
    o_hand := '[]'::jsonb;
    boneyard := '[]'::jsonb;

    FOR i IN 0..6 LOOP
      p_hand := p_hand || jsonb_build_array(deck->i);
      o_hand := o_hand || jsonb_build_array(deck->(i+7));
    END LOOP;

    FOR i IN 14..27 LOOP
      boneyard := boneyard || jsonb_build_array(deck->i);
    END LOOP;

    next_round_starter := (r_row.game_state->>'nextRoundStarter')::uuid;
    IF next_round_starter IS NULL THEN
      cur_player := public.determine_starting_player(p_hand, r_row.creator_id, o_hand, r_row.opponent_id);
    ELSE
      cur_player := next_round_starter;
    END IF;

    INSERT INTO public.room_hands (room_id, player_id, hand)
    VALUES (NEW.room_id, r_row.creator_id, p_hand)
    ON CONFLICT (room_id, player_id) DO UPDATE SET hand = EXCLUDED.hand;

    INSERT INTO public.room_hands (room_id, player_id, hand)
    VALUES (NEW.room_id, r_row.opponent_id, o_hand)
    ON CONFLICT (room_id, player_id) DO UPDATE SET hand = EXCLUDED.hand;

    INSERT INTO public.room_boneyard (room_id, tiles)
    VALUES (NEW.room_id, boneyard)
    ON CONFLICT (room_id) DO UPDATE SET tiles = EXCLUDED.tiles;

    g_state := jsonb_build_object(
      'placedTiles', '[]'::jsonb,
      'boneyard_count', 14,
      'currentPlayer', cur_player,
      'score_creator', new_score_creator,
      'score_opponent', new_score_opponent,
      'round', COALESCE((r_row.game_state->>'round')::int, 0) + 1,
      'matchStatus', 'ongoing',
      'revealPhase', 'none',
      'revealData', NULL,
      'nextRoundStarter', NULL,
      'rounds_won_creator', COALESCE((r_row.game_state->>'rounds_won_creator')::int, 0),
      'rounds_won_opponent', COALESCE((r_row.game_state->>'rounds_won_opponent')::int, 0),
      'target_manches', COALESCE((r_row.game_state->>'target_manches')::int, 3),
      'next_round_start_at', NULL,
      'consecutive_passes', 0
    );

    UPDATE public.rooms
    SET status = 'active', game_state = g_state, updated_at = NOW()
    WHERE id = NEW.room_id;

    RETURN NEW;
  END IF;

  -- 3. Vérification de statut actif pour les autres coups
  IF r_row.status <> 'active' THEN
    RAISE EXCEPTION 'Le salon est inactif.';
  END IF;

  g_state := r_row.game_state;
  cur_player := (g_state->>'currentPlayer')::uuid;
  placed_tiles := g_state->'placedTiles';
  b_count := (g_state->>'boneyard_count')::int;
  creator_score := COALESCE((g_state->>'score_creator')::int, 0);
  opponent_score := COALESCE((g_state->>'score_opponent')::int, 0);

  IF p_id <> cur_player THEN
    RAISE EXCEPTION 'Ce n''est pas votre tour.';
  END IF;

  SELECT * INTO p_hand_row FROM public.room_hands WHERE room_id = NEW.room_id AND player_id = p_id FOR UPDATE;
  SELECT * INTO o_hand_row FROM public.room_hands WHERE room_id = NEW.room_id AND player_id = o_id FOR UPDATE;
  
  p_hand := p_hand_row.hand;
  o_hand := o_hand_row.hand;
  p_hand_len := jsonb_array_length(p_hand);
  o_hand_len := jsonb_array_length(o_hand);

  -- 4. PLAY_TILE
  IF action_type = 'PLAY_TILE' THEN
    tile := payload->'tile';
    side := payload->>'side';
    
    IF tile IS NULL OR side IS NULL THEN
      RAISE EXCEPTION 'Tuile ou côté manquant.';
    END IF;

    IF NOT public.player_has_tile(p_hand, tile) THEN
      RAISE EXCEPTION 'Vous ne possédez pas cette tuile.';
    END IF;

    IF jsonb_array_length(placed_tiles) = 0 THEN
      side := 'start';
      rotation := tile;
    ELSE
      open_ends := public.get_open_ends(placed_tiles);
      IF NOT public.is_valid_play(tile, side, open_ends) THEN
        RAISE EXCEPTION 'Coup invalide.';
      END IF;
      rotation := public.calculate_tile_rotation(tile, side, placed_tiles);
    END IF;

    new_placed_tile := jsonb_build_object(
      'id', public.generateId(),
      'tile', tile,
      'connectedAs', rotation,
      'isDouble', (tile->>0)::int = (tile->>1)::int,
      'playedAt', side
    );

    IF jsonb_array_length(placed_tiles) = 0 THEN
      placed_tiles := jsonb_build_array(new_placed_tile);
    ELSE
      IF side IN ('left', 'top') THEN
        placed_tiles := new_placed_tile || placed_tiles;
      ELSE
        placed_tiles := placed_tiles || new_placed_tile;
      END IF;
    END IF;

    p_hand := public.remove_tile_from_hand(p_hand, tile);
    p_hand_len := p_hand_len - 1;

    sum_ends := public.calculate_board_score(placed_tiles);
    IF sum_ends % 5 = 0 THEN
      points := sum_ends;
    END IF;

    IF p_id = r_row.creator_id THEN
      creator_score := creator_score + points;
    ELSE
      opponent_score := opponent_score + points;
    END IF;

    -- Play reset consecutive passes
    consecutive_passes := 0;

    -- Victoire ?
    IF p_hand_len = 0 THEN
      round_winner_id := p_id;
      reveal_phase := 'score';
      round_score := public.round_to_nearest_five(public.calculate_remaining_pips(o_hand));
      
      IF p_id = r_row.creator_id THEN
        creator_score := creator_score + round_score;
      ELSE
        opponent_score := opponent_score + round_score;
      END IF;

      reveal_data := jsonb_build_object(
        'winner_id', p_id,
        'reason', 'domino',
        'points_gained', round_score,
        'creator_hand', p_hand,
        'opponent_hand', o_hand
      );
    ELSE
      -- Blocage ?
      p_can_play := public.can_play(p_hand, public.get_open_ends(placed_tiles));
      o_can_play := public.can_play(o_hand, public.get_open_ends(placed_tiles));
      
      IF b_count = 0 AND NOT p_can_play AND NOT o_can_play THEN
        reveal_phase := 'score';
        p_pips := public.calculate_remaining_pips(p_hand);
        o_pips := public.calculate_remaining_pips(o_hand);
        
        IF p_pips < o_pips THEN
          round_winner_id := r_row.creator_id;
          round_score := public.round_to_nearest_five(o_pips);
          creator_score := creator_score + round_score;
          tie_explain := '';
        ELSIF o_pips < p_pips THEN
          round_winner_id := r_row.opponent_id;
          round_score := public.round_to_nearest_five(p_pips);
          opponent_score := opponent_score + round_score;
          tie_explain := '';
        ELSE
          round_winner_id := public.determine_tiebreaker_winner(p_hand, r_row.creator_id, o_hand, r_row.opponent_id);
          IF round_winner_id = r_row.creator_id THEN
            round_score := public.round_to_nearest_five(o_pips);
            creator_score := creator_score + round_score;
          ELSE
            round_score := public.round_to_nearest_five(p_pips);
            opponent_score := opponent_score + round_score;
          END IF;
          tie_explain := 'Égalité de points ! Le joueur avec le domino le plus fort l''emporte.';
        END IF;

        reveal_data := jsonb_build_object(
          'winner_id', round_winner_id,
          'reason', 'blocked',
          'points_gained', round_score,
          'creator_hand', p_hand,
          'opponent_hand', o_hand,
          'tieBreakExplained', tie_explain
        );
      END IF;
    END IF;

    IF reveal_phase = 'none' THEN
      cur_player := o_id;
    END IF;

  -- 5. DRAW_TILE
  ELSIF action_type = 'DRAW_TILE' THEN
    IF b_count = 0 THEN
      RAISE EXCEPTION 'Pioche vide.';
    END IF;
    IF public.can_play(p_hand, public.get_open_ends(placed_tiles)) THEN
      RAISE EXCEPTION 'Vous pouvez jouer, vous ne pouvez pas piocher.';
    END IF;

    SELECT tiles INTO boneyard FROM public.room_boneyard WHERE room_id = NEW.room_id FOR UPDATE;
    idx := floor(random() * jsonb_array_length(boneyard))::int;
    drawn_tile := boneyard->idx;
    boneyard := boneyard - idx;
    b_count := b_count - 1;

    p_hand := p_hand || jsonb_build_array(drawn_tile);
    p_hand_len := p_hand_len + 1;

    UPDATE public.room_boneyard SET tiles = boneyard WHERE room_id = NEW.room_id;

    NEW.payload := jsonb_build_object('drawn_tile', drawn_tile);

    -- Draw reset consecutive passes
    consecutive_passes := 0;

  -- 6. PASS
  ELSIF action_type = 'PASS' THEN
    IF public.can_play(p_hand, public.get_open_ends(placed_tiles)) THEN
      RAISE EXCEPTION 'Vous avez une tuile jouable.';
    END IF;
    IF b_count > 0 THEN
      RAISE EXCEPTION 'Vous devez piocher.';
    END IF;

    consecutive_passes := COALESCE((r_row.game_state->>'consecutive_passes')::int, 0) + 1;
    o_can_play := public.can_play(o_hand, public.get_open_ends(placed_tiles));

    IF consecutive_passes >= 2 OR NOT o_can_play THEN
      -- Blocage total
      reveal_phase := 'score';
      p_pips := public.calculate_remaining_pips(p_hand);
      o_pips := public.calculate_remaining_pips(o_hand);
      
      IF p_pips < o_pips THEN
        round_winner_id := r_row.creator_id;
        round_score := public.round_to_nearest_five(o_pips);
        creator_score := creator_score + round_score;
      ELSIF o_pips < p_pips THEN
        round_winner_id := r_row.opponent_id;
        round_score := public.round_to_nearest_five(p_pips);
        opponent_score := opponent_score + round_score;
      ELSE
        round_winner_id := public.determine_tiebreaker_winner(p_hand, r_row.creator_id, o_hand, r_row.opponent_id);
        IF round_winner_id = r_row.creator_id THEN
          round_score := public.round_to_nearest_five(o_pips);
          creator_score := creator_score + round_score;
        ELSE
          round_score := public.round_to_nearest_five(p_pips);
          opponent_score := opponent_score + round_score;
        END IF;
        tie_explain := 'Égalité de points ! Le joueur avec le domino le plus fort l''emporte.';
      END IF;

      reveal_data := jsonb_build_object(
        'winner_id', round_winner_id,
        'reason', 'blocked',
        'points_gained', round_score,
        'creator_hand', p_hand,
        'opponent_hand', o_hand,
        'tieBreakExplained', tie_explain
      );

      consecutive_passes := 0; -- reset for next round
    ELSE
      cur_player := o_id;
    END IF;

  ELSE
    RAISE EXCEPTION 'Action non reconnue.';
  END IF;

  -- 7. Sauvegarde et Fin
  UPDATE public.room_hands SET hand = p_hand WHERE room_id = NEW.room_id AND player_id = p_id;
  UPDATE public.room_hands SET hand = o_hand WHERE room_id = NEW.room_id AND player_id = o_id;

  g_state := jsonb_build_object(
    'placedTiles', placed_tiles,
    'boneyard_count', b_count,
    'currentPlayer', cur_player,
    'score_creator', creator_score,
    'score_opponent', opponent_score,
    'round', COALESCE((r_row.game_state->>'round')::int, 1),
    'matchStatus', r_row.game_state->>'matchStatus',
    'revealPhase', reveal_phase,
    'revealData', reveal_data,
    'nextRoundStarter', (r_row.game_state->>'nextRoundStarter'),
    'rounds_won_creator', COALESCE((r_row.game_state->>'rounds_won_creator')::int, 0),
    'rounds_won_opponent', COALESCE((r_row.game_state->>'rounds_won_opponent')::int, 0),
    'target_manches', COALESCE((r_row.game_state->>'target_manches')::int, 3),
    'next_round_start_at', (r_row.game_state->>'next_round_start_at'),
    'consecutive_passes', consecutive_passes
  );

  IF reveal_phase = 'score' THEN
    IF creator_score >= target_score OR opponent_score >= target_score THEN
      -- A player reached target_score, so they win the manche!
      DECLARE
        winner_uuid UUID;
        rounds_won_c INT := COALESCE((r_row.game_state->>'rounds_won_creator')::int, 0);
        rounds_won_o INT := COALESCE((r_row.game_state->>'rounds_won_opponent')::int, 0);
        target_manches INT := COALESCE((r_row.game_state->>'target_manches')::int, 3);
      BEGIN
        IF creator_score >= target_score THEN
          winner_uuid := r_row.creator_id;
          rounds_won_c := rounds_won_c + 1;
        ELSE
          winner_uuid := r_row.opponent_id;
          rounds_won_o := rounds_won_o + 1;
        END IF;

        -- Update the rounds_won in game_state
        g_state := g_state || jsonb_build_object(
          'rounds_won_creator', rounds_won_c,
          'rounds_won_opponent', rounds_won_o
        );

        -- Check if match winner condition is met
        IF rounds_won_c >= target_manches OR rounds_won_o >= target_manches THEN
          -- Match finished!
          g_state := g_state || jsonb_build_object('matchStatus', 'finished');
          UPDATE public.rooms
          SET status = 'finished',
              game_state = g_state,
              winner_id = winner_uuid,
              updated_at = NOW()
          WHERE id = NEW.room_id;
        ELSE
          -- Match not finished, start transition to next round (manche)
          g_state := g_state || jsonb_build_object(
            'matchStatus', 'ongoing',
            'next_round_start_at', (EXTRACT(EPOCH FROM NOW() + INTERVAL '10 seconds') * 1000)::bigint,
            'nextRoundStarter', round_winner_id
          );
          UPDATE public.rooms
          SET game_state = g_state, updated_at = NOW()
          WHERE id = NEW.room_id;
        END IF;
      END;
    ELSE
      g_state := g_state || jsonb_build_object(
        'nextRoundStarter', round_winner_id
      );
      UPDATE public.rooms
      SET game_state = g_state, updated_at = NOW()
      WHERE id = NEW.room_id;
    END IF;

    INSERT INTO public.room_events (room_id, player_id, event_type)
    VALUES (NEW.room_id, p_id, 'ROUND_BLOCKED');
  ELSE
    g_state := g_state || jsonb_build_object(
      'currentPlayer', cur_player
    );

    UPDATE public.rooms
    SET game_state = g_state, updated_at = NOW()
    WHERE id = NEW.room_id;
  END IF;

  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- L. Définition de la fonction de commodité player_has_tile si manquante
CREATE OR REPLACE FUNCTION public.player_has_tile(p_hand JSONB, p_tile JSONB)
RETURNS BOOLEAN AS $$
DECLARE
  v_tile_rev JSONB;
BEGIN
  -- Permet de vérifier la présence d'une tuile dans la main dans les deux sens [a,b] ou [b,a]
  v_tile_rev := jsonb_build_array(p_tile->1, p_tile->0);
  RETURN (p_hand @> jsonb_build_array(p_tile)) 
      OR (p_hand @> jsonb_build_array(v_tile_rev));
END;
$$ LANGUAGE plpgsql IMMUTABLE;
