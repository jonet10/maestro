
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
