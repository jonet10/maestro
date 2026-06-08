import React from 'react';
import { View, Text, StyleSheet, ScrollView, Platform } from 'react-native';
import { DominoTile } from './DominoTile';
import type { Tile } from '../../engine/types';

interface OpponentHandProps {
  count: number;
  hand?: Tile[];
  faceDown?: boolean;
}

const OVERLAP = -6;

export function OpponentHand({ count, hand, faceDown = true }: OpponentHandProps) {
  const tiles = hand && hand.length > 0 ? hand : null;

  return (
    <View style={styles.container}>
      <View style={styles.labelRow}>
        <View style={styles.countBadge}>
          <Text style={styles.countText}>{count}</Text>
        </View>
        <Text style={styles.labelText}>Adversaire</Text>
      </View>
      <ScrollView
        horizontal
        showsHorizontalScrollIndicator={false}
        contentContainerStyle={styles.scrollContent}
        bounces={false}
      >
        {(tiles ?? Array.from({ length: count })).map((tile, i) => (
          <View key={i} style={styles.tileWrapper}>
            <DominoTile
              a={tiles ? tile[0] : 0}
              b={tiles ? tile[1] : 0}
              faceDown={tiles ? faceDown : true}
              size="small"
            />
          </View>
        ))}
      </ScrollView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    paddingVertical: 8,
    alignItems: 'center',
    backgroundColor: '#1B3A1F',
    borderBottomWidth: 1,
    borderBottomColor: '#0F2412',
  },
  labelRow: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: 6,
    gap: 8,
  },
  labelText: {
    color: '#9CAF9E',
    fontSize: 12,
    fontWeight: '600',
    letterSpacing: 0.3,
  },
  countBadge: {
    backgroundColor: 'rgba(255,255,255,0.1)',
    borderRadius: 10,
    paddingHorizontal: 8,
    paddingVertical: 2,
    borderWidth: 1,
    borderColor: 'rgba(255,255,255,0.15)',
  },
  countText: {
    color: '#E0E7E1',
    fontSize: 12,
    fontWeight: '700',
  },
  scrollContent: {
    paddingHorizontal: 16,
    gap: OVERLAP,
  },
  tileWrapper: {
    ...Platform.select({
      web: {
        boxShadow: '0 2px 6px rgba(0,0,0,0.25)',
      },
      default: {
        shadowColor: '#000',
        shadowOffset: { width: -1, height: 2 },
        shadowOpacity: 0.4,
        shadowRadius: 3,
        elevation: 3,
      },
    }),
  },
});
