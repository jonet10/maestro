import React, { useState } from 'react';
import {
  View, Text, StyleSheet, ScrollView, Switch, TouchableOpacity, Alert,
} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { router } from 'expo-router';
import { supabase } from '../../services/supabase';
import { useAuthStore } from '../../store/authStore';

const BG = '#080808';
const SURFACE = '#111111';
const SURFACE2 = '#1A1A1A';
const TEXT = '#FFFFFF';
const TEXT_DIM = '#888888';
const GREEN = '#1DB954';
const RED = '#FF4444';

export default function SettingsScreen() {
  const [soundEnabled, setSoundEnabled] = useState(true);
  const [hapticEnabled, setHapticEnabled] = useState(true);
  const { setSession } = useAuthStore();

  const handleLogout = () => {
    Alert.alert('Déconnexion', 'Voulez-vous vous déconnecter ?', [
      { text: 'Annuler', style: 'cancel' },
      {
        text: 'Se déconnecter',
        style: 'destructive',
        onPress: async () => {
          await supabase.auth.signOut();
          setSession(null);
          router.replace('/auth/login' as any);
        },
      },
    ]);
  };

  return (
    <View style={styles.container}>
      <SafeAreaView style={{ flex: 1 }}>
        <ScrollView contentContainerStyle={styles.scroll} showsVerticalScrollIndicator={false}>
          <Text style={styles.screenTitle}>Paramètres</Text>

          {/* Sound toggle */}
          <View style={styles.card}>
            <View style={styles.row}>
              <Text style={styles.rowLabel}>Son</Text>
              <Switch
                value={soundEnabled}
                onValueChange={setSoundEnabled}
                trackColor={{ false: SURFACE2, true: GREEN }}
                thumbColor={TEXT}
              />
            </View>
          </View>

          {/* Haptic toggle */}
          <View style={styles.card}>
            <View style={styles.row}>
              <Text style={styles.rowLabel}>Vibrations</Text>
              <Switch
                value={hapticEnabled}
                onValueChange={setHapticEnabled}
                trackColor={{ false: SURFACE2, true: GREEN }}
                thumbColor={TEXT}
              />
            </View>
          </View>

          {/* App info */}
          <View style={styles.card}>
            <View style={styles.row}>
              <Text style={styles.rowLabel}>Version</Text>
              <Text style={styles.rowValue}>1.0.0</Text>
            </View>
          </View>

          {/* À propos */}
          <View style={styles.card}>
            <View style={styles.row}>
              <Text style={styles.rowLabel}>À propos</Text>
              <Text style={styles.rowValue}>Maestro Domino</Text>
            </View>
          </View>

          {/* Logout */}
          <TouchableOpacity
            style={styles.logoutButton}
            onPress={handleLogout}
            activeOpacity={0.8}
          >
            <Text style={styles.logoutText}>Se déconnecter</Text>
          </TouchableOpacity>
        </ScrollView>
      </SafeAreaView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: BG },
  scroll: {
    paddingHorizontal: 20,
    paddingTop: 16,
    paddingBottom: 40,
    gap: 12,
  },
  screenTitle: {
    fontSize: 22,
    fontWeight: '800',
    color: TEXT,
    marginBottom: 8,
  },
  card: {
    backgroundColor: SURFACE,
    borderRadius: 14,
    borderWidth: 1,
    borderColor: SURFACE2,
    padding: 16,
  },
  row: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  rowLabel: {
    fontSize: 16,
    color: TEXT,
    fontWeight: '600',
  },
  rowValue: {
    fontSize: 15,
    color: TEXT_DIM,
  },
  logoutButton: {
    backgroundColor: SURFACE,
    borderRadius: 14,
    borderWidth: 1,
    borderColor: RED,
    paddingVertical: 16,
    alignItems: 'center',
    marginTop: 8,
  },
  logoutText: {
    color: RED,
    fontSize: 16,
    fontWeight: '700',
  },
});
