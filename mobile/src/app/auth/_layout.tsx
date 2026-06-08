import { Stack } from 'expo-router';
import { View, StyleSheet } from 'react-native';

const BG = '#080808';

export default function AuthLayout() {
  return (
    <View style={{ flex: 1, backgroundColor: BG }}>
      <Stack
        screenOptions={{
          headerShown: false,
          contentStyle: { backgroundColor: BG },
          animation: 'slide_from_right',
        }}
      />
    </View>
  );
}
