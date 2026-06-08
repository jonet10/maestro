import 'react-native-url-polyfill/auto';
import * as SecureStore from 'expo-secure-store';
import { Platform } from 'react-native';
import { createClient } from '@supabase/supabase-js';
import { Database } from '../types/supabase';

const memoryStorage = new Map<string, string>();
const isWeb = Platform.OS === 'web';
const isBrowser = typeof window !== 'undefined';

const ExpoSecureStoreAdapter = {
  getItem: (key: string) => {
    return SecureStore.getItemAsync(key);
  },
  setItem: (key: string, value: string) => {
    return SecureStore.setItemAsync(key, value);
  },
  removeItem: (key: string) => {
    return SecureStore.deleteItemAsync(key);
  },
};

const WebStorageAdapter = {
  getItem: async (key: string) => {
    if (isBrowser && window.localStorage) return window.localStorage.getItem(key);
    return memoryStorage.get(key) ?? null;
  },
  setItem: async (key: string, value: string) => {
    if (isBrowser && window.localStorage) {
      window.localStorage.setItem(key, value);
      return;
    }
    memoryStorage.set(key, value);
  },
  removeItem: async (key: string) => {
    if (isBrowser && window.localStorage) {
      window.localStorage.removeItem(key);
      return;
    }
    memoryStorage.delete(key);
  },
};

const supabaseUrl = process.env.EXPO_PUBLIC_SUPABASE_URL || 'YOUR_SUPABASE_URL';
const supabaseAnonKey = process.env.EXPO_PUBLIC_SUPABASE_ANON_KEY || 'YOUR_SUPABASE_ANON_KEY';
const authStorage = isWeb ? WebStorageAdapter : ExpoSecureStoreAdapter;

export const supabase = createClient<Database>(supabaseUrl, supabaseAnonKey, {
  auth: {
    storage: authStorage as any,
    autoRefreshToken: true,
    persistSession: true,
    detectSessionInUrl: false,
  },
});
