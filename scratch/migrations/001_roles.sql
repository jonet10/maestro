
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
