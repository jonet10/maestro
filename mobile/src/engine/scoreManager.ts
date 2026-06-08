/**
 * Façade scoring — réexporte la logique existante avec une API stable.
 */
export {
  calculateHandValue,
  calculateRoundScore,
  calculateFivesScore,
  calculateFivesRoundEndScore,
  calculateCapotScore,
  calculateBlockEndScore,
  checkBlockWinner,
  isCapot,
} from './scoring';

import { EngineGameState } from './types';
import { getTargetScore } from './dominoRules';

export function getMatchScores(state: EngineGameState): { player1: number; player2: number } {
  return { player1: state.player1_score, player2: state.player2_score };
}

export function isMatchComplete(state: EngineGameState): boolean {
  const target = state.target_score ?? getTargetScore(state.game_mode);
  return state.player1_score >= target || state.player2_score >= target;
}

export function getMatchWinnerId(state: EngineGameState): string | null {
  if (!isMatchComplete(state)) return null;
  if (state.player1_score > state.player2_score) return state.player1_id;
  if (state.player2_score > state.player1_score) return state.player2_id;
  return null;
}
