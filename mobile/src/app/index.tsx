// This file is superseded by app/(tabs)/index.tsx
// Expo Router will resolve (tabs)/index as the default tab screen.
// This stub exists only to avoid a routing conflict and will be removed in a future cleanup.
import { Redirect } from 'expo-router';
export default function OldIndex() {
  return <Redirect href="/(tabs)" />;
}
