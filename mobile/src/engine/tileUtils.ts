import { Tile } from './types';

// Generate standard double-6 set (28 tiles)
export const generateTileSet = (): Tile[] => {
  const tiles: Tile[] = [];
  for (let i = 0; i <= 6; i++) {
    for (let j = i; j <= 6; j++) {
      tiles.push([i, j]);
    }
  }
  return tiles;
};

// Fisher-Yates shuffle
export const shuffleTiles = (tiles: Tile[], seed?: number): Tile[] => {
  const shuffled = [...tiles];
  
  // Note: For deterministic shuffling, a seeded random function should be used here.
  // For simplicity in this local version, we use Math.random() unless seed logic is injected.
  const random = () => Math.random();

  for (let i = shuffled.length - 1; i > 0; i--) {
    const j = Math.floor(random() * (i + 1));
    [shuffled[i], shuffled[j]] = [shuffled[j], shuffled[i]];
  }
  return shuffled;
};

export const isDouble = (tile: Tile): boolean => {
  return tile[0] === tile[1];
};

export const tileValue = (tile: Tile): number => {
  return tile[0] + tile[1];
};

export const areTilesEqual = (t1: Tile, t2: Tile): boolean => {
  return (t1[0] === t2[0] && t1[1] === t2[1]) || (t1[0] === t2[1] && t1[1] === t2[0]);
};

export const hasTile = (hand: Tile[], tile: Tile): boolean => {
  return hand.some(t => areTilesEqual(t, tile));
};

export const removeTile = (hand: Tile[], tile: Tile): Tile[] => {
  const idx = hand.findIndex(t => areTilesEqual(t, tile));
  if (idx === -1) return hand;
  const newHand = [...hand];
  newHand.splice(idx, 1);
  return newHand;
};
