
-- ========================================================
-- MIGRATION: 006_comments.sql
-- OBJECTIF : Commentaires hiérarchiques et polymorphes
-- DEPENDANCES : profiles
-- ========================================================
CREATE TABLE IF NOT EXISTS public.generic_comments (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  entity_type TEXT NOT NULL,
  entity_id UUID NOT NULL,
  author_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
  parent_id UUID REFERENCES public.generic_comments(id) ON DELETE CASCADE,
  content TEXT NOT NULL,
  status TEXT DEFAULT 'active',
  created_at TIMESTAMPTZ DEFAULT NOW(),
  updated_at TIMESTAMPTZ DEFAULT NOW()
);
