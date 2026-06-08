import React, { useMemo } from 'react';
import { View, StyleSheet, Dimensions, Platform } from 'react-native';
import Animated, {
  useSharedValue,
  useAnimatedStyle,
  withSpring,
  runOnJS,
  withSequence,
  withTiming,
} from 'react-native-reanimated';
import { GestureDetector, Gesture } from 'react-native-gesture-handler';
import { DominoTile } from './DominoTile';
import { Tile } from '../../engine/types';
import { haptics } from '../../utils/HapticsManager';
import { sounds } from '../../utils/SoundManager';

const MAX_FAN_ANGLE = 12;
const OVERLAP = 4;

interface DraggableTileProps {
  tile: Tile;
  isPlayable: boolean;
  onPlayRequest: (tile: Tile, side: 'left' | 'right' | 'up' | 'down') => void;
  index: number;
  total: number;
  onDragPreview?: (payload: { tile: Tile; x: number; y: number; side: 'left' | 'right'; isDropZone: boolean }) => void;
  onDragRelease?: () => void;
  isSelected?: boolean;
  onSelect?: (tile: Tile) => void;
}

const { width: SCREEN_WIDTH, height: SCREEN_HEIGHT } = Dimensions.get('window');

const DraggableTile = React.memo(function DraggableTile({
  tile, isPlayable, onPlayRequest, index, total, onDragPreview, onDragRelease,
  isSelected = false, onSelect,
}: DraggableTileProps) {
  const translateX = useSharedValue(0);
  const translateY = useSharedValue(0);
  const scale = useSharedValue(1);
  const zIndex = useSharedValue(1);
  const rotationOffset = useSharedValue(0);

  const [a, b] = tile;

  const triggerErrorShake = () => {
    haptics.playError();
    sounds.play('invalid_move');
    rotationOffset.value = withSequence(
      withTiming(-8, { duration: 50 }),
      withTiming(8, { duration: 50 }),
      withTiming(-8, { duration: 50 }),
      withTiming(8, { duration: 50 }),
      withTiming(0, { duration: 50 }),
    );
  };

  const panGesture = Gesture.Pan()
    .minDistance(2)
    .onStart(() => {
      scale.value = withSpring(1.18);
      zIndex.value = 9999;
    })
    .onUpdate((event) => {
      translateX.value = event.translationX;
      translateY.value = event.translationY;
      if (isPlayable && onDragPreview && (Math.abs(event.translationX) >= 2 || Math.abs(event.translationY) >= 2)) {
        const side: 'left' | 'right' = event.absoluteX < SCREEN_WIDTH / 2 ? 'left' : 'right';
        const isDropZone = event.translationY < -20;
        runOnJS(onDragPreview)({ tile, x: event.translationX, y: event.translationY, side, isDropZone });
      }
    })
    .onEnd((event) => {
      scale.value = withSpring(1);
      if (!isPlayable) {
        translateX.value = withSpring(0);
        translateY.value = withSpring(0);
        zIndex.value = 1;
        runOnJS(triggerErrorShake)();
        if (onDragRelease) runOnJS(onDragRelease)();
        return;
      }
      // The hand area is at the bottom. A drag is valid if they moved it significantly
      // away from its original position in the hand.
      const draggedSignificantly = Math.abs(event.translationX) > 50 || event.translationY < -30 || event.translationY > 50;
      
      if (draggedSignificantly) {
        const side: 'left' | 'right' = event.absoluteX < SCREEN_WIDTH / 2 ? 'left' : 'right';
        runOnJS(onPlayRequest)(tile, side);
        translateX.value = withSpring(0);
        translateY.value = withSpring(0);
        zIndex.value = 1;
      } else {
        translateX.value = withSpring(0);
        translateY.value = withSpring(0);
        zIndex.value = 1;
      }
      if (onDragRelease) runOnJS(onDragRelease)();
    });

  const tapGesture = Gesture.Tap()
    .maxDuration(220)
    .maxDistance(10)
    .onEnd(() => {
      if (!isPlayable) return;
      if (onSelect) runOnJS(onSelect)(tile);
    });

  const composedGesture = Gesture.Exclusive(panGesture, tapGesture);

  const animatedStyle = useAnimatedStyle(() => ({
    transform: [
      { translateX: translateX.value },
      { translateY: translateY.value },
      { rotateZ: `${rotationOffset.value}deg` },
      { scale: scale.value },
    ],
    zIndex: zIndex.value,
  }));

  return (
    <GestureDetector gesture={composedGesture}>
      <Animated.View
        style={[styles.draggableWrapper, animatedStyle]}
        accessibilityRole="adjustable"
        accessibilityLabel={`Tuile domino ${a} ${b}. ${isPlayable ? 'Jouable' : 'Ce n\'est pas votre tour'}`}
        accessibilityActions={[{ name: 'play', label: 'Jouer la tuile' }]}
        onAccessibilityAction={(event) => {
          if (event.nativeEvent.actionName === 'play' && isPlayable) {
            onPlayRequest(tile, 'right');
          }
        }}
      >
        <DominoTile a={a} b={b} size="medium" isPlayable={isPlayable} isSelected={isSelected} />
      </Animated.View>
    </GestureDetector>
  );
});

interface PlayerHandProps {
  hand: Tile[];
  isMyTurn: boolean;
  onPlayTile: (tile: Tile, side: 'left' | 'right' | 'up' | 'down') => void;
  onDragPreview?: (payload: { tile: Tile; x: number; y: number; side: 'left' | 'right'; isDropZone: boolean }) => void;
  onDragRelease?: () => void;
  selectedTile?: Tile | null;
  onSelectTile?: (tile: Tile) => void;
  isTilePlayable?: (tile: Tile) => boolean;
}

export function PlayerHand({
  hand, isMyTurn, onPlayTile, onDragPreview, onDragRelease,
  selectedTile = null, onSelectTile, isTilePlayable,
}: PlayerHandProps) {
  return (
    <View style={styles.container}>
      <View style={styles.handWrapper}>
        {hand.map((tile, i) => (
          <DraggableTile
            key={`${tile[0]}-${tile[1]}`}
            tile={tile}
            index={i}
            total={hand.length}
            isPlayable={isMyTurn && (isTilePlayable ? isTilePlayable(tile) : true)}
            onPlayRequest={onPlayTile}
            onDragPreview={onDragPreview}
            onDragRelease={onDragRelease}
            isSelected={!!selectedTile && selectedTile[0] === tile[0] && selectedTile[1] === tile[1]}
            onSelect={onSelectTile}
          />
        ))}
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    height: 140,
    backgroundColor: '#5C2E0E',
    borderTopWidth: 3,
    borderTopColor: '#8B4513',
    alignItems: 'center',
    justifyContent: 'center',
    paddingBottom: 20,
    zIndex: 9999,
    elevation: 9999,
    overflow: 'visible',
  },
  handWrapper: {
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    gap: OVERLAP,
    overflow: 'visible',
  },
  draggableWrapper: {
    overflow: 'visible',
    zIndex: 9999,
    elevation: 9999,
  },
});
