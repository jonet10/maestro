import { EngineGameState, PlayerId } from './types';
import { generateTileSet, shuffleTiles } from './tileUtils';
import { getRequiredOpeningTile } from './dominoRules';
import { isMatchComplete } from './scoreManager';

const pickRoundOpener = (
  state: EngineGameState,
  lastRoundWinnerId: PlayerId | null,
  p1Hand: ReturnType<typeof generateTileSet>,
  p2Hand: ReturnType<typeof generateTileSet>,
): PlayerId => {
  if (lastRoundWinnerId && lastRoundWinnerId !== 'tie') {
    return lastRoundWinnerId;
  }

  const p1Open = getRequiredOpeningTile(p1Hand);
  const p2Open = getRequiredOpeningTile(p2Hand);
  if (!p1Open || !p2Open) return state.player1_id;

  const p1Double = p1Open[0] === p1Open[1] ? p1Open[0] : -1;
  const p2Double = p2Open[0] === p2Open[1] ? p2Open[0] : -1;
  if (p1Double !== p2Double) {
    return p1Double > p2Double ? state.player1_id : state.player2_id;
  }

  const p1Val = p1Open[0] + p1Open[1];
  const p2Val = p2Open[0] + p2Open[1];
  if (p1Val !== p2Val) {
    return p1Val > p2Val ? state.player1_id : state.player2_id;
  }

  return state.player1_id;
};

/**
 * Prépare la manche suivante : nouvelle distribution, scores cumulés conservés.
 */
export function startNextRound(
  state: EngineGameState,
  lastRoundWinnerId: PlayerId | 'tie' | null,
  seed?: number,
): EngineGameState {
  const deck = shuffleTiles(generateTileSet(), seed);
  const p1Hand = deck.slice(0, 7);
  const p2Hand = deck.slice(7, 14);
  const boneyard = deck.slice(14);

  const winnerId = lastRoundWinnerId === 'tie' ? null : lastRoundWinnerId;
  const opener = pickRoundOpener(state, winnerId, p1Hand, p2Hand);

  return {
    ...state,
    board_state: [],
    player1_hand: p1Hand,
    player2_hand: p2Hand,
    boneyard,
    current_turn: opener,
    round_number: state.round_number + 1,
    last_player_id: null,
    consecutive_passes: 0,
    match_status: 'in_progress',
    last_action_timestamp: Date.now(),
  };
}

export function applyRoundPoints(
  state: EngineGameState,
  winnerId: PlayerId | 'tie',
  points: number,
): EngineGameState {
  const next = { ...state };
  if (winnerId === state.player1_id) next.player1_score += points;
  else if (winnerId === state.player2_id) next.player2_score += points;
  return next;
}

/**
 * Termine une manche : cumule les points, enchaîne ou clôt le match.
 */
export function finalizeRound(
  state: EngineGameState,
  winnerId: PlayerId | 'tie',
  points: number,
  seed?: number,
): EngineGameState {
  const withPoints = applyRoundPoints(state, winnerId, points);
  if (isMatchComplete(withPoints)) {
    return { ...withPoints, match_status: 'completed' };
  }
  return startNextRound(withPoints, winnerId, seed);
}
