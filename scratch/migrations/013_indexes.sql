
-- ========================================================
-- MIGRATION: 013_indexes.sql
-- OBJECTIF : Optimisation des performances via Index
-- ========================================================
CREATE INDEX IF NOT EXISTS idx_announcements_status_date ON public.community_announcements(status, published_at DESC);
CREATE INDEX IF NOT EXISTS idx_comments_entity ON public.generic_comments(entity_type, entity_id);
CREATE INDEX IF NOT EXISTS idx_reactions_entity ON public.generic_reactions(entity_type, entity_id);
CREATE INDEX IF NOT EXISTS idx_availability_search ON public.user_availabilities(day_of_week, start_time, end_time);
CREATE INDEX IF NOT EXISTS idx_user_roles_user ON public.user_roles(user_id);
