import { create } from 'zustand';
import { Session } from '@supabase/supabase-js';
import { Database } from '../types/supabase';

type Player = Database['public']['Tables']['players']['Row'];

interface AuthState {
  session: Session | null;
  profile: Player | null;
  isInitialized: boolean;
  setSession: (session: Session | null) => void;
  setProfile: (profile: Player | null) => void;
  setInitialized: (initialized: boolean) => void;
  signOut: () => void;
}

export const useAuthStore = create<AuthState>((set) => ({
  session: null,
  profile: null,
  isInitialized: false,
  setSession: (session) => set({ session }),
  setProfile: (profile) => set({ profile }),
  setInitialized: (initialized) => set({ isInitialized: initialized }),
  signOut: () => set({ session: null, profile: null }),
}));
