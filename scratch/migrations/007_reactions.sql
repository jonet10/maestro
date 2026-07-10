
-- ========================================================
-- MIGRATION: 007_reactions.sql
-- OBJECTIF : Système générique de réactions (emojis)
-- DEPENDANCES : profiles
-- ========================================================
CREATE TABLE IF NOT EXISTS public.generic_reactions (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  entity_type TEXT NOT NULL,
  entity_id UUID NOT NULL,
  user_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
  emoji TEXT NOT NULL,
  created_at TIMESTAMPTZ DEFAULT NOW(),
  UNIQUE (entity_type, entity_id, user_id, emoji)
);
