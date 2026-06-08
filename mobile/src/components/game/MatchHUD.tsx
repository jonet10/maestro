import React, { useEffect, useRef, useState } from 'react';
import { View, Text, StyleSheet, Platform } from 'react-native';
import Animated, { useSharedValue, useAnimatedStyle, withTiming, Easing, withSequence } from 'react-native-reanimated';

interface MatchHUDProps {
  myScore: number;
  opponentScore: number;
  isMyTurn: boolean;
  matchStatus: string;
  connectionState: string;
  isOfflineMode?: boolean;
  isOpponentDragging?: boolean;
  targetScore?: number;
  myName?: string;
  opponentName?: string;
}

function PlayerAvatar({ variant, active }: { variant: 'human' | 'bot'; active: boolean }) {
  return (
    <View style={[styles.avatarFrame, active && styles.avatarFrameActive]}>
      <View style={styles.avatarGlass}>
        {variant === 'human' ? (
          <>
            <View style={styles.avatarHead} />
            <View style={styles.avatarShoulders} />
            <View style={styles.avatarHighlight} />
          </>
        ) : (
          <>
            <View style={styles.botScreen}>
              <View style={styles.botEyeRow}>
                <View style={styles.botEye} />
                <View style={styles.botEye} />
              </View>
              <View style={styles.botMouth} />
            </View>
            <View style={styles.botNeck} />
          </>
        )}
      </View>
    </View>
  );
}

export function MatchHUD({
  myScore, opponentScore, isMyTurn, matchStatus, connectionState,
  isOfflineMode = false, isOpponentDragging = false, targetScore = 100,
  myName = 'Vous', opponentName = 'Adversaire',
}: MatchHUDProps) {
  const progress = useSharedValue(100);
  const turnScale = useSharedValue(1);
  const myGainOpacity = useSharedValue(0);
  const oppGainOpacity = useSharedValue(0);
  const [myGain, setMyGain] = useState(0);
  const [oppGain, setOppGain] = useState(0);
  const prevScoresRef = useRef({ my: myScore, opp: opponentScore });

  useEffect(() => {
    if (matchStatus !== 'in_progress') {
      progress.value = 100;
      return;
    }
    if (isMyTurn) {
      import('../../utils/HapticsManager').then(m => m.haptics.playTurnStart());
      import('../../utils/SoundManager').then(m => m.sounds.play('turn_start'));
      turnScale.value = withSequence(
        withTiming(1.12, { duration: 120 }),
        withTiming(1, { duration: 180 }),
      );
    }
    progress.value = 100;
    progress.value = withTiming(0, { duration: 10000, easing: Easing.linear });
  }, [isMyTurn, matchStatus]);

  useEffect(() => {
    const prev = prevScoresRef.current;
    const myDelta = myScore - prev.my;
    const oppDelta = opponentScore - prev.opp;
    if (myDelta > 0) { setMyGain(myDelta); myGainOpacity.value = withSequence(withTiming(1, { duration: 160 }), withTiming(0, { duration: 900 })); }
    if (oppDelta > 0) { setOppGain(oppDelta); oppGainOpacity.value = withSequence(withTiming(1, { duration: 160 }), withTiming(0, { duration: 900 })); }
    prevScoresRef.current = { my: myScore, opp: opponentScore };
  }, [myScore, opponentScore]);

  const timerStyle = useAnimatedStyle(() => ({
    width: `${progress.value}%`,
    backgroundColor: progress.value > 50 ? '#4ADE80' : progress.value > 20 ? '#FBBF24' : '#F87171',
  }));

  const turnPillStyle = useAnimatedStyle(() => ({ transform: [{ scale: turnScale.value }] }));
  const myGainStyle = useAnimatedStyle(() => ({ opacity: myGainOpacity.value, transform: [{ translateY: (1 - myGainOpacity.value) * -6 }] }));
  const oppGainStyle = useAnimatedStyle(() => ({ opacity: oppGainOpacity.value, transform: [{ translateY: (1 - oppGainOpacity.value) * -6 }] }));

  return (
    <View style={styles.container}>
      <View style={styles.woodTexture} />
      <View style={styles.headerRow}>
        <View style={styles.playerContainerLeft}>
          <PlayerAvatar variant="human" active={isMyTurn} />
          <View style={styles.playerInfoLeft}>
            <Text style={styles.playerName} numberOfLines={1}>{myName}</Text>
            <View style={styles.scoreRow}>
              <Text style={styles.scoreText}>{myScore}</Text>
              <Animated.Text style={[styles.gainText, myGainStyle]}>+{myGain}</Animated.Text>
            </View>
          </View>
        </View>

        <View style={styles.centerSection}>
          <Animated.View style={[styles.turnIndicator, isMyTurn && styles.turnIndicatorActive, turnPillStyle]}>
            <Text style={styles.turnDot}>{isMyTurn ? '●' : '○'}</Text>
          </Animated.View>
          <Text style={styles.targetText}>{targetScore}</Text>
          {isOfflineMode && <Text style={styles.modeLabel}>Hors ligne</Text>}
        </View>

        <View style={styles.playerContainerRight}>
          <View style={styles.playerInfoRight}>
            <Text style={styles.playerName} numberOfLines={1}>{opponentName}</Text>
            <View style={styles.scoreRowRight}>
              <Text style={styles.scoreText}>{opponentScore}</Text>
              <Animated.Text style={[styles.gainText, oppGainStyle]}>+{oppGain}</Animated.Text>
            </View>
          </View>
          <PlayerAvatar variant="bot" active={!isMyTurn} />
        </View>
      </View>

      <View style={styles.timerTrack}>
        <Animated.View style={[styles.timerFill, timerStyle]} />
      </View>
      {isOpponentDragging && (
        <View style={styles.draggingPill}>
          <Text style={styles.draggingText}>Adversaire en train de jouer...</Text>
        </View>
      )}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: '#5C2E0E',
    position: 'relative',
    overflow: 'hidden',
    paddingTop: 4,
    borderBottomWidth: 2,
    borderBottomColor: '#2B1003',
    zIndex: 100,
  },
  woodTexture: {
    ...StyleSheet.absoluteFill,
    backgroundColor: '#5C2E0E',
    borderTopWidth: 3,
    borderTopColor: '#8B4513',
    borderBottomWidth: 3,
    borderBottomColor: '#3B1A09',
    opacity: 0.95,
  },
  headerRow: {
    flexDirection: 'row',
    alignItems: 'center',
    paddingHorizontal: 10,
    paddingBottom: 6,
    paddingTop: 4,
  },
  playerContainerLeft: {
    flex: 1,
    flexDirection: 'row',
    alignItems: 'center',
  },
  playerContainerRight: {
    flex: 1,
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'flex-end',
  },
  playerInfoLeft: { marginLeft: 8 },
  playerInfoRight: { marginRight: 8, alignItems: 'flex-end' },
  scoreRow: { flexDirection: 'row', alignItems: 'center', gap: 4 },
  scoreRowRight: { flexDirection: 'row', alignItems: 'center', gap: 4, justifyContent: 'flex-end' },
  playerName: {
    color: '#FFDCA8',
    fontSize: 12,
    fontWeight: '600',
    maxWidth: 80,
  },
  scoreText: {
    color: '#FFF',
    fontSize: 22,
    fontWeight: '800',
    letterSpacing: 0.5,
  },
  gainText: {
    fontSize: 12,
    fontWeight: '700',
    color: '#4ADE80',
  },
  centerSection: {
    alignItems: 'center',
    justifyContent: 'center',
    paddingHorizontal: 12,
    gap: 2,
  },
  turnIndicator: {
    width: 24,
    height: 24,
    borderRadius: 12,
    backgroundColor: 'rgba(255,255,255,0.1)',
    alignItems: 'center',
    justifyContent: 'center',
    borderWidth: 1.5,
    borderColor: 'rgba(255,255,255,0.2)',
  },
  turnIndicatorActive: {
    backgroundColor: 'rgba(74,222,128,0.2)',
    borderColor: '#4ADE80',
    ...Platform.select({
      web: { boxShadow: '0 0 10px rgba(74,222,128,0.3)' },
      default: { shadowColor: '#4ADE80', shadowOpacity: 0.3, shadowRadius: 8 },
    }),
  },
  turnDot: {
    fontSize: 12,
    color: '#FFF',
  },
  targetText: {
    color: 'rgba(255,255,255,0.5)',
    fontSize: 10,
    fontWeight: '700',
    letterSpacing: 0.5,
  },
  modeLabel: {
    color: '#FBBF24',
    fontSize: 8,
    fontWeight: '700',
    letterSpacing: 0.3,
    textTransform: 'uppercase',
  },
  avatarFrame: {
    width: 40,
    height: 40,
    borderRadius: 6,
    borderWidth: 1,
    borderColor: '#3B1A09',
    backgroundColor: '#3B1A09',
    padding: 2,
    ...Platform.select({
      web: { boxShadow: '0 2px 6px rgba(0,0,0,0.3)' },
      default: { shadowColor: '#000', shadowOffset: { width: 0, height: 2 }, shadowOpacity: 0.35, shadowRadius: 3, elevation: 4 },
    }),
  },
  avatarFrameActive: {
    borderColor: '#FBBF24',
    ...Platform.select({
      web: { boxShadow: '0 0 8px rgba(251,191,36,0.3)' },
      default: { shadowColor: '#FBBF24', shadowOpacity: 0.3 },
    }),
  },
  avatarGlass: {
    flex: 1,
    borderRadius: 4,
    backgroundColor: '#D4C4A8',
    justifyContent: 'center',
    alignItems: 'center',
    overflow: 'hidden',
  },
  avatarHead: { width: 12, height: 12, borderRadius: 6, backgroundColor: '#7A4A2A', marginTop: 2 },
  avatarShoulders: { width: 26, height: 14, borderTopLeftRadius: 13, borderTopRightRadius: 13, backgroundColor: '#1F3F5B', marginTop: 2 },
  avatarHighlight: { position: 'absolute', top: 3, left: 4, width: 14, height: 4, borderRadius: 4, backgroundColor: 'rgba(255,255,255,0.3)' },
  botScreen: { width: 26, height: 22, borderRadius: 4, borderWidth: 2, borderColor: '#28556A', backgroundColor: '#ECF7F9', alignItems: 'center', justifyContent: 'center' },
  botEyeRow: { flexDirection: 'row', gap: 5, marginBottom: 3 },
  botEye: { width: 4, height: 4, borderRadius: 2, backgroundColor: '#00ACC1' },
  botMouth: { width: 10, height: 2, borderRadius: 1, backgroundColor: '#C04040' },
  botNeck: { width: 8, height: 3, backgroundColor: '#28556A' },
  timerTrack: { height: 3, backgroundColor: 'rgba(0,0,0,0.35)', width: '100%', overflow: 'hidden' },
  timerFill: { height: '100%' },
  draggingPill: {
    alignSelf: 'center', marginTop: 2, marginBottom: 4, paddingHorizontal: 12, paddingVertical: 4,
    borderRadius: 999, backgroundColor: '#10243A', borderWidth: 1, borderColor: '#1F4B78',
  },
  draggingText: { color: '#58A6FF', fontSize: 11, fontWeight: '700', letterSpacing: 0.2 },
});
