import { useEffect } from 'react';
import { Stack, useRouter, useSegments } from 'expo-router';
import { StatusBar } from 'expo-status-bar';
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import { useFonts } from 'expo-font';
import * as SplashScreen from 'expo-splash-screen';
import { useAuthStore } from '../store/authStore';
import { supabase } from '../services/supabase';

SplashScreen.preventAutoHideAsync();

const queryClient = new QueryClient();

function useAuthGuard() {
  const { session, isInitialized } = useAuthStore();
  const segments = useSegments();
  const router = useRouter();

  useEffect(() => {
    if (!isInitialized) return;

    const inAuthGroup = segments[0] === ('auth' as any);

    if (!session && !inAuthGroup) {
      router.replace('/auth/login' as any);
    } else if (session && inAuthGroup) {
      router.replace('/(tabs)' as any);
    }
  }, [session, isInitialized, segments]);
}

export default function RootLayout() {
  const { setSession, setProfile, setInitialized } = useAuthStore();
  const [fontsLoaded, fontError] = useFonts({
    'Geomanist-Regular': require('../../assets/fonts/Geomanist-Regular.ttf'),
    'Geomanist-Medium': require('../../assets/fonts/Geomanist-Medium.ttf'),
  });

  useAuthGuard();

  const appReady = fontsLoaded || fontError;

  useEffect(() => {
    if (!appReady) return;

    SplashScreen.hideAsync();

    supabase.auth.getSession().then(({ data: { session } }) => {
      setSession(session);
      if (session?.user) {
        supabase.from('players').select('*').eq('id', session.user.id).single()
          .then(({ data }) => {
            if (data) setProfile(data as any);
          });
      }
      setInitialized(true);
    });

    const { data: { subscription } } = supabase.auth.onAuthStateChange((_event, session) => {
      setSession(session);
      if (!session) {
        setProfile(null);
      }
    });

    return () => {
      subscription.unsubscribe();
    };
  }, [appReady]);

  if (!appReady) return null;

  return (
    <QueryClientProvider client={queryClient}>
      <StatusBar style="light" />
      <Stack screenOptions={{ headerShown: false, animation: 'fade' }}>
        <Stack.Screen name="auth" options={{ headerShown: false }} />
        <Stack.Screen name="(tabs)" options={{ headerShown: false }} />
        <Stack.Screen
          name="matchmaking"
          options={{ animation: 'fade', headerShown: false }}
        />
        <Stack.Screen
          name="match"
          options={{ animation: 'slide_from_right', headerShown: false, gestureEnabled: false }}
        />
        <Stack.Screen
          name="debug"
          options={{ animation: 'slide_from_bottom', headerShown: false }}
        />
      </Stack>
    </QueryClientProvider>
  );
}
