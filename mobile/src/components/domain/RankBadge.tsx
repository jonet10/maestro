import React, { useEffect } from 'react';
import { View, Text, StyleSheet } from 'react-native';
import Animated, { 
  useSharedValue, 
  useAnimatedStyle, 
  withSpring, 
  withRepeat, 
  withSequence, 
  withTiming 
} from 'react-native-reanimated';

type Rank = 'Debitant' | 'Mwayen' | 'Avanse' | 'Met' | 'Gran Met' | 'Dominolog';

interface RankBadgeProps {
  rank: Rank;
}

const rankColors: Record<Rank, string> = {
  Debitant: '#FFD700', // yellow
  Mwayen: '#4CAF50', // green
  Avanse: '#03A9F4', // light blue
  Met: '#000080', // navy blue
  'Gran Met': '#FFDF00', // gold
  Dominolog: '#FF0000', // red
};

export const RankBadge = ({ rank }: RankBadgeProps) => {
  const scale = useSharedValue(0.9);
  const opacity = useSharedValue(0.8);

  useEffect(() => {
    scale.value = withRepeat(
      withSequence(
        withTiming(1.05, { duration: 1500 }),
        withTiming(0.95, { duration: 1500 })
      ),
      -1,
      true
    );
    opacity.value = withRepeat(
      withSequence(
        withTiming(1, { duration: 1500 }),
        withTiming(0.8, { duration: 1500 })
      ),
      -1,
      true
    );
  }, []);

  const animatedStyle = useAnimatedStyle(() => {
    return {
      transform: [{ scale: scale.value }],
      opacity: opacity.value,
    };
  });

  return (
    <View style={styles.container}>
      <Animated.View style={[
        styles.badge, 
        { backgroundColor: rankColors[rank] },
        animatedStyle
      ]}>
        <Text style={styles.text}>{rank}</Text>
      </Animated.View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    alignItems: 'center',
    justifyContent: 'center',
    marginVertical: 12,
  },
  badge: {
    paddingHorizontal: 16,
    paddingVertical: 8,
    borderRadius: 20,
    shadowColor: '#000',
    shadowOffset: { width: 0, height: 4 },
    shadowOpacity: 0.3,
    shadowRadius: 5,
    elevation: 8,
  },
  text: {
    color: '#FFF',
    fontWeight: '900',
    fontSize: 14,
    textTransform: 'uppercase',
    letterSpacing: 1,
    textShadowColor: 'rgba(0, 0, 0, 0.75)',
    textShadowOffset: {width: -1, height: 1},
    textShadowRadius: 10
  },
});
