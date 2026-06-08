import React, { useEffect, useState } from 'react';
import {
  View,
  Text,
  StyleSheet,
  Pressable,
  Animated,
  Dimensions,
} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { useMatchCreation } from '../../hooks/useMatchCreation';
import { useMatchStore } from '../../store/matchStore';
import { useMultiplayerStore } from '../../multiplayer/store';
import { useAuthStore } from '../../store/authStore';
import { router } from 'expo-router';

const { width } = Dimensions.get('window');

// ─── Domino tile decorative component ────────────────────────────────────────
function DecorativeTile({ top, left, a, b, rotation }: {
  top: number; left: number; a: number; b: number; rotation: string;
}) {
  return (
    <View style={[styles.decorTile, { top, left, transform: [{ rotate: rotation }] }]}>
      <View style={styles.decorHalf}>
        <View style={styles.decorPipRow}>
          {Array.from({ length: a }).map((_, i) => (
            <View key={i} style={styles.decorPip} />
          ))}
        </View>
      </View>
      <View style={styles.decorDivider} />
      <View style={styles.decorHalf}>
        <View style={styles.decorPipRow}>
          {Array.from({ length: b }).map((_, i) => (
            <View key={i} style={styles.decorPip} />
          ))}
        </View>
      </View>
    </View>
  );
}

// ─── Connection status pill ───────────────────────────────────────────────────
function ConnectionStatusPill() {
  const connectionState = useMultiplayerStore((s) => s.connectionState);
  const [pulseAnim] = useState(() => new Animated.Value(1));

  useEffect(() => {
    if (connectionState === 'connecting' || connectionState === 'recovering') {
      const pulse = Animated.loop(
        Animated.sequence([
          Animated.timing(pulseAnim, { toValue: 0.3, duration: 600, useNativeDriver: true }),
          Animated.timing(pulseAnim, { toValue: 1, duration: 600, useNativeDriver: true }),
        ])
      );
      pulse.start();
      return () => pulse.stop();
    } else {
      pulseAnim.setValue(1);
    }
  }, [connectionState, pulseAnim]);

  const config = {
    disconnected: { color: '#666', label: 'Hors ligne' },
    connecting:   { color: '#F5A623', label: 'Connexion…' },
    connected:    { color: '#1DB954', label: 'En ligne' },
    recovering:   { color: '#F5A623', label: 'Reconnexion…' },
  }[connectionState];

  return (
    <View style={styles.statusPill}>
      <Animated.View style={[styles.statusDot, { backgroundColor: config.color, opacity: pulseAnim }]} />
      <Text style={[styles.statusLabel, { color: config.color }]}>{config.label}</Text>
    </View>
  );
}

// ─── Animated Play Button ─────────────────────────────────────────────────────
function PlayButton({ onPress, loading }: { onPress: () => void; loading: boolean }) {
  const [scale] = useState(() => new Animated.Value(1));
  const [glowAnim] = useState(() => new Animated.Value(0));

  useEffect(() => {
    const glow = Animated.loop(
      Animated.sequence([
        Animated.timing(glowAnim, { toValue: 1, duration: 1800, useNativeDriver: true }),
        Animated.timing(glowAnim, { toValue: 0, duration: 1800, useNativeDriver: true }),
      ])
    );
    glow.start();
    return () => glow.stop();
  }, [glowAnim]);

  const handlePressIn = () =>
    Animated.spring(scale, { toValue: 0.95, useNativeDriver: true }).start();
  const handlePressOut = () =>
    Animated.spring(scale, { toValue: 1, friction: 3, useNativeDriver: true }).start();

  const glowOpacity = glowAnim.interpolate({ inputRange: [0, 1], outputRange: [0.4, 0.9] });

  return (
    <Pressable
      onPress={onPress}
      onPressIn={handlePressIn}
      onPressOut={handlePressOut}
      disabled={loading}
    >
      <Animated.View style={[styles.playButtonGlow, { opacity: glowOpacity }]} />
      <Animated.View style={[styles.playButton, { transform: [{ scale }], opacity: loading ? 0.7 : 1 }]}>
        {loading ? (
          <Text style={styles.playButtonText}>Recherche…</Text>
        ) : (
          <>
            <Text style={styles.playButtonIcon}>▶</Text>
            <Text style={styles.playButtonText}>JOUER</Text>
          </>
        )}
      </Animated.View>
    </Pressable>
  );
}

// ─── Secondary action button ──────────────────────────────────────────────────
function SecondaryButton({ label, emoji, onPress }: { label: string; emoji: string; onPress: () => void }) {
  const [scale] = useState(() => new Animated.Value(1));

  const handlePressIn = () =>
    Animated.spring(scale, { toValue: 0.96, useNativeDriver: true }).start();
  const handlePressOut = () =>
    Animated.spring(scale, { toValue: 1, friction: 4, useNativeDriver: true }).start();

  return (
    <Pressable onPress={onPress} onPressIn={handlePressIn} onPressOut={handlePressOut}>
      <Animated.View style={[styles.secondaryButton, { transform: [{ scale }] }]}>
        <Text style={styles.secondaryEmoji}>{emoji}</Text>
        <Text style={styles.secondaryLabel}>{label}</Text>
      </Animated.View>
    </Pressable>
  );
}

// ─── Home Screen ──────────────────────────────────────────────────────────────
type GameModeOption = 'fives' | 'draw' | 'block';

const MODE_OPTIONS: { key: GameModeOption; label: string; desc: string }[] = [
  { key: 'fives', label: 'Fives', desc: '5 pts par extrémité' },
  { key: 'draw', label: 'Draw', desc: 'Pioche si pas de jeu' },
  { key: 'block', label: 'Block', desc: 'Passe si pas de jeu' },
];

export default function HomeScreen() {
  const { isLoading, createLocalTestMatch, navigateToDebug } = useMatchCreation();
  const { profile } = useAuthStore();
  const { gameMode, setGameMode } = useMatchStore();

  const [titleAnim] = useState(() => new Animated.Value(0));
  const [fadeAnim] = useState(() => new Animated.Value(0));

  useEffect(() => {
    Animated.parallel([
      Animated.timing(titleAnim, { toValue: 1, duration: 700, useNativeDriver: true }),
      Animated.timing(fadeAnim,  { toValue: 1, duration: 1000, delay: 200, useNativeDriver: true }),
    ]).start();
  }, []);

  return (
    <View style={styles.container}>
      {/* Background decorative domino tiles */}
      <DecorativeTile top={-20} left={-30} a={6} b={3} rotation="-15deg" />
      <DecorativeTile top={80}  left={width - 60} a={4} b={5} rotation="20deg" />
      <DecorativeTile top={300} left={-40} a={2} b={6} rotation="10deg" />
      <DecorativeTile top={500} left={width - 80} a={1} b={3} rotation="-25deg" />

      <SafeAreaView style={styles.safeArea}>

        {/* Header */}
        <View style={styles.header}>
          <ConnectionStatusPill />
          <Pressable style={styles.avatarButton} onPress={() => router.push('/(tabs)/profile' as any)}>
            <View style={styles.avatar}>
              <Text style={styles.avatarText}>
                {profile?.username?.[0]?.toUpperCase() ?? '?'}
              </Text>
            </View>
          </Pressable>
        </View>

        {/* Hero */}
        <Animated.View
          style={[
            styles.hero,
            {
              opacity: titleAnim,
              transform: [{ translateY: titleAnim.interpolate({ inputRange: [0, 1], outputRange: [20, 0] }) }],
            },
          ]}
        >
          <Text style={styles.gameTitle} adjustsFontSizeToFit numberOfLines={1}>MAESTRO</Text>
          <View style={styles.dominoSeparator}>
            <View style={styles.sepLine} />
            <Text style={styles.sepDomino}>⊞</Text>
            <View style={styles.sepLine} />
          </View>
          <Text style={styles.gameSubtitle}>DOMINO</Text>
          {profile && (
            <Text style={styles.greetingText}>
              Bon retour,{' '}
              <Text style={styles.greetingName}>{profile.username}</Text>
            </Text>
          )}
        </Animated.View>

        {/* Mode Selector */}
        <Animated.View style={[styles.modeRow, { opacity: fadeAnim }]}>
          {MODE_OPTIONS.map((opt) => (
            <Pressable
              key={opt.key}
              onPress={() => setGameMode(opt.key)}
              style={[
                styles.modeButton,
                gameMode === opt.key && styles.modeButtonActive,
              ]}
            >
              <Text style={[
                styles.modeLabel,
                gameMode === opt.key && styles.modeLabelActive,
              ]}>{opt.label}</Text>
              <Text style={[
                styles.modeDesc,
                gameMode === opt.key && styles.modeDescActive,
              ]}>{opt.desc}</Text>
            </Pressable>
          ))}
        </Animated.View>

        {/* Auth CTA when not logged in */}
        {!profile && (
          <Animated.View style={[styles.authCta, { opacity: fadeAnim }]}>
            <Pressable
              style={styles.authButton}
              onPress={() => router.push('/auth/login' as any)}
            >
              <Text style={styles.authButtonText}>Se connecter</Text>
            </Pressable>
            <Pressable
              style={styles.registerButton}
              onPress={() => router.push('/auth/register' as any)}
            >
              <Text style={styles.registerButtonText}>Créer un compte</Text>
            </Pressable>
          </Animated.View>
        )}

        {/* Actions */}
        <Animated.View style={[styles.actions, { opacity: fadeAnim }]}>
          <PlayButton onPress={() => createLocalTestMatch(gameMode)} loading={isLoading} />

          <View style={styles.secondaryRow}>
            <SecondaryButton
              emoji="🐛"
              label="Partie Debug"
              onPress={navigateToDebug}
            />
            <SecondaryButton
              emoji="🧪"
              label="Test QA"
              onPress={() => router.push('/test-dashboard')}
            />
            <SecondaryButton
              emoji="📊"
              label="Classement"
              onPress={() => router.push('/(tabs)/profile' as any)}
            />
          </View>
        </Animated.View>

        {/* Stats strip */}
        <Animated.View style={[styles.statsStrip, { opacity: fadeAnim }]}>
          <View style={styles.statItem}>
            <Text style={styles.statValue}>{profile?.elo_points ?? '—'}</Text>
            <Text style={styles.statLabel}>ELO</Text>
          </View>
          <View style={styles.statDivider} />
          <View style={styles.statItem}>
            <Text style={styles.statValue}>0</Text>
            <Text style={styles.statLabel}>Victoires</Text>
          </View>
          <View style={styles.statDivider} />
          <View style={styles.statItem}>
            <Text style={styles.statValue}>0</Text>
            <Text style={styles.statLabel}>Série</Text>
          </View>
        </Animated.View>

      </SafeAreaView>
    </View>
  );
}

// ─── Styles ───────────────────────────────────────────────────────────────────
const DOMINO_GREEN  = '#1DB954';
const DOMINO_GOLD   = '#F5A623';
const BG            = '#080808';
const SURFACE       = '#111111';
const SURFACE2      = '#1A1A1A';
const TEXT          = '#FFFFFF';
const TEXT_DIM      = '#888888';

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: BG,
    overflow: 'hidden',
  },
  safeArea: {
    flex: 1,
    paddingHorizontal: 24,
  },

  // ── Header
  header: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    paddingTop: 8,
    paddingBottom: 16,
  },
  statusPill: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: SURFACE2,
    borderRadius: 20,
    paddingHorizontal: 12,
    paddingVertical: 6,
    gap: 6,
  },
  statusDot: {
    width: 8,
    height: 8,
    borderRadius: 4,
  },
  statusLabel: {
    fontSize: 12,
    fontWeight: '600',
  },
  avatarButton: {},
  avatar: {
    width: 40,
    height: 40,
    borderRadius: 20,
    backgroundColor: DOMINO_GOLD,
    alignItems: 'center',
    justifyContent: 'center',
  },
  avatarText: {
    fontSize: 18,
    fontWeight: '700',
    color: '#000',
  },

  // ── Hero
  hero: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    gap: 8,
  },
  gameTitle: {
    fontSize: 52,
    fontWeight: '900',
    color: TEXT,
    letterSpacing: 12,
  },
  dominoSeparator: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 10,
    width: 200,
  },
  sepLine: {
    flex: 1,
    height: 1,
    backgroundColor: SURFACE2,
  },
  sepDomino: {
    fontSize: 22,
    color: DOMINO_GOLD,
  },
  gameSubtitle: {
    fontSize: 24,
    fontWeight: '300',
    color: TEXT_DIM,
    letterSpacing: 8,
  },
  greetingText: {
    marginTop: 24,
    fontSize: 15,
    color: TEXT_DIM,
  },
  greetingName: {
    color: DOMINO_GOLD,
    fontWeight: '700',
  },

  // ── Mode Selector
  modeRow: {
    flexDirection: 'row',
    gap: 8,
    paddingBottom: 8,
  },
  modeButton: {
    flex: 1,
    backgroundColor: SURFACE,
    borderRadius: 12,
    paddingVertical: 10,
    paddingHorizontal: 8,
    alignItems: 'center',
    borderWidth: 1,
    borderColor: SURFACE2,
  },
  modeButtonActive: {
    borderColor: DOMINO_GOLD,
    backgroundColor: '#1A1400',
  },
  modeLabel: {
    fontSize: 13,
    fontWeight: '700',
    color: TEXT_DIM,
  },
  modeLabelActive: {
    color: DOMINO_GOLD,
  },
  modeDesc: {
    fontSize: 9,
    color: '#555',
    marginTop: 2,
  },
  modeDescActive: {
    color: '#887744',
  },

  // ── Auth CTA
  authCta: {
    flexDirection: 'row',
    gap: 12,
    paddingBottom: 12,
  },
  authButton: {
    flex: 1,
    backgroundColor: DOMINO_GOLD,
    borderRadius: 14,
    paddingVertical: 14,
    alignItems: 'center',
  },
  authButtonText: {
    fontSize: 15,
    fontWeight: '800',
    color: '#000',
    letterSpacing: 1,
  },
  registerButton: {
    flex: 1,
    backgroundColor: SURFACE,
    borderRadius: 14,
    paddingVertical: 14,
    alignItems: 'center',
    borderWidth: 1,
    borderColor: SURFACE2,
  },
  registerButtonText: {
    fontSize: 15,
    fontWeight: '800',
    color: TEXT,
    letterSpacing: 1,
  },

  // ── Actions
  actions: {
    gap: 16,
    paddingBottom: 16,
  },
  playButton: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: DOMINO_GOLD,
    borderRadius: 16,
    paddingVertical: 20,
    gap: 12,
  },
  playButtonGlow: {
    position: 'absolute',
    top: -6,
    left: -6,
    right: -6,
    bottom: -6,
    borderRadius: 22,
    backgroundColor: DOMINO_GOLD,
    zIndex: -1,
  },
  playButtonIcon: {
    fontSize: 18,
    color: '#000',
  },
  playButtonText: {
    fontSize: 18,
    fontWeight: '900',
    color: '#000',
    letterSpacing: 3,
  },
  secondaryRow: {
    flexDirection: 'row',
    gap: 12,
  },
  secondaryButton: {
    flex: 1,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: SURFACE,
    borderRadius: 14,
    paddingVertical: 16,
    gap: 8,
    borderWidth: 1,
    borderColor: SURFACE2,
  },
  secondaryEmoji: {
    fontSize: 18,
  },
  secondaryLabel: {
    fontSize: 14,
    fontWeight: '600',
    color: TEXT,
  },

  // ── Stats strip
  statsStrip: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-around',
    backgroundColor: SURFACE,
    borderRadius: 16,
    paddingVertical: 16,
    marginBottom: 8,
    borderWidth: 1,
    borderColor: SURFACE2,
  },
  statItem: {
    alignItems: 'center',
    gap: 4,
  },
  statValue: {
    fontSize: 22,
    fontWeight: '800',
    color: TEXT,
  },
  statLabel: {
    fontSize: 11,
    fontWeight: '500',
    color: TEXT_DIM,
    letterSpacing: 1,
    textTransform: 'uppercase',
  },
  statDivider: {
    width: 1,
    height: 32,
    backgroundColor: SURFACE2,
  },

  // ── Decorative background tiles
  decorTile: {
    position: 'absolute',
    width: 44,
    height: 88,
    backgroundColor: '#111',
    borderRadius: 6,
    borderWidth: 1,
    borderColor: '#222',
    padding: 4,
    opacity: 0.35,
    zIndex: 0,
  },
  decorHalf: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  decorPipRow: {
    flexDirection: 'row',
    flexWrap: 'wrap',
    gap: 2,
    justifyContent: 'center',
  },
  decorPip: {
    width: 5,
    height: 5,
    borderRadius: 2.5,
    backgroundColor: '#444',
  },
  decorDivider: {
    height: 1,
    backgroundColor: '#333',
    marginVertical: 2,
  },
});
