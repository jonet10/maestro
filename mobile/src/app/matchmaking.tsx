import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet, Animated } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';

const BG       = '#080808';
const GREEN    = '#1DB954';
const TEXT     = '#FFFFFF';
const TEXT_DIM = '#888888';

/**
 * Matchmaking loading screen.
 *
 * Shown briefly while the local match is being initialised.
 * In future phases this will be replaced by a real queue system that waits
 * for an opponent via Supabase.
 */
export default function MatchmakingScreen() {
  const [dot1] = useState(() => new Animated.Value(0));
  const [dot2] = useState(() => new Animated.Value(0));
  const [dot3] = useState(() => new Animated.Value(0));

  const [rotateAnim] = useState(() => new Animated.Value(0));

  useEffect(() => {
    // Spinning tile animation
    Animated.loop(
      Animated.timing(rotateAnim, {
        toValue: 1,
        duration: 1200,
        useNativeDriver: true,
      })
    ).start();

    // Bouncing dots
    const makeBounce = (anim: Animated.Value, delay: number) =>
      Animated.loop(
        Animated.sequence([
          Animated.delay(delay),
          Animated.timing(anim, { toValue: -8, duration: 300, useNativeDriver: true }),
          Animated.timing(anim, { toValue: 0, duration: 300, useNativeDriver: true }),
          Animated.delay(600 - delay),
        ])
      );

    const b1 = makeBounce(dot1, 0);
    const b2 = makeBounce(dot2, 150);
    const b3 = makeBounce(dot3, 300);

    b1.start();
    b2.start();
    b3.start();

    return () => {
      b1.stop();
      b2.stop();
      b3.stop();
    };
  }, []);

  const spin = rotateAnim.interpolate({ inputRange: [0, 1], outputRange: ['0deg', '360deg'] });

  return (
    <View style={styles.container}>
      <SafeAreaView style={styles.inner}>
        {/* Spinning domino tile */}
        <Animated.View style={[styles.tile, { transform: [{ rotate: spin }] }]}>
          <View style={styles.tileHalf}>
            <View style={styles.pip} />
            <View style={styles.pip} />
          </View>
          <View style={styles.tileDivider} />
          <View style={styles.tileHalf}>
            <View style={styles.pip} />
          </View>
        </Animated.View>

        <Text style={styles.title}>Finding Match</Text>
        <Text style={styles.subtitle}>Preparing your game…</Text>

        {/* Bouncing dots */}
        <View style={styles.dots}>
          {[dot1, dot2, dot3].map((d, i) => (
            <Animated.View
              key={i}
              style={[styles.dot, { transform: [{ translateY: d }] }]}
            />
          ))}
        </View>

        <Text style={styles.hint}>
          Local test match — no opponent required
        </Text>
      </SafeAreaView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: BG },
  inner: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    gap: 16,
    paddingHorizontal: 32,
  },

  tile: {
    width: 60,
    height: 120,
    backgroundColor: '#111',
    borderRadius: 10,
    borderWidth: 2,
    borderColor: GREEN,
    padding: 8,
    marginBottom: 24,
  },
  tileHalf: {
    flex: 1,
    flexDirection: 'row',
    flexWrap: 'wrap',
    gap: 4,
    alignItems: 'center',
    justifyContent: 'center',
  },
  tileDivider: { height: 2, backgroundColor: GREEN, marginVertical: 4 },
  pip: {
    width: 10,
    height: 10,
    borderRadius: 5,
    backgroundColor: GREEN,
  },

  title: {
    fontSize: 28,
    fontWeight: '800',
    color: TEXT,
    letterSpacing: 2,
  },
  subtitle: {
    fontSize: 15,
    color: TEXT_DIM,
  },
  dots: {
    flexDirection: 'row',
    gap: 8,
    marginTop: 8,
  },
  dot: {
    width: 10,
    height: 10,
    borderRadius: 5,
    backgroundColor: GREEN,
  },
  hint: {
    marginTop: 40,
    fontSize: 12,
    color: '#444',
    textAlign: 'center',
  },
});
