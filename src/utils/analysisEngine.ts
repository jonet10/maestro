/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

import { Tile, PlacedTile, PipCount, TileAnalysis, GeneralAnalysis } from "../types";
import { 
  getOpenEnds2D, 
  evaluatePlayability2D, 
  getPlayedTileRotation2D, 
  calculateAllFivesSum2D 
} from "./dominoLogic";

/**
 * Run comprehensive game analysis on the user's current hand and board state (2D adaptive branching version).
 */
export function analyzeGameState(
  userHand: Tile[],
  placedTiles: PlacedTile[],
  boneyardCount: number,
  mode: "draw" | "block" | "all-fives",
  openingForcedTile?: Tile | null
): GeneralAnalysis {
  const activeEnds = getOpenEnds2D(placedTiles);
  const openLeft = activeEnds.left;
  const openRight = activeEnds.right;

  // 1. Calculate Pip Statistics
  const pipStats: PipCount[] = [];
  for (let p = 0; p <= 6; p++) {
    // Count how many tiles containing pip 'p' are played
    let played = 0;
    placedTiles.forEach(pt => {
      if (pt.tile[0] === p || pt.tile[1] === p) {
        played++;
      }
    });

    // Count how many in user's hand
    let inHand = 0;
    userHand.forEach(t => {
      if (t[0] === p || t[1] === p) {
        inHand++;
      }
    });

    // Total possible unique tiles with this pip is 7 (0-p to 6-p)
    const total = 7;
    const unknown = Math.max(0, total - played - inHand);

    pipStats.push({
      pip: p,
      total,
      played,
      inHand,
      unknown
    });
  }

  // 2. Estimate Opponent Pip Strengths
  const estimatedOpponentStrengths: { [key: number]: number } = {};
  for (let p = 0; p <= 6; p++) {
    const stat = pipStats[p];
    if (stat.unknown === 0) {
      estimatedOpponentStrengths[p] = 0; // 0% chance opponent has this pip
    } else {
      const totalUnknownTiles = 28 - placedTiles.length - userHand.length;
      if (totalUnknownTiles > 0) {
        const pNotInHand = 1 - (stat.unknown / totalUnknownTiles);
        estimatedOpponentStrengths[p] = Math.round(Math.max(5, Math.min(95, (1 - Math.pow(pNotInHand, 7)) * 100)));
      } else {
        estimatedOpponentStrengths[p] = 0;
      }
    }
  }

  // Identify dominant pips on the board (already played 4 or more times)
  const dominantPips = pipStats
    .filter(stat => stat.played >= 4)
    .map(stat => stat.pip);

  // 3. Analyze each tile in Hand
  let handFlexibilitySum = 0;
  const recommendations: TileAnalysis[] = userHand.map(tile => {
    // Empty board playability
    if (placedTiles.length === 0) {
      const isDouble = tile[0] === tile[1];
      const sum = tile[0] + tile[1];
      const maxScorePotential = mode === "all-fives" ? (sum % 5 === 0 ? sum : 0) : sum;

      // If there's a forced opening tile, only that tile is playable
      if (openingForcedTile !== null && openingForcedTile !== undefined) {
        const isForced = tile[0] === openingForcedTile[0] && tile[1] === openingForcedTile[1];
        return {
          tile,
          isPlayable: isForced,
          scorePotential: isForced ? maxScorePotential : 0,
          blockingIndex: 50,
          safetyScore: isForced ? 100 : 0,
          playRecommendation: isForced ? "best" : "risky",
          playDescription: isForced
            ? `Opening double! You must play this tile first (heaviest double rule).`
            : `Locked — you must play [${openingForcedTile[0]}|${openingForcedTile[1]}] first.`
        };
      }

      return {
        tile,
        isPlayable: true,
        scorePotential: maxScorePotential,
        blockingIndex: 50,
        safetyScore: 85,
        playRecommendation: isDouble ? "best" : "good",
        playDescription: `Opening tile. Play this ${isDouble ? "double" : "heavy tile"} to start your branches with ${sum} pips.`
      };
    }

    const playability = evaluatePlayability2D(tile, activeEnds);
    const isPlayable = playability.left || playability.right || playability.top || playability.bottom;

    if (!isPlayable) {
      return {
        tile,
        isPlayable: false,
        scorePotential: 0,
        blockingIndex: 0,
        safetyScore: 0,
        playRecommendation: "unplayable",
        playDescription: "This tile does not match any open branch of the board (Left, Right, Top, or Bottom)."
      };
    }

    // Evaluate scoring potentials on all directions
    let maxScorePotential = 0;
    let bestSide: "left" | "right" | "top" | "bottom" | "either" = "either";
    
    const sides: ("left" | "right" | "top" | "bottom")[] = ["left", "right", "top", "bottom"];
    const playBranches = sides.filter(s => playability[s]);

    playBranches.forEach(side => {
      const rotation = getPlayedTileRotation2D(tile, side, activeEnds);
      const simulatedPlaced: PlacedTile = {
        id: `sim-${side}`,
        tile,
        connectedAs: rotation,
        isDouble: tile[0] === tile[1],
        playedAt: side
      };
      const simulatedBoard = [...placedTiles, simulatedPlaced];
      
      let score = 0;
      if (mode === "all-fives") {
        const sum = calculateAllFivesSum2D(simulatedBoard);
        score = sum % 5 === 0 ? sum : 0;
      } else {
        score = tile[0] + tile[1];
      }

      if (score > maxScorePotential) {
        maxScorePotential = score;
        bestSide = side;
      } else if (score === maxScorePotential && bestSide !== "either") {
        bestSide = "either";
      }
    });

    if (bestSide === "either" && playBranches.length > 0) {
      bestSide = playBranches[0];
    }

    // Safety score: Check our remainders flexibility
    let safetyScore = 50;
    const resolvedSide = bestSide === "either" ? playBranches[0] : bestSide;
    const simulatedPlaced: PlacedTile = {
      id: "temp-safety",
      tile,
      connectedAs: getPlayedTileRotation2D(tile, resolvedSide, activeEnds),
      isDouble: tile[0] === tile[1],
      playedAt: resolvedSide
    };

    const simulatedBoard = [...placedTiles, simulatedPlaced];
    const nextEnds = getOpenEnds2D(simulatedBoard);
    
    const otherTilesInHand = userHand.filter(t => t !== tile);
    const futureMatches = otherTilesInHand.filter(t => 
      t[0] === nextEnds.left || t[1] === nextEnds.left || 
      t[0] === nextEnds.right || t[1] === nextEnds.right ||
      (nextEnds.top !== null && (t[0] === nextEnds.top || t[1] === nextEnds.top)) ||
      (nextEnds.bottom !== null && (t[0] === nextEnds.bottom || t[1] === nextEnds.bottom))
    ).length;

    safetyScore = Math.min(100, Math.max(10, 30 + futureMatches * 18));
    handFlexibilitySum += safetyScore;

    // Blocking Index
    let blockingIndex = 50;
    const exposedEndValue = simulatedPlaced.connectedAs[1]; // Exposed outer value
    if (exposedEndValue !== undefined) {
      const unknownForExposed = pipStats[exposedEndValue]?.unknown ?? 3;
      if (unknownForExposed <= 1) {
        blockingIndex = 90; // High probability of opponent passing/drawing
      } else if (unknownForExposed >= 5) {
        blockingIndex = 30; // Very open
      }
    }

    // Recommendation category
    let playRecommendation: "best" | "good" | "neutral" | "risky" = "neutral";
    let playDescription = "";

    const isDouble = tile[0] === tile[1];
    const totalPips = tile[0] + tile[1];

    if (mode === "all-fives" && maxScorePotential > 0) {
      playRecommendation = maxScorePotential >= 10 ? "best" : "good";
      playDescription = `Scores ${maxScorePotential} Fives points on the ${resolvedSide}! Excellent scoring opportunity.`;
    } else if (isDouble && totalPips >= 10) {
      playRecommendation = "good";
      playDescription = `Lighten heavy hand by dumping double [${tile[0]}|${tile[1]}] on the ${resolvedSide}.`;
    } else if (safetyScore >= 70) {
      playRecommendation = "good";
      playDescription = `Safe move on ${resolvedSide} keeping active branches open for your remaining hand.`;
    } else if (safetyScore <= 30) {
      playRecommendation = "risky";
      playDescription = `Risky move on ${resolvedSide}. Leaving your hand without matching replies.`;
    } else if (blockingIndex >= 85) {
      playRecommendation = "good";
      playDescription = `Tactical layout! Connecting on ${resolvedSide} squeezes opponent with dry ends.`;
    } else {
      playRecommendation = "neutral";
      playDescription = `Standard move on the ${resolvedSide} branch. Keeps match flow steady.`;
    }

    return {
      tile,
      isPlayable: true,
      scorePotential: maxScorePotential,
      blockingIndex,
      safetyScore,
      playRecommendation,
      playDescription
    };
  });

  const playableCount = recommendations.filter(r => r.isPlayable).length;
  const handSafetyAverage = userHand.length > 0 
    ? Math.round(handFlexibilitySum / Math.max(1, playableCount)) 
    : 100;

  return {
    openLeft,
    openRight,
    playedCount: placedTiles.length,
    boneyardCount,
    pipStats,
    recommendations,
    estimatedOpponentStrengths,
    dominantPips,
    handSafetyAverage
  };
}
