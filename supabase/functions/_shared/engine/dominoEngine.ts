import { EngineGameState, EngineAction } from './types.ts';
import { hasPlayableTile, validatePlay, validateDraw, validatePass } from './moveValidator.ts';
import { removeTile } from './tileUtils.ts';
import { calculateRoundScore, calculateFivesRoundEndScore, calculateFivesScore, checkBlockWinner } from './scoring.ts';

const switchTurn = (state: EngineGameState): string => {
  return state.current_turn === state.player1_id ? state.player2_id : state.player1_id;
};

const handleRoundEnd = (state: EngineGameState, winnerId: string | 'tie', points: number): EngineGameState => {
  const newState = { ...state, match_status: 'completed' as const };
  if (winnerId === state.player1_id) {
    newState.player1_score += points;
  } else if (winnerId === state.player2_id) {
    newState.player2_score += points;
  }
  
  const targetScore = state.target_score ?? (state.game_mode === 'fives' ? 150 : 250);
  if (newState.player1_score >= targetScore || newState.player2_score >= targetScore) {
    newState.match_status = 'completed';
  }
  return newState;
};

const orientTileForSide = (
  state: EngineGameState,
  tile: [number, number],
  side: 'left' | 'right' | 'up' | 'down'
): [number, number] => {
  if (state.board_state.length === 0) return tile;

  // For spinner branches (up/down), match against the spinner's value
  if (side === 'up' || side === 'down') {
    const spinner = state.board_state.find((bt) => bt.isSpinner);
    if (spinner) {
      const spinnerVal = spinner.tile[0];
      const [a, b] = tile;
      return b === spinnerVal ? [a, b] : [b, a];
    }
  }

  const first = state.board_state[0].orientedTile ?? state.board_state[0].tile;
  const last = state.board_state[state.board_state.length - 1].orientedTile ?? state.board_state[state.board_state.length - 1].tile;
  const leftEnd = first[0];
  const rightEnd = last[1];
  const [a, b] = tile;

  if (side === 'left') return b === leftEnd ? [a, b] : [b, a];
  return a === rightEnd ? [a, b] : [b, a];
};

export const dominoEngine = (state: EngineGameState, action: EngineAction): EngineGameState => {
  const newState = { ...state, last_action_timestamp: action.timestamp };
  const isP1 = action.playerId === state.player1_id;
  const mode = state.game_mode ?? 'fives';

  if (state.match_status === 'completed' || state.match_status === 'cancelled') {
    return state;
  }

  switch (action.type) {
    case 'PLAY': {
      if (!action.payload?.tile || !action.payload.side) return state;
      if (!validatePlay(state, action.playerId, action.payload.tile, action.payload.side as any)) return state;

      if (isP1) {
        newState.player1_hand = removeTile(state.player1_hand, action.payload.tile);
      } else {
        newState.player2_hand = removeTile(state.player2_hand, action.payload.tile);
      }

      const side = action.payload.side as 'left' | 'right' | 'up' | 'down' | 'first';
      const orientedTile = side === 'first'
        ? action.payload.tile
        : orientTileForSide(state, action.payload.tile, side as any);

      const tileIsDouble = action.payload.tile[0] === action.payload.tile[1];
      const hasSpinnerAlready = state.board_state.some((bt) => bt.isSpinner);
      const isSpinner = tileIsDouble && !hasSpinnerAlready && state.board_state.length > 0;

      const boardTile = {
        tile: action.payload.tile,
        orientedTile,
        side: side as any,
        isDouble: tileIsDouble,
        isSpinner,
      };

      if (side === 'left') {
        newState.board_state = [boardTile, ...state.board_state];
      } else if (side === 'right') {
        newState.board_state = [...state.board_state, boardTile];
      } else if (side === 'up' || side === 'down') {
        newState.board_state = [...state.board_state, boardTile];
      } else {
        newState.board_state = [boardTile];
      }

      newState.consecutive_passes = 0;
      newState.last_player_id = action.playerId;

      if (mode === 'fives') {
        const fivesPoints = calculateFivesScore(newState.board_state);
        if (fivesPoints > 0) {
          if (isP1) newState.player1_score += fivesPoints;
          else newState.player2_score += fivesPoints;
        }
      }

      if (newState.player1_hand.length === 0 || newState.player2_hand.length === 0) {
        const winnerId = newState.player1_hand.length === 0 ? state.player1_id : state.player2_id;
        const pts = mode === 'fives'
          ? calculateFivesRoundEndScore([winnerId === state.player1_id ? newState.player2_hand : newState.player1_hand])
          : calculateRoundScore([], winnerId === state.player1_id ? newState.player2_hand : newState.player1_hand);
        return handleRoundEnd(newState, winnerId, pts);
      }

      newState.current_turn = switchTurn(state);
      return newState;
    }

    case 'DRAW': {
      if (!validateDraw(state, action.playerId)) return state;

      let nextBoneyard = [...state.boneyard];
      let nextHand = isP1 ? [...state.player1_hand] : [...state.player2_hand];
      while (nextBoneyard.length > 0 && !hasPlayableTile(state.board_state, nextHand)) {
        const drawnTile = nextBoneyard.shift();
        if (!drawnTile) break;
        nextHand.push(drawnTile);
      }

      if (isP1) {
        newState.player1_hand = nextHand;
      } else {
        newState.player2_hand = nextHand;
      }
      newState.boneyard = nextBoneyard;

      newState.consecutive_passes = 0;

      if (!hasPlayableTile(state.board_state, nextHand) && nextBoneyard.length === 0) {
        newState.current_turn = switchTurn(state);
      }

      return newState;
    }

    case 'PASS': {
      if (!validatePass(state, action.playerId)) return state;

      newState.consecutive_passes += 1;
      
      if (newState.consecutive_passes >= 2) {
        const blockResult = checkBlockWinner(newState.player1_hand, newState.player2_hand);
        let winnerId = blockResult.winner === 'p1' ? state.player1_id :
          blockResult.winner === 'p2' ? state.player2_id : 'tie';
        if (blockResult.winner === 'tie' && state.last_player_id) {
          winnerId = state.last_player_id;
        }
        const p1Total = newState.player1_hand.reduce((sum, t) => sum + t[0] + t[1], 0);
        const p2Total = newState.player2_hand.reduce((sum, t) => sum + t[0] + t[1], 0);
        const pts = winnerId === 'tie'
          ? 0
          : mode === 'block'
            ? Math.abs(p1Total - p2Total)
            : winnerId === state.player1_id ? blockResult.p2Value : blockResult.p1Value;
        return handleRoundEnd(newState, winnerId, pts);
      }

      newState.current_turn = switchTurn(state);
      return newState;
    }

    case 'TIMEOUT': {
      return state;
    }

    default:
      return state;
  }
};
