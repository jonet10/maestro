import { GameMode, Tile } from './types';
import { tileValue, areTilesEqual } from './tileUtils';

/** Scores cibles officiels Maestro (alignés moteur ↔ HUD). */
export const TARGET_SCORES: Record<GameMode, number> = {
  fives: 150,
  draw: 250,
  block: 250,
};

export const TILES_PER_PLAYER = 7;
export const DOUBLE_SIX_SET_SIZE = 28;

export function getTargetScore(mode: GameMode = 'fives'): number {
  return TARGET_SCORES[mode];
}

/**
 * Tuile d'ouverture obligatoire : plus haut double en main, sinon plus haute tuile (pip sum).
 * Règle standard All Fives / Draw / Block.
 */
export function getRequiredOpeningTile(hand: Tile[]): Tile | null {
  if (hand.length === 0) return null;

  let bestDouble: Tile | null = null;
  let bestDoubleVal = -1;
  let bestTile: Tile | null = null;
  let bestTileVal = -1;

  for (const t of hand) {
    if (t[0] === t[1] && t[0] > bestDoubleVal) {
      bestDoubleVal = t[0];
      bestDouble = t;
    }
    const v = tileValue(t);
    if (v > bestTileVal) {
      bestTileVal = v;
      bestTile = t;
    }
  }

  return bestDouble ?? bestTile;
}

export function isValidOpeningTile(hand: Tile[], tile: Tile): boolean {
  const required = getRequiredOpeningTile(hand);
  return required !== null && areTilesEqual(required, tile);
}

/** Deux passes consécutives = blocage de partie. */
export const BLOCK_PASS_THRESHOLD = 2;
