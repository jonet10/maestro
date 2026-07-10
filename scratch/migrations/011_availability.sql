
-- ========================================================
-- MIGRATION: 011_availability.sql
-- OBJECTIF : Planification et disponibilités
-- DEPENDANCES : profiles
-- ========================================================
CREATE TABLE IF NOT EXISTS public.user_availabilities (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  user_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
  day_of_week INT NOT NULL CHECK (day_of_week BETWEEN 0 AND 6),
  start_time TIME NOT NULL,
  end_time TIME NOT NULL,
  timezone TEXT NOT NULL
);
