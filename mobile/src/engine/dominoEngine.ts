import { EngineGameState, EngineAction } from './types';
import { hasPlayableTile, validatePlay, validateDraw, validatePass } from './moveValidator';
import { removeTile } from './tileUtils';
import { calculateRoundScore, calculateFivesRoundEndScore, calculateFivesScore, checkBlockWinner, isCapot, calculateCapotScore, calculateBlockEndScore, calculateHandValue } from './scoring';
import { finalizeRound } from './matchManager';

const switchTurn = (state: EngineGameState): string => {
  return state.current_turn === state.player1_id ? state.player2_id : state.player1_id;
};

export const orientTileForSide = (
  state: EngineGameState,
  tile: [number, number],
  side: 'left' | 'right' | 'up' | 'down'
): [number, number] => {
  if (state.board_state.length === 0) return tile;

  let refTile;
  let exposedEnd: number;

  if (side === 'left') {
    refTile = state.board_state.find(bt => bt.side === 'left') ?? state.board_state.find(bt => bt.side === 'first');
    const oriented = refTile!.orientedTile ?? refTile!.tile;
    exposedEnd = oriented[0];
  } else if (side === 'right') {
    refTile = [...state.board_state].reverse().find(bt => bt.side === 'right') ?? state.board_state.find(bt => bt.side === 'first');
    const oriented = refTile!.orientedTile ?? refTile!.tile;
    exposedEnd = oriented[1];
  } else if (side === 'up') {
    refTile = [...state.board_state].reverse().find(bt => bt.side === 'up') ?? state.board_state.find(bt => bt.isSpinner);
    const oriented = refTile!.orientedTile ?? refTile!.tile;
    exposedEnd = oriented[0];
  } else if (side === 'down') {
    refTile = [...state.board_state].reverse().find(bt => bt.side === 'down') ?? state.board_state.find(bt => bt.isSpinner);
    const oriented = refTile!.orientedTile ?? refTile!.tile;
    exposedEnd = oriented[1];
  }

  const [a, b] = tile;
  if (side === 'left' || side === 'up') {
    return b === exposedEnd! ? [a, b] : [b, a];
  } else {
    return a === exposedEnd! ? [a, b] : [b, a];
  }
};

export const dominoEngine = (state: EngineGameState, action: EngineAction): EngineGameState => {
  const newState = { ...state, last_action_timestamp: action.timestamp };
  const isP1 = action.playerId === state.player1_id;
  const mode = state.game_mode ?? 'fives';

  if (state.match_status === 'completed' || state.match_status === 'cancelled') {
    return state; // No actions allowed if game is over
  }

  switch (action.type) {
    case 'PLAY': {
      if (!action.payload?.tile || !action.payload.side) return state;
      if (!validatePlay(state, action.playerId, action.payload.tile, action.payload.side as any)) return state;

      // Apply play
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
      // The spinner is the first double ever played on the board
      const hasSpinnerAlready = state.board_state.some((bt) => bt.isSpinner);
      const isSpinner = tileIsDouble && !hasSpinnerAlready;

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
        // Spinner branches: insert after the spinner in the array
        // Convention: 'up' tiles are stored right after spinner, 'down' tiles after 'up' tiles
        // The layout engine will pick them up by their side property
        newState.board_state = [...state.board_state, boardTile];
      } else {
        // 'first' — board was empty
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

      // Check Domino (Win)
      if (newState.player1_hand.length === 0 || newState.player2_hand.length === 0) {
        const winnerId = newState.player1_hand.length === 0 ? state.player1_id : state.player2_id;
        const loserHand = winnerId === state.player1_id ? newState.player2_hand : newState.player1_hand;
        const capot = isCapot([], loserHand);
        const pts = mode === 'fives'
          ? calculateFivesRoundEndScore([loserHand])
          : capot
            ? calculateCapotScore(loserHand)
            : calculateRoundScore([], loserHand);
        return finalizeRound(newState, winnerId, pts);
      }

      newState.current_turn = switchTurn(state);
      return newState;
    }

    case 'DRAW': {
      if (!validateDraw(state, action.playerId)) return state;

      // DRAW/FIVES rule: draw one by one until a playable tile is found,
      // or boneyard is empty.
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

      // If no playable tile after exhausting boneyard, pass automatically.
      if (!hasPlayableTile(state.board_state, nextHand) && nextBoneyard.length === 0) {
        newState.current_turn = switchTurn(state);
      }

      return newState;
    }

    case 'PASS': {
      if (!validatePass(state, action.playerId)) return state;

      newState.consecutive_passes += 1;
      
      // Check block (both passed)
      if (newState.consecutive_passes >= 2) {
        const blockResult = checkBlockWinner(newState.player1_hand, newState.player2_hand);
        let winnerId = blockResult.winner === 'p1' ? state.player1_id :
          blockResult.winner === 'p2' ? state.player2_id : 'tie';
        if (blockResult.winner === 'tie' && state.last_player_id) {
          winnerId = state.last_player_id;
        }

        let pts: number;
        if (mode === 'block') {
          const blockEnd = calculateBlockEndScore(newState.player1_hand, newState.player2_hand);
          if (blockEnd.winnerId === 'tie' && state.last_player_id) {
            const loserHand = state.last_player_id === state.player1_id ? newState.player2_hand : newState.player1_hand;
            pts = calculateHandValue(loserHand);
          } else {
            pts = blockEnd.points;
          }
        } else {
          pts = winnerId === state.player1_id ? blockResult.p2Value : blockResult.p1Value;
        }

        return finalizeRound(newState, winnerId as string | 'tie', pts);
      }

      newState.current_turn = switchTurn(state);
      return newState;
    }

    case 'TIMEOUT': {
      // No-op: timeout fallback is handled by turnManager via legal DRAW/PASS/PLAY actions.
      return state;
    }

    default:
      return state;
  }
};
