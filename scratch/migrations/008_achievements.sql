
-- ========================================================
-- MIGRATION: 008_achievements.sql
-- OBJECTIF : Badges et gamification
-- DEPENDANCES : profiles
-- ========================================================
CREATE TABLE IF NOT EXISTS public.achievements (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  code TEXT UNIQUE NOT NULL,
  name_i18n JSONB NOT NULL,
  description_i18n JSONB NOT NULL,
  icon_url TEXT,
  criteria JSONB NOT NULL
);

CREATE TABLE IF NOT EXISTS public.user_achievements (
  user_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
  achievement_id UUID REFERENCES public.achievements(id) ON DELETE CASCADE,
  unlocked_at TIMESTAMPTZ DEFAULT NOW(),
  PRIMARY KEY (user_id, achievement_id)
);
