// This file is superseded by the (tabs) routing group.
// Expo Router now handles navigation via app/(tabs)/.
import { Redirect } from 'expo-router';
export default function OldExplore() {
  return <Redirect href="/(tabs)" />;
}
