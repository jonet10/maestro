import React from 'react';
import { View, Text, StyleSheet, Pressable } from 'react-native';
import Animated, { FadeIn, SlideInDown } from 'react-native-reanimated';

interface GameOverOverlayProps {
  winnerId: string | null;
  localPlayerId: string;
  myScore: number;
  opponentScore: number;
  onRematch: () => void;
  onHome: () => void;
}

export function GameOverOverlay({ winnerId, localPlayerId, myScore, opponentScore, onRematch, onHome }: GameOverOverlayProps) {
  const isWinner = winnerId === localPlayerId;
  const isTie = winnerId === 'tie' || winnerId === null; // In case engine returns tie

  let title = isTie ? "Match Nul !" : isWinner ? 'Victoire !' : 'Défaite';
  let color = isTie ? '#F5A623' : isWinner ? '#39D353' : '#F85149';
  let emoji = isTie ? '🤝' : isWinner ? '🏆' : '💀';

  return (
    <Animated.View entering={FadeIn.duration(400)} style={styles.overlay}>
      <Animated.View entering={SlideInDown.delay(200).springify().damping(15)} style={styles.card}>
        <Text style={styles.emoji}>{emoji}</Text>
        <Text style={[styles.title, { color }]}>{title}</Text>
        
        <View style={styles.scoreRow}>
          <View style={styles.scoreBlock}>
            <Text style={styles.scoreLabel}>Vous</Text>
            <Text style={styles.scoreValue}>{myScore}</Text>
          </View>
          <Text style={styles.scoreDivider}>:</Text>
          <View style={styles.scoreBlock}>
            <Text style={styles.scoreLabel}>Adversaire</Text>
            <Text style={styles.scoreValue}>{opponentScore}</Text>
          </View>
        </View>

        <View style={styles.actions}>
          <Pressable style={[styles.btn, styles.btnHome]} onPress={onHome}>
            <Text style={styles.btnHomeText}>Accueil</Text>
          </Pressable>
          <Pressable style={[styles.btn, styles.btnRematch]} onPress={onRematch}>
            <Text style={styles.btnRematchText}>Rejouer</Text>
          </Pressable>
        </View>
      </Animated.View>
    </Animated.View>
  );
}

const styles = StyleSheet.create({
  overlay: {
    ...StyleSheet.absoluteFill,
    backgroundColor: 'rgba(0,0,0,0.85)',
    zIndex: 1000,
    alignItems: 'center',
    justifyContent: 'center',
    padding: 24,
  },
  card: {
    backgroundColor: '#0D1117',
    borderWidth: 1,
    borderColor: '#30363D',
    borderRadius: 20,
    padding: 32,
    alignItems: 'center',
    width: '100%',
    maxWidth: 400,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 10 },
    shadowOpacity: 0.5,
    shadowRadius: 20,
    elevation: 10,
  },
  emoji: {
    fontSize: 48,
    marginBottom: 8,
  },
  title: {
    fontSize: 32,
    fontWeight: '900',
    marginBottom: 24,
    textTransform: 'uppercase',
    letterSpacing: 2,
  },
  scoreRow: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: 16,
    marginBottom: 32,
    backgroundColor: '#161B22',
    paddingHorizontal: 24,
    paddingVertical: 16,
    borderRadius: 16,
    borderWidth: 1,
    borderColor: '#30363D',
  },
  scoreBlock: {
    alignItems: 'center',
  },
  scoreLabel: {
    color: '#8B949E',
    fontSize: 12,
    textTransform: 'uppercase',
    letterSpacing: 1,
    marginBottom: 4,
  },
  scoreValue: {
    color: '#FFF',
    fontSize: 32,
    fontWeight: '800',
  },
  scoreDivider: {
    color: '#30363D',
    fontSize: 24,
    fontWeight: '800',
    marginTop: 16,
  },
  actions: {
    flexDirection: 'row',
    gap: 12,
    width: '100%',
  },
  btn: {
    flex: 1,
    paddingVertical: 14,
    borderRadius: 10,
    alignItems: 'center',
  },
  btnHome: {
    backgroundColor: '#161B22',
    borderWidth: 1,
    borderColor: '#30363D',
  },
  btnHomeText: {
    color: '#FFF',
    fontWeight: '700',
    fontSize: 16,
  },
  btnRematch: {
    backgroundColor: '#39D353',
  },
  btnRematchText: {
    color: '#030810',
    fontWeight: '800',
    fontSize: 16,
  }
});
