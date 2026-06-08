import React, { useMemo, useState, useEffect } from 'react';
import { LayoutChangeEvent, Platform, Pressable, StyleSheet, Text, View } from 'react-native';
import Animated, { FadeIn, FadeOut, ZoomIn, LinearTransition, useSharedValue, useAnimatedStyle, withTiming, Easing, withRepeat, withSequence } from 'react-native-reanimated';
import { Gesture, GestureDetector, GestureHandlerRootView } from 'react-native-gesture-handler';
import { DominoTile } from './DominoTile';
import { BoardTile } from '../../engine/types';
import { DragPreview } from '../../multiplayer/types';
import { calculateBoardPositions, TilePosition, TILE_LG, TILE_SW } from './BoardLayoutEngine';

interface DominoBoardProps {
  boardState: BoardTile[];
  isMyTurn?: boolean;
  remoteDragPreview?: DragPreview | null;
  onSelectEnd?: (side: 'left' | 'right' | 'up' | 'down') => void;
  showPlayableEnds?: { left: boolean; right: boolean; up: boolean; down: boolean };
  showInvalidEnds?: { left: boolean; right: boolean; up: boolean; down: boolean };
  scorePopupPoints?: number | null;
}

const AnimatedPressable = Animated.createAnimatedComponent(Pressable);

const TableFelt = React.memo(function TableFelt() {
  return (
    <View style={[styles.feltBase, { pointerEvents: 'none' }]}>
      <View style={styles.feltGradientA} />
      <View style={styles.feltGradientB} />
      <View style={styles.feltCenterGlow} />
    </View>
  );
});

const ScoreParticle = React.memo(function ScoreParticle({ x, y, delay }: { x: number; y: number; delay: number }) {
  return (
    <Animated.View
      entering={FadeIn.duration(200).delay(delay)}
      exiting={FadeOut.duration(300)}
      style={[styles.particle, { left: x - 3, top: y - 3 }]}
    />
  );
});

const DominoNode = React.memo(function DominoNode({
  tile, pos, isLast,
}: {
  tile: BoardTile;
  pos: TilePosition;
  isLast: boolean;
}) {
  const glowValue = useSharedValue(0.4);
  useEffect(() => {
    if (isLast) {
      glowValue.value = withRepeat(
        withSequence(
          withTiming(1, { duration: 800, easing: Easing.inOut(Easing.sin) }),
          withTiming(0.4, { duration: 800, easing: Easing.inOut(Easing.sin) }),
        ),
        -1,
        true,
      );
    }
  }, [isLast]);

  const glowStyle = useAnimatedStyle(() => {
    if (!isLast) return {};
    const opacity = glowValue.value;
    return {
      borderColor: `rgba(255,215,0,${opacity})`,
      borderWidth: 2.5,
      borderRadius: 12,
      ...Platform.select({
        web: { boxShadow: `0 0 20px rgba(255,215,0,${opacity * 0.5}), 0 0 40px rgba(255,215,0,${opacity * 0.2})` },
        default: { shadowColor: '#FFD700', shadowOpacity: opacity * 0.5, shadowRadius: 16 },
      }),
    };
  });

  return (
    <Animated.View
      entering={ZoomIn.springify().damping(14).stiffness(250)}
      layout={LinearTransition.springify().damping(20).stiffness(220)}
      style={[
        styles.dominoNode,
        { left: pos.x, top: pos.y, zIndex: pos.zIndex, transform: [{ rotate: `${pos.rotation}deg` }] },
        isLast && glowStyle,
      ]}
    >
      <DominoTile
        a={pos.displayA}
        b={pos.displayB}
        horizontal={pos.orientation === 'horizontal'}
        size="medium"
      />
    </Animated.View>
  );
});

export function DominoBoard({
  boardState, isMyTurn = false, remoteDragPreview = null, onSelectEnd,
  showPlayableEnds, showInvalidEnds, scorePopupPoints = null,
}: DominoBoardProps) {
  const [viewport, setViewport] = useState({ width: 320, height: 320 });

  const layout = useMemo(
    () => calculateBoardPositions(boardState, {
      viewportWidth: viewport.width,
      viewportHeight: viewport.height,
    }),
    [boardState, viewport.width, viewport.height],
  );
  const positioned = layout.positions;
  const leftPos = layout.leftEnd;
  const rightPos = layout.rightEnd;
  const upPos = layout.upEnd;
  const downPos = layout.downEnd;
  const bb = layout.boundingBox;
  const fitScaleHint = layout.fitScale;

  const particleRects = useMemo(() => {
    if (!scorePopupPoints) return [];
    const lastIdx = boardState.length - 1;
    const pos = positioned[lastIdx];
    if (!pos) return [];
    const cx = pos.x + TILE_SW / 2;
    const cy = pos.y + TILE_LG / 2;
    return Array.from({ length: 6 }, (_, i) => {
      const angle = (i / 6) * Math.PI * 2;
      return {
        key: i, delay: i * 40,
        x: cx + Math.cos(angle) * (30 + ((i * 7) % 5) * 5) - 3,
        y: cy + Math.sin(angle) * (30 + ((i * 7) % 5) * 5) - 3,
      };
    });
  }, [scorePopupPoints, boardState.length, positioned]);

  const onLayout = (event: LayoutChangeEvent) => {
    const { width, height } = event.nativeEvent.layout;
    if (!width || !height) return;
    setViewport({ width, height });
  };

  const scale = useSharedValue(1);
  const savedScale = useSharedValue(1);
  const translateX = useSharedValue(0);
  const translateY = useSharedValue(0);
  const savedTranslateX = useSharedValue(0);
  const savedTranslateY = useSharedValue(0);

  useEffect(() => {
    if (boardState.length === 0) return;
    const bbWidth = bb.maxX - bb.minX;
    const bbHeight = bb.maxY - bb.minY;

    const newScale = fitScaleHint;

    const cx = bb.minX + bbWidth / 2;
    const cy = bb.minY + bbHeight / 2;
    const vx = viewport.width / 2;
    const vy = viewport.height / 2;

    scale.value = withTiming(newScale, { duration: 500, easing: Easing.out(Easing.cubic) });
    translateX.value = withTiming(vx - cx * newScale, { duration: 500, easing: Easing.out(Easing.cubic) });
    translateY.value = withTiming(vy - cy * newScale, { duration: 500, easing: Easing.out(Easing.cubic) });

    savedScale.value = newScale;
    savedTranslateX.value = vx - cx * newScale;
    savedTranslateY.value = vy - cy * newScale;
  }, [bb.maxX, bb.maxY, bb.minX, bb.minY, boardState.length, viewport, fitScaleHint]);

  const panGesture = Gesture.Pan()
    .onUpdate((e) => {
      translateX.value = savedTranslateX.value + e.translationX;
      translateY.value = savedTranslateY.value + e.translationY;
    })
    .onEnd(() => {
      savedTranslateX.value = translateX.value;
      savedTranslateY.value = translateY.value;
    });

  const pinchGesture = Gesture.Pinch()
    .onUpdate((e) => { scale.value = savedScale.value * e.scale; })
    .onEnd(() => { savedScale.value = scale.value; });

  const composedGesture = Gesture.Simultaneous(panGesture, pinchGesture);

  const animatedStyle = useAnimatedStyle(() => ({
    transform: [
      { translateX: translateX.value },
      { translateY: translateY.value },
      { scale: scale.value },
    ],
  }));

  if (boardState.length === 0) {
    return (
      <View style={styles.emptyContainer} onLayout={onLayout}>
        <TableFelt />
        <View style={styles.emptyDashed}>
          <Text style={styles.emptyText}>Pose une tuile pour commencer</Text>
        </View>
      </View>
    );
  }

  return (
    <GestureHandlerRootView style={styles.gestureRoot}>
      <View
        style={[styles.container, isMyTurn && styles.myTurnContainer]}
        onLayout={onLayout}
        accessibilityLabel="Domino Board"
        accessibilityHint={isMyTurn ? "It is your turn to play" : "Waiting for opponent"}
      >
        <TableFelt />
        <GestureDetector gesture={composedGesture}>
          <Animated.View style={[StyleSheet.absoluteFill, animatedStyle]}>
            {boardState.map((bt, i) => {
              const pos = positioned[i];
              if (!pos) return null;
              return (
                <DominoNode
                  key={`${bt.tile[0]}-${bt.tile[1]}`}
                  tile={bt}
                  pos={pos}
                  isLast={i === boardState.length - 1}
                />
              );
            })}

            {leftPos && (
              <AnimatedPressable
                layout={LinearTransition.springify().damping(20)}
                style={[
                  styles.endIndicator,
                  { left: leftPos.x - 14, top: leftPos.y + (leftPos.orientation === 'horizontal' ? TILE_SW : TILE_LG) / 2 - 9 },
                  showPlayableEnds?.left && styles.endIndicatorActive,
                  showInvalidEnds?.left && styles.endIndicatorInvalid,
                ]}
                onPress={() => onSelectEnd?.('left')}
              />
            )}
            {rightPos && (
              <AnimatedPressable
                layout={LinearTransition.springify().damping(20)}
                style={[
                  styles.endIndicator,
                  { left: rightPos.x + (rightPos.orientation === 'horizontal' ? TILE_LG : TILE_SW) + 2, top: rightPos.y + (rightPos.orientation === 'horizontal' ? TILE_SW : TILE_LG) / 2 - 9 },
                  showPlayableEnds?.right && styles.endIndicatorActive,
                  showInvalidEnds?.right && styles.endIndicatorInvalid,
                ]}
                onPress={() => onSelectEnd?.('right')}
              />
            )}
            {upPos && (
              <AnimatedPressable
                layout={LinearTransition.springify().damping(20)}
                style={[
                  styles.endIndicator,
                  { left: upPos.x + (upPos.orientation === 'horizontal' ? TILE_LG : TILE_SW) / 2 - 9, top: upPos.y - 14 },
                  showPlayableEnds?.up && styles.endIndicatorActive,
                  showInvalidEnds?.up && styles.endIndicatorInvalid,
                ]}
                onPress={() => onSelectEnd?.('up')}
              />
            )}
            {downPos && (
              <AnimatedPressable
                layout={LinearTransition.springify().damping(20)}
                style={[
                  styles.endIndicator,
                  { left: downPos.x + (downPos.orientation === 'horizontal' ? TILE_LG : TILE_SW) / 2 - 9, top: downPos.y + (downPos.orientation === 'horizontal' ? TILE_SW : TILE_LG) + 2 },
                  showPlayableEnds?.down && styles.endIndicatorActive,
                  showInvalidEnds?.down && styles.endIndicatorInvalid,
                ]}
                onPress={() => onSelectEnd?.('down')}
              />
            )}

            {particleRects.length > 0 && particleRects.map((pr) => (
              <ScoreParticle key={pr.key} x={pr.x} y={pr.y} delay={pr.delay} />
            ))}

            {remoteDragPreview && (
              <Animated.View
                entering={FadeIn.duration(90)}
                exiting={FadeOut.duration(120)}
                style={[
                  styles.remotePreviewTile,
                  { left: bb.minX + bb.maxX / 2 + remoteDragPreview.x, top: bb.minY + bb.maxY / 2 + remoteDragPreview.y, pointerEvents: 'none' },
                ]}
              >
                <DominoTile a={remoteDragPreview.tile[0]} b={remoteDragPreview.tile[1]} size="medium" />
              </Animated.View>
            )}
          </Animated.View>
        </GestureDetector>

        {scorePopupPoints && boardState.length > 0 && positioned[boardState.length - 1] && (
          <Animated.View
            entering={FadeIn.duration(100)}
            exiting={FadeOut.duration(240)}
            style={[styles.scorePopup, { pointerEvents: 'none', left: positioned[boardState.length - 1].x, top: positioned[boardState.length - 1].y - 30 }]}
          >
            <Text style={styles.scorePopupText}>+{scorePopupPoints}</Text>
          </Animated.View>
        )}
      </View>
    </GestureHandlerRootView>
  );
}

const styles = StyleSheet.create({
  gestureRoot: { flex: 1 },
  container: { flex: 1, overflow: 'hidden', backgroundColor: '#1B4D2A' },
  myTurnContainer: {},
  feltBase: { ...StyleSheet.absoluteFill, backgroundColor: '#1B4D2A' },
  feltGradientA: { ...StyleSheet.absoluteFill, backgroundColor: 'rgba(0,0,0,0.08)' },
  feltGradientB: {
    position: 'absolute', bottom: 0, left: 0, right: 0, height: '40%',
    backgroundColor: 'rgba(0,0,0,0.12)',
  },
  feltCenterGlow: {
    position: 'absolute', top: '30%', left: '20%', right: '20%', height: '40%',
    borderRadius: 999, backgroundColor: 'rgba(45,107,63,0.3)',
  },
  dominoNode: {
    position: 'absolute',
    ...Platform.select({
      web: { boxShadow: '0 4px 12px rgba(0,0,0,0.25), 0 1px 3px rgba(0,0,0,0.1)' },
      default: { shadowColor: '#000', shadowOffset: { width: 0, height: 4 }, shadowOpacity: 0.28, shadowRadius: 6, elevation: 5 },
    }),
  },
  endIndicator: {
    position: 'absolute', width: 20, height: 20, borderRadius: 10,
    backgroundColor: 'rgba(134,239,172,0.25)', borderWidth: 2.5, borderColor: '#4ADE80',
    ...Platform.select({
      web: { boxShadow: '0 0 8px rgba(74,222,128,0.3)' },
      default: { shadowColor: '#4ADE80', shadowOpacity: 0.3, shadowRadius: 8, elevation: 5 },
    }),
  },
  endIndicatorActive: {
    backgroundColor: 'rgba(251,191,36,0.3)', borderColor: '#FBBF24',
    ...Platform.select({
      web: { boxShadow: '0 0 8px rgba(251,191,36,0.35)' },
      default: { shadowColor: '#FBBF24' },
    }),
  },
  endIndicatorInvalid: {
    backgroundColor: 'rgba(248,81,73,0.3)', borderColor: '#F85149',
    ...Platform.select({
      web: { boxShadow: '0 0 8px rgba(248,81,73,0.3)' },
      default: { shadowColor: '#F85149' },
    }),
  },
  scorePopup: {
    position: 'absolute', paddingHorizontal: 14, paddingVertical: 6, borderRadius: 999,
    backgroundColor: 'rgba(0,0,0,0.65)', zIndex: 1000,
  },
  scorePopupText: {
    color: '#4ADE80', fontWeight: '900', fontSize: 24,
    textShadowColor: 'rgba(74,222,128,0.7)', textShadowOffset: { width: 0, height: 0 }, textShadowRadius: 10,
  },
  particle: { position: 'absolute', width: 6, height: 6, borderRadius: 3, backgroundColor: '#FBBF24', zIndex: 999 },
  remotePreviewTile: {
    position: 'absolute', opacity: 0.7, transform: [{ scale: 1.05 }],
    ...Platform.select({
      web: { boxShadow: '0 2px 6px rgba(88,166,255,0.35)' },
      default: { shadowColor: '#58A6FF', shadowOffset: { width: 0, height: 2 }, shadowOpacity: 0.35, shadowRadius: 6, elevation: 5 },
    }),
  },
  emptyContainer: {
    flex: 1, overflow: 'hidden', justifyContent: 'center', padding: 28, backgroundColor: '#1B4D2A',
  },
  emptyDashed: {
    flex: 1, borderWidth: 2, borderColor: '#2D6B3F', borderStyle: 'dashed', borderRadius: 16,
    alignItems: 'center', justifyContent: 'center', backgroundColor: 'rgba(0,0,0,0.08)',
  },
  emptyText: {
    color: '#8BBF9B', fontSize: 16, fontWeight: '600',
  },
});
