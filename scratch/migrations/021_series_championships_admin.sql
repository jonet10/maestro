-- A. Nouvelles colonnes sur la table rooms
ALTER TABLE public.rooms ADD COLUMN IF NOT EXISTS match_mode TEXT DEFAULT 'first_to' CHECK (match_mode IN ('single', 'first_to', 'fixed'));
ALTER TABLE public.rooms ADD COLUMN IF NOT EXISTS target_manches INT DEFAULT 3;

-- B. Nouvelles tables pour Championnats, Tournois et Saisons
CREATE TABLE IF NOT EXISTS public.seasons (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  number INT UNIQUE NOT NULL,
  start_date TIMESTAMP WITH TIME ZONE NOT NULL,
  end_date TIMESTAMP WITH TIME ZONE NOT NULL,
  rewards JSONB DEFAULT '{}'::jsonb NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL
);

CREATE TABLE IF NOT EXISTS public.competitions (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  name TEXT NOT NULL,
  description TEXT,
  start_date TIMESTAMP WITH TIME ZONE,
  end_date TIMESTAMP WITH TIME ZONE,
  status TEXT DEFAULT 'waiting' CHECK (status IN ('waiting', 'ongoing', 'finished', 'cancelled', 'abandoned')),
  type TEXT NOT NULL CHECK (type IN ('championship', 'tournament', 'season')),
  settings JSONB DEFAULT '{}'::jsonb NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL
);

CREATE TABLE IF NOT EXISTS public.series (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  competition_id UUID REFERENCES public.competitions(id) ON DELETE CASCADE,
  player1_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
  player2_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
  winner_id UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
  match_mode TEXT DEFAULT 'first_to' NOT NULL CHECK (match_mode IN ('single', 'first_to', 'fixed')),
  target_manches INT DEFAULT 3 NOT NULL,
  status TEXT DEFAULT 'waiting' NOT NULL CHECK (status IN ('waiting', 'ongoing', 'finished', 'cancelled', 'abandoned')),
  created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL
);

CREATE TABLE IF NOT EXISTS public.rounds (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  series_id UUID REFERENCES public.series(id) ON DELETE CASCADE NOT NULL,
  round_number INT NOT NULL,
  winner_id UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
  player1_score INT DEFAULT 0 NOT NULL,
  player2_score INT DEFAULT 0 NOT NULL,
  created_at TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL
);

CREATE TABLE IF NOT EXISTS public.season_rankings (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  season_id UUID REFERENCES public.seasons(id) ON DELETE CASCADE NOT NULL,
  player_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE NOT NULL,
  rank INT,
  points INT DEFAULT 0 NOT NULL,
  updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL,
  CONSTRAINT unique_season_player UNIQUE (season_id, player_id)
);

CREATE TABLE IF NOT EXISTS public.competition_settings (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  key TEXT UNIQUE NOT NULL,
  value JSONB NOT NULL,
  description TEXT,
  updated_at TIMESTAMP WITH TIME ZONE DEFAULT NOW() NOT NULL
);

-- C. Surcharge compatible de la fonction RPC create_room avec paramètres par défaut
CREATE OR REPLACE FUNCTION public.create_room(
  room_name TEXT,
  target_score INT,
  deal_option TEXT,
  visibility TEXT,
  match_mode TEXT DEFAULT 'first_to',
  target_manches INT DEFAULT 3
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
    status,
    match_mode,
    target_manches,
    game_state
  )
  VALUES (
    room_name,
    auth.uid(),
    target_score,
    deal_option,
    visibility,
    code,
    'waiting',
    match_mode,
    target_manches,
    jsonb_build_object(
      'match_mode', match_mode,
      'target_manches', CASE WHEN match_mode = 'fixed' THEN 9999 WHEN match_mode = 'single' THEN 1 ELSE target_manches END,
      'rounds_won_creator', 0,
      'rounds_won_opponent', 0,
      'rounds_played', 0,
      'placedTiles', '[]'::jsonb,
      'boneyard_count', 14,
      'matchStatus', 'not-started',
      'revealPhase', 'none',
      'revealData', NULL
    )
  )
  RETURNING id INTO new_room_id;

  RETURN new_room_id;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

-- D. RPC finish_fixed_match pour finaliser les matchs à format fixe
CREATE OR REPLACE FUNCTION public.finish_fixed_match(p_room_id UUID)
RETURNS VOID AS $$
DECLARE
  r_row public.rooms%ROWTYPE;
  g_state JSONB;
  rounds_won_c INT;
  rounds_won_o INT;
  winner_uuid UUID := NULL;
BEGIN
  SELECT * INTO r_row FROM public.rooms WHERE id = p_room_id FOR UPDATE;
  IF NOT FOUND THEN
    RAISE EXCEPTION 'Salon introuvable.';
  END IF;

  IF auth.uid() <> r_row.creator_id THEN
    RAISE EXCEPTION 'Seul le créateur peut finaliser le match.';
  END IF;

  g_state := r_row.game_state;
  rounds_won_c := COALESCE((g_state->>'rounds_won_creator')::int, 0);
  rounds_won_o := COALESCE((g_state->>'rounds_won_opponent')::int, 0);

  IF rounds_won_c > rounds_won_o THEN
    winner_uuid := r_row.creator_id;
  ELSIF rounds_won_o > rounds_won_c THEN
    winner_uuid := r_row.opponent_id;
  END IF;

  g_state := g_state || jsonb_build_object('matchStatus', 'finished');

  UPDATE public.rooms
  SET status = 'finished',
      game_state = g_state,
      winner_id = winner_uuid,
      updated_at = NOW()
  WHERE id = p_room_id;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

-- E. Initialisation des paramètres par défaut dans system_settings
INSERT INTO public.system_settings (key, value, description)
VALUES (
  'gameplay_config',
  '{
    "default_match_mode": "first_to",
    "default_target_score": 100,
    "default_target_manches": 3,
    "allow_custom_match_rules": true
  }'::jsonb,
  'Configurations globales du gameplay'
)
ON CONFLICT (key) DO UPDATE
SET value = EXCLUDED.value;

-- F. Promotion automatique du compte super-admin s'il existe déjà
DO $$
DECLARE
  v_user_id UUID;
BEGIN
  SELECT id INTO v_user_id FROM auth.users WHERE email = 'fawentz21@gmail.com';
  IF v_user_id IS NOT NULL THEN
    INSERT INTO public.profiles (id, username, role, is_banned)
    VALUES (v_user_id, 'SuperAdmin', 'super-admin', false)
    ON CONFLICT (id) DO UPDATE
    SET role = 'super-admin',
        is_banned = false;
  END IF;
END $$;
