/**
 * Façade publique du moteur Maestro Domino.
 * Point d'entrée unique pour init, dispatch et helpers de match.
 */
export { dominoEngine, orientTileForSide } from './dominoEngine';
export { initializeGame } from './gameInitializer';
export { getAIAction, getAIThinkDelay } from './aiPlayer';
export type { AIDifficulty, AIPlayerConfig } from './aiPlayer';
export { finalizeRound, startNextRound, applyRoundPoints } from './matchManager';
export { isMatchComplete, getMatchWinnerId, getMatchScores } from './scoreManager';
export {
  getTargetScore,
  getRequiredOpeningTile,
  isValidOpeningTile,
  TARGET_SCORES,
  TILES_PER_PLAYER,
} from './dominoRules';
export {
  validatePlay,
  validateDraw,
  validatePass,
  canPlayTile,
  hasPlayableTile,
  getBoardEndpoints,
} from './moveValidator';
export type { EngineGameState, EngineAction, GameMode, Tile, BoardTile } from './types';

import { dominoEngine } from './dominoEngine';
import { EngineAction, EngineGameState } from './types';

export function dispatchAction(state: EngineGameState, action: EngineAction): EngineGameState {
  return dominoEngine(state, action);
}
