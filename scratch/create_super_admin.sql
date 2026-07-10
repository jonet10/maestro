-- =========================================================================
-- SCRIPT DE CRÉATION / PROMOTION DU COMPTE SUPER ADMIN
-- =========================================================================
-- Email : admin@maestro.com
-- Mot de passe : @#2026Maestro@
-- =========================================================================

DO $$
DECLARE
  super_admin_id UUID := gen_random_uuid();
  admin_email TEXT := 'admin@maestro.com';
  admin_password TEXT := '@#2026Maestro@';
  hashed_password TEXT;
  user_exists BOOLEAN;
BEGIN
  -- 1. Activer l'extension pgcrypto pour le hachage bcrypt si elle n'est pas activée
  CREATE EXTENSION IF NOT EXISTS pgcrypto;
  
  -- 2. Calculer le hash bcrypt sécurisé du mot de passe
  hashed_password := crypt(admin_password, gen_salt('bf', 10));

  -- 3. Vérifier si l'utilisateur existe déjà
  SELECT EXISTS(SELECT 1 FROM auth.users WHERE email = admin_email) INTO user_exists;

  IF NOT user_exists THEN
    -- Insérer le nouvel utilisateur dans la table auth.users
    INSERT INTO auth.users (
      instance_id,
      id,
      aud,
      role,
      email,
      encrypted_password,
      email_confirmed_at,
      raw_app_meta_data,
      raw_user_meta_data,
      created_at,
      updated_at,
      confirmation_token,
      email_change,
      email_change_token_new,
      recovery_token
    ) VALUES (
      '00000000-0000-0000-0000-000000000000',
      super_admin_id,
      'authenticated',
      'authenticated',
      admin_email,
      hashed_password,
      now(),
      '{"provider": "email", "providers": ["email"]}',
      '{"username": "SuperAdmin"}',
      now(),
      now(),
      '',
      '',
      '',
      ''
    );
    
    RAISE NOTICE 'Utilisateur créé avec succès.';
  ELSE
    -- Mettre à jour le mot de passe et confirmer l'email si déjà existant
    UPDATE auth.users 
    SET encrypted_password = hashed_password,
        email_confirmed_at = now(),
        updated_at = now()
    WHERE email = admin_email;
    
    RAISE NOTICE 'Utilisateur existant mis à jour avec le nouveau mot de passe.';
  END IF;

  -- 4. Attendre ou s'assurer que le profil existe (normalement créé par le trigger handle_new_user)
  -- Si le trigger n'a pas encore fonctionné ou si le profil n'existe pas, on le crée manuellement
  INSERT INTO public.profiles (id, username, role, is_banned, elo_rating)
  VALUES (
    (SELECT id FROM auth.users WHERE email = admin_email),
    'SuperAdmin',
    'super-admin',
    false,
    1000
  )
  ON CONFLICT (id) DO UPDATE 
  SET role = 'super-admin',
      is_banned = false;

  RAISE NOTICE 'Profil utilisateur promu au rôle super-admin avec succès.';
END $$;
