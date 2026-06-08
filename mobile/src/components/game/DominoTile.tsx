import React from 'react';
import { View, StyleSheet, Platform } from 'react-native';
import { TILE_SW, TILE_LG } from './BoardLayoutEngine';

interface DominoTileProps {
  a: number;
  b: number;
  faceDown?: boolean;
  isPlayable?: boolean;
  isSelected?: boolean;
  size?: 'small' | 'medium' | 'large';
  horizontal?: boolean;
}

const TILE_SIZES = {
  small:  { w: 32, h: 64 },
  medium: { w: TILE_SW, h: TILE_LG },
  large:  { w: 55, h: 110 },
};

const PIP_COLORS: Record<number, string> = {
  1: '#00ACC1',
  2: '#D32F2F',
  3: '#E65100',
  4: '#1565C0',
  5: '#2E7D32',
  6: '#6A1B9A',
};

const PIP_POSITIONS: Record<number, Array<[number, number]>> = {
  0: [],
  1: [[0.5, 0.5]],
  2: [[0.3, 0.3], [0.7, 0.7]],
  3: [[0.3, 0.3], [0.5, 0.5], [0.7, 0.7]],
  4: [[0.3, 0.3], [0.7, 0.3], [0.3, 0.7], [0.7, 0.7]],
  5: [[0.3, 0.3], [0.7, 0.3], [0.5, 0.5], [0.3, 0.7], [0.7, 0.7]],
  6: [[0.3, 0.2], [0.7, 0.2], [0.3, 0.5], [0.7, 0.5], [0.3, 0.8], [0.7, 0.8]],
};

const PipGloss = ({ r }: { r: number }) => (
  <View style={{ width: r * 1.4, height: r * 0.45, borderRadius: r * 0.22, backgroundColor: 'rgba(255,255,255,0.35)', position: 'absolute', top: r * 0.1 }} />
);

const PipDot = ({ cx, cy, r, color }: { cx: number; cy: number; r: number; color: string }) => (
  <View style={{
    position: 'absolute', left: cx - r, top: cy - r, width: r * 2, height: r * 2,
    borderRadius: r, backgroundColor: color, alignItems: 'center', overflow: 'hidden',
    ...Platform.select({
      web: { boxShadow: `0 1px 2px rgba(0,0,0,0.4), inset 0 1px 0 rgba(255,255,255,0.3)` },
      default: { shadowColor: '#000', shadowOffset: { width: 0, height: 1 }, shadowOpacity: 0.35, shadowRadius: 1.5, elevation: 2 },
    }),
  }}>
    <PipGloss r={r} />
  </View>
);

const PipHalf = ({ value, halfW, halfH }: { value: number; halfW: number; halfH: number }) => {
  const pips = PIP_POSITIONS[value] ?? [];
  const color = PIP_COLORS[value] ?? '#1A1A1A';
  const r = Math.max(1.5, Math.min(Math.min(halfW, halfH) * 0.078, 3.0));
  return (
    <View style={{ width: halfW, height: halfH, position: 'relative', justifyContent: 'center', alignItems: 'center' }}>
      {pips.map(([x, y], i) => (
        <PipDot key={i} cx={x * halfW} cy={y * halfH} r={r} color={color} />
      ))}
    </View>
  );
};

/**
 * a = pip sur le bord début (gauche si horizontal, haut si vertical).
 * b = pip sur le bord fin   (droite si horizontal, bas si vertical).
 * L'ordre [a, b] est calculé par resolveTileDisplay() dans tileDisplayOrientation.ts.
 */
export function DominoTile({
  a, b, faceDown = false, isPlayable = false, isSelected = false,
  size = 'medium', horizontal = false,
}: DominoTileProps) {
  const base = TILE_SIZES[size];
  const width = horizontal ? base.h : base.w;
  const height = horizontal ? base.w : base.h;
  const dividerHorizontal = horizontal;
  const halfW = dividerHorizontal ? width / 2 : width;
  const halfH = dividerHorizontal ? height : height / 2;

  if (faceDown) {
    return (
      <View style={[styles.backTile, { width, height }]}>
        <View style={styles.backInner}>
          <View style={styles.backPattern}>
            {Array.from({ length: 4 }).map((_, i) => (
              <View key={i} style={[styles.backDot, { top: 15 + i * 12, left: 10 + (i % 2) * 12 }]} />
            ))}
          </View>
          <View style={styles.backCenterLine} />
        </View>
      </View>
    );
  }

  return (
    <View style={[styles.tile, { width, height }, isPlayable && styles.playable, isSelected && styles.selected]}>
      <View style={styles.tileInner}>
        <View style={[styles.content, dividerHorizontal ? styles.row : styles.col]}>
          <View style={styles.half}>
            <PipHalf value={a} halfW={halfW} halfH={halfH} />
          </View>
          <View style={dividerHorizontal ? styles.vDivider : styles.hDivider} />
          <View style={styles.half}>
            <PipHalf value={b} halfW={halfW} halfH={halfH} />
          </View>
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  tile: {
    backgroundColor: '#FDF8F0',
    borderRadius: 10,
    borderWidth: 1,
    borderColor: '#D4C9B0',
    ...Platform.select({
      web: {
        boxShadow: '0 6px 16px rgba(0,0,0,0.25), 0 2px 4px rgba(0,0,0,0.12), inset 0 1px 0 rgba(255,255,255,0.9), inset 0 -1px 0 rgba(0,0,0,0.05)',
        transition: 'transform 0.15s ease, box-shadow 0.15s ease',
      },
      default: {
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 5 },
        shadowOpacity: 0.3,
        shadowRadius: 8,
        elevation: 8,
      },
    }),
  },
  tileInner: {
    flex: 1,
    borderRadius: 9,
    overflow: 'hidden',
    backgroundColor: '#FDF8F0',
  },
  content: { flex: 1 },
  row: { flexDirection: 'row' },
  col: { flexDirection: 'column' },
  half: { flex: 1, alignItems: 'center', justifyContent: 'center' },
  hDivider: {
    height: 2,
    backgroundColor: '#1A1A1A',
    width: '100%',
    ...Platform.select({
      web: { boxShadow: '0 1px 0 rgba(255,255,255,0.3), 0 -1px 0 rgba(0,0,0,0.08)' },
      default: {},
    }),
  },
  vDivider: {
    width: 2,
    backgroundColor: '#1A1A1A',
    height: '100%',
    ...Platform.select({
      web: { boxShadow: '1px 0 0 rgba(255,255,255,0.3), -1px 0 0 rgba(0,0,0,0.08)' },
      default: {},
    }),
  },
  playable: {
    borderColor: '#4ADE80',
    ...Platform.select({
      web: { boxShadow: '0 4px 12px rgba(0,0,0,0.2), 0 0 0 1.5px rgba(74,222,128,0.45)' },
      default: { shadowColor: '#4ADE80', shadowOpacity: 0.5, shadowRadius: 10 },
    }),
  },
  selected: {
    borderColor: '#FBBF24',
    ...Platform.select({
      web: { boxShadow: '0 4px 14px rgba(0,0,0,0.22), 0 0 0 1.5px rgba(251,191,36,0.55), 0 0 16px rgba(251,191,36,0.2)' },
      default: { shadowColor: '#FBBF24', shadowOpacity: 0.6, shadowRadius: 12 },
    }),
  },
  backTile: {
    backgroundColor: '#0F1A2E',
    borderColor: '#1E3A5F',
    borderWidth: 1.5,
    borderRadius: 9,
    ...Platform.select({
      web: { boxShadow: '0 3px 8px rgba(0,0,0,0.25), inset 0 1px 0 rgba(255,255,255,0.08)' },
      default: { shadowColor: '#000', shadowOffset: { width: 0, height: 3 }, shadowOpacity: 0.3, shadowRadius: 5, elevation: 5 },
    }),
    padding: 3,
  },
  backInner: {
    flex: 1,
    backgroundColor: '#13213A',
    borderRadius: 5,
    alignItems: 'center',
    justifyContent: 'center',
    overflow: 'hidden',
    borderWidth: 1,
    borderColor: 'rgba(255,255,255,0.05)',
  },
  backPattern: {
    position: 'absolute',
    top: 0, left: 0, right: 0, bottom: 0,
    opacity: 0.3,
  },
  backDot: {
    position: 'absolute',
    width: 4,
    height: 4,
    borderRadius: 2,
    backgroundColor: 'rgba(255,255,255,0.15)',
  },
  backCenterLine: {
    width: '50%',
    height: 1.5,
    backgroundColor: 'rgba(255,255,255,0.08)',
    transform: [{ rotate: '45deg' }],
  },
});
