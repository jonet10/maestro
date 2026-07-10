
-- ========================================================
-- MIGRATION: 010_notifications.sql
-- OBJECTIF : Amélioration des notifications existantes (compatible)
-- DEPENDANCES : notifications
-- ========================================================
ALTER TABLE public.notifications
ADD COLUMN IF NOT EXISTS entity_type TEXT,
ADD COLUMN IF NOT EXISTS entity_id UUID;
