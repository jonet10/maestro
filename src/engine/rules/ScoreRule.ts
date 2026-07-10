import { PlacedTile } from "../../types";
import * as ScoreEngine from "../../utils/scoreEngine";

/**
 * Règle de calcul du score.
 * Séparée de l'interface graphique pour permettre un calcul unitaire testable.
 */
export function calculateRoundScore(
  board: PlacedTile[],
  gameMode: string
): { sum: number; pointsWon: number } {
  if (gameMode !== "all-fives") {
    return { sum: 0, pointsWon: 0 };
  }

  const sum = ScoreEngine.calculateBoardScore(board);
  const pointsWon = ScoreEngine.calculateMultipleOfFive(sum);

  return { sum, pointsWon };
}
