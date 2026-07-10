/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import { Tile, PlacedTile, GameMode, Difficulty } from "../types";
import { getOpenEnds2D, evaluatePlayability2D, getPlayedTileRotation2D } from "./dominoLogic";
import { calculateBoardScore, calculateMultipleOfFive } from "./scoreEngine";

export interface PlayOption {
  tile: Tile;
  side: "left" | "right" | "top" | "bottom";
}

/**
 * Calculates the best strategic play options for a given hand and board state
 * using the project's existing Tactical AI algorithm.
 * 
 * @returns The best PlayOption, or null if no tiles in hand are playable.
 */
export function getBestMoveForHand(
  hand: Tile[],
  placedTiles: PlacedTile[],
  gameMode: GameMode,
  difficulty: Difficulty
): { tile: Tile; side: "left" | "right" | "top" | "bottom" | "start" } | null {
  const ends2D = getOpenEnds2D(placedTiles);
  const playableOptions: PlayOption[] = [];

  // Find all playable cards in hand across all active 2D ends
  hand.forEach(tile => {
    if (placedTiles.length === 0) {
      playableOptions.push({ tile, side: "left" }); // Opening first card
    } else {
      const playability = evaluatePlayability2D(tile, ends2D);
      if (playability.left) playableOptions.push({ tile, side: "left" });
      if (playability.right) playableOptions.push({ tile, side: "right" });
      if (playability.top) playableOptions.push({ tile, side: "top" });
      if (playability.bottom) playableOptions.push({ tile, side: "bottom" });
    }
  });

  if (playableOptions.length === 0) {
    return null;
  }

  // SELECT THE BEST STRATEGIC PLAY
  let selectedOption = playableOptions[0];

  if (difficulty === "easy") {
    // Random pick
    selectedOption = playableOptions[Math.floor(Math.random() * playableOptions.length)];
  } else {
    // Medium & Hard Tactical AI Selector with 2D Board Simulation
    let highestStrategicWeight = -1000;

    playableOptions.forEach(opt => {
      let strategyWeight = 0;
      const { tile, side } = opt;
      const isDouble = tile[0] === tile[1];
      const totalPips = tile[0] + tile[1];

      // 1. All-Fives Scoring Priority
      if (gameMode === "all-fives") {
        const tempPlaced: PlacedTile = {
          id: "temp",
          tile,
          connectedAs: getPlayedTileRotation2D(tile, side, ends2D),
          isDouble,
          playedAt: side,
        };
        const tempBoard = [...placedTiles, tempPlaced];
        const sum = calculateBoardScore(tempBoard);
        const points = calculateMultipleOfFive(sum);
        if (points > 0) {
          strategyWeight += points * 10; // Mega weights for heavy scores!
        }
      }

      // 2. Lighten heavy cards (General strategy is to dump heavy doubles, so we don't carry their pips)
      if (isDouble) {
        strategyWeight += 15 + totalPips; // Prefer doubles strongly, heavier is better
      } else {
        strategyWeight += totalPips; // Prefer heavier pips to leave less if blocked
      }

      // 3. For Hard difficulty, add blockade metrics
      if (difficulty === "hard") {
        const rot = getPlayedTileRotation2D(tile, side, ends2D);
        const exposedValue = rot[1]; // Rotated tiles connectedAs is [inner, outer]. Exposed is outer.
        
        // Check remaining counts for this pip in current player's hand.
        const countsInHand = hand.filter(t => t[0] === exposedValue || t[1] === exposedValue).length;
        strategyWeight += countsInHand * 8; // Multi-match safety bonus
      }

      if (strategyWeight > highestStrategicWeight) {
        highestStrategicWeight = strategyWeight;
        selectedOption = opt;
      }
    });
  }

  const playSide = (placedTiles.length === 0) ? "start" : selectedOption.side;
  return {
    tile: selectedOption.tile,
    side: playSide,
  };
}
