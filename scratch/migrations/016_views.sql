
-- ========================================================
-- MIGRATION: 016_views.sql
-- OBJECTIF : Vues Matérialisées Hautes Performances (Classements)
-- ========================================================
CREATE MATERIALIZED VIEW IF NOT EXISTS public.mat_view_global_leaderboard AS
SELECT 
  p.id AS player_id,
  p.username,
  p.avatar_url,
  p.elo_rating,
  p.games_played,
  p.games_won,
  p.win_rate,
  COALESCE(psa.current_streak, 0) AS current_streak
FROM public.profiles p
LEFT JOIN public.player_stats_aggregations psa ON p.id = psa.user_id
WHERE p.games_played > 0
ORDER BY p.elo_rating DESC;

CREATE UNIQUE INDEX IF NOT EXISTS idx_mat_view_global_leaderboard_player_id ON public.mat_view_global_leaderboard(player_id);
