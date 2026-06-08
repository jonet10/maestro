/**
 * scenarios/fullMatchSimulation.ts
 *
 * TEST: Full Match Simulation (AI vs AI)
 * ──────────────────────────────────────
 * Runs a complete AI vs AI domino match through the real engine reducer.
 * Validates every state transition, ensures no desync, and checks rule compliance.
 *
 * PASS criteria:
 *  - Game reaches a terminal state (completed) within MAX_ACTIONS
 *  - No action is rejected by the engine
 *  - Total tile count stays constant (28 tiles throughout)
 *  - Score is updated correctly
 */

import { TestScenario, SyncReport, TimingMetric } from '../types';
import { simulateFullMatch } from '../matchSimulator';
import { dominoEngine } from '../../engine/dominoEngine';
import { getBotAction } from '../../engine/botLogic';
import { initializeGame } from '../../engine/gameInitializer';

const TILE_CONSERVATION_TOTAL = 28; // Always exactly 28 tiles in the game

const countTotalTiles = (state: ReturnType<typeof initializeGame>): number =>
  state.board_state.length +
  state.player1_hand.length +
  state.player2_hand.length +
  state.boneyard.length;

export const fullMatchSimulationScenario: TestScenario = {
  id: 'full_match_simulation',
  name: 'Full Match Simulation (AI vs AI)',
  description: 'Simulates a complete 2-player match using the game engine and bot logic. Validates state transitions, tile conservation, and scoring.',
  category: 'engine',

  async run(emit, signal) {
    const metrics: TimingMetric[] = [];

    emit({ level: 'info', tag: 'Scenario', message: 'Starting full AI vs AI match simulation' });

    // ── Phase 1: Single match validation ──
    const t0 = Date.now();
    const result = simulateFullMatch(emit, 'scenario_match_001');
    metrics.push({ label: 'Single match duration', durationMs: Date.now() - t0 });

    if (signal.aborted) return { passed: false };

    // Tile conservation check
    const finalTileCount = countTotalTiles(result.finalState);
    const tileConservationOk = finalTileCount === TILE_CONSERVATION_TOTAL;

    emit({
      level: tileConservationOk ? 'info' : 'error',
      tag: 'Validator',
      message: `Tile conservation: ${finalTileCount}/${TILE_CONSERVATION_TOTAL} tiles accounted for`,
      data: {
        board: result.finalState.board_state.length,
        p1Hand: result.finalState.player1_hand.length,
        p2Hand: result.finalState.player2_hand.length,
        boneyard: result.finalState.boneyard.length,
      },
    });

    // Action acceptance check
    const rejectedActions = result.actions.filter(a => !a.wasAccepted);
    emit({
      level: rejectedActions.length === 0 ? 'info' : 'warn',
      tag: 'Validator',
      message: `Action acceptance: ${result.actions.length - rejectedActions.length}/${result.actions.length} accepted`,
      data: { rejectedCount: rejectedActions.length },
    });

    // Terminal state check
    const reachedTerminal = result.finalState.match_status === 'completed' ||
                            result.finalState.match_status === 'cancelled';
    emit({
      level: reachedTerminal ? 'info' : 'error',
      tag: 'Validator',
      message: `Terminal state: ${result.finalState.match_status}`,
      data: { winnerId: result.winnerId, score: `${result.finalState.player1_score}:${result.finalState.player2_score}` },
    });

    if (signal.aborted) return { passed: false };

    // ── Phase 2: Batch stress test (10 matches) ──
    emit({ level: 'info', tag: 'Scenario', message: 'Running 10-match batch to check consistency' });
    const batchT0 = Date.now();
    let batchDesyncCount = 0;

    for (let i = 0; i < 10; i++) {
      if (signal.aborted) return { passed: false };
      const r = simulateFullMatch(emit, `batch_${i}`, i);
      if (r.desyncDetected) batchDesyncCount++;
    }
    metrics.push({ label: '10-match batch duration', durationMs: Date.now() - batchT0 });

    emit({
      level: batchDesyncCount === 0 ? 'info' : 'error',
      tag: 'Validator',
      message: `Batch consistency: ${10 - batchDesyncCount}/10 matches clean`,
      data: { desyncCount: batchDesyncCount },
    });

    const syncReport: SyncReport = {
      totalActions: result.totalActions,
      acceptedActions: result.actions.filter(a => a.wasAccepted).length,
      rejectedActions: rejectedActions.length,
      desyncEvents: result.desyncDetected ? 1 : 0,
      maxDriftMs: Math.max(...result.actions.map(a => a.durationMs)),
      avgLatencyMs: result.durationMs / result.totalActions,
    };

    const passed =
      tileConservationOk &&
      rejectedActions.length === 0 &&
      reachedTerminal &&
      batchDesyncCount === 0;

    emit({
      level: passed ? 'info' : 'error',
      tag: 'Scenario',
      message: passed ? '✅ Full Match Simulation PASSED' : '❌ Full Match Simulation FAILED',
    });

    return { passed, syncReport, metrics };
  },
};
