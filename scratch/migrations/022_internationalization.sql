-- ========================================================
-- MIGRATION: 022_internationalization.sql
-- OBJECTIF : Système de langues (i18n), pays, fuseaux horaires, disponibilités extensibles et préférences
-- DEPENDANCES : profiles
-- ========================================================

-- A. Ajout des colonnes d'internationalisation à la table profiles
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS country_code TEXT;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS preferred_language TEXT;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS timezone TEXT;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS accept_game_invites BOOLEAN DEFAULT true NOT NULL;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS preferred_match_language TEXT;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS featured_player_id UUID;
ALTER TABLE public.profiles ADD COLUMN IF NOT EXISTS onboarding_completed BOOLEAN DEFAULT false NOT NULL;

-- B. Extension extensible de la table user_availabilities
ALTER TABLE public.user_availabilities ADD COLUMN IF NOT EXISTS created_at TIMESTAMPTZ DEFAULT NOW() NOT NULL;
ALTER TABLE public.user_availabilities ADD COLUMN IF NOT EXISTS type TEXT DEFAULT 'regular' CHECK (type IN ('regular', 'temporary', 'event'));

-- C. Activation et configuration des politiques RLS pour user_availabilities
ALTER TABLE public.user_availabilities ENABLE ROW LEVEL SECURITY;

DROP POLICY IF EXISTS "Availabilities view policy" ON public.user_availabilities;
CREATE POLICY "Availabilities view policy" ON public.user_availabilities
  FOR SELECT USING (true);

DROP POLICY IF EXISTS "Availabilities insert policy" ON public.user_availabilities;
CREATE POLICY "Availabilities insert policy" ON public.user_availabilities
  FOR INSERT WITH CHECK (auth.uid() = user_id);

DROP POLICY IF EXISTS "Availabilities update policy" ON public.user_availabilities;
CREATE POLICY "Availabilities update policy" ON public.user_availabilities
  FOR UPDATE USING (auth.uid() = user_id) WITH CHECK (auth.uid() = user_id);

DROP POLICY IF EXISTS "Availabilities delete policy" ON public.user_availabilities;
CREATE POLICY "Availabilities delete policy" ON public.user_availabilities
  FOR DELETE USING (auth.uid() = user_id);

-- D. Création d'index de performance
CREATE INDEX IF NOT EXISTS idx_user_availabilities_user_id ON public.user_availabilities(user_id);
CREATE INDEX IF NOT EXISTS idx_user_availabilities_day_of_week ON public.user_availabilities(day_of_week);

-- E. Mise à jour de la fonction trigger handle_new_user
CREATE OR REPLACE FUNCTION public.handle_new_user()
RETURNS TRIGGER AS $$
BEGIN
  INSERT INTO public.profiles (
    id, 
    username, 
    avatar_url, 
    role, 
    is_banned, 
    elo_rating,
    country_code,
    preferred_language,
    timezone,
    accept_game_invites,
    preferred_match_language,
    onboarding_completed
  )
  VALUES (
    new.id,
    COALESCE(new.raw_user_meta_data->>'username', 'User_' || substring(new.id::text from 1 for 8)),
    new.raw_user_meta_data->>'avatar_url',
    'player',
    false,
    1000,
    new.raw_user_meta_data->>'country_code',
    new.raw_user_meta_data->>'preferred_language',
    new.raw_user_meta_data->>'timezone',
    COALESCE((new.raw_user_meta_data->>'accept_game_invites')::boolean, true),
    new.raw_user_meta_data->>'preferred_match_language',
    COALESCE((new.raw_user_meta_data->>'onboarding_completed')::boolean, false)
  )
  ON CONFLICT (id) DO NOTHING;
  RETURN new;
END;
$$ LANGUAGE plpgsql SECURITY DEFINER;

-- F. Initialisation de la configuration des langues activées dans system_settings
INSERT INTO public.system_settings (key, value, description)
VALUES (
  'enabled_languages',
  '["fr", "ht", "en", "es", "pt"]'::jsonb,
  'Liste des langues activées sur la plateforme'
)
ON CONFLICT (key) DO UPDATE
SET value = EXCLUDED.value;

-- G. Configuration RLS pour la table system_settings
ALTER TABLE public.system_settings ENABLE ROW LEVEL SECURITY;

DROP POLICY IF EXISTS "System settings read policy" ON public.system_settings;
CREATE POLICY "System settings read policy" ON public.system_settings
  FOR SELECT USING (true);

DROP POLICY IF EXISTS "System settings write policy" ON public.system_settings;
CREATE POLICY "System settings write policy" ON public.system_settings
  FOR ALL TO authenticated
  USING (
    EXISTS (
      SELECT 1 FROM public.profiles
      WHERE id = auth.uid() AND role IN ('admin', 'super-admin')
    )
  )
  WITH CHECK (
    EXISTS (
      SELECT 1 FROM public.profiles
      WHERE id = auth.uid() AND role IN ('admin', 'super-admin')
    )
  );
