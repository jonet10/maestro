import { EngineGameState, EngineAction, BoardTile, Tile } from './types';
import { canPlayTile, validateDraw, validatePass, getBoardEndpoints } from './moveValidator';
import { calculateFivesScore } from './scoring';
import { orientTileForSide } from './dominoEngine';
import { getRequiredOpeningTile } from './dominoRules';
import { areTilesEqual, tileValue } from './tileUtils';

type PlaySide = 'left' | 'right' | 'up' | 'down' | 'first';

interface EvaluatedMove {
  tile: Tile;
  side: PlaySide;
  fivesScore: number;
  pipValue: number;
  isDouble: boolean;
  keepsOptions: number;
  isBalanced: boolean;
}

const simulateFivesScore = (state: EngineGameState, tile: Tile, side: PlaySide): number => {
  if (side === 'first') {
    const isDouble = tile[0] === tile[1];
    const boardTile: BoardTile = { tile, side: 'first', orientedTile: tile, isDouble, isSpinner: isDouble };
    return calculateFivesScore([boardTile]);
  }

  const orientedTile = orientTileForSide(state, tile, side as any);
  const isDouble = tile[0] === tile[1];
  const hasSpinnerAlready = state.board_state.some((bt) => bt.isSpinner);
  const isSpinner = isDouble && !hasSpinnerAlready && state.board_state.length > 0;

  const boardTile: BoardTile = {
    tile,
    orientedTile,
    side: side as any,
    isDouble,
    isSpinner,
  };

  let simulatedBoard = [...state.board_state];
  if (side === 'left') {
    simulatedBoard = [boardTile, ...simulatedBoard];
  } else {
    simulatedBoard = [...simulatedBoard, boardTile];
  }

  return calculateFivesScore(simulatedBoard);
};

const getHandCounts = (hand: Tile[]): Map<number, number> => {
  const counts = new Map<number, number>();
  for (const [a, b] of hand) {
    counts.set(a, (counts.get(a) ?? 0) + 1);
    counts.set(b, (counts.get(b) ?? 0) + 1);
  }
  return counts;
};

const calcBranchBalance = (tile: Tile, side: PlaySide, endpoints: { left: number; right: number; up: number | null; down: number | null } | null): boolean => {
  if (!endpoints) return true;
  const a = tile[0];
  if (side === 'left' && endpoints.right !== undefined) {
    return Math.abs(a - endpoints.right) <= 3;
  }
  if (side === 'right' && endpoints.left !== undefined) {
    return Math.abs(a - endpoints.left) <= 3;
  }
  return true;
};

export const getBotAction = (state: EngineGameState): EngineAction => {
  const playerId = state.current_turn;
  const hand = playerId === state.player1_id ? state.player1_hand : state.player2_hand;
  const timestamp = Date.now();
  const mode = state.game_mode ?? 'fives';

  const endpoints = getBoardEndpoints(state.board_state);
  const handCounts = getHandCounts(hand);

  const possibleMoves: EvaluatedMove[] = [];

  for (const tile of hand) {
    if (state.board_state.length === 0) {
      const required = getRequiredOpeningTile(hand);
      if (!required || !areTilesEqual(tile, required)) continue;
      const isDouble = tile[0] === tile[1];
      possibleMoves.push({
        tile,
        side: 'first',
        fivesScore: simulateFivesScore(state, tile, 'first'),
        pipValue: tileValue(tile),
        isDouble,
        keepsOptions: (handCounts.get(tile[0]) ?? 0) + (handCounts.get(tile[1]) ?? 0),
        isBalanced: true,
      });
      continue;
    }

    const playability = canPlayTile(state.board_state, tile);
    const validSides: PlaySide[] = [];
    if (playability.left) validSides.push('left');
    if (playability.right) validSides.push('right');
    if (playability.up) validSides.push('up');
    if (playability.down) validSides.push('down');

    for (const side of validSides) {
  const [a, b] = tile;
      const valueToPlay = side === 'left' ? b : side === 'right' ? a : a;
      const matchingHandCount = handCounts.get(valueToPlay) ?? 0;

      possibleMoves.push({
        tile,
        side,
        fivesScore: simulateFivesScore(state, tile, side),
        pipValue: tileValue(tile),
        isDouble: tile[0] === tile[1],
        keepsOptions: matchingHandCount,
        isBalanced: calcBranchBalance(tile, side, endpoints),
      });
    }
  }

  if (possibleMoves.length > 0) {
    possibleMoves.sort((a, b) => {
      // Priority 1: Fives score (only in fives mode)
      if (mode === 'fives' && b.fivesScore !== a.fivesScore) return b.fivesScore - a.fivesScore;

      // Priority 2: Keep options open — prefer tiles that match numbers we have many of
      if (b.keepsOptions !== a.keepsOptions) return b.keepsOptions - a.keepsOptions;

      // Priority 3: Balanced branches — keep board symmetrical
      if (b.isBalanced !== a.isBalanced) return b.isBalanced ? 1 : -1;

      // Priority 4: Play doubles first
      if (b.isDouble !== a.isDouble) return b.isDouble ? 1 : -1;

      // Priority 5: Play highest pip value
      return b.pipValue - a.pipValue;
    });

    const bestMove = possibleMoves[0];
    return { type: 'PLAY', playerId, payload: { tile: bestMove.tile, side: bestMove.side as any }, timestamp };
  }

  if (validateDraw(state, playerId)) {
    return { type: 'DRAW', playerId, timestamp };
  }

  if (validatePass(state, playerId)) {
    return { type: 'PASS', playerId, timestamp };
  }

  return { type: 'TIMEOUT', playerId, timestamp };
};
