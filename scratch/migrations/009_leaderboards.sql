
-- ========================================================
-- MIGRATION: 009_leaderboards.sql
-- OBJECTIF : Saisons et statistiques de classements
-- DEPENDANCES : profiles
-- ========================================================
CREATE TABLE IF NOT EXISTS public.seasons (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  name_i18n JSONB NOT NULL,
  number INT NOT NULL UNIQUE,
  start_date TIMESTAMPTZ NOT NULL,
  end_date TIMESTAMPTZ NOT NULL,
  status TEXT DEFAULT 'upcoming'
);

CREATE TABLE IF NOT EXISTS public.season_rankings (
  season_id UUID REFERENCES public.seasons(id) ON DELETE CASCADE,
  player_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
  final_elo INT NOT NULL,
  final_rank INT NOT NULL,
  matches_played INT DEFAULT 0,
  wins INT DEFAULT 0,
  PRIMARY KEY (season_id, player_id)
);

CREATE TABLE IF NOT EXISTS public.player_stats_aggregations (
  user_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE PRIMARY KEY,
  current_streak INT DEFAULT 0,
  max_streak INT DEFAULT 0,
  weekly_wins INT DEFAULT 0,
  monthly_wins INT DEFAULT 0,
  updated_at TIMESTAMPTZ DEFAULT NOW()
);
