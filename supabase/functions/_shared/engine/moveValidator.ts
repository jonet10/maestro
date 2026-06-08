import { BoardTile, EngineGameState, Tile } from './types.ts';
import { hasTile } from './tileUtils.ts';

const getOriented = (bt: BoardTile): Tile => bt.orientedTile ?? bt.tile;

export interface BoardEndpoints {
  left: number;
  right: number;
  up: number | null;
  down: number | null;
}

const findSpinner = (board: BoardTile[]): BoardTile | null =>
  board.find((bt) => bt.isSpinner) ?? null;

export const getBoardEndpoints = (board: BoardTile[]): BoardEndpoints | null => {
  if (board.length === 0) return null;

  const mainChain = board.filter((bt) => bt.side !== 'up' && bt.side !== 'down');
  const first = getOriented(mainChain[0]);
  const last = getOriented(mainChain[mainChain.length - 1]);

  const spinner = findSpinner(board);
  let upVal: number | null = null;
  let downVal: number | null = null;

  if (spinner) {
    const spinnerVal = spinner.tile[0];
    const hasUp = board.some((bt) => bt.side === 'up');
    const hasDown = board.some((bt) => bt.side === 'down');

    if (hasUp) {
      const upChain = board.filter((bt) => bt.side === 'up');
      const lastUp = getOriented(upChain[upChain.length - 1]);
      upVal = lastUp[0];
    } else {
      upVal = spinnerVal;
    }

    if (hasDown) {
      const downChain = board.filter((bt) => bt.side === 'down');
      const lastDown = getOriented(downChain[downChain.length - 1]);
      downVal = lastDown[0];
    } else {
      downVal = spinnerVal;
    }
  }

  return {
    left: first[0],
    right: last[1],
    up: upVal,
    down: downVal,
  };
};

export const canPlayTile = (
  board: BoardTile[],
  tile: Tile
): { left: boolean; right: boolean; up: boolean; down: boolean } => {
  const endpoints = getBoardEndpoints(board);
  if (!endpoints) {
    return { left: true, right: true, up: false, down: false };
  }

  const [t1, t2] = tile;
  return {
    left: t1 === endpoints.left || t2 === endpoints.left,
    right: t1 === endpoints.right || t2 === endpoints.right,
    up: endpoints.up !== null && (t1 === endpoints.up || t2 === endpoints.up),
    down: endpoints.down !== null && (t1 === endpoints.down || t2 === endpoints.down),
  };
};

export const hasPlayableTile = (board: BoardTile[], hand: Tile[]): boolean => {
  return hand.some((tile) => {
    const playability = canPlayTile(board, tile);
    return playability.left || playability.right || playability.up || playability.down;
  });
};

export const validatePlay = (
  state: EngineGameState,
  playerId: string,
  tile: Tile,
  side: 'left' | 'right' | 'first' | 'up' | 'down'
): boolean => {
  if (state.current_turn !== playerId) return false;

  const hand = playerId === state.player1_id ? state.player1_hand : state.player2_hand;
  if (!hasTile(hand, tile)) return false;

  if (state.board_state.length === 0 && side === 'first') return true;

  const playability = canPlayTile(state.board_state, tile);
  if (side === 'left' && !playability.left) return false;
  if (side === 'right' && !playability.right) return false;
  if (side === 'up' && !playability.up) return false;
  if (side === 'down' && !playability.down) return false;

  return true;
};

export const validateDraw = (state: EngineGameState, playerId: string): boolean => {
  if (state.current_turn !== playerId) return false;
  const mode = state.game_mode ?? 'fives';
  if (mode === 'block') return false;
  if (state.boneyard.length === 0) return false;

  const hand = playerId === state.player1_id ? state.player1_hand : state.player2_hand;

  if (hasPlayableTile(state.board_state, hand)) return false;

  return true;
};

export const validatePass = (state: EngineGameState, playerId: string): boolean => {
  if (state.current_turn !== playerId) return false;

  const hand = playerId === state.player1_id ? state.player1_hand : state.player2_hand;

  if (hasPlayableTile(state.board_state, hand)) return false;
  const mode = state.game_mode ?? 'fives';
  if (mode !== 'block' && state.boneyard.length > 0) return false;

  return true;
};
