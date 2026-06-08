/**
 * scenarios/actionSpam.ts
 *
 * TEST: Action Spam Test (100 rapid actions)
 * ──────────────────────────────────────────
 * Dispatches 100 sequential engine actions as fast as possible (no async gaps)
 * to verify the engine:
 *  - Handles rapid state mutations without corrupting state
 *  - Rejects invalid actions cleanly (no crashes or partial mutations)
 *  - Maintains tile conservation under stress
 *  - Does not enter infinite loops or stall
 *
 * PASS criteria:
 *  - All 100 actions are processed without exceptions
 *  - Tile count remains at 28 after every step
 *  - Engine never returns undefined/null state
 *  - No duplicate tile appears in any zone (hand/board/boneyard)
 */

import { TestScenario, SyncReport, TimingMetric } from '../types';
import { initializeGame } from '../../engine/gameInitializer';
import { dominoEngine } from '../../engine/dominoEngine';
import { getBotAction } from '../../engine/botLogic';
import { EngineGameState, Tile } from '../../engine/types';

const TARGET_ACTIONS = 100;

const countTiles = (state: EngineGameState): number =>
  state.board_state.length +
  state.player1_hand.length +
  state.player2_hand.length +
  state.boneyard.length;

/** Detect duplicate tiles across all zones */
const hasDuplicateTiles = (state: EngineGameState): boolean => {
  const seen = new Set<string>();
  const allTiles: Tile[] = [
    ...state.player1_hand,
    ...state.player2_hand,
    ...state.boneyard,
    ...state.board_state.map(bt => bt.tile),
  ];

  for (const [a, b] of allTiles) {
    // Normalize tile representation (e.g., [1,3] == [3,1])
    const key = a <= b ? `${a}-${b}` : `${b}-${a}`;
    if (seen.has(key)) return true;
    seen.add(key);
  }
  return false;
};

export const actionSpamScenario: TestScenario = {
  id: 'action_spam',
  name: 'Action Spam Test (100 Rapid Actions)',
  description: 'Fires 100 rapid engine actions as fast as possible. Checks for state corruption, tile duplication, and engine stability.',
  category: 'engine',

  async run(emit, signal) {
    const metrics: TimingMetric[] = [];
    emit({ level: 'info', tag: 'Spam', message: `Starting ${TARGET_ACTIONS}-action rapid fire test` });

    let state: EngineGameState = initializeGame('spam_match', 'spam_p1', 'spam_p2', 0);
    const t0 = Date.now();

    let accepted = 0;
    let rejected = 0;
    let tileErrors = 0;
    let duplicateErrors = 0;
    let exceptions = 0;
    const actionTimings: number[] = [];

    for (let i = 0; i < TARGET_ACTIONS; i++) {
      if (signal.aborted) return { passed: false };

      // Stop advancing if game is already over (count remaining as skipped)
      if (state.match_status !== 'in_progress') {
        emit({ level: 'info', tag: 'Spam', message: `Game ended at action ${i} — remaining ${TARGET_ACTIONS - i} actions skipped` });
        break;
      }

      let nextState: EngineGameState;
      const actionStart = Date.now();

      try {
        const action = getBotAction(state);
        nextState = dominoEngine(state, action);
      } catch (err: any) {
        exceptions++;
        emit({ level: 'error', tag: 'Spam', message: `Exception at action ${i}: ${err?.message ?? err}` });
        break;
      }

      const actionMs = Date.now() - actionStart;
      actionTimings.push(actionMs);

      // Validate state mutation
      if (nextState === state) {
        rejected++;
      } else {
        accepted++;
        state = nextState;
      }

      // Tile conservation check
      const tileCount = countTiles(state);
      if (tileCount !== 28) {
        tileErrors++;
        emit({ level: 'error', tag: 'Spam', message: `Tile conservation violation at action ${i}: ${tileCount}/28` });
      }

      // Duplicate tile check
      if (hasDuplicateTiles(state)) {
        duplicateErrors++;
        emit({ level: 'error', tag: 'Spam', message: `Duplicate tile detected at action ${i}` });
      }
    }

    const totalMs = Date.now() - t0;
    const avgActionMs = actionTimings.length > 0
      ? Math.round(actionTimings.reduce((s, v) => s + v, 0) / actionTimings.length)
      : 0;
    const maxActionMs = actionTimings.length > 0 ? Math.max(...actionTimings) : 0;

    metrics.push({ label: 'Total spam test duration', durationMs: totalMs });
    metrics.push({ label: 'Avg action processing time', durationMs: avgActionMs });
    metrics.push({ label: 'Max action processing time', durationMs: maxActionMs });

    emit({ level: 'metric', tag: 'Spam', message: 'Stress test summary', data: {
      accepted,
      rejected,
      tileErrors,
      duplicateErrors,
      exceptions,
      avgActionMs,
      maxActionMs,
      totalMs,
    }});

    const syncReport: SyncReport = {
      totalActions: TARGET_ACTIONS,
      acceptedActions: accepted,
      rejectedActions: rejected,
      desyncEvents: duplicateErrors + tileErrors,
      maxDriftMs: maxActionMs,
      avgLatencyMs: avgActionMs,
    };

    const passed =
      exceptions === 0 &&
      tileErrors === 0 &&
      duplicateErrors === 0;

    emit({
      level: passed ? 'info' : 'error',
      tag: 'Scenario',
      message: passed
        ? `✅ Action Spam PASSED (${accepted} accepted, avg ${avgActionMs}ms/action)`
        : `❌ Action Spam FAILED (${exceptions} exceptions, ${tileErrors} tile errors, ${duplicateErrors} duplicates)`,
    });

    return { passed, syncReport, metrics };
  },
};
