import { EngineAction, EngineGameState } from './types';
import { getBotAction } from './botLogic';
import { canPlayTile } from './moveValidator';
import { getRequiredOpeningTile } from './dominoRules';
import { calculateFivesScore } from './scoring';
import { orientTileForSide } from './dominoEngine';
import { tileValue } from './tileUtils';
import type { BoardTile } from './types';

export type AIDifficulty = 'easy' | 'medium' | 'hard' | 'expert';

export interface AIPlayerConfig {
  difficulty: AIDifficulty;
  /** Délai simulé minimum avant coup (ms) — utilisé par l'UI solo. */
  thinkDelayMs?: number;
}

const DEFAULT_CONFIG: AIPlayerConfig = { difficulty: 'medium', thinkDelayMs: 650 };

type PlaySide = 'left' | 'right' | 'up' | 'down' | 'first';

interface MoveCandidate {
  tile: [number, number];
  side: PlaySide;
  score: number;
}

function enumerateMoves(state: EngineGameState, playerId: string): MoveCandidate[] {
  const hand = playerId === state.player1_id ? state.player1_hand : state.player2_hand;
  const opponentHand = playerId === state.player1_id ? state.player2_hand : state.player1_hand;
  const mode = state.game_mode ?? 'fives';
  const moves: MoveCandidate[] = [];

  for (const tile of hand) {
    if (state.board_state.length === 0) {
      const required = getRequiredOpeningTile(hand);
      if (required && tile[0] === required[0] && tile[1] === required[1]) {
        moves.push({ tile, side: 'first', score: 0 });
      }
      continue;
    }

    const p = canPlayTile(state.board_state, tile);
    const sides: PlaySide[] = [];
    if (p.left) sides.push('left');
    if (p.right) sides.push('right');
    if (p.up) sides.push('up');
    if (p.down) sides.push('down');

    for (const side of sides) {
      let score = 0;

      if (mode === 'fives') {
        const simBoard = simulatePlay(state.board_state, tile, side, state);
        score += calculateFivesScore(simBoard) * 10;
      }

      // Flexibilité : garder des options en main
      const remaining = hand.filter((t) => !(t[0] === tile[0] && t[1] === tile[1]));
      score += countPlayableAfter(state.board_state, remaining, tile, side) * 2;

      // Blocage adversaire : réduire les extrémités utiles pour l'adversaire
      score += estimateOpponentBlock(state, opponentHand, tile, side) * 3;

      // Jouer les doubles tôt si peu d'options
      if (tile[0] === tile[1]) score += 1;

      // Éviter de vider la main sur un coup faible (expert)
      score -= tileValue(tile) * 0.1;

      moves.push({ tile, side, score });
    }
  }

  return moves;
}

function simulatePlay(
  board: BoardTile[],
  tile: [number, number],
  side: PlaySide,
  state: EngineGameState,
): BoardTile[] {
  if (side === 'first') {
    const isDouble = tile[0] === tile[1];
    return [{ tile, side: 'first', orientedTile: tile, isDouble, isSpinner: isDouble }];
  }
  const orientedTile = orientTileForSide(state, tile, side as 'left' | 'right' | 'up' | 'down');
  const isDouble = tile[0] === tile[1];
  const hasSpinner = board.some((b) => b.isSpinner);
  const boardTile: BoardTile = {
    tile,
    orientedTile,
    side: side as BoardTile['side'],
    isDouble,
    isSpinner: isDouble && !hasSpinner,
  };
  return side === 'left' ? [boardTile, ...board] : [...board, boardTile];
}

function countPlayableAfter(
  board: BoardTile[],
  hand: [number, number][],
  played: [number, number],
  side: PlaySide,
): number {
  const simState = { board_state: board } as EngineGameState;
  const simBoard = simulatePlay(board, played, side, simState);
  return hand.filter((t) => {
    const p = canPlayTile(simBoard, t);
    return p.left || p.right || p.up || p.down;
  }).length;
}

function estimateOpponentBlock(
  state: EngineGameState,
  opponentHand: [number, number][],
  tile: [number, number],
  side: PlaySide,
): number {
  const simBoard = simulatePlay(state.board_state, tile, side, state);
  const playableBefore = opponentHand.filter((t) => {
    const p = canPlayTile(state.board_state, t);
    return p.left || p.right || p.up || p.down;
  }).length;
  const playableAfter = opponentHand.filter((t) => {
    const p = canPlayTile(simBoard, t);
    return p.left || p.right || p.up || p.down;
  }).length;
  return Math.max(0, playableBefore - playableAfter);
}

function pickWithDifficulty(moves: MoveCandidate[], difficulty: AIDifficulty): MoveCandidate {
  if (moves.length === 0) throw new Error('No moves');
  moves.sort((a, b) => b.score - a.score);

  switch (difficulty) {
    case 'easy': {
      const topHalf = moves.slice(0, Math.max(1, Math.ceil(moves.length / 2)));
      return topHalf[Math.floor(Math.random() * topHalf.length)];
    }
    case 'medium':
      return moves[0];
    case 'hard':
      return moves[0];
    case 'expert': {
      // Expert : top 3 recalculés avec bonus blocage
      const top = moves.slice(0, Math.min(3, moves.length));
      top.sort((a, b) => b.score - a.score);
      return top[0];
    }
    default:
      return moves[0];
  }
}

export function getAIAction(
  state: EngineGameState,
  playerId: string,
  config: Partial<AIPlayerConfig> = {},
): EngineAction {
  const { difficulty } = { ...DEFAULT_CONFIG, ...config };
  const timestamp = Date.now();

  if (difficulty === 'medium' && state.current_turn === playerId) {
    return getBotAction(state);
  }

  const moves = enumerateMoves(state, playerId);
  if (moves.length > 0) {
    const best = pickWithDifficulty(moves, difficulty);
    return {
      type: 'PLAY',
      playerId,
      payload: { tile: best.tile, side: best.side },
      timestamp,
    };
  }

  const mode = state.game_mode ?? 'fives';
  if (mode !== 'block' && state.boneyard.length > 0) {
    return { type: 'DRAW', playerId, timestamp };
  }
  return { type: 'PASS', playerId, timestamp };
}

export function getAIThinkDelay(config: Partial<AIPlayerConfig> = {}): number {
  const { difficulty, thinkDelayMs } = { ...DEFAULT_CONFIG, ...config };
  const base = thinkDelayMs ?? 650;
  switch (difficulty) {
    case 'easy': return base + 400;
    case 'medium': return base;
    case 'hard': return Math.max(300, base - 200);
    case 'expert': return Math.max(200, base - 350);
    default: return base;
  }
}
