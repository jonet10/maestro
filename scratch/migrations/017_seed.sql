
-- ========================================================
-- MIGRATION: 017_seed.sql
-- OBJECTIF : Données de démonstration initiales (Seed)
-- ========================================================
INSERT INTO public.roles (name, description) VALUES 
('SuperAdmin', 'Administrateur principal'),
('Moderator', 'Modérateur de la communauté')
ON CONFLICT (name) DO NOTHING;

INSERT INTO public.system_settings (key, value, description) VALUES
('maintenance_mode', 'false'::jsonb, 'Active ou désactive l''accès au jeu'),
('featured_player_id', 'null'::jsonb, 'ID du joueur mis en vedette')
ON CONFLICT (key) DO NOTHING;

INSERT INTO public.seasons (name_i18n, number, start_date, end_date, status) VALUES
('{"fr": "Saison 1: L''Éveil", "en": "Season 1: Awakening"}'::jsonb, 1, NOW(), NOW() + INTERVAL '3 months', 'active')
ON CONFLICT (number) DO NOTHING;
