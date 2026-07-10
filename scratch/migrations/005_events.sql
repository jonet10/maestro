
-- ========================================================
-- MIGRATION: 005_events.sql
-- OBJECTIF : Module événementiel
-- DEPENDANCES : profiles
-- ========================================================
CREATE TABLE IF NOT EXISTS public.community_events (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  organizer_id UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
  title_i18n JSONB NOT NULL,
  description_i18n JSONB NOT NULL,
  image_url TEXT,
  start_date TIMESTAMPTZ NOT NULL,
  end_date TIMESTAMPTZ NOT NULL,
  timezone TEXT NOT NULL,
  max_participants INT,
  status TEXT DEFAULT 'upcoming',
  created_at TIMESTAMPTZ DEFAULT NOW(),
  updated_at TIMESTAMPTZ DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS public.event_participants (
  event_id UUID REFERENCES public.community_events(id) ON DELETE CASCADE,
  user_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
  status TEXT DEFAULT 'registered',
  created_at TIMESTAMPTZ DEFAULT NOW(),
  PRIMARY KEY (event_id, user_id)
);
