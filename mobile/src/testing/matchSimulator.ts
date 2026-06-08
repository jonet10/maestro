/**
 * matchSimulator.ts
 *
 * Pure AI-vs-AI match simulation engine.
 * Runs a complete domino match using the real game engine reducer and
 * bot logic — no React, no Realtime, no side effects.
 * Returns a structured trace of every action taken and the final state.
 *
 * Used by test scenarios to generate reproducible game sequences.
 */

import { EngineGameState, EngineAction, Tile } from '../engine/types';
import { initializeGame } from '../engine/gameInitializer';
import { dominoEngine } from '../engine/dominoEngine';
import { getBotAction } from '../engine/botLogic';
import { TestLogEntry } from './types';

export interface SimulatedAction {
  turnIndex: number;
  playerId: string;
  action: EngineAction;
  stateBefore: EngineGameState;
  stateAfter: EngineGameState;
  durationMs: number;
  wasAccepted: boolean;
}

export interface SimulationResult {
  matchId: string;
  player1Id: string;
  player2Id: string;
  totalActions: number;
  totalRounds: number;
  finalState: EngineGameState;
  winnerId: string | null;
  durationMs: number;
  actions: SimulatedAction[];
  wasBlocked: boolean;      // True if game ended via blocking rule
  capotDetected: boolean;   // True if one player never played
  desyncDetected: boolean;  // True if any state mutation was rejected
}

const MAX_ACTIONS = 500; // Safety cap to prevent infinite loops in degenerate games

/**
 * Run a complete AI vs AI match simulation.
 * Both players use getBotAction() deterministically.
 */
export const simulateFullMatch = (
  emit: (entry: Omit<TestLogEntry, 'ts'>) => void,
  matchId?: string,
  seed?: number,
): SimulationResult => {
  const p1 = 'sim_player_1';
  const p2 = 'sim_player_2';
  const mid = matchId ?? `sim_match_${Date.now()}`;

  const startTime = Date.now();
  let state = initializeGame(mid, p1, p2, seed);

  emit({ level: 'info', tag: 'Simulator', message: `Match started: ${mid}`, data: {
    p1HandSize: state.player1_hand.length,
    p2HandSize: state.player2_hand.length,
    boneyardSize: state.boneyard.length,
  }});

  const actions: SimulatedAction[] = [];
  let turnIndex = 0;
  let desyncDetected = false;

  while (state.match_status === 'in_progress' && turnIndex < MAX_ACTIONS) {
    const currentPlayerId = state.current_turn;
    const actionStart = Date.now();

    // Derive action from bot
    const action = getBotAction(state);
    const stateBefore = state;

    // Run through the pure engine reducer
    const stateAfter = dominoEngine(state, action);
    const wasAccepted = stateAfter !== stateBefore; // Reference equality check

    const durationMs = Date.now() - actionStart;

    if (!wasAccepted) {
      desyncDetected = true;
      emit({ level: 'error', tag: 'Simulator', message: `Action REJECTED by engine`, data: {
        turn: turnIndex,
        player: currentPlayerId,
        actionType: action.type,
      }});
    } else {
      emit({ level: 'info', tag: 'Simulator', message: `Turn ${turnIndex}: ${currentPlayerId} → ${action.type}`, data: {
        type: action.type,
        payload: action.payload ?? {},
        boardSize: stateAfter.board_state.length,
        boneyardSize: stateAfter.boneyard.length,
      }});
    }

    actions.push({ turnIndex, playerId: currentPlayerId, action, stateBefore, stateAfter, durationMs, wasAccepted });
    state = stateAfter;
    turnIndex++;
  }

  const totalMs = Date.now() - startTime;

  if (turnIndex >= MAX_ACTIONS) {
    emit({ level: 'warn', tag: 'Simulator', message: `Safety cap hit — match may be infinite loop`, data: { MAX_ACTIONS } });
  }

  // Determine winner
  let winnerId: string | null = null;
  if (state.player1_score > state.player2_score) winnerId = p1;
  else if (state.player2_score > state.player1_score) winnerId = p2;

  // Detect blocking game
  const wasBlocked = state.consecutive_passes >= 2 ||
    (state.match_status === 'completed' &&
      state.player1_hand.length > 0 &&
      state.player2_hand.length > 0);

  // Capot: loser never reduced their hand from 7
  const capotDetected = state.player1_hand.length === 7 || state.player2_hand.length === 7;

  emit({ level: 'info', tag: 'Simulator', message: `Match complete in ${totalMs}ms`, data: {
    totalActions: actions.length,
    winnerId,
    finalScore: `${state.player1_score}:${state.player2_score}`,
    wasBlocked,
    capotDetected,
    desyncDetected,
  }});

  return {
    matchId: mid,
    player1Id: p1,
    player2Id: p2,
    totalActions: actions.length,
    totalRounds: state.round_number,
    finalState: state,
    winnerId,
    durationMs: totalMs,
    actions,
    wasBlocked,
    capotDetected,
    desyncDetected,
  };
};

/**
 * Run N matches back-to-back and aggregate statistics.
 */
export const simulateMatchBatch = (
  count: number,
  emit: (entry: Omit<TestLogEntry, 'ts'>) => void,
): {
  total: number;
  avgActions: number;
  avgDurationMs: number;
  desyncCount: number;
  p1Wins: number;
  p2Wins: number;
  ties: number;
} => {
  emit({ level: 'info', tag: 'BatchSim', message: `Starting batch of ${count} matches` });

  let totalActions = 0;
  let totalDurationMs = 0;
  let desyncCount = 0;
  let p1Wins = 0;
  let p2Wins = 0;
  let ties = 0;

  for (let i = 0; i < count; i++) {
    const result = simulateFullMatch(emit, `batch_match_${i}`, i);
    totalActions += result.totalActions;
    totalDurationMs += result.durationMs;
    if (result.desyncDetected) desyncCount++;
    if (result.winnerId === 'sim_player_1') p1Wins++;
    else if (result.winnerId === 'sim_player_2') p2Wins++;
    else ties++;
  }

  return {
    total: count,
    avgActions: Math.round(totalActions / count),
    avgDurationMs: Math.round(totalDurationMs / count),
    desyncCount,
    p1Wins,
    p2Wins,
    ties,
  };
};
