import { Tile } from "../../types";

export type PlayerType = "user" | "ai";

export function getHeaviestDouble(hand: Tile[]): Tile | null {
  let bestDouble: Tile | null = null;
  for (const t of hand) {
    if (t[0] === t[1]) {
      if (!bestDouble || t[0] > bestDouble[0]) {
        bestDouble = t;
      }
    }
  }
  return bestDouble;
}

export function compareNonDoubleTiles(t1: Tile, t2: Tile): number {
  const sum1 = t1[0] + t1[1];
  const sum2 = t2[0] + t2[1];
  if (sum1 !== sum2) return sum1 - sum2;

  const max1 = Math.max(t1[0], t1[1]);
  const min1 = Math.min(t1[0], t1[1]);
  
  const max2 = Math.max(t2[0], t2[1]);
  const min2 = Math.min(t2[0], t2[1]);

  if (max1 !== max2) return max1 - max2;
  return min1 - min2;
}

export function getHeaviestTile(hand: Tile[]): Tile | null {
  if (hand.length === 0) return null;
  let best = hand[0];
  for (let i = 1; i < hand.length; i++) {
    if (compareNonDoubleTiles(hand[i], best) > 0) {
      best = hand[i];
    }
  }
  return best;
}

export function determineFirstPlayer(
  userHand: Tile[],
  aiHand: Tile[],
  prevWinner: PlayerType | null
): { starter: PlayerType; reason: string; tile: Tile | null } {
  // Règle : Le plus grand double détermine toujours qui commence la manche
  // (à chaque manche, après redistribution des dominos)
  const userBestDouble = getHeaviestDouble(userHand);
  const aiBestDouble = getHeaviestDouble(aiHand);

  if (userBestDouble || aiBestDouble) {
    if (!aiBestDouble) return { starter: "user", reason: "Plus grand double", tile: userBestDouble };
    if (!userBestDouble) return { starter: "ai", reason: "Plus grand double", tile: aiBestDouble };
    
    if (userBestDouble[0] > aiBestDouble[0]) {
      return { starter: "user", reason: "Plus grand double", tile: userBestDouble };
    } else {
      return { starter: "ai", reason: "Plus grand double", tile: aiBestDouble };
    }
  }

  // Aucun double : comparaison de tous les dominos
  const userBestTile = getHeaviestTile(userHand);
  const aiBestTile = getHeaviestTile(aiHand);

  if (userBestTile && aiBestTile) {
    if (compareNonDoubleTiles(userBestTile, aiBestTile) >= 0) {
      return { starter: "user", reason: "Plus grand domino", tile: userBestTile };
    } else {
      return { starter: "ai", reason: "Plus grand domino", tile: aiBestTile };
    }
  }

  return { starter: "user", reason: "Fallback", tile: null };
}
