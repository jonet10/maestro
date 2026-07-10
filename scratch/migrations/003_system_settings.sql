
-- ========================================================
-- MIGRATION: 003_system_settings.sql
-- OBJECTIF : Préférences utilisateur et variables globales système
-- DEPENDANCES : profiles
-- ========================================================
CREATE TABLE IF NOT EXISTS public.user_preferences (
  user_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE PRIMARY KEY,
  email_notifs BOOLEAN DEFAULT true,
  push_notifs BOOLEAN DEFAULT true,
  public_profile BOOLEAN DEFAULT true,
  show_country BOOLEAN DEFAULT true,
  show_stats BOOLEAN DEFAULT true,
  accept_invites BOOLEAN DEFAULT true,
  accept_dms BOOLEAN DEFAULT true
);

CREATE TABLE IF NOT EXISTS public.system_settings (
  key TEXT PRIMARY KEY,
  value JSONB NOT NULL,
  description TEXT,
  updated_by UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
  updated_at TIMESTAMPTZ DEFAULT NOW()
);
