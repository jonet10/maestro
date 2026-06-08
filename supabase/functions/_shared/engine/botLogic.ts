import { EngineGameState, EngineAction } from './types.ts';
import { canPlayTile, validateDraw, validatePass } from './moveValidator.ts';

export const getBotAction = (state: EngineGameState): EngineAction => {
  const playerId = state.current_turn;
  const hand = playerId === state.player1_id ? state.player1_hand : state.player2_hand;
  const timestamp = Date.now();

  // 1. Try to play the first valid tile
  for (const tile of hand) {
    if (state.board_state.length === 0) {
      // Board is empty — use 'right' as the starting side; engine handles the first-tile case
      return { type: 'PLAY', playerId, payload: { tile, side: 'right' }, timestamp };
    }

    const playability = canPlayTile(state.board_state, tile);
    if (playability.left) {
      return { type: 'PLAY', playerId, payload: { tile, side: 'left' }, timestamp };
    }
    if (playability.right) {
      return { type: 'PLAY', playerId, payload: { tile, side: 'right' }, timestamp };
    }
  }

  // 2. Try to draw one tile from boneyard
  if (validateDraw(state, playerId)) {
    return { type: 'DRAW', playerId, timestamp };
  }

  // 3. Pass (boneyard empty, no valid move)
  if (validatePass(state, playerId)) {
    return { type: 'PASS', playerId, timestamp };
  }

  // Fallback — should theoretically never reach here
  return { type: 'TIMEOUT', playerId, timestamp };
};
