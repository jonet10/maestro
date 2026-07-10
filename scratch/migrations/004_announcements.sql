
-- ========================================================
-- MIGRATION: 004_announcements.sql
-- OBJECTIF : Annonces communautaires avec i18n
-- DEPENDANCES : profiles
-- ========================================================
CREATE TABLE IF NOT EXISTS public.community_announcements (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  author_id UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
  title_i18n JSONB NOT NULL,
  content_i18n JSONB NOT NULL,
  status TEXT DEFAULT 'draft',
  is_pinned BOOLEAN DEFAULT false,
  published_at TIMESTAMPTZ,
  created_at TIMESTAMPTZ DEFAULT NOW(),
  updated_at TIMESTAMPTZ DEFAULT NOW()
);
