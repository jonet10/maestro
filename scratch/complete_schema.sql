-- ========================================================
-- 1. EXTENSIONS & NETTOYAGE
-- ========================================================
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Nettoyer les tables en premier (ce qui supprime automatiquement leurs triggers associés)
DROP TABLE IF EXISTS public.room_events CASCADE;
DROP TABLE IF EXISTS public.moves CASCADE;
DROP TABLE IF EXISTS public.room_boneyard CASCADE;
DROP TABLE IF EXISTS public.room_hands CASCADE;
DROP TABLE IF EXISTS public.rooms CASCADE;
DROP TABLE IF EXISTS public.profiles CASCADE;
DROP TABLE IF EXISTS public.match_history CASCADE;
DROP TABLE IF EXISTS public.matches CASCADE;

-- Nettoyer les fonctions
DROP FUNCTION IF EXISTS public.before_room_update_security_check();
DROP FUNCTION IF EXISTS public.update_profiles_stats();
DROP FUNCTION IF EXISTS public.handle_move_insert();
DROP FUNCTION IF EXISTS public.determine_tiebreaker_winner(jsonb, uuid, jsonb, uuid);
DROP FUNCTION IF EXISTS public.determine_starting_player(jsonb, uuid, jsonb, uuid);
DROP FUNCTION IF EXISTS public.calculate_remaining_pips(jsonb);
DROP FUNCTION IF EXISTS public.round_to_nearest_five(int);
DROP FUNCTION IF EXISTS public.calculate_board_score(jsonb);
DROP FUNCTION IF EXISTS public.get_open_ends(jsonb);
DROP FUNCTION IF EXISTS public.get_played_tile_rotation(jsonb, text, jsonb);
DROP FUNCTION IF EXISTS public.has_playable_tile(jsonb, jsonb);
DROP FUNCTION IF EXISTS public.generate_shuffled_deck();
DROP FUNCTION IF EXISTS public.generate_unique_room_code();
DROP FUNCTION IF EXISTS public.create_room(text, int, text, text);
DROP FUNCTION IF EXISTS public.join_room(uuid);
DROP FUNCTION IF EXISTS public.join_room_by_code(text);
DROP FUNCTION IF EXISTS public.mark_player_disconnected(uuid, uuid);
DROP FUNCTION IF EXISTS public.claim_forfeit(uuid);
DROP FUNCTION IF EXISTS public.register_reconnect(uuid);


-- ========================================================
-- 2. TABLES DE BASE
-- ========================================================

-- A. Profils des joueurs
CREATE TABLE public.profiles (
  id UUID REFERENCES auth.users ON DELETE CASCADE PRIMARY KEY,
  username TEXT UNIQUE NOT NULL,
  avatar_url TEXT,
  games_played INT DEFAULT 0 NOT NULL,
  games_won INT DEFAULT 0 NOT NULL,
  games_lost INT DEFAULT 0 NOT NULL,
  win_rate NUMERIC(5,2) DEFAULT 0.00 NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL
);

-- B. Salons / Salles de jeu
CREATE TABLE public.rooms (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  name TEXT NOT NULL,
  creator_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
  opponent_id UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
  status TEXT DEFAULT 'waiting' NOT NULL, -- 'waiting', 'active', 'finished'
  visibility TEXT DEFAULT 'public' NOT NULL, -- 'public', 'private'
  room_code TEXT UNIQUE, -- Code privé de 6 caractères
  target_score INT DEFAULT 100 NOT NULL,
  deal_option TEXT DEFAULT 'auto' NOT NULL, -- 'auto', 'manual'
  winner_id UUID REFERENCES public.profiles(id),
  game_state JSONB DEFAULT '{}'::jsonb NOT NULL,
  creator_disconnected_at TIMESTAMP WITH TIME ZONE,
  opponent_disconnected_at TIMESTAMP WITH TIME ZONE,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL,
  CONSTRAINT check_visibility CHECK (visibility IN ('public', 'private')),
  CONSTRAINT check_status CHECK (status IN ('waiting', 'active', 'finished')),
  CONSTRAINT check_target_score CHECK (target_score IN (50, 100, 150, 200)),
  CONSTRAINT check_deal_option CHECK (deal_option IN ('auto', 'manual'))
);

CREATE INDEX idx_rooms_status ON public.rooms(status);
CREATE INDEX idx_rooms_room_code ON public.rooms(room_code) WHERE visibility = 'private';

-- C. Mains sécurisées (ségrégation complète)
CREATE TABLE public.room_hands (
  room_id UUID REFERENCES public.rooms(id) ON DELETE CASCADE NOT NULL,
  player_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
  hand JSONB DEFAULT '[]'::jsonb NOT NULL, -- Tableau secret de tuiles : [[6,6],[5,4]]
  PRIMARY KEY (room_id, player_id)
);

-- D. Pioche sécurisée (secrète)
CREATE TABLE public.room_boneyard (
  room_id UUID REFERENCES public.rooms(id) ON DELETE CASCADE PRIMARY KEY,
  tiles JSONB DEFAULT '[]'::jsonb NOT NULL -- Tuiles sécurisées restantes
);

-- E. Historique des actions
CREATE TABLE public.moves (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  room_id UUID REFERENCES public.rooms(id) ON DELETE CASCADE NOT NULL,
  player_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
  action_type TEXT NOT NULL, -- 'PLAY_TILE', 'DRAW_TILE', 'PASS', 'START_ROUND'
  payload JSONB DEFAULT '{}'::jsonb NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL,
  CONSTRAINT check_action_type CHECK (action_type IN ('PLAY_TILE', 'DRAW_TILE', 'PASS', 'START_ROUND'))
);

CREATE INDEX idx_moves_room_id ON public.moves(room_id);

-- F. Événements de jeu
CREATE TABLE public.room_events (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  room_id UUID REFERENCES public.rooms(id) ON DELETE CASCADE NOT NULL,
  player_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
  event_type TEXT NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL
);

-- G. Historique des matchs solo (Legacy)
CREATE TABLE IF NOT EXISTS public.match_history (
  id TEXT PRIMARY KEY,
  device_id TEXT NOT NULL,
  game_type TEXT NOT NULL,
  target_score INT NOT NULL,
  score_user INT NOT NULL,
  score_ai INT NOT NULL,
  winner TEXT NOT NULL,
  created_at_str TEXT,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT TIMEZONE('utc'::text, NOW()) NOT NULL
);

-- ========================================================
-- 3. POLITIQUES RLS (ROW LEVEL SECURITY)
-- ========================================================
ALTER TABLE public.profiles ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.rooms ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.room_hands ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.room_boneyard ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.moves ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.room_events ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.match_history ENABLE ROW LEVEL SECURITY;

CREATE POLICY "Allow public select match_history" ON public.match_history FOR SELECT USING (true);
CREATE POLICY "Allow public insert match_history" ON public.match_history FOR INSERT WITH CHECK (true);

CREATE POLICY "Profiles view policy" ON public.profiles FOR SELECT USING (true);
CREATE POLICY "Profiles edit policy" ON public.profiles FOR UPDATE USING (auth.uid() = id);

CREATE POLICY "Rooms view policy" ON public.rooms FOR SELECT USING (true);
CREATE POLICY "Rooms create policy" ON public.rooms FOR INSERT WITH CHECK (auth.uid() = creator_id);
CREATE POLICY "Rooms update policy" ON public.rooms FOR UPDATE USING (
  auth.uid() = creator_id OR auth.uid() = opponent_id OR opponent_id IS NULL
);

-- Les joueurs ne peuvent voir la main adverse QU'EN phase de révélation, de score, ou quand la partie est finie.
CREATE POLICY "Hands view policy" ON public.room_hands FOR SELECT USING (
  auth.uid() = player_id OR EXISTS (
    SELECT 1 FROM public.rooms r 
    WHERE r.id = room_id 
    AND (
      r.status = 'finished' 
      OR r.game_state->>'revealPhase' = 'revealing' 
      OR r.game_state->>'revealPhase' = 'scoring'
    )
  )
);
CREATE POLICY "System update hands" ON public.room_hands FOR ALL USING (true) WITH CHECK (true);

-- Le boneyard n'a AUCUNE politique SELECT publique. Protège la pioche contre l'inspection client.
CREATE POLICY "System update boneyard" ON public.room_boneyard FOR ALL USING (true) WITH CHECK (true);

CREATE POLICY "Moves view policy" ON public.moves FOR SELECT USING (
  EXISTS (
    SELECT 1 FROM public.rooms r 
    WHERE r.id = room_id AND (r.creator_id = auth.uid() OR r.opponent_id = auth.uid())
  )
);
CREATE POLICY "Moves insert policy" ON public.moves FOR INSERT WITH CHECK (
  auth.uid() = player_id AND EXISTS (
    SELECT 1 FROM public.rooms r 
    WHERE r.id = room_id AND (r.creator_id = auth.uid() OR r.opponent_id = auth.uid())
  )
);

CREATE POLICY "Events view policy" ON public.room_events FOR SELECT USING (
  EXISTS (
    SELECT 1 FROM public.rooms r 
    WHERE r.id = room_id AND (r.creator_id = auth.uid() OR r.opponent_id = auth.uid())
  )
);

-- ========================================================
-- 4. FONCTIONS DE JEU & LOGIQUE DE SCORING
-- ========================================================

-- A. Générateur de code de room unique à 6 caractères

CREATE OR REPLACE FUNCTION public.generate_unique_room_code()
RETURNS TEXT AS $$
DECLARE
  chars TEXT := 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
  code TEXT;
  i INT;
  collision BOOLEAN := true;
BEGIN
  WHILE collision LOOP
    code := '';
    FOR i IN 1..6 LOOP
      code := code || substr(chars, floor(random() * length(chars) + 1)::int, 1);
    END LOOP;
    SELECT EXISTS(SELECT 1 FROM public.rooms WHERE room_code = code) INTO collision;
  END LOOP;
  RETURN code;
END;
$$ LANGUAGE plpgsql;

-- B. Mélange des cartes natif SQL
CREATE OR REPLACE FUNCTION public.generate_shuffled_deck()
RETURNS JSONB AS $$
DECLARE
  shuffled JSONB;
BEGIN
  SELECT jsonb_agg(tile) INTO shuffled FROM (
    SELECT tile FROM (
      SELECT jsonb_build_array(i, j) AS tile
      FROM generate_series(0, 6) i
      CROSS JOIN generate_series(0, 6) j
      WHERE i <= j
    ) sub
    ORDER BY random()
  ) sub2;
  RETURN shuffled;
END;
$$ LANGUAGE plpgsql;

-- C. Calcul des extrémités ouvertes du plateau (Géométrie 2D snaking)
CREATE OR REPLACE FUNCTION public.get_open_ends(placed_tiles JSONB)
RETURNS JSONB AS $$
DECLARE
  start_tile JSONB;
  left_branch JSONB := '[]'::jsonb;
  right_branch JSONB := '[]'::jsonb;
  top_branch JSONB := '[]'::jsonb;
  bottom_branch JSONB := '[]'::jsonb;
  has_spinner BOOLEAN := false;
  spinner_tile JSONB;
  spinner_val INT;
  spinner_connected_both BOOLEAN := false;
  t JSONB;
  res JSONB := '{"left": null, "right": null, "top": null, "bottom": null}'::jsonb;
  left_len INT;
  right_len INT;
  top_len INT;
  bottom_len INT;
  idx INT;
BEGIN
  IF jsonb_array_length(placed_tiles) = 0 THEN
    RETURN res;
  END IF;

  FOR t IN SELECT * FROM jsonb_array_elements(placed_tiles) LOOP
    IF t->>'playedAt' = 'start' THEN
      start_tile := t;
    ELSIF t->>'playedAt' = 'left' THEN
      left_branch := left_branch || t;
    ELSIF t->>'playedAt' = 'right' THEN
      right_branch := right_branch || t;
    ELSIF t->>'playedAt' = 'top' THEN
      top_branch := top_branch || t;
    ELSIF t->>'playedAt' = 'bottom' THEN
      bottom_branch := bottom_branch || t;
    END IF;

    IF (t->>'isDouble')::boolean = true AND NOT has_spinner THEN
      has_spinner := true;
      spinner_tile := t;
    END IF;
  END LOOP;

  IF start_tile IS NULL THEN
    RETURN res;
  END IF;

  left_len := jsonb_array_length(left_branch);
  right_len := jsonb_array_length(right_branch);
  top_len := jsonb_array_length(top_branch);
  bottom_len := jsonb_array_length(bottom_branch);

  IF left_len > 0 THEN
    res := jsonb_set(res, '{left}', (left_branch->(left_len - 1)->'connectedAs'->1));
  ELSE
    res := jsonb_set(res, '{left}', (start_tile->'connectedAs'->0));
  END IF;

  IF right_len > 0 THEN
    res := jsonb_set(res, '{right}', (right_branch->(right_len - 1)->'connectedAs'->1));
  ELSE
    res := jsonb_set(res, '{right}', (start_tile->'connectedAs'->1));
  END IF;

  IF has_spinner THEN
    spinner_val := (spinner_tile->'tile'->>0)::int;

    IF spinner_tile->>'playedAt' = 'start' THEN
      IF left_len > 0 AND right_len > 0 THEN
        spinner_connected_both := true;
      END IF;
    ELSIF spinner_tile->>'playedAt' = 'left' THEN
      idx := -1;
      FOR i IN 0 .. left_len - 1 LOOP
        IF (left_branch->i->>'id') = (spinner_tile->>'id') THEN
          idx := i;
          EXIT;
        END IF;
      END LOOP;
      IF idx <> -1 AND idx < left_len - 1 THEN
        spinner_connected_both := true;
      END IF;
    ELSIF spinner_tile->>'playedAt' = 'right' THEN
      idx := -1;
      FOR i IN 0 .. right_len - 1 LOOP
        IF (right_branch->i->>'id') = (spinner_tile->>'id') THEN
          idx := i;
          EXIT;
        END IF;
      END LOOP;
      IF idx <> -1 AND idx < right_len - 1 THEN
        spinner_connected_both := true;
      END IF;
    END IF;

    IF spinner_connected_both THEN
      IF top_len > 0 THEN
        res := jsonb_set(res, '{top}', (top_branch->(top_len - 1)->'connectedAs'->1));
      ELSE
        res := jsonb_set(res, '{top}', to_jsonb(spinner_val));
      END IF;

      IF bottom_len > 0 THEN
        res := jsonb_set(res, '{bottom}', (bottom_branch->(bottom_len - 1)->'connectedAs'->1));
      ELSE
        res := jsonb_set(res, '{bottom}', to_jsonb(spinner_val));
      END IF;
    END IF;
  END IF;

  RETURN res;
END;
$$ LANGUAGE plpgsql;

-- D. Calcul du score de plateau Fives (calcul rigoureux)
CREATE OR REPLACE FUNCTION public.calculate_board_score(placed_tiles JSONB)
RETURNS INT AS $$
DECLARE
  start_tile JSONB;
  left_branch JSONB := '[]'::jsonb;
  right_branch JSONB := '[]'::jsonb;
  top_branch JSONB := '[]'::jsonb;
  bottom_branch JSONB := '[]'::jsonb;
  t JSONB;
  left_len INT;
  right_len INT;
  top_len INT;
  bottom_len INT;
  score_left INT := 0;
  score_right INT := 0;
  score_top INT := 0;
  score_bottom INT := 0;
  last_tile JSONB;
BEGIN
  IF jsonb_array_length(placed_tiles) = 0 THEN
    RETURN 0;
  END IF;

  IF jsonb_array_length(placed_tiles) = 1 THEN
    start_tile := placed_tiles->0;
    RETURN (start_tile->'tile'->>0)::int + (start_tile->'tile'->>1)::int;
  END IF;

  FOR t IN SELECT * FROM jsonb_array_elements(placed_tiles) LOOP
    IF t->>'playedAt' = 'start' THEN
      start_tile := t;
    ELSIF t->>'playedAt' = 'left' THEN
      left_branch := left_branch || t;
    ELSIF t->>'playedAt' = 'right' THEN
      right_branch := right_branch || t;
    ELSIF t->>'playedAt' = 'top' THEN
      top_branch := top_branch || t;
    ELSIF t->>'playedAt' = 'bottom' THEN
      bottom_branch := bottom_branch || t;
    END IF;
  END LOOP;

  left_len := jsonb_array_length(left_branch);
  right_len := jsonb_array_length(right_branch);
  top_len := jsonb_array_length(top_branch);
  bottom_len := jsonb_array_length(bottom_branch);

  IF left_len > 0 THEN
    last_tile := left_branch->(left_len - 1);
    IF (last_tile->>'isDouble')::boolean THEN
      score_left := (last_tile->'tile'->>0)::int + (last_tile->'tile'->>1)::int;
    ELSE
      score_left := (last_tile->'connectedAs'->>1)::int;
    END IF;
  ELSE
    IF (start_tile->>'isDouble')::boolean AND top_len = 0 AND bottom_len = 0 THEN
      score_left := (start_tile->'tile'->>0)::int + (start_tile->'tile'->>1)::int;
    ELSE
      score_left := (start_tile->'connectedAs'->>0)::int;
    END IF;
  END IF;

  IF right_len > 0 THEN
    last_tile := right_branch->(right_len - 1);
    IF (last_tile->>'isDouble')::boolean THEN
      score_right := (last_tile->'tile'->>0)::int + (last_tile->'tile'->>1)::int;
    ELSE
      score_right := (last_tile->'connectedAs'->>1)::int;
    END IF;
  ELSE
    IF (start_tile->>'isDouble')::boolean AND top_len = 0 AND bottom_len = 0 THEN
      score_right := (start_tile->'tile'->>0)::int + (start_tile->'tile'->>1)::int;
    ELSE
      score_right := (start_tile->'connectedAs'->>1)::int;
    END IF;
  END IF;

  IF top_len > 0 THEN
    last_tile := top_branch->(top_len - 1);
    IF (last_tile->>'isDouble')::boolean THEN
      score_top := (last_tile->'tile'->>0)::int + (last_tile->'tile'->>1)::int;
    ELSE
      score_top := (last_tile->'connectedAs'->>1)::int;
    END IF;
  END IF;

  IF bottom_len > 0 THEN
    last_tile := bottom_branch->(bottom_len - 1);
    IF (last_tile->>'isDouble')::boolean THEN
      score_bottom := (last_tile->'tile'->>0)::int + (last_tile->'tile'->>1)::int;
    ELSE
      score_bottom := (last_tile->'connectedAs'->>1)::int;
    END IF;
  END IF;

  RETURN score_left + score_right + score_top + score_bottom;
END;
$$ LANGUAGE plpgsql;

-- E. Rotation de la tuile posée (inner_match / outer_open)
CREATE OR REPLACE FUNCTION public.get_played_tile_rotation(tile JSONB, side TEXT, open_ends JSONB)
RETURNS JSONB AS $$
DECLARE
  a INT := (tile->>0)::int;
  b INT := (tile->>1)::int;
  open_val INT;
BEGIN
  IF side = 'start' OR (open_ends->>'left') IS NULL THEN
    RETURN tile;
  END IF;

  IF side = 'left' THEN open_val := (open_ends->>'left')::int;
  ELSIF side = 'right' THEN open_val := (open_ends->>'right')::int;
  ELSIF side = 'top' THEN open_val := (open_ends->>'top')::int;
  ELSIF side = 'bottom' THEN open_val := (open_ends->>'bottom')::int;
  END IF;

  IF open_val IS NULL THEN
    RETURN tile;
  END IF;

  IF a = open_val THEN
    RETURN tile;
  ELSE
    RETURN jsonb_build_array(b, a);
  END IF;
END;
$$ LANGUAGE plpgsql;

-- F. Détection de tuiles jouables
CREATE OR REPLACE FUNCTION public.has_playable_tile(hand JSONB, open_ends JSONB)
RETURNS BOOLEAN AS $$
DECLARE
  t JSONB;
  a INT;
  b INT;
  le INT := (open_ends->>'left')::int;
  re INT := (open_ends->>'right')::int;
  te INT := (open_ends->>'top')::int;
  be INT := (open_ends->>'bottom')::int;
BEGIN
  IF hand IS NULL OR jsonb_array_length(hand) = 0 THEN
    RETURN false;
  END IF;
  
  IF le IS NULL AND re IS NULL AND te IS NULL AND be IS NULL THEN
    RETURN true;
  END IF;

  FOR t IN SELECT * FROM jsonb_array_elements(hand) LOOP
    a := (t->>0)::int;
    b := (t->>1)::int;
    IF (le IS NOT NULL AND (a = le OR b = le)) OR
       (re IS NOT NULL AND (a = re OR b = re)) OR
       (te IS NOT NULL AND (a = te OR b = te)) OR
       (be IS NOT NULL AND (a = be OR b = be)) THEN
      RETURN true;
    END IF;
  END LOOP;
  RETURN false;
END;
$$ LANGUAGE plpgsql;

-- G. Détermination du premier joueur
CREATE OR REPLACE FUNCTION public.determine_starting_player(hand_a JSONB, player_a UUID, hand_b JSONB, player_b UUID)
RETURNS UUID AS $$
DECLARE
  max_double_a INT := -1;
  max_double_b INT := -1;
  max_sum_a INT := -1;
  max_sum_b INT := -1;
  t JSONB;
  val INT;
BEGIN
  FOR t IN SELECT * FROM jsonb_array_elements(hand_a) LOOP
    IF (t->>0)::int = (t->>1)::int THEN
      val := (t->>0)::int;
      IF val > max_double_a THEN max_double_a := val; END IF;
    END IF;
    val := (t->>0)::int + (t->>1)::int;
    IF val > max_sum_a THEN max_sum_a := val; END IF;
  END LOOP;

  FOR t IN SELECT * FROM jsonb_array_elements(hand_b) LOOP
    IF (t->>0)::int = (t->>1)::int THEN
      val := (t->>0)::int;
      IF val > max_double_b THEN max_double_b := val; END IF;
    END IF;
    val := (t->>0)::int + (t->>1)::int;
    IF val > max_sum_b THEN max_sum_b := val; END IF;
  END LOOP;

  IF max_double_a <> -1 OR max_double_b <> -1 THEN
    IF max_double_a > max_double_b THEN
      RETURN player_a;
    ELSE
      RETURN player_b;
    END IF;
  END IF;

  IF max_sum_a >= max_sum_b THEN
    RETURN player_a;
  ELSE
    RETURN player_b;
  END IF;
END;
$$ LANGUAGE plpgsql;

-- H. Calcul de la somme des pips restants
CREATE OR REPLACE FUNCTION public.calculate_remaining_pips(hand JSONB)
RETURNS INT AS $$
DECLARE
  t JSONB;
  sum_pips INT := 0;
BEGIN
  IF hand IS NULL OR jsonb_array_length(hand) = 0 THEN
    RETURN 0;
  END IF;
  FOR t IN SELECT * FROM jsonb_array_elements(hand) LOOP
    sum_pips := sum_pips + (t->>0)::int + (t->>1)::int;
  END LOOP;
  RETURN sum_pips;
END;
$$ LANGUAGE plpgsql;

-- I. Arrondi au multiple de 5 le plus proche
CREATE OR REPLACE FUNCTION public.round_to_nearest_five(value INT)
RETURNS INT AS $$
BEGIN
  RETURN 5 * ROUND(value::numeric / 5.0)::int;
END;
$$ LANGUAGE plpgsql;

-- J. Résolution du tiebreaker en cas de blocage avec pips égaux
CREATE OR REPLACE FUNCTION public.determine_tiebreaker_winner(
  hand_a JSONB, player_a UUID,
  hand_b JSONB, player_b UUID
) RETURNS UUID AS $$
DECLARE
  double_a INT := -1;
  double_b INT := -1;
  sum_a INT := -1;
  sum_b INT := -1;
  max_pip_a INT := -1;
  max_pip_b INT := -1;
  t JSONB;
  v0 INT;
  v1 INT;
BEGIN
  FOR t IN SELECT * FROM jsonb_array_elements(hand_a) LOOP
    v0 := (t->>0)::int;
    v1 := (t->>1)::int;
    IF v0 = v1 AND v0 > double_a THEN double_a := v0; END IF;
    IF (v0 + v1) > sum_a THEN sum_a := v0 + v1; END IF;
    IF v0 > max_pip_a THEN max_pip_a := v0; END IF;
    IF v1 > max_pip_a THEN max_pip_a := v1; END IF;
  END LOOP;

  FOR t IN SELECT * FROM jsonb_array_elements(hand_b) LOOP
    v0 := (t->>0)::int;
    v1 := (t->>1)::int;
    IF v0 = v1 AND v0 > double_b THEN double_b := v0; END IF;
    IF (v0 + v1) > sum_b THEN sum_b := v0 + v1; END IF;
    IF v0 > max_pip_b THEN max_pip_b := v0; END IF;
    IF v1 > max_pip_b THEN max_pip_b := v1; END IF;
  END LOOP;

  IF double_a <> -1 OR double_b <> -1 THEN
    IF double_a > double_b THEN RETURN player_a; ELSE RETURN player_b; END IF;
  END IF;

  IF sum_a <> sum_b THEN
    IF sum_a > sum_b THEN RETURN player_a; ELSE RETURN player_b; END IF;
  END IF;

  IF max_pip_a > max_pip_b THEN
    RETURN player_a;
  ELSE
    RETURN player_b;
  END IF;
END;
$$ LANGUAGE plpgsql;

-- ========================================================
-- 5. RPC & TRIGGERS DE SÉCURITÉ DE LA BASE DE DONNÉES
-- ========================================================

-- A. Protection contre les modifications directes côté client
CREATE OR REPLACE FUNCTION public.before_room_update_security_check()
RETURNS TRIGGER AS $$
BEGIN
  IF auth.uid() IS NOT NULL AND current_setting('app.game_mutation_authorized', true) IS DISTINCT FROM 'true' THEN
    IF NEW.game_state IS DISTINCT FROM OLD.game_state 
       OR NEW.status IS DISTINCT FROM OLD.status 
       OR NEW.winner_id IS DISTINCT FROM OLD.winner_id 
       OR NEW.target_score != OLD.target_score
       OR NEW.deal_option != OLD.deal_option THEN
      RAISE EXCEPTION 'Les modifications directes du plateau, du statut ou des paramètres sont strictement interdites.';
    END IF;
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER on_room_client_update_protect
  BEFORE UPDATE ON public.rooms
  FOR EACH ROW EXECUTE FUNCTION public.before_room_update_security_check();

-- B. RPC : Création de salon
CREATE OR REPLACE FUNCTION public.create_room(
  room_name TEXT,
  target_score INT,
  deal_option TEXT,
  visibility TEXT
)
RETURNS UUID AS $$
DECLARE
  new_room_id UUID;
  code TEXT := NULL;
BEGIN
  IF visibility = 'private' THEN
    code := public.generate_unique_room_code();
  END IF;

  INSERT INTO public.rooms (
    name,
    creator_id,
    target_score,
    deal_option,
    visibility,
    room_code,
    status
  )
  VALUES (
    room_name,
    auth.uid(),
    target_score,
    deal_option,
    visibility,
    code,
    'waiting'
  )
  RETURNING id INTO new_room_id;

  RETURN new_room_id;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

-- C. RPC : Rejoindre un salon public
CREATE OR REPLACE FUNCTION public.join_room(p_room_id UUID)
RETURNS VOID AS $$
BEGIN
  UPDATE public.rooms
  SET opponent_id = auth.uid(),
      updated_at = NOW()
  WHERE id = p_room_id 
    AND status = 'waiting' 
    AND creator_id <> auth.uid() 
    AND opponent_id IS NULL;
    
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Impossible de rejoindre le salon. Il est peut-être plein ou actif.';
  END IF;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

-- D. RPC : Rejoindre un salon privé par code
CREATE OR REPLACE FUNCTION public.join_room_by_code(p_room_code TEXT)
RETURNS UUID AS $$
DECLARE
  target_room_id UUID;
BEGIN
  SELECT id INTO target_room_id
  FROM public.rooms
  WHERE room_code = UPPER(p_room_code)
    AND status = 'waiting'
    AND creator_id <> auth.uid()
    AND opponent_id IS NULL;

  IF target_room_id IS NULL THEN
    RAISE EXCEPTION 'Code de salon invalide, salon plein ou vous en êtes le créateur.';
  END IF;

  UPDATE public.rooms
  SET opponent_id = auth.uid(),
      updated_at = NOW()
  WHERE id = target_room_id;

  RETURN target_room_id;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

-- ========================================================
-- 6. MOTEUR DE TOUR CENTRALISÉ (TRIGGER SUR TABLE MOVES)
-- ========================================================
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

    deck := public.generate_shuffled_deck();

    p_hand := '[]'::jsonb;
    o_hand := '[]'::jsonb;
    boneyard := '[]'::jsonb;

    FOR i IN 0..6 LOOP
      p_hand := p_hand || (deck->i);
      o_hand := o_hand || (deck->(i+7));
    END LOOP;

    FOR i IN 14..27 LOOP
      boneyard := boneyard || (deck->i);
    END LOOP;

    -- next_round_starter est soit NULL (nouvelle partie), soit le vainqueur de la manche précédente
    IF next_round_starter IS NULL THEN
      cur_player := public.determine_starting_player(p_hand, r_row.creator_id, o_hand, r_row.opponent_id);
    ELSE
      cur_player := next_round_starter;
    END IF;

    INSERT INTO public.room_hands (room_id, player_id, hand)
    VALUES (NEW.room_id, r_row.creator_id, p_hand)
    ON CONFLICT (room_id, player_id) DO UPDATE SET hand = p_hand;

    INSERT INTO public.room_hands (room_id, player_id, hand)
    VALUES (NEW.room_id, r_row.opponent_id, o_hand)
    ON CONFLICT (room_id, player_id) DO UPDATE SET hand = o_hand;

    INSERT INTO public.room_boneyard (room_id, tiles)
    VALUES (NEW.room_id, boneyard)
    ON CONFLICT (room_id) DO UPDATE SET tiles = boneyard;

    g_state := jsonb_build_object(
      'placedTiles', '[]'::jsonb,
      'boneyard_count', 14,
      'currentPlayer', cur_player,
      'score_creator', COALESCE((r_row.game_state->>'score_creator')::int, 0),
      'score_opponent', COALESCE((r_row.game_state->>'score_opponent')::int, 0),
      'round', COALESCE((r_row.game_state->>'round')::int, 0) + 1,
      'matchStatus', 'ongoing',
      'revealPhase', 'none',
      'revealData', NULL,
      'nextRoundStarter', NULL
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

  SELECT * INTO p_hand_row FROM public.room_hands WHERE room_id = NEW.room_id AND player_id = p_id;
  p_hand := p_hand_row.hand;
  p_hand_len := jsonb_array_length(p_hand);

  SELECT * INTO o_hand_row FROM public.room_hands WHERE room_id = NEW.room_id AND player_id = o_id;
  o_hand := o_hand_row.hand;
  o_hand_len := jsonb_array_length(o_hand);

  IF p_id <> cur_player THEN
    RAISE EXCEPTION 'Ce n''est pas votre tour.';
  END IF;

  IF g_state->>'revealPhase' <> 'none' THEN
    RAISE EXCEPTION 'Partie en attente de la manche suivante.';
  END IF;

  -- 4. Traitement PLAY_TILE
  IF action_type = 'PLAY_TILE' THEN
    tile := payload->'tile';
    side := payload->>'side';

    IF NOT (p_hand @> tile) THEN
      tile := jsonb_build_array(tile->1, tile->0);
      IF NOT (p_hand @> tile) THEN
        RAISE EXCEPTION 'Vous ne possédez pas ce domino dans votre main.';
      END IF;
    END IF;

    open_ends := public.get_open_ends(placed_tiles);
    IF jsonb_array_length(placed_tiles) > 0 THEN
      IF side IS NULL OR side NOT IN ('left', 'right', 'top', 'bottom') THEN
        RAISE EXCEPTION 'Direction de placement requise.';
      END IF;

      IF (open_ends->>side) IS NULL THEN
        RAISE EXCEPTION 'Cette extrémité est fermée.';
      END IF;

      IF (tile->>0)::int <> (open_ends->>side)::int AND (tile->>1)::int <> (open_ends->>side)::int THEN
        RAISE EXCEPTION 'Le domino ne correspond pas à l''extrémité.';
      END IF;

      rotation := public.get_played_tile_rotation(tile, side, open_ends);
    ELSE
      side := 'start';
      rotation := tile;
    END IF;

    SELECT jsonb_agg(elem) INTO p_hand
    FROM (
      SELECT elem FROM jsonb_array_elements(p_hand) elem
      EXCEPT ALL
      SELECT tile
    ) sub;

    p_hand := COALESCE(p_hand, '[]'::jsonb);
    p_hand_len := jsonb_array_length(p_hand);

    UPDATE public.room_hands
    SET hand = p_hand
    WHERE room_id = NEW.room_id AND player_id = p_id;

    new_placed_tile := jsonb_build_object(
      'id', public.generateId(),
      'tile', tile,
      'connectedAs', rotation,
      'isDouble', (tile->>0)::int = (tile->>1)::int,
      'playedAt', side
    );
    placed_tiles := placed_tiles || new_placed_tile;

    -- Score Fives
    sum_ends := public.calculate_board_score(placed_tiles);
    IF sum_ends % 5 = 0 AND sum_ends > 0 THEN
      points := sum_ends;
      IF p_id = r_row.creator_id THEN
        creator_score := creator_score + points;
      ELSE
        opponent_score := opponent_score + points;
      END IF;

      -- Check if target score is reached
      IF creator_score >= target_score OR opponent_score >= target_score THEN
        r_row.status := 'finished';
        IF creator_score >= target_score THEN
          r_row.winner_id := r_row.creator_id;
        ELSE
          r_row.winner_id := r_row.opponent_id;
        END IF;

        g_state := g_state || jsonb_build_object(
          'placedTiles', placed_tiles,
          'score_creator', creator_score,
          'score_opponent', opponent_score
        );

        UPDATE public.rooms
        SET status = r_row.status, winner_id = r_row.winner_id, game_state = g_state, updated_at = NOW()
        WHERE id = NEW.room_id;

        INSERT INTO public.room_events (room_id, player_id, event_type)
        VALUES (NEW.room_id, p_id, 'MATCH_FINISHED');

        RETURN NEW;
      END IF;
    END IF;

    -- Victoire par Domino
    IF p_hand_len = 0 THEN
      o_pips := public.calculate_remaining_pips(o_hand);
      round_score := public.round_to_nearest_five(o_pips);
      
      IF p_id = r_row.creator_id THEN
        creator_score := creator_score + round_score;
      ELSE
        opponent_score := opponent_score + round_score;
      END IF;

      IF creator_score >= target_score OR opponent_score >= target_score THEN
        r_row.status := 'finished';
        IF creator_score >= target_score THEN
          r_row.winner_id := r_row.creator_id;
        ELSE
          r_row.winner_id := r_row.opponent_id;
        END IF;
      END IF;

      reveal_phase := 'revealing';
      reveal_data := jsonb_build_object(
        'result', 'domino',
        'roundWinner', p_id,
        'creatorHand', p_hand,
        'opponentHand', o_hand,
        'creatorPipsSum', 0,
        'opponentPipsSum', o_pips,
        'scoreGained', round_score
      );

      g_state := g_state || jsonb_build_object(
        'placedTiles', placed_tiles,
        'score_creator', creator_score,
        'score_opponent', opponent_score,
        'revealPhase', reveal_phase,
        'revealData', reveal_data,
        'nextRoundStarter', p_id
      );

      UPDATE public.rooms
      SET status = r_row.status, winner_id = r_row.winner_id, game_state = g_state, updated_at = NOW()
      WHERE id = NEW.room_id;

      INSERT INTO public.room_events (room_id, player_id, event_type)
      VALUES (NEW.room_id, p_id, 'ROUND_DOMINO');

      RETURN NEW;
    END IF;

    -- Blocage de manche
    open_ends := public.get_open_ends(placed_tiles);
    p_can_play := public.has_playable_tile(p_hand, open_ends);
    o_can_play := public.has_playable_tile(o_hand, open_ends);

    IF NOT p_can_play AND NOT o_can_play AND b_count = 0 THEN
      p_pips := public.calculate_remaining_pips(p_hand);
      o_pips := public.calculate_remaining_pips(o_hand);

      IF p_pips < o_pips THEN
        round_winner_id := p_id;
        round_score := public.round_to_nearest_five(o_pips - p_pips);
        tie_explain := 'Vous avez moins de pips restants (' || p_pips || ' vs ' || o_pips || ').';
      ELSIF o_pips < p_pips THEN
        round_winner_id := o_id;
        round_score := public.round_to_nearest_five(p_pips - o_pips);
        tie_explain := 'L''adversaire a moins de pips restants (' || o_pips || ' vs ' || p_pips || ').';
      ELSE
        round_winner_id := public.determine_tiebreaker_winner(p_hand, p_id, o_hand, o_id);
        round_score := 0;
        IF round_winner_id = p_id THEN
          tie_explain := 'Pips égaux (' || p_pips || '). Vainqueur au tie-breaker.';
        ELSE
          tie_explain := 'Pips égaux (' || p_pips || '). L''adversaire gagne au tie-breaker.';
        END IF;
      END IF;

      IF round_winner_id = r_row.creator_id THEN
        creator_score := creator_score + round_score;
      ELSE
        opponent_score := opponent_score + round_score;
      END IF;

      IF creator_score >= target_score OR opponent_score >= target_score THEN
        r_row.status := 'finished';
        IF creator_score >= target_score THEN
          r_row.winner_id := r_row.creator_id;
        ELSE
          r_row.winner_id := r_row.opponent_id;
        END IF;
      END IF;

      reveal_phase := 'revealing';
      reveal_data := jsonb_build_object(
        'result', 'blocked',
        'roundWinner', round_winner_id,
        'creatorHand', p_hand,
        'opponentHand', o_hand,
        'creatorPipsSum', p_pips,
        'opponentPipsSum', o_pips,
        'scoreGained', round_score,
        'tieBreakExplained', tie_explain
      );

      g_state := g_state || jsonb_build_object(
        'placedTiles', placed_tiles,
        'score_creator', creator_score,
        'score_opponent', opponent_score,
        'revealPhase', reveal_phase,
        'revealData', reveal_data,
        'nextRoundStarter', round_winner_id
      );

      UPDATE public.rooms
      SET status = r_row.status, winner_id = r_row.winner_id, game_state = g_state, updated_at = NOW()
      WHERE id = NEW.room_id;

      INSERT INTO public.room_events (room_id, player_id, event_type)
      VALUES (NEW.room_id, p_id, 'ROUND_BLOCKED');

      RETURN NEW;
    END IF;

    -- Tour suivant (ou auto-pass si l'adversaire est bloqué et qu'il n'y a plus de pioche)
    IF o_can_play OR b_count > 0 THEN
      next_turn := o_id;
    ELSE
      next_turn := p_id;
    END IF;

    g_state := g_state || jsonb_build_object(
      'placedTiles', placed_tiles,
      'score_creator', creator_score,
      'score_opponent', opponent_score,
      'currentPlayer', next_turn
    );

    UPDATE public.rooms
    SET game_state = g_state, updated_at = NOW()
    WHERE id = NEW.room_id;

    RETURN NEW;
  END IF;

  -- 5. Traitement DRAW_TILE
  IF action_type = 'DRAW_TILE' THEN
    IF b_count = 0 THEN
      RAISE EXCEPTION 'Pioche vide.';
    END IF;

    open_ends := public.get_open_ends(placed_tiles);
    IF public.has_playable_tile(p_hand, open_ends) THEN
      RAISE EXCEPTION 'Vous avez des coups jouables. Pioche interdite.';
    END IF;

    SELECT tiles INTO boneyard FROM public.room_boneyard WHERE room_id = NEW.room_id FOR UPDATE;
    
    idx := 0;
    drawn_tile := boneyard->idx;
    
    SELECT jsonb_agg(elem) INTO boneyard
    FROM (
      SELECT elem, row_number() over() - 1 as rn FROM jsonb_array_elements(boneyard) elem
    ) sub
    WHERE rn <> idx;

    boneyard := COALESCE(boneyard, '[]'::jsonb);
    b_count := jsonb_array_length(boneyard);

    p_hand := p_hand || drawn_tile;

    UPDATE public.room_hands
    SET hand = p_hand
    WHERE room_id = NEW.room_id AND player_id = p_id;

    UPDATE public.room_boneyard
    SET tiles = boneyard
    WHERE room_id = NEW.room_id;

    IF public.has_playable_tile(jsonb_build_array(drawn_tile), open_ends) THEN
      next_turn := p_id;
    ELSE
      IF b_count > 0 THEN
        next_turn := p_id;
      ELSE
        IF public.has_playable_tile(o_hand, open_ends) THEN
          next_turn := o_id;
        ELSE
          p_pips := public.calculate_remaining_pips(p_hand);
          o_pips := public.calculate_remaining_pips(o_hand);

          IF p_pips < o_pips THEN
            round_winner_id := p_id;
            round_score := public.round_to_nearest_five(o_pips - p_pips);
            tie_explain := 'Moins de pips restants (' || p_pips || ' vs ' || o_pips || ').';
          ELSIF o_pips < p_pips THEN
            round_winner_id := o_id;
            round_score := public.round_to_nearest_five(p_pips - o_pips);
            tie_explain := 'L''adversaire a moins de pips restants (' || o_pips || ' vs ' || p_pips || ').';
          ELSE
            round_winner_id := public.determine_tiebreaker_winner(p_hand, p_id, o_hand, o_id);
            round_score := 0;
            IF round_winner_id = p_id THEN
              tie_explain := 'Pips égaux (' || p_pips || '). Vainqueur au tie-breaker.';
            ELSE
              tie_explain := 'Pips égaux (' || p_pips || '). L''adversaire gagne au tie-breaker.';
            END IF;
          END IF;

          IF round_winner_id = r_row.creator_id THEN
            creator_score := creator_score + round_score;
          ELSE
            opponent_score := opponent_score + round_score;
          END IF;

          IF creator_score >= target_score OR opponent_score >= target_score THEN
            r_row.status := 'finished';
            IF creator_score >= target_score THEN
              r_row.winner_id := r_row.creator_id;
            ELSE
              r_row.winner_id := r_row.opponent_id;
            END IF;
          END IF;

          reveal_phase := 'revealing';
          reveal_data := jsonb_build_object(
            'result', 'blocked',
            'roundWinner', round_winner_id,
            'creatorHand', p_hand,
            'opponentHand', o_hand,
            'creatorPipsSum', p_pips,
            'opponentPipsSum', o_pips,
            'scoreGained', round_score,
            'tieBreakExplained', tie_explain
          );

          g_state := g_state || jsonb_build_object(
            'score_creator', creator_score,
            'score_opponent', opponent_score,
            'boneyard_count', 0,
            'revealPhase', reveal_phase,
            'revealData', reveal_data,
            'nextRoundStarter', round_winner_id
          );

          UPDATE public.rooms
          SET status = r_row.status, winner_id = r_row.winner_id, game_state = g_state, updated_at = NOW()
          WHERE id = NEW.room_id;

          INSERT INTO public.room_events (room_id, player_id, event_type)
          VALUES (NEW.room_id, p_id, 'ROUND_BLOCKED');

          RETURN NEW;
        END IF;
      END IF;
    END IF;

    g_state := g_state || jsonb_build_object(
      'boneyard_count', b_count,
      'currentPlayer', next_turn
    );

    UPDATE public.rooms
    SET game_state = g_state, updated_at = NOW()
    WHERE id = NEW.room_id;

    RETURN NEW;
  END IF;

  -- 6. Traitement PASS
  IF action_type = 'PASS' THEN
    IF b_count > 0 THEN
      RAISE EXCEPTION 'La pioche n''est pas vide. Vous devez piocher.';
    END IF;

    open_ends := public.get_open_ends(placed_tiles);
    IF public.has_playable_tile(p_hand, open_ends) THEN
      RAISE EXCEPTION 'Vous avez des coups jouables. Passage interdit.';
    END IF;

    IF NOT public.has_playable_tile(o_hand, open_ends) THEN
      p_pips := public.calculate_remaining_pips(p_hand);
      o_pips := public.calculate_remaining_pips(o_hand);

      IF p_pips < o_pips THEN
        round_winner_id := p_id;
        round_score := public.round_to_nearest_five(o_pips - p_pips);
        tie_explain := 'Moins de pips restants (' || p_pips || ' vs ' || o_pips || ').';
      ELSIF o_pips < p_pips THEN
        round_winner_id := o_id;
        round_score := public.round_to_nearest_five(p_pips - o_pips);
        tie_explain := 'L''adversaire a moins de pips restants (' || o_pips || ' vs ' || p_pips || ').';
      ELSE
        round_winner_id := public.determine_tiebreaker_winner(p_hand, p_id, o_hand, o_id);
        round_score := 0;
        IF round_winner_id = p_id THEN
          tie_explain := 'Pips égaux (' || p_pips || '). Vainqueur au tie-breaker.';
        ELSE
          tie_explain := 'Pips égaux (' || p_pips || '). L''adversaire gagne au tie-breaker.';
        END IF;
      END IF;

      IF round_winner_id = r_row.creator_id THEN
        creator_score := creator_score + round_score;
      ELSE
        opponent_score := opponent_score + round_score;
      END IF;

      IF creator_score >= target_score OR opponent_score >= target_score THEN
        r_row.status := 'finished';
        IF creator_score >= target_score THEN
          r_row.winner_id := r_row.creator_id;
        ELSE
          r_row.winner_id := r_row.opponent_id;
        END IF;
      END IF;

      reveal_phase := 'revealing';
      reveal_data := jsonb_build_object(
        'result', 'blocked',
        'roundWinner', round_winner_id,
        'creatorHand', p_hand,
        'opponentHand', o_hand,
        'creatorPipsSum', p_pips,
        'opponentPipsSum', o_pips,
        'scoreGained', round_score,
        'tieBreakExplained', tie_explain
      );

      g_state := g_state || jsonb_build_object(
        'score_creator', creator_score,
        'score_opponent', opponent_score,
        'revealPhase', reveal_phase,
        'revealData', reveal_data,
        'nextRoundStarter', round_winner_id
      );

      UPDATE public.rooms
      SET status = r_row.status, winner_id = r_row.winner_id, game_state = g_state, updated_at = NOW()
      WHERE id = NEW.room_id;

      INSERT INTO public.room_events (room_id, player_id, event_type)
      VALUES (NEW.room_id, p_id, 'ROUND_BLOCKED');
    ELSE
      g_state := g_state || jsonb_build_object(
        'currentPlayer', o_id
      );

      UPDATE public.rooms
      SET game_state = g_state, updated_at = NOW()
      WHERE id = NEW.room_id;
    END IF;

    RETURN NEW;
  END IF;

  RAISE EXCEPTION 'Action non supportée.';
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER on_move_before_insert
  BEFORE INSERT ON public.moves
  FOR EACH ROW EXECUTE FUNCTION public.handle_move_insert();

-- ========================================================
-- 7. MISES À JOUR DES STATISTIQUES AUTOMATIQUES
-- ========================================================
CREATE OR REPLACE FUNCTION public.update_profiles_stats()
RETURNS TRIGGER AS $$
DECLARE
  winner_uuid UUID;
  loser_uuid UUID;
BEGIN
  IF NEW.status = 'finished' AND OLD.status <> 'finished' AND NEW.winner_id IS NOT NULL THEN
    winner_uuid := NEW.winner_id;
    IF winner_uuid = NEW.creator_id THEN
      loser_uuid := NEW.opponent_id;
    ELSE
      loser_uuid := NEW.creator_id;
    END IF;

    IF winner_uuid IS NOT NULL THEN
      UPDATE public.profiles
      SET games_played = games_played + 1,
          games_won = games_won + 1,
          win_rate = ROUND(((games_won + 1)::numeric / (games_played + 1)::numeric) * 100.0, 2)
      WHERE id = winner_uuid;
    END IF;

    IF loser_uuid IS NOT NULL THEN
      UPDATE public.profiles
      SET games_played = games_played + 1,
          games_lost = games_lost + 1,
          win_rate = ROUND((games_won::numeric / (games_played + 1)::numeric) * 100.0, 2)
      WHERE id = loser_uuid;
    END IF;
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER on_room_finished_update_stats
  AFTER UPDATE ON public.rooms
  FOR EACH ROW EXECUTE FUNCTION public.update_profiles_stats();

-- ========================================================
-- 8. GESTION DES RECONNEXIONS & FORFAITS
-- ========================================================

-- A. Déclarer une déconnexion d'adversaire
CREATE OR REPLACE FUNCTION public.mark_player_disconnected(p_room_id UUID, p_player_id UUID)
RETURNS VOID AS $$
DECLARE
  r_row public.rooms%ROWTYPE;
BEGIN
  SELECT * INTO r_row FROM public.rooms WHERE id = p_room_id;
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Salon introuvable.';
  END IF;

  IF auth.uid() <> r_row.creator_id AND auth.uid() <> r_row.opponent_id THEN
    RAISE EXCEPTION 'Non autorisé.';
  END IF;
  IF auth.uid() = p_player_id THEN
    RAISE EXCEPTION 'Impossible de vous marquer déconnecté vous-même.';
  END IF;

  PERFORM set_config('app.game_mutation_authorized', 'true', true);

  IF p_player_id = r_row.creator_id THEN
    UPDATE public.rooms
    SET creator_disconnected_at = COALESCE(creator_disconnected_at, NOW())
    WHERE id = p_room_id;
  ELSIF p_player_id = r_row.opponent_id THEN
    UPDATE public.rooms
    SET opponent_disconnected_at = COALESCE(opponent_disconnected_at, NOW())
    WHERE id = p_room_id;
  END IF;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

-- B. Réclamer forfait (après 180s)
CREATE OR REPLACE FUNCTION public.claim_forfeit(p_room_id UUID)
RETURNS VOID AS $$
DECLARE
  r_row public.rooms%ROWTYPE;
  disconnected_time TIMESTAMP WITH TIME ZONE;
  caller_id UUID := auth.uid();
  g_state JSONB;
BEGIN
  SELECT * INTO r_row FROM public.rooms WHERE id = p_room_id FOR UPDATE;
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Salon introuvable.';
  END IF;

  IF r_row.status <> 'active' THEN
    RAISE EXCEPTION 'Salon inactif.';
  END IF;

  IF caller_id <> r_row.creator_id AND caller_id <> r_row.opponent_id THEN
    RAISE EXCEPTION 'Non autorisé.';
  END IF;

  IF caller_id = r_row.creator_id THEN
    disconnected_time := r_row.opponent_disconnected_at;
  ELSE
    disconnected_time := r_row.creator_disconnected_at;
  END IF;

  IF disconnected_time IS NULL THEN
    RAISE EXCEPTION 'L''adversaire n''est pas marqué comme déconnecté.';
  END IF;

  IF NOW() < disconnected_time + INTERVAL '180 seconds' THEN
    RAISE EXCEPTION 'Veuillez patienter 180 secondes.';
  END IF;

  PERFORM set_config('app.game_mutation_authorized', 'true', true);

  g_state := r_row.game_state || jsonb_build_object(
    'matchStatus', 'finished',
    'winner', CASE WHEN caller_id = r_row.creator_id THEN 'creator' ELSE 'opponent' END
  );

  UPDATE public.rooms
  SET status = 'finished',
      winner_id = caller_id,
      game_state = g_state,
      updated_at = NOW()
  WHERE id = p_room_id;

  INSERT INTO public.room_events (room_id, player_id, event_type)
  VALUES (p_room_id, caller_id, 'FORFEIT_VICTORY');
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

-- C. Enregistrer une reconnexion
CREATE OR REPLACE FUNCTION public.register_reconnect(p_room_id UUID)
RETURNS VOID AS $$
BEGIN
  PERFORM set_config('app.game_mutation_authorized', 'true', true);
  
  IF auth.uid() = (SELECT creator_id FROM public.rooms WHERE id = p_room_id) THEN
    UPDATE public.rooms
    SET creator_disconnected_at = NULL
    WHERE id = p_room_id;
  ELSIF auth.uid() = (SELECT opponent_id FROM public.rooms WHERE id = p_room_id) THEN
    UPDATE public.rooms
    SET opponent_disconnected_at = NULL
    WHERE id = p_room_id;
  END IF;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;