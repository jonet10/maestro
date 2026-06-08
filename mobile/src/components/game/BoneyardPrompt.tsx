import React from 'react';
import { View, StyleSheet, Pressable, Platform } from 'react-native';
import Animated, { FadeInDown, FadeOutUp } from 'react-native-reanimated';
import { DominoTile } from './DominoTile';
import { sounds } from '../../utils/SoundManager';
import { haptics } from '../../utils/HapticsManager';

interface BoneyardPromptProps {
  visible: boolean;
  onDraw: () => void;
  boneyardCount: number;
}

export function BoneyardPrompt({ visible, onDraw, boneyardCount }: BoneyardPromptProps) {
  if (!visible || boneyardCount <= 0) return null;

  const handleDraw = () => {
    sounds.play('tile_place');
    haptics.playSnap();
    onDraw();
  };

  return (
    <Animated.View 
      entering={FadeInDown.springify().damping(15)} 
      exiting={FadeOutUp.duration(200)} 
      style={styles.container}
    >
      <View style={styles.tray}>
        {Array.from({ length: boneyardCount }).map((_, i) => (
          <Pressable 
            key={i} 
            onPress={handleDraw} 
            style={({ pressed }) => [
              styles.tileWrapper,
              pressed && styles.tilePressed
            ]}
          >
            <DominoTile a={0} b={0} faceDown={true} size="medium" />
          </Pressable>
        ))}
      </View>
    </Animated.View>
  );
}

const styles = StyleSheet.create({
  container: {
    position: 'absolute',
    top: '20%',
    left: 20,
    right: 20,
    zIndex: 100,
    alignItems: 'center',
  },
  tray: {
    backgroundColor: '#8B4513', // Wood color
    padding: 12,
    borderRadius: 8,
    borderWidth: 4,
    borderColor: '#5C2E0E', // Dark wood border
    flexDirection: 'row',
    flexWrap: 'wrap',
    justifyContent: 'center',
    gap: 8,
    maxWidth: 380, // Enough for 7 medium tiles (40px) + gaps
    ...Platform.select({
      web: {
        boxShadow: '0 10px 25px rgba(0,0,0,0.5)',
      },
      default: {
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 10 },
        shadowOpacity: 0.5,
        shadowRadius: 15,
        elevation: 10,
      },
    }),
  },
  tileWrapper: {
    ...Platform.select({
      web: {
        boxShadow: '0 2px 5px rgba(0,0,0,0.3)',
      },
      default: {
        shadowColor: '#000',
        shadowOffset: { width: 1, height: 2 },
        shadowOpacity: 0.4,
        shadowRadius: 3,
        elevation: 4,
      },
    }),
  },
  tilePressed: {
    opacity: 0.8,
    transform: [{ scale: 0.95 }],
  },
});
