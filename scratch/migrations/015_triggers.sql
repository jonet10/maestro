
-- ========================================================
-- MIGRATION: 015_triggers.sql
-- OBJECTIF : Triggers PostgreSQL (Update Timestamp)
-- ========================================================
CREATE OR REPLACE FUNCTION public.update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ language 'plpgsql';

DROP TRIGGER IF EXISTS update_community_announcements_modtime ON public.community_announcements;
CREATE TRIGGER update_community_announcements_modtime
    BEFORE UPDATE ON public.community_announcements
    FOR EACH ROW EXECUTE PROCEDURE public.update_updated_at_column();
