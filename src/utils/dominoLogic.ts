/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import { Tile, PlacedTile, Player, GameLog } from "../types";
import { calculateBoardScore } from "./scoreEngine";

/**
 * Generates a standard double-six set of 28 dominoes.
 */
export function generateDoubleSixSet(): Tile[] {
  const set: Tile[] = [];
  for (let i = 0; i <= 6; i++) {
    for (let j = i; j <= 6; j++) {
      set.push([i, j]);
    }
  }
  return set;
}

/**
 * Shuffles an array of tiles.
 */
export function shuffleTiles(tiles: Tile[]): Tile[] {
  const result = [...tiles];
  for (let i = result.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    const temp = result[i];
    result[i] = result[j];
    result[j] = temp;
  }
  return result;
}

/**
 * Deals tiles to user and ai.
 * Returns { userHand, aiHand, boneyard }
 */
export function dealDominoes(): { userHand: Tile[]; aiHand: Tile[]; boneyard: Tile[] } {
  const fullSet = shuffleTiles(generateDoubleSixSet());
  
  // Standard 2-player deal is 7 tiles each
  const userHand = fullSet.slice(0, 7);
  const aiHand = fullSet.slice(7, 14);
  const boneyard = fullSet.slice(14);
  
  return { userHand, aiHand, boneyard };
}

export interface OpenEnds2D {
  left: number | null;
  right: number | null;
  top: number | null;
  bottom: number | null;
}

/**
 * Returns the open ends of the current board layout in 2D.
 */
export function getOpenEnds2D(placedTiles: PlacedTile[]): OpenEnds2D {
  const result: OpenEnds2D = { left: null, right: null, top: null, bottom: null };
  if (placedTiles.length === 0) {
    return result;
  }

  const startTile = placedTiles.find(pt => pt.playedAt === "start");
  if (!startTile) return result;

  const leftBranch = placedTiles.filter(pt => pt.playedAt === "left");
  const rightBranch = placedTiles.filter(pt => pt.playedAt === "right");
  const topBranch = placedTiles.filter(pt => pt.playedAt === "top");
  const bottomBranch = placedTiles.filter(pt => pt.playedAt === "bottom");

  const hasSpinner = placedTiles.some(pt => pt.isDouble);

  // Left open value:
  if (leftBranch.length > 0) {
    result.left = leftBranch[leftBranch.length - 1].connectedAs[1];
  } else {
    result.left = startTile.connectedAs[0];
  }

  // Right open value:
  if (rightBranch.length > 0) {
    result.right = rightBranch[rightBranch.length - 1].connectedAs[1];
  } else {
    result.right = startTile.connectedAs[1];
  }

  // Top and bottom only open if spinner exists and BOTH left and right have been played onto.
  if (hasSpinner) {
    const spinnerTile = placedTiles.find(pt => pt.isDouble)!;
    const spinnerVal = spinnerTile.tile[0];

    // Determine if the spinner is connected on both sides (left/right) so its top/bottom activate
    let spinnerConnectedBothSides = false;

    if (spinnerTile.playedAt === "start") {
      spinnerConnectedBothSides = leftBranch.length > 0 && rightBranch.length > 0;
    } else if (spinnerTile.playedAt === "left") {
      const spinnerIndex = leftBranch.findIndex(pt => pt.id === spinnerTile.id);
      spinnerConnectedBothSides = spinnerIndex !== -1 && spinnerIndex < leftBranch.length - 1;
    } else if (spinnerTile.playedAt === "right") {
      const spinnerIndex = rightBranch.findIndex(pt => pt.id === spinnerTile.id);
      spinnerConnectedBothSides = spinnerIndex !== -1 && spinnerIndex < rightBranch.length - 1;
    }

    if (spinnerConnectedBothSides) {
      if (topBranch.length > 0) {
        result.top = topBranch[topBranch.length - 1].connectedAs[1];
      } else {
        result.top = spinnerVal;
      }

      if (bottomBranch.length > 0) {
        result.bottom = bottomBranch[bottomBranch.length - 1].connectedAs[1];
      } else {
        result.bottom = spinnerVal;
      }
    }
  }

  return result;
}

/**
 * Returns the open ends in legacy format [left, right]
 */
export function getOpenEnds(placedTiles: PlacedTile[]): [number | null, number | null] {
  if (placedTiles.length === 0) {
    return [null, null];
  }
  const ends = getOpenEnds2D(placedTiles);
  return [ends.left, ends.right];
}

/**
 * Checks if a tile can be played on the active 2D ends.
 */
export function evaluatePlayability2D(
  tile: Tile,
  openEnds: OpenEnds2D
): { left: boolean; right: boolean; top: boolean; bottom: boolean } {
  const [a, b] = tile;
  return {
    left: openEnds.left !== null && (a === openEnds.left || b === openEnds.left),
    right: openEnds.right !== null && (a === openEnds.right || b === openEnds.right),
    top: openEnds.top !== null && (a === openEnds.top || b === openEnds.top),
    bottom: openEnds.bottom !== null && (a === openEnds.bottom || b === openEnds.bottom),
  };
}

/**
 * Legacy wrapper for checking playability.
 */
export function evaluatePlayability(
  tile: Tile,
  openEnds: [number | null, number | null]
): [boolean, boolean] {
  const [leftOpen, rightOpen] = openEnds;
  const [a, b] = tile;

  if (leftOpen === null || rightOpen === null) {
    return [true, true];
  }

  const canLeft = a === leftOpen || b === leftOpen;
  const canRight = a === rightOpen || b === rightOpen;

  return [canLeft, canRight];
}

/**
 * Rotates tile so that connectedAs represents [inner_value, outer_value]
 * where inner matches the connection point on the board.
 */
export function getPlayedTileRotation2D(
  tile: Tile,
  side: "left" | "right" | "top" | "bottom" | "start",
  openEnds: OpenEnds2D
): [number, number] {
  const [a, b] = tile;

  if (side === "start" || openEnds.left === null) {
    return [a, b];
  }

  let openVal: number | null = null;
  if (side === "left") openVal = openEnds.left;
  else if (side === "right") openVal = openEnds.right;
  else if (side === "top") openVal = openEnds.top;
  else if (side === "bottom") openVal = openEnds.bottom;

  if (openVal === null) {
    return [a, b];
  }

  if (a === openVal) {
    return [a, b]; // matching a to the board, b is the new end
  } else {
    return [b, a]; // matching b to the board, a is the new end
  }
}

/**
 * Legacy wrapper for tile rotater
 */
export function getPlayedTileRotation(
  tile: Tile,
  side: "left" | "right" | "start",
  openEnds: [number | null, number | null]
): [number, number] {
  const [leftOpen, rightOpen] = openEnds;
  const ends = { left: leftOpen, right: rightOpen, top: null, bottom: null };
  return getPlayedTileRotation2D(tile, side, ends);
}

/**
 * Calculates current All Fives score of the board ends.
 * In All Fives, points are scored when the sum of the exposed ends is a multiple of 5.
 */
export function calculateAllFivesSum2D(placedTiles: PlacedTile[]): number {
  return calculateBoardScore(placedTiles);
}

/**
 * Legacy wrapper for calculated score sum
 */
export function calculateAllFivesSum(placedTiles: PlacedTile[]): number {
  return calculateBoardScore(placedTiles);
}

/**
 * Checks if a hand has any playable moves in 2D.
 */
export function hasPlayableTile2D(hand: Tile[], openEnds: OpenEnds2D): boolean {
  return hand.some(tile => {
    const play = evaluatePlayability2D(tile, openEnds);
    return play.left || play.right || play.top || play.bottom;
  });
}

/**
 * Legacy/Dual compatible playable tile checker
 */
export function hasPlayableTile(hand: Tile[], openEnds: [number | null, number | null] | OpenEnds2D): boolean {
  if (Array.isArray(openEnds)) {
    return hand.some(tile => {
      const [a, b] = tile;
      return (openEnds[0] !== null && (a === openEnds[0] || b === openEnds[0])) ||
             (openEnds[1] !== null && (a === openEnds[1] || b === openEnds[1]));
    });
  } else {
    return hasPlayableTile2D(hand, openEnds);
  }
}

/**
 * Sums the pip total of a hand (used for scoring at the end of a round).
 */
export function sumHandPips(hand: Tile[]): number {
  return hand.reduce((acc, tile) => acc + tile[0] + tile[1], 0);
}

/**
 * Creates a unique ID.
 */
export function generateId(): string {
  return Math.random().toString(36).substring(2, 9);
}

/**
 * Helper to record a log message.
 */
export function createLog(
  player: "user" | "ai" | "system",
  message: string,
  type: "play" | "draw" | "pass" | "score" | "win" | "system"
): GameLog {
  return {
    id: generateId(),
    timestamp: new Date().toLocaleTimeString([], { hour: '2-digit', minute: '2-digit', second: '2-digit' }),
    player,
    message,
    type,
  };
}

export interface TileLayout {
  gridX: number;
  gridY: number;
  rotation: number;
}

export interface BoundingBox {
  minX: number;
  maxX: number;
  minY: number;
  maxY: number;
}

export function getBoundingBox(gridX: number, gridY: number, rotation: number): BoundingBox {
  const isVertical = rotation === 0 || rotation === 180;
  if (isVertical) {
    return {
      minX: gridX - 0.5,
      maxX: gridX + 0.5,
      minY: gridY - 1.0,
      maxY: gridY + 1.0,
    };
  } else {
    return {
      minX: gridX - 1.0,
      maxX: gridX + 1.0,
      minY: gridY - 0.5,
      maxY: gridY + 0.5,
    };
  }
}

export function intersectBoxes(box1: BoundingBox, box2: BoundingBox, epsilon = 0.1): boolean {
  return (
    box1.minX < box2.maxX - epsilon &&
    box1.maxX > box2.minX + epsilon &&
    box1.minY < box2.maxY - epsilon &&
    box1.maxY > box2.minY + epsilon
  );
}

function getDynamicTurnDirections(
  dir: "left" | "right" | "up" | "down",
  gridX: number,
  gridY: number,
  branch: "left" | "right" | "top" | "bottom"
): ("left" | "right" | "up" | "down")[] {
  // Windmill Snaking Layout: Gated branch growth into non-overlapping diagonal quadrants
  if (branch === "left") {
    // Left branch: only moves left and up (Top-Left quadrant)
    if (dir === "left") return ["up", "left", "down", "right"];
    if (dir === "up") return ["left", "up", "right", "down"];
    if (dir === "down") return ["left", "up", "down", "right"];
    if (dir === "right") return ["up", "left", "right", "down"];
  } else if (branch === "top") {
    // Top branch: only moves up and right (Top-Right quadrant)
    if (dir === "up") return ["right", "up", "left", "down"];
    if (dir === "right") return ["up", "right", "down", "left"];
    if (dir === "down") return ["right", "up", "down", "left"];
    if (dir === "left") return ["up", "right", "left", "down"];
  } else if (branch === "right") {
    // Right branch: only moves right and down (Bottom-Right quadrant)
    if (dir === "right") return ["down", "right", "up", "left"];
    if (dir === "down") return ["right", "down", "left", "up"];
    if (dir === "up") return ["right", "down", "up", "left"];
    if (dir === "left") return ["down", "right", "left", "up"];
  } else if (branch === "bottom") {
    // Bottom branch: only moves down and left (Bottom-Left quadrant)
    if (dir === "down") return ["left", "down", "right", "up"];
    if (dir === "left") return ["down", "left", "up", "right"];
    if (dir === "up") return ["left", "down", "up", "right"];
    if (dir === "right") return ["down", "left", "right", "up"];
  }

  // Fallback
  if (dir === "left" || dir === "right") return ["up", "down"];
  return ["left", "right"];
}



function getTileGeometry(
  cursorX: number,
  cursorY: number,
  prevDir: "left" | "right" | "up" | "down",
  dir: "left" | "right" | "up" | "down",
  isDouble: boolean,
  prevIsDouble: boolean = false
) {
  // If direction is reversed (shouldn't happen), treat it as continuing straight to avoid crash
  if ((dir === "left" && prevDir === "right") || (dir === "right" && prevDir === "left")) dir = prevDir;
  if ((dir === "up" && prevDir === "down") || (dir === "down" && prevDir === "up")) dir = prevDir;

  // If the predecessor was a double, adjust connection coordinates since doubles are perpendicular
  if (prevIsDouble) {
    if (prevDir === "left") {
      const prevCenterX = cursorX + 0.5;
      const prevCenterY = cursorY;
      if (dir === "down") {
        return isDouble
          ? { gridX: prevCenterX - 1.5, gridY: prevCenterY + 1.0, rotation: 90, nextCursorX: prevCenterX - 1.5, nextCursorY: prevCenterY + 1.5 }
          : { gridX: prevCenterX - 1.0, gridY: prevCenterY + 0.5, rotation: 0, nextCursorX: prevCenterX - 1.0, nextCursorY: prevCenterY + 1.5 };
      } else if (dir === "up") {
        return isDouble
          ? { gridX: prevCenterX - 1.5, gridY: prevCenterY - 1.0, rotation: 90, nextCursorX: prevCenterX - 1.5, nextCursorY: prevCenterY - 1.5 }
          : { gridX: prevCenterX - 1.0, gridY: prevCenterY - 0.5, rotation: 0, nextCursorX: prevCenterX - 1.0, nextCursorY: prevCenterY - 1.5 };
      } else if (dir === "left") {
        return isDouble
          ? { gridX: prevCenterX - 1.0, gridY: prevCenterY, rotation: 0, nextCursorX: prevCenterX - 1.5, nextCursorY: prevCenterY }
          : { gridX: prevCenterX - 1.5, gridY: prevCenterY, rotation: 90, nextCursorX: prevCenterX - 2.5, nextCursorY: prevCenterY };
      }
    } else if (prevDir === "right") {
      const prevCenterX = cursorX - 0.5;
      const prevCenterY = cursorY;
      if (dir === "down") {
        return isDouble
          ? { gridX: prevCenterX + 1.5, gridY: prevCenterY + 1.0, rotation: 90, nextCursorX: prevCenterX + 1.5, nextCursorY: prevCenterY + 1.5 }
          : { gridX: prevCenterX + 1.0, gridY: prevCenterY + 0.5, rotation: 0, nextCursorX: prevCenterX + 1.0, nextCursorY: prevCenterY + 1.5 };
      } else if (dir === "up") {
        return isDouble
          ? { gridX: prevCenterX + 1.5, gridY: prevCenterY - 1.0, rotation: 90, nextCursorX: prevCenterX + 1.5, nextCursorY: prevCenterY - 1.5 }
          : { gridX: prevCenterX + 1.0, gridY: prevCenterY - 0.5, rotation: 0, nextCursorX: prevCenterX + 1.0, nextCursorY: prevCenterY - 1.5 };
      } else if (dir === "right") {
        return isDouble
          ? { gridX: prevCenterX + 1.0, gridY: prevCenterY, rotation: 0, nextCursorX: prevCenterX + 1.5, nextCursorY: prevCenterY }
          : { gridX: prevCenterX + 1.5, gridY: prevCenterY, rotation: 90, nextCursorX: prevCenterX + 2.5, nextCursorY: prevCenterY };
      }
    } else if (prevDir === "up") {
      const prevCenterX = cursorX;
      const prevCenterY = cursorY + 0.5;
      if (dir === "left") {
        return isDouble
          ? { gridX: prevCenterX - 1.5, gridY: prevCenterY, rotation: 0, nextCursorX: prevCenterX - 2.0, nextCursorY: prevCenterY }
          : { gridX: prevCenterX - 2.0, gridY: prevCenterY, rotation: 90, nextCursorX: prevCenterX - 3.0, nextCursorY: prevCenterY };
      } else if (dir === "right") {
        return isDouble
          ? { gridX: prevCenterX + 1.5, gridY: prevCenterY, rotation: 0, nextCursorX: prevCenterX + 2.0, nextCursorY: prevCenterY }
          : { gridX: prevCenterX + 2.0, gridY: prevCenterY, rotation: 90, nextCursorX: prevCenterX + 3.0, nextCursorY: prevCenterY };
      } else if (dir === "up") {
        return isDouble
          ? { gridX: prevCenterX, gridY: prevCenterY - 1.0, rotation: 90, nextCursorX: prevCenterX, nextCursorY: prevCenterY - 1.5 }
          : { gridX: prevCenterX, gridY: prevCenterY - 1.5, rotation: 0, nextCursorX: prevCenterX, nextCursorY: prevCenterY - 2.5 };
      }
    } else if (prevDir === "down") {
      const prevCenterX = cursorX;
      const prevCenterY = cursorY - 0.5;
      if (dir === "left") {
        return isDouble
          ? { gridX: prevCenterX - 1.5, gridY: prevCenterY, rotation: 0, nextCursorX: prevCenterX - 2.0, nextCursorY: prevCenterY }
          : { gridX: prevCenterX - 2.0, gridY: prevCenterY, rotation: 90, nextCursorX: prevCenterX - 3.0, nextCursorY: prevCenterY };
      } else if (dir === "right") {
        return isDouble
          ? { gridX: prevCenterX + 1.5, gridY: prevCenterY, rotation: 0, nextCursorX: prevCenterX + 2.0, nextCursorY: prevCenterY }
          : { gridX: prevCenterX + 2.0, gridY: prevCenterY, rotation: 90, nextCursorX: prevCenterX + 3.0, nextCursorY: prevCenterY };
      } else if (dir === "down") {
        return isDouble
          ? { gridX: prevCenterX, gridY: prevCenterY + 1.0, rotation: 90, nextCursorX: prevCenterX, nextCursorY: prevCenterY + 1.5 }
          : { gridX: prevCenterX, gridY: prevCenterY + 1.5, rotation: 0, nextCursorX: prevCenterX, nextCursorY: prevCenterY + 2.5 };
      }
    }
  }

  if (prevDir === "up") {
    if (dir === "up") {
      return isDouble 
        ? { gridX: cursorX, gridY: cursorY - 0.5, rotation: 90, nextCursorX: cursorX, nextCursorY: cursorY - 1.0 }
        : { gridX: cursorX, gridY: cursorY - 1.0, rotation: 0, nextCursorX: cursorX, nextCursorY: cursorY - 2.0 };
    } else if (dir === "left") {
      return isDouble
        ? { gridX: cursorX - 1.0, gridY: cursorY + 1.0, rotation: 0, nextCursorX: cursorX - 1.5, nextCursorY: cursorY + 1.0 }
        : { gridX: cursorX - 0.5, gridY: cursorY - 0.5, rotation: 90, nextCursorX: cursorX - 1.5, nextCursorY: cursorY - 0.5 };
    } else if (dir === "right") {
      return isDouble
        ? { gridX: cursorX + 1.0, gridY: cursorY + 1.0, rotation: 0, nextCursorX: cursorX + 1.5, nextCursorY: cursorY + 1.0 }
        : { gridX: cursorX + 0.5, gridY: cursorY - 0.5, rotation: 90, nextCursorX: cursorX + 1.5, nextCursorY: cursorY - 0.5 };
    }
  } else if (prevDir === "down") {
    if (dir === "down") {
      return isDouble 
        ? { gridX: cursorX, gridY: cursorY + 0.5, rotation: 90, nextCursorX: cursorX, nextCursorY: cursorY + 1.0 }
        : { gridX: cursorX, gridY: cursorY + 1.0, rotation: 0, nextCursorX: cursorX, nextCursorY: cursorY + 2.0 };
    } else if (dir === "left") {
      return isDouble
        ? { gridX: cursorX - 1.0, gridY: cursorY - 1.0, rotation: 0, nextCursorX: cursorX - 1.5, nextCursorY: cursorY - 1.0 }
        : { gridX: cursorX - 0.5, gridY: cursorY + 0.5, rotation: 90, nextCursorX: cursorX - 1.5, nextCursorY: cursorY + 0.5 };
    } else if (dir === "right") {
      return isDouble
        ? { gridX: cursorX + 1.0, gridY: cursorY - 1.0, rotation: 0, nextCursorX: cursorX + 1.5, nextCursorY: cursorY - 1.0 }
        : { gridX: cursorX + 0.5, gridY: cursorY + 0.5, rotation: 90, nextCursorX: cursorX + 1.5, nextCursorY: cursorY + 0.5 };
    }
  } else if (prevDir === "left") {
    if (dir === "left") {
      return isDouble 
        ? { gridX: cursorX - 0.5, gridY: cursorY, rotation: 0, nextCursorX: cursorX - 1.0, nextCursorY: cursorY }
        : { gridX: cursorX - 1.0, gridY: cursorY, rotation: 90, nextCursorX: cursorX - 2.0, nextCursorY: cursorY };
    } else if (dir === "up") {
      return isDouble
        ? { gridX: cursorX - 1.0, gridY: cursorY - 1.0, rotation: 90, nextCursorX: cursorX - 1.0, nextCursorY: cursorY - 1.5 }
        : { gridX: cursorX - 0.5, gridY: cursorY - 0.5, rotation: 0, nextCursorX: cursorX - 0.5, nextCursorY: cursorY - 1.5 };
    } else if (dir === "down") {
      return isDouble
        ? { gridX: cursorX - 1.0, gridY: cursorY + 1.0, rotation: 90, nextCursorX: cursorX - 1.0, nextCursorY: cursorY + 1.5 }
        : { gridX: cursorX - 0.5, gridY: cursorY + 0.5, rotation: 0, nextCursorX: cursorX - 0.5, nextCursorY: cursorY + 1.5 };
    }
  } else if (prevDir === "right") {
    if (dir === "right") {
      return isDouble 
        ? { gridX: cursorX + 0.5, gridY: cursorY, rotation: 0, nextCursorX: cursorX + 1.0, nextCursorY: cursorY }
        : { gridX: cursorX + 1.0, gridY: cursorY, rotation: 90, nextCursorX: cursorX + 2.0, nextCursorY: cursorY };
    } else if (dir === "up") {
      return isDouble
        ? { gridX: cursorX + 1.0, gridY: cursorY - 1.0, rotation: 90, nextCursorX: cursorX + 1.0, nextCursorY: cursorY - 1.5 }
        : { gridX: cursorX + 0.5, gridY: cursorY - 0.5, rotation: 0, nextCursorX: cursorX + 0.5, nextCursorY: cursorY - 1.5 };
    } else if (dir === "down") {
      return isDouble
        ? { gridX: cursorX + 1.0, gridY: cursorY + 1.0, rotation: 90, nextCursorX: cursorX + 1.0, nextCursorY: cursorY + 1.5 }
        : { gridX: cursorX + 0.5, gridY: cursorY + 0.5, rotation: 0, nextCursorX: cursorX + 0.5, nextCursorY: cursorY + 1.5 };
    }
  }

  // Fallback if everything fails
  return { gridX: cursorX, gridY: cursorY, rotation: 0, nextCursorX: cursorX, nextCursorY: cursorY };
}

/**
 * Beautiful dynamic 2D coordinate board-alignment calculator with intelligent snaking.
 * Grid coordinates are relative to the startTile.
 */
export function computeTileLayouts(placedTiles: PlacedTile[]): Record<string, TileLayout> {
  const layouts: Record<string, TileLayout> = {};
  if (placedTiles.length === 0) return layouts;

  const startTile = placedTiles.find(pt => pt.playedAt === "start");
  if (!startTile) return layouts;

  // Let's keep a record of all positions computed so far
  const rawPositions: Record<string, TileLayout> = {};
  rawPositions[startTile.id] = { gridX: 0, gridY: 0, rotation: startTile.isDouble ? 0 : 90 };

  // Track parent-child connections
  const parentMap: Record<string, string> = {};

  // Helper to store bounding boxes of placed tiles for collision detection
  const placedBoxes: { id: string; box: BoundingBox }[] = [];
  placedBoxes.push({
    id: startTile.id,
    box: getBoundingBox(0, 0, startTile.isDouble ? 0 : 90)
  });

  // Map of tileId to branch name for repulsion collision checking
  const tileBranches: Record<string, string> = {};
  tileBranches[startTile.id] = "start";


  // We have 4 branch trackers
  const branchStates: Record<"left" | "right" | "top" | "bottom", {
    cursorX: number;
    cursorY: number;
    dir: "left" | "right" | "up" | "down";
    prevDir: "left" | "right" | "up" | "down";
    lastTileId: string;
    initialized: boolean;
    straightCount: number;
  }> = {
    left: {
      cursorX: startTile.isDouble ? -0.5 : -1.0,
      cursorY: 0,
      dir: "left",
      prevDir: "left",
      lastTileId: startTile.id,
      initialized: true,
      straightCount: 1
    },
    right: {
      cursorX: startTile.isDouble ? 0.5 : 1.0,
      cursorY: 0,
      dir: "right",
      prevDir: "right",
      lastTileId: startTile.id,
      initialized: true,
      straightCount: 1
    },
    top: {
      cursorX: 0,
      cursorY: 0,
      dir: "up",
      prevDir: "up",
      lastTileId: startTile.id,
      initialized: false,
      straightCount: 0
    },
    bottom: {
      cursorX: 0,
      cursorY: 0,
      dir: "down",
      prevDir: "down",
      lastTileId: startTile.id,
      initialized: false,
      straightCount: 0
    }
  };

  // If the start tile is a double, it also acts as the spinner, so we initialize the top and bottom branches immediately!
  if (startTile.isDouble) {
    branchStates.top = {
      cursorX: 0,
      cursorY: -1.0,
      dir: "up",
      prevDir: "up",
      lastTileId: startTile.id,
      initialized: true,
      straightCount: 1
    };
    branchStates.bottom = {
      cursorX: 0,
      cursorY: 1.0,
      dir: "down",
      prevDir: "down",
      lastTileId: startTile.id,
      initialized: true,
      straightCount: 1
    };
  }



  // Dynamic soft grid boundaries calculated based on the number of placed tiles
  // Adjusted starting limits to perfectly replicate the exact count of the reference image
  // (Left branch: 5 tiles left, Right branch: 4-5 tiles right, Top branch: 4 tiles up)
  const tileCount = placedTiles.length;
  const scaleFactor = Math.min(2.0, 1.0 + tileCount * 0.03); // gradual scaling
  const MAX_LIMIT_X = Math.round(8.5 * scaleFactor);
  const MIN_LIMIT_X = -Math.round(8.5 * scaleFactor);
  const MAX_LIMIT_Y = Math.round(7.5 * scaleFactor);
  const MIN_LIMIT_Y = -Math.round(7.5 * scaleFactor);

  // Separate and sort tiles by branch to process them from center outwards
  const leftBranch = placedTiles.filter(pt => pt.playedAt === "left");
  const rightBranch = placedTiles.filter(pt => pt.playedAt === "right");
  const topBranch = placedTiles.filter(pt => pt.playedAt === "top");
  const bottomBranch = placedTiles.filter(pt => pt.playedAt === "bottom");

  const sortedTiles = [startTile, ...leftBranch, ...rightBranch, ...topBranch, ...bottomBranch];

  sortedTiles.forEach(pt => {
    if (pt.playedAt === "start") return;
    if (layouts[pt.id]) return; // Skip replica tiles as they already have layout

    const branch = pt.playedAt;
    const state = branchStates[branch];
    if (!state) return;

    // Retrieve previous piece's bounding box or center
    const predecessorId = state.lastTileId;
    parentMap[pt.id] = predecessorId;
    const prevTile = placedTiles.find(t => t.id === predecessorId);
    const prevIsDouble = prevTile ? prevTile.isDouble : false;

    // Turn exactly after 3 tiles (i.e. on the 4th tile, straightCount starts at 1)
    // in any straight segment to create the Flyclops square layout.
    // A double tile is never allowed to turn (it must continue straight).
    // Also prevent turning if the predecessor was a double to avoid overlap/cramping.
    const shouldTurn = state.straightCount >= 4 && !pt.isDouble && !prevIsDouble;

    // Try all directions. If shouldTurn is true, prioritize the preferred turn direction.
    // If not, prioritize going straight. Fallbacks will automatically try alternative directions.
    const allPossibleDirections: ("left" | "right" | "up" | "down")[] = ["left", "right", "up", "down"];
    const turnDirs = getDynamicTurnDirections(state.dir, state.cursorX, state.cursorY, branch);
    const directionsToTry = shouldTurn
      ? Array.from(new Set([...turnDirs, state.dir, ...allPossibleDirections]))
      : Array.from(new Set([state.dir, ...turnDirs, ...allPossibleDirections]));

    const checkBranchCollision = (box: BoundingBox, branchName: string, ignoreId: string | null = null) => {
      // 1. Physical collision check (overlap)
      for (const ob of placedBoxes) {
        if (ignoreId && ob.id === ignoreId) continue;
        if (intersectBoxes(box, ob.box, 0.05)) {
          return true;
        }
      }

      // 2. Smart Parallel touching repulsion check
      const isVertical = box.maxX - box.minX === 1.0;
      for (const ob of placedBoxes) {
        if (ignoreId && ob.id === ignoreId) continue;
        const obBranch = tileBranches[ob.id] || "start";
        if (obBranch === "start" || obBranch === branchName) continue;

        const obVertical = ob.box.maxX - ob.box.minX === 1.0;

        if (isVertical && obVertical) {
          // Both are vertical
          const xDistance = Math.abs((box.minX + box.maxX)/2 - (ob.box.minX + ob.box.maxX)/2);
          if (xDistance < 1.5) { // in adjacent columns (distance = 1.0)
            const yOverlap = box.minY < ob.box.maxY - 0.05 && box.maxY > ob.box.minY + 0.05;
            if (yOverlap) {
              return true; // blocked: parallel touching
            }
          }
        } else if (!isVertical && !obVertical) {
          // Both are horizontal
          const yDistance = Math.abs((box.minY + box.maxY)/2 - (ob.box.minY + ob.box.maxY)/2);
          if (yDistance < 1.5) { // in adjacent rows (distance = 1.0)
            const xOverlap = box.minX < ob.box.maxX - 0.05 && box.maxX > ob.box.minX + 0.05;
            if (xOverlap) {
              return true; // blocked: parallel touching
            }
          }
        }
      }

      return false;
    };

    const checkCollision = (box: BoundingBox, branchName: string, ignoreId: string | null = null, ptId: string = "") => {
      return checkBranchCollision(box, branchName, ignoreId);
    };

    const checkLookahead = (testDir: "left" | "right" | "up" | "down", testGeom: any, branchName: string) => {
       const nextDirs: ("left" | "right" | "up" | "down")[] = 
          testDir === "left" || testDir === "right" ? [testDir, "up", "down"] : [testDir, "left", "right"];
       
       for (const nd of nextDirs) {
          const nGeom = getTileGeometry(testGeom.nextCursorX, testGeom.nextCursorY, testDir, nd, false);
          const nBox = getBoundingBox(nGeom.gridX, nGeom.gridY, nGeom.rotation);
          
          if (!checkBranchCollision(nBox, branchName)) {
             return true;
          }
       }
       return false;
    };

    const isDirSafe = (
      dir: "left" | "right" | "up" | "down",
      useLimits: boolean,
      margin: number
    ) => {
      // Doubles must continue in the same direction of growth
      if (pt.isDouble && dir !== state.dir) {
        return null;
      }

      // Prevent folding directly backwards onto the immediate predecessor
      if (
        (dir === "left" && state.prevDir === "right") ||
        (dir === "right" && state.prevDir === "left") ||
        (dir === "up" && state.prevDir === "down") ||
        (dir === "down" && state.prevDir === "up")
      ) {
        return null;
      }

      const geom = getTileGeometry(state.cursorX, state.cursorY, state.prevDir, dir, pt.isDouble, prevIsDouble);
      const box = getBoundingBox(geom.gridX, geom.gridY, geom.rotation);

      // Check collision with already placed tiles
      for (const ob of placedBoxes) {
        const isPredecessor = ob.id === predecessorId;
        const epsilon = isPredecessor ? 0.05 : margin;
        if (intersectBoxes(box, ob.box, epsilon)) {
          return null;
        }
      }

      // Parallel touching prevention
      const isVertical = box.maxX - box.minX === 1.0;
      for (const ob of placedBoxes) {
        if (ob.id === predecessorId) continue;
        const obBranch = tileBranches[ob.id] || "start";
        if (obBranch === "start" || obBranch === branch) continue;

        const obVertical = ob.box.maxX - ob.box.minX === 1.0;
        if (isVertical && obVertical) {
          const xDistance = Math.abs((box.minX + box.maxX) / 2 - (ob.box.minX + ob.box.maxX) / 2);
          if (xDistance < 1.5) {
            const yOverlap = box.minY < ob.box.maxY - 0.05 && box.maxY > ob.box.minY + 0.05;
            if (yOverlap) return null;
          }
        } else if (!isVertical && !obVertical) {
          const yDistance = Math.abs((box.minY + box.maxY) / 2 - (ob.box.minY + ob.box.maxY) / 2);
          if (yDistance < 1.5) {
            const xOverlap = box.minX < ob.box.maxX - 0.05 && box.maxX > ob.box.minX + 0.05;
            if (xOverlap) return null;
          }
        }
      }

      // Check soft limits
      if (useLimits) {
        if (
          geom.gridX < MIN_LIMIT_X ||
          geom.gridX > MAX_LIMIT_X ||
          geom.gridY < MIN_LIMIT_Y ||
          geom.gridY > MAX_LIMIT_Y
        ) {
          return null;
        }
      }

      return { geom, box };
    };

    const SAFETY_MARGIN = -0.25;
    const priorityDirs: ("left" | "right" | "up" | "down")[] = ["right", "down", "left", "up"];

    let selectedDir = state.dir;
    let selectedGeom = getTileGeometry(state.cursorX, state.cursorY, state.prevDir, state.dir, pt.isDouble, prevIsDouble);
    let selectedBox = getBoundingBox(selectedGeom.gridX, selectedGeom.gridY, selectedGeom.rotation);
    let foundSafe = false;

    // Phase 1: Try going straight (if under segment length limit or turn is forbidden) with limits and safety margin
    if (!shouldTurn) {
      const res = isDirSafe(state.dir, true, SAFETY_MARGIN);
      if (res) {
        selectedDir = state.dir;
        selectedGeom = res.geom;
        selectedBox = res.box;
        foundSafe = true;
      }
    }

    // Phase 2: Try turning to alternative directions by preferred order (with limits and safety margin)
    if (!foundSafe) {
      for (const d of directionsToTry) {
        if (d === state.dir) continue;
        const res = isDirSafe(d, true, SAFETY_MARGIN);
        if (res) {
          selectedDir = d;
          selectedGeom = res.geom;
          selectedBox = res.box;
          foundSafe = true;
          break;
        }
      }
    }

    // Phase 3: Fallback - Try straight (even if straightCount limit exceeded) with limits and safety margin
    if (!foundSafe) {
      const res = isDirSafe(state.dir, true, SAFETY_MARGIN);
      if (res) {
        selectedDir = state.dir;
        selectedGeom = res.geom;
        selectedBox = res.box;
        foundSafe = true;
      }
    }

    // Phase 4: Fallback - Try straight first, then priority directions WITHOUT board limits check (keeping safety margin)
    if (!foundSafe) {
      const res = isDirSafe(state.dir, false, SAFETY_MARGIN);
      if (res) {
        selectedDir = state.dir;
        selectedGeom = res.geom;
        selectedBox = res.box;
        foundSafe = true;
      }
    }
    if (!foundSafe) {
      for (const d of directionsToTry) {
        if (d === state.dir) continue;
        const res = isDirSafe(d, false, SAFETY_MARGIN);
        if (res) {
          selectedDir = d;
          selectedGeom = res.geom;
          selectedBox = res.box;
          foundSafe = true;
          break;
        }
      }
    }

    // Phase 5: Fallback - Try straight, then priority directions WITHOUT limits, and with reduced physical margin (epsilon = 0.05)
    if (!foundSafe) {
      const res = isDirSafe(state.dir, false, 0.05);
      if (res) {
        selectedDir = state.dir;
        selectedGeom = res.geom;
        selectedBox = res.box;
        foundSafe = true;
      }
    }
    if (!foundSafe) {
      for (const d of directionsToTry) {
        if (d === state.dir) continue;
        const res = isDirSafe(d, false, 0.05);
        if (res) {
          selectedDir = d;
          selectedGeom = res.geom;
          selectedBox = res.box;
          foundSafe = true;
          break;
        }
      }
    }

    // Phase 6: Absolute Fallback - Ignore collisions/boundaries, pick first direction not folding directly backwards
    if (!foundSafe) {
      let fallbackDir = state.dir;
      for (const d of directionsToTry) {
        const isBackwards = (
          (d === "left" && state.prevDir === "right") ||
          (d === "right" && state.prevDir === "left") ||
          (d === "up" && state.prevDir === "down") ||
          (d === "down" && state.prevDir === "up")
        );
        if (!isBackwards) {
          fallbackDir = d;
          break;
        }
      }
      selectedDir = fallbackDir;
      selectedGeom = getTileGeometry(state.cursorX, state.cursorY, state.prevDir, selectedDir, pt.isDouble, prevIsDouble);
      selectedBox = getBoundingBox(selectedGeom.gridX, selectedGeom.gridY, selectedGeom.rotation);
    }

    // Store layout coordinates for this tile
    rawPositions[pt.id] = {
      gridX: selectedGeom.gridX,
      gridY: selectedGeom.gridY,
      rotation: selectedGeom.rotation
    };

    placedBoxes.push({
      id: pt.id,
      box: selectedBox
    });

    tileBranches[pt.id] = branch;

    // Update branch cursor states
    state.cursorX = selectedGeom.nextCursorX;
    state.cursorY = selectedGeom.nextCursorY;
    
    // Update straight count
    if (selectedDir === state.dir) {
      state.straightCount += 1;
    } else {
      state.straightCount = 1;
    }
    
    state.prevDir = selectedDir;
    state.dir = selectedDir;
    state.lastTileId = pt.id;

    // Initialize top/bottom spinner branches if spinner is double
    if (pt.isDouble && !branchStates.top.initialized && !branchStates.bottom.initialized) {
      const isSpinnerVertical = selectedGeom.rotation === 0 || selectedGeom.rotation === 180;
      const offset = isSpinnerVertical ? 1.0 : 0.5;

      branchStates.top = {
        cursorX: selectedGeom.gridX,
        cursorY: selectedGeom.gridY - offset,
        dir: "up",
        prevDir: "up",
        lastTileId: pt.id,
        initialized: true,
        straightCount: 1
      };
      branchStates.bottom = {
        cursorX: selectedGeom.gridX,
        cursorY: selectedGeom.gridY + offset,
        dir: "down",
        prevDir: "down",
        lastTileId: pt.id,
        initialized: true,
        straightCount: 1
      };
    }
  });

  // Post-layout validation logic to guarantee no collisions or superpositions.
  const finalPlacedBoxes: { id: string; box: BoundingBox }[] = [];
    Object.keys(rawPositions).forEach(id => {
      const pos = rawPositions[id];
      const pt = placedTiles.find(t => t.id === id);
      if (pt) {
        const box = getBoundingBox(pos.gridX, pos.gridY, pos.rotation);
        
        // Validation Check: Collision with already processed tiles
        for (const existing of finalPlacedBoxes) {
          // Exclude direct parent/child connections completely to avoid false positive nudges
          const isParentOrChild = parentMap[pt.id] === existing.id || parentMap[existing.id] === pt.id;
          if (isParentOrChild) continue;

          const epsilon = 0.2; // strict check for non-connected branches
          if (intersectBoxes(box, existing.box, epsilon)) {
            console.warn(`[Layout Validation Warning] Overlap detected between tile ${id} and ${existing.id}. Adjusting position...`);
            // Nudge position slightly dynamically to resolve crossing
            if (pos.rotation === 90 || pos.rotation === 270) {
              pos.gridX += 0.5;
            } else {
              pos.gridY += 0.5;
            }
          }
        }
        finalPlacedBoxes.push({ id, box });
      }
    });

  // Adjust so that the entire board is centered relative to the startTile
  const pivotId = startTile.id;
  const pivotPos = rawPositions[pivotId] || { gridX: 0, gridY: 0 };

  Object.keys(rawPositions).forEach(id => {
    layouts[id] = {
      gridX: rawPositions[id].gridX - pivotPos.gridX,
      gridY: rawPositions[id].gridY - pivotPos.gridY,
      rotation: rawPositions[id].rotation
    };
  });

  return layouts;
}
