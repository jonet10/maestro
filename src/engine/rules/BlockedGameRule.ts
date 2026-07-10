import { Tile } from "../../types";
import { getHeaviestDouble, compareNonDoubleTiles, getHeaviestTile, PlayerType } from "./FirstPlayerRule";

export function sumHand(hand: Tile[]): number {
  return hand.reduce((acc, t) => acc + t[0] + t[1], 0);
}

export function resolveBlockedGame(
  userHand: Tile[],
  aiHand: Tile[]
): { winner: PlayerType; userPips: number; aiPips: number; reason: string } {
  const userPips = sumHand(userHand);
  const aiPips = sumHand(aiHand);

  if (userPips < aiPips) {
    return { winner: "user", userPips, aiPips, reason: "Moins de points restants" };
  } else if (aiPips < userPips) {
    return { winner: "ai", userPips, aiPips, reason: "Moins de points restants" };
  }

  // Égalité parfaite de points
  const userBestDouble = getHeaviestDouble(userHand);
  const aiBestDouble = getHeaviestDouble(aiHand);

  if (userBestDouble || aiBestDouble) {
    if (!aiBestDouble) return { winner: "user", userPips, aiPips, reason: "Égalité : Départage par double" };
    if (!userBestDouble) return { winner: "ai", userPips, aiPips, reason: "Égalité : Départage par double" };
    
    if (userBestDouble[0] > aiBestDouble[0]) {
      return { winner: "user", userPips, aiPips, reason: "Égalité : Départage par double" };
    } else {
      return { winner: "ai", userPips, aiPips, reason: "Égalité : Départage par double" };
    }
  }

  // Aucun double
  const userBestTile = getHeaviestTile(userHand);
  const aiBestTile = getHeaviestTile(aiHand);
  
  if (userBestTile && aiBestTile) {
    if (compareNonDoubleTiles(userBestTile, aiBestTile) > 0) {
      return { winner: "user", userPips, aiPips, reason: "Égalité : Départage par plus grand domino" };
    } else {
      return { winner: "ai", userPips, aiPips, reason: "Égalité : Départage par plus grand domino" };
    }
  }

  return { winner: "user", userPips, aiPips, reason: "Fallback" };
}
