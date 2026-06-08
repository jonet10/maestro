import { Tabs } from 'expo-router';
import { View, Text, StyleSheet } from 'react-native';

const DOMINO_GREEN = '#1DB954';
const INACTIVE = '#555';
const BG = '#0A0A0A';

/**
 * Tab bar for the main app shell.
 * Three tabs: Play, Profile, Settings.
 */
export default function TabLayout() {
  return (
    <Tabs
      screenOptions={{
        headerShown: false,
        tabBarStyle: styles.tabBar,
        tabBarActiveTintColor: DOMINO_GREEN,
        tabBarInactiveTintColor: INACTIVE,
        tabBarLabelStyle: styles.label,
      }}
    >
      <Tabs.Screen
        name="index"
        options={{
          title: 'Play',
          tabBarIcon: ({ color }) => (
            <View style={[styles.dot, { backgroundColor: color }]} />
          ),
        }}
      />
      <Tabs.Screen
        name="profile"
        options={{
          title: 'Profile',
          tabBarIcon: ({ color }) => (
            <View style={[styles.dot, { backgroundColor: color }]} />
          ),
        }}
      />
      <Tabs.Screen
        name="settings"
        options={{
          title: 'Settings',
          tabBarIcon: ({ color }) => (
            <Text style={{ fontSize: 18, color }}>⚙️</Text>
          ),
        }}
      />
    </Tabs>
  );
}

const styles = StyleSheet.create({
  tabBar: {
    backgroundColor: BG,
    borderTopColor: '#1A1A1A',
    borderTopWidth: 1,
    height: 64,
    paddingBottom: 10,
  },
  label: {
    fontSize: 11,
    fontWeight: '600',
    letterSpacing: 0.5,
  },
  dot: {
    width: 6,
    height: 6,
    borderRadius: 3,
    marginBottom: 2,
  },
});
