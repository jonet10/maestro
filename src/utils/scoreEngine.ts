import { PlacedTile, Tile } from "../types";

export interface OpenEnds {
  left: number | null;
  right: number | null;
  top: number | null;
  bottom: number | null;
}

/**
 * Phase 1: Detects open ends of the board strictly based on connectivity (exposed faces).
 */
export function calculateOpenEnds(placedTiles: PlacedTile[]): OpenEnds {
  const result: OpenEnds = { left: null, right: null, top: null, bottom: null };

  if (placedTiles.length === 0) {
    return result;
  }

  // Find the start tile
  const startTile = placedTiles.find(pt => pt.playedAt === "start");
  if (!startTile) {
    return result;
  }

  // Handle single tile on the board
  if (placedTiles.length === 1) {
    if (startTile.isDouble) {
      result.left = startTile.tile[0];
      result.right = startTile.tile[1];
    } else {
      result.left = startTile.tile[0];
      result.right = startTile.tile[1];
    }
    return result;
  }

  // Separate branches
  const leftBranch = placedTiles.filter(pt => pt.playedAt === "left");
  const rightBranch = placedTiles.filter(pt => pt.playedAt === "right");
  const topBranch = placedTiles.filter(pt => pt.playedAt === "top");
  const bottomBranch = placedTiles.filter(pt => pt.playedAt === "bottom");

  // Left open end:
  if (leftBranch.length > 0) {
    const lastLeft = leftBranch[leftBranch.length - 1];
    result.left = lastLeft.isDouble ? (lastLeft.tile[0] + lastLeft.tile[1]) : lastLeft.connectedAs[1];
  } else {
    // If left branch is empty, the left side of start tile is exposed.
    // If startTile is a double, and top/bottom branches are also empty, it acts as an end double (both exposed sides count).
    result.left = (startTile.isDouble && topBranch.length === 0 && bottomBranch.length === 0) 
      ? (startTile.tile[0] + startTile.tile[1]) 
      : startTile.connectedAs[0];
  }

  // Right open end:
  if (rightBranch.length > 0) {
    const lastRight = rightBranch[rightBranch.length - 1];
    result.right = lastRight.isDouble ? (lastRight.tile[0] + lastRight.tile[1]) : lastRight.connectedAs[1];
  } else {
    // If right branch is empty, the right side of start tile is exposed.
    // If startTile is a double, and top/bottom branches are also empty, it acts as an end double (both exposed sides count).
    result.right = (startTile.isDouble && topBranch.length === 0 && bottomBranch.length === 0) 
      ? (startTile.tile[0] + startTile.tile[1]) 
      : startTile.connectedAs[1];
  }

  // Top open end:
  // According to the verified Flyclops rule, empty branches do not contribute to the score.
  if (topBranch.length > 0) {
    const lastTop = topBranch[topBranch.length - 1];
    result.top = lastTop.isDouble ? (lastTop.tile[0] + lastTop.tile[1]) : lastTop.connectedAs[1];
  }

  // Bottom open end:
  if (bottomBranch.length > 0) {
    const lastBottom = bottomBranch[bottomBranch.length - 1];
    result.bottom = lastBottom.isDouble ? (lastBottom.tile[0] + lastBottom.tile[1]) : lastBottom.connectedAs[1];
  }

  return result;
}

/**
 * Calculates raw board score sum from open ends.
 */
export function calculateBoardScore(placedTiles: PlacedTile[]): number {
  const ends = calculateOpenEnds(placedTiles);
  return (ends.left ?? 0) + (ends.right ?? 0) + (ends.top ?? 0) + (ends.bottom ?? 0);
}

/**
 * Phase 2: Checks if a sum is a multiple of 5 and returns it, otherwise 0.
 */
export function calculateMultipleOfFive(sum: number): number {
  if (sum > 0 && sum % 5 === 0) {
    return sum;
  }
  return 0;
}

/**
 * Calculates total pips remaining in a hand.
 */
export function calculateRemainingTiles(hand: Tile[]): number {
  return hand.reduce((acc, tile) => acc + tile[0] + tile[1], 0);
}

/**
 * Rounds a value to the nearest multiple of 5.
 */
export function roundToNearestFive(value: number): number {
  return 5 * Math.round(value / 5);
}

/**
 * Adds points to a player's current score.
 */
export function addPlayerScore(currentScore: number, points: number): number {
  return currentScore + points;
}

/**
 * Checks if a score has reached or exceeded the victory target.
 */
export function checkVictory(score: number, target: number): boolean {
  return score >= target;
}

/**
 * Triggers the callback to reset states and start the next round.
 */
export function startNextRound(resetCallback: () => void): void {
  resetCallback();
}

/**
 * Prints a clean console debug log of the current board's scoring information.
 */
export function printScoreDebug(_placedTiles: PlacedTile[], _sum: number, _points: number) {
  // Debug logging disabled in production to keep the console clean.
  // Re-enable by uncommenting below during local development only.
  /*
  if (import.meta.env.DEV) {
    console.log("========== SCORE DEBUG ==========");
    console.log(`Total = ${_sum} | Awarded = ${_points}`);
    console.log("=================================");
  }
  */
}

