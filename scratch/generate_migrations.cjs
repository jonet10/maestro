const fs = require('fs');
const path = require('path');

const migrationsDir = path.join(__dirname, 'migrations');
if (!fs.existsSync(migrationsDir)) {
  fs.mkdirSync(migrationsDir);
}

const templates = [
  {
    filename: '001_roles.sql',
    content: `
-- ========================================================
-- MIGRATION: 001_roles.sql
-- OBJECTIF : Créer le système RBAC (rôles)
-- DEPENDANCES : profiles
-- IMPACT : Nouvelles tables ajoutées. Zéro régression.
-- PERF : Index automatique sur PK.
-- ========================================================
CREATE TABLE IF NOT EXISTS public.roles (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  name TEXT UNIQUE NOT NULL,
  description TEXT
);

CREATE TABLE IF NOT EXISTS public.user_roles (
  user_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
  role_id UUID REFERENCES public.roles(id) ON DELETE CASCADE,
  PRIMARY KEY (user_id, role_id)
);
`
  },
  {
    filename: '002_permissions.sql',
    content: `
-- ========================================================
-- MIGRATION: 002_permissions.sql
-- OBJECTIF : Permissions granulaires pour le RBAC
-- DEPENDANCES : roles
-- IMPACT : Nouvelles tables ajoutées.
-- ========================================================
CREATE TABLE IF NOT EXISTS public.permissions (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  resource TEXT NOT NULL,
  action TEXT NOT NULL,
  description TEXT,
  UNIQUE(resource, action)
);

CREATE TABLE IF NOT EXISTS public.role_permissions (
  role_id UUID REFERENCES public.roles(id) ON DELETE CASCADE,
  permission_id UUID REFERENCES public.permissions(id) ON DELETE CASCADE,
  PRIMARY KEY (role_id, permission_id)
);
`
  },
  {
    filename: '003_system_settings.sql',
    content: `
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
`
  },
  {
    filename: '004_announcements.sql',
    content: `
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
`
  },
  {
    filename: '005_events.sql',
    content: `
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
`
  },
  {
    filename: '006_comments.sql',
    content: `
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
`
  },
  {
    filename: '007_reactions.sql',
    content: `
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
`
  },
  {
    filename: '008_achievements.sql',
    content: `
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
`
  },
  {
    filename: '009_leaderboards.sql',
    content: `
-- ========================================================
-- MIGRATION: 009_leaderboards.sql
-- OBJECTIF : Saisons et statistiques de classements
-- DEPENDANCES : profiles
-- ========================================================
CREATE TABLE IF NOT EXISTS public.seasons (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  name_i18n JSONB NOT NULL,
  number INT NOT NULL UNIQUE,
  start_date TIMESTAMPTZ NOT NULL,
  end_date TIMESTAMPTZ NOT NULL,
  status TEXT DEFAULT 'upcoming'
);

CREATE TABLE IF NOT EXISTS public.season_rankings (
  season_id UUID REFERENCES public.seasons(id) ON DELETE CASCADE,
  player_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
  final_elo INT NOT NULL,
  final_rank INT NOT NULL,
  matches_played INT DEFAULT 0,
  wins INT DEFAULT 0,
  PRIMARY KEY (season_id, player_id)
);

CREATE TABLE IF NOT EXISTS public.player_stats_aggregations (
  user_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE PRIMARY KEY,
  current_streak INT DEFAULT 0,
  max_streak INT DEFAULT 0,
  weekly_wins INT DEFAULT 0,
  monthly_wins INT DEFAULT 0,
  updated_at TIMESTAMPTZ DEFAULT NOW()
);
`
  },
  {
    filename: '010_notifications.sql',
    content: `
-- ========================================================
-- MIGRATION: 010_notifications.sql
-- OBJECTIF : Amélioration des notifications existantes (compatible)
-- DEPENDANCES : notifications
-- ========================================================
ALTER TABLE public.notifications
ADD COLUMN IF NOT EXISTS entity_type TEXT,
ADD COLUMN IF NOT EXISTS entity_id UUID;
`
  },
  {
    filename: '011_availability.sql',
    content: `
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
`
  },
  {
    filename: '012_admin.sql',
    content: `
-- ========================================================
-- MIGRATION: 012_admin.sql
-- OBJECTIF : Modération et Logs d'Audit
-- DEPENDANCES : profiles
-- ========================================================
CREATE TABLE IF NOT EXISTS public.admin_audit_logs (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  admin_id UUID REFERENCES public.profiles(id) ON DELETE SET NULL,
  action TEXT NOT NULL,
  entity_type TEXT NOT NULL,
  entity_id UUID,
  details JSONB,
  created_at TIMESTAMPTZ DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS public.user_reports (
  id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
  reporter_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
  reported_id UUID REFERENCES public.profiles(id) ON DELETE CASCADE,
  entity_type TEXT,
  entity_id UUID,
  reason TEXT NOT NULL,
  status TEXT DEFAULT 'pending',
  created_at TIMESTAMPTZ DEFAULT NOW()
);
`
  },
  {
    filename: '013_indexes.sql',
    content: `
-- ========================================================
-- MIGRATION: 013_indexes.sql
-- OBJECTIF : Optimisation des performances via Index
-- ========================================================
CREATE INDEX IF NOT EXISTS idx_announcements_status_date ON public.community_announcements(status, published_at DESC);
CREATE INDEX IF NOT EXISTS idx_comments_entity ON public.generic_comments(entity_type, entity_id);
CREATE INDEX IF NOT EXISTS idx_reactions_entity ON public.generic_reactions(entity_type, entity_id);
CREATE INDEX IF NOT EXISTS idx_availability_search ON public.user_availabilities(day_of_week, start_time, end_time);
CREATE INDEX IF NOT EXISTS idx_user_roles_user ON public.user_roles(user_id);
`
  },
  {
    filename: '014_rls.sql',
    content: `
-- ========================================================
-- MIGRATION: 014_rls.sql
-- OBJECTIF : Activation des politiques de sécurité
-- ========================================================
ALTER TABLE public.community_announcements ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.community_events ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.generic_comments ENABLE ROW LEVEL SECURITY;
ALTER TABLE public.generic_reactions ENABLE ROW LEVEL SECURITY;

-- Exemples de politiques de base
CREATE POLICY "Announcements are viewable by everyone" ON public.community_announcements FOR SELECT USING (status = 'published');
CREATE POLICY "Comments are viewable by everyone" ON public.generic_comments FOR SELECT USING (status = 'active');
CREATE POLICY "Users can create their own reactions" ON public.generic_reactions FOR INSERT WITH CHECK (auth.uid() = user_id);
CREATE POLICY "Users can delete their own reactions" ON public.generic_reactions FOR DELETE USING (auth.uid() = user_id);
`
  },
  {
    filename: '015_triggers.sql',
    content: `
-- ========================================================
-- MIGRATION: 015_triggers.sql
-- OBJECTIF : Triggers PostgreSQL (Update Timestamp)
-- ========================================================
CREATE OR REPLACE FUNCTION public.update_updated_at_column()
RETURNS TRIGGER AS $$
BEGIN
    NEW.updated_at = NOW();
    RETURN NEW;
END;
$$ language 'plpgsql';

DROP TRIGGER IF EXISTS update_community_announcements_modtime ON public.community_announcements;
CREATE TRIGGER update_community_announcements_modtime
    BEFORE UPDATE ON public.community_announcements
    FOR EACH ROW EXECUTE PROCEDURE public.update_updated_at_column();
`
  },
  {
    filename: '016_views.sql',
    content: `
-- ========================================================
-- MIGRATION: 016_views.sql
-- OBJECTIF : Vues Matérialisées Hautes Performances (Classements)
-- ========================================================
CREATE MATERIALIZED VIEW IF NOT EXISTS public.mat_view_global_leaderboard AS
SELECT 
  p.id AS player_id,
  p.username,
  p.avatar_url,
  p.elo_rating,
  p.games_played,
  p.games_won,
  p.win_rate,
  COALESCE(psa.current_streak, 0) AS current_streak
FROM public.profiles p
LEFT JOIN public.player_stats_aggregations psa ON p.id = psa.user_id
WHERE p.games_played > 0
ORDER BY p.elo_rating DESC;

CREATE UNIQUE INDEX IF NOT EXISTS idx_mat_view_global_leaderboard_player_id ON public.mat_view_global_leaderboard(player_id);
`
  },
  {
    filename: '017_seed.sql',
    content: `
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
`
  }
];

templates.forEach(t => {
  fs.writeFileSync(path.join(migrationsDir, t.filename), t.content);
});
console.log('Successfully generated ' + templates.length + ' migration files.');
