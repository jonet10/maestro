import React from 'react';
import { View, Text, StyleSheet, ScrollView, Pressable } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { router } from 'expo-router';
import { useAuthStore } from '../../store/authStore';
import { RankBadge } from '../../components/domain/RankBadge';
import type { Database } from '../../types/supabase';

type PlayerRank = Database['public']['Enums']['player_rank'];

const BG      = '#080808';
const SURFACE = '#111111';
const SURFACE2= '#1A1A1A';
const TEXT    = '#FFFFFF';
const TEXT_DIM= '#888888';
const GREEN   = '#1DB954';
const GOLD    = '#F5A623';

export default function ProfileScreen() {
  const { profile, signOut } = useAuthStore();

  const username     = profile?.username     ?? 'Invité';
  const eloPoints    = profile?.elo_points   ?? 0;
  const rank: PlayerRank = profile?.rank ?? 'Debitant';

  const handleSignOut = async () => {
    await signOut();
    router.replace('/(tabs)');
  };

  return (
    <View style={styles.container}>
      <SafeAreaView style={{ flex: 1 }}>
        <ScrollView contentContainerStyle={styles.scroll} showsVerticalScrollIndicator={false}>

          {/* Avatar block */}
          <View style={styles.avatarBlock}>
            <View style={styles.avatarCircle}>
              <Text style={styles.avatarText}>{username[0]?.toUpperCase() ?? '?'}</Text>
            </View>
            <Text style={styles.username}>{username}</Text>
            <Text style={styles.eloText}>{eloPoints} ELO</Text>
            <View style={styles.rankContainer}>
              <RankBadge rank={rank} />
            </View>
          </View>

          {/* Stats grid */}
          <View style={styles.statsGrid}>
            {[
              { label: 'Parties',    value: '0' },
              { label: 'Victoires',  value: '0' },
              { label: 'Défaites',   value: '0' },
              { label: 'Win Rate',   value: '—%' },
            ].map((s) => (
              <View key={s.label} style={styles.statCard}>
                <Text style={styles.statValue}>{s.value}</Text>
                <Text style={styles.statLabel}>{s.label}</Text>
              </View>
            ))}
          </View>

          {/* Match history */}
          <View style={styles.section}>
            <Text style={styles.sectionTitle}>Dernières parties</Text>
            <View style={styles.emptyCard}>
              <Text style={styles.emptyEmoji}>🎲</Text>
              <Text style={styles.emptyText}>Aucune partie jouée.</Text>
              <Text style={styles.emptySubText}>Lancez votre première partie !</Text>
            </View>
          </View>

          {/* League info */}
          <View style={styles.section}>
            <Text style={styles.sectionTitle}>Ligue</Text>
            <View style={styles.leagueCard}>
              <Text style={styles.leagueEmoji}>🏆</Text>
              <View style={{ flex: 1 }}>
                <Text style={styles.leagueName}>Ligue Débutant</Text>
                <Text style={styles.leagueSub}>Jouez 10 parties pour avancer</Text>
              </View>
            </View>
          </View>

          {/* Sign out */}
          {profile && (
            <Pressable style={styles.signOutBtn} onPress={handleSignOut}>
              <Text style={styles.signOutText}>Se déconnecter</Text>
            </Pressable>
          )}

        </ScrollView>
      </SafeAreaView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: BG },
  scroll:    { paddingHorizontal: 20, paddingTop: 16, paddingBottom: 40, gap: 24 },

  avatarBlock: {
    alignItems: 'center',
    gap: 8,
    paddingVertical: 24,
  },
  avatarCircle: {
    width: 88,
    height: 88,
    borderRadius: 44,
    backgroundColor: GREEN,
    alignItems: 'center',
    justifyContent: 'center',
    marginBottom: 4,
  },
  avatarText: { fontSize: 38, fontWeight: '800', color: '#000' },
  username:   { fontSize: 22, fontWeight: '800', color: TEXT },
  eloText:    { fontSize: 15, color: TEXT_DIM },
  rankContainer: { marginTop: 8 },

  statsGrid: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    gap: 12,
  },
  statCard: {
    flex: 1,
    minWidth: '44%',
    backgroundColor: SURFACE,
    borderRadius: 14,
    padding: 20,
    alignItems: 'center',
    borderWidth: 1,
    borderColor: SURFACE2,
  },
  statValue: { fontSize: 28, fontWeight: '800', color: TEXT },
  statLabel: { fontSize: 12, color: TEXT_DIM, marginTop: 4, letterSpacing: 0.5, textTransform: 'uppercase' },

  section: { gap: 12 },
  sectionTitle: { fontSize: 16, fontWeight: '700', color: TEXT, letterSpacing: 0.5 },

  emptyCard: {
    backgroundColor: SURFACE,
    borderRadius: 14,
    padding: 32,
    alignItems: 'center',
    borderWidth: 1,
    borderColor: SURFACE2,
    gap: 8,
  },
  emptyEmoji:   { fontSize: 36 },
  emptyText:    { color: TEXT, fontSize: 15, fontWeight: '600' },
  emptySubText: { color: TEXT_DIM, fontSize: 13 },

  leagueCard: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: SURFACE,
    borderRadius: 14,
    padding: 20,
    gap: 16,
    borderWidth: 1,
    borderColor: SURFACE2,
  },
  leagueEmoji: { fontSize: 32 },
  leagueName:  { fontSize: 16, fontWeight: '700', color: TEXT },
  leagueSub:   { fontSize: 13, color: TEXT_DIM, marginTop: 2 },

  signOutBtn: {
    backgroundColor: SURFACE,
    borderRadius: 14,
    paddingVertical: 16,
    alignItems: 'center',
    borderWidth: 1,
    borderColor: '#3A1010',
    marginTop: 8,
  },
  signOutText: { color: '#F85149', fontWeight: '700', fontSize: 15 },
});
