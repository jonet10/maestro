/**
 * Tests moteur : multi-manches, ouverture, IA.
 * Run: npx tsx src/engine/engine.test.ts
 */
import { initializeGame } from './gameInitializer';
import { dominoEngine } from './dominoEngine';
import { getRequiredOpeningTile, getTargetScore } from './dominoRules';
import { finalizeRound, startNextRound } from './matchManager';
import { isMatchComplete } from './scoreManager';
import { validatePlay } from './moveValidator';
import { getAIAction } from './aiPlayer';
import type { EngineGameState } from './types';

function assert(cond: boolean, msg: string) {
  if (!cond) throw new Error(msg);
}

// --- Ouverture forcée ---
{
  const hand: [number, number][] = [[6, 6], [3, 5], [1, 2]];
  const required = getRequiredOpeningTile(hand);
  assert(required !== null && required[0] === 6 && required[1] === 6, 'opening: highest double');

  const state = initializeGame('t1', 'p1', 'p2', undefined, 'fives');
  state.player1_hand = hand;
  state.current_turn = 'p1';

  assert(validatePlay(state, 'p1', [6, 6], 'first'), 'valid opening double');
  assert(!validatePlay(state, 'p1', [3, 5], 'first'), 'reject non-opening tile');
}

// --- Multi-manches ---
{
  let state = initializeGame('t2', 'p1', 'p2', undefined, 'fives');
  state.player1_score = 140;
  state.player2_score = 0;
  state.target_score = 150;

  state = finalizeRound(state, 'p1', 15);
  assert(isMatchComplete(state), 'match completes at target');
  assert(state.match_status === 'completed', 'status completed');
}

{
  let state = initializeGame('t3', 'p1', 'p2', undefined, 'fives');
  state.player1_score = 50;
  state = finalizeRound(state, 'p1', 10);
  assert(state.round_number === 2, 'round increments');
  assert(state.board_state.length === 0, 'board cleared');
  assert(state.player1_score === 60, 'score accumulated');
  assert(state.match_status === 'in_progress', 'match continues');
}

// --- Target scores ---
{
  assert(getTargetScore('fives') === 150, 'fives target');
  assert(getTargetScore('block') === 250, 'block target');
}

// --- IA produit un coup légal ---
{
  const state = initializeGame('t4', 'p1', 'p2', undefined, 'fives');
  const action = getAIAction(state, state.current_turn, { difficulty: 'hard' });
  assert(['PLAY', 'DRAW', 'PASS'].includes(action.type), 'AI returns legal action type');
}

console.log('All engine tests passed.');
