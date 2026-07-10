
-- ========================================================
-- MIGRATION: 014_rls.sql
-- OBJECTIF : Activation des politiques de sécurité
-- ========================================================
ALTER TABLE public.community_announcements ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.community_events ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.generic_comments ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.generic_reactions ENABLE ROW LEVEL SECURITY;

-- Exemples de politiques de base
CREATE POLICY "Announcements are viewable by everyone" ON public.community_announcements FOR SELECT USING (status = 'published');
CREATE POLICY "Comments are viewable by everyone" ON public.generic_comments FOR SELECT USING (status = 'active');
CREATE POLICY "Users can create their own reactions" ON public.generic_reactions FOR INSERT WITH CHECK (auth.uid() = user_id);
CREATE POLICY "Users can delete their own reactions" ON public.generic_reactions FOR DELETE USING (auth.uid() = user_id);
