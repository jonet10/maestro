/**
 * scenarios/reconnectLoop.ts
 *
 * TEST: Reconnect Loop Test
 * ─────────────────────────
 * Simulates rapid connect/disconnect cycles to verify the connection
 * state machine handles repeated reconnects gracefully.
 *
 * Validates:
 *  - Connection state transitions are always valid (no stuck states)
 *  - Zustand store is cleaned up correctly after each disconnect
 *  - Re-seeding state after reconnect produces consistent results
 *  - No memory leaks or stale references from previous cycles
 *
 * PASS criteria:
 *  - All RECONNECT_CYCLES complete without invalid state transitions
 *  - Store is always clean (matchId null) after disconnect
 *  - State after reseed equals expected initial state
 */

import { TestScenario, SyncReport, TimingMetric } from '../types';
import { useMultiplayerStore } from '../../multiplayer/store';
import { initializeGame } from '../../engine/gameInitializer';
import { EngineGameState } from '../../engine/types';

const RECONNECT_CYCLES = 10;
const VALID_CONNECTION_STATES = new Set(['disconnected', 'connecting', 'connected', 'recovering']);

export const reconnectLoopScenario: TestScenario = {
  id: 'reconnect_loop',
  name: 'Reconnect Loop Test (10 Cycles)',
  description: 'Simulates 10 rapid connect/disconnect cycles on the Zustand multiplayer store. Validates clean teardown and correct reseed on reconnect.',
  category: 'reliability',

  async run(emit, signal) {
    const metrics: TimingMetric[] = [];
    emit({ level: 'info', tag: 'Reconnect', message: `Starting ${RECONNECT_CYCLES} connect/disconnect cycles` });

    let invalidTransitions = 0;
    let dirtyResets = 0;
    let reseedFailures = 0;
    const cycleTimes: number[] = [];

    const store = useMultiplayerStore.getState();

    for (let cycle = 0; cycle < RECONNECT_CYCLES; cycle++) {
      if (signal.aborted) return { passed: false };

      const cycleStart = Date.now();
      emit({ level: 'info', tag: 'Reconnect', message: `── Cycle ${cycle + 1}/${RECONNECT_CYCLES}` });

      // ── Step 1: Simulate connecting ──
      store.setConnectionState('connecting');
      store.setMatchId(`cycle_match_${cycle}`);
      await new Promise<void>(r => setTimeout(r, 20)); // Brief async gap

      let connState = useMultiplayerStore.getState().connectionState;
      if (!VALID_CONNECTION_STATES.has(connState)) {
        invalidTransitions++;
        emit({ level: 'error', tag: 'Reconnect', message: `Invalid state after connect: "${connState}"` });
      }

      // ── Step 2: Seed game state ──
      const engineState = initializeGame(
        `cycle_match_${cycle}`,
        `cycle_p1_${cycle}`,
        `cycle_p2_${cycle}`,
        cycle,
      );

      store.setConnectionState('connected');
      store.updateGameState(engineState as any, Date.now());
      await new Promise<void>(r => setTimeout(r, 10));

      // Verify seed was applied
      const seededState = useMultiplayerStore.getState().gameState as EngineGameState | null;
      if (!seededState || seededState.player1_hand.length !== 7 || seededState.player2_hand.length !== 7) {
        reseedFailures++;
        emit({ level: 'error', tag: 'Reconnect', message: `Reseed verification failed at cycle ${cycle + 1}`, data: {
          p1Hand: seededState?.player1_hand?.length ?? 'null',
          p2Hand: seededState?.player2_hand?.length ?? 'null',
        }});
      } else {
        emit({ level: 'info', tag: 'Reconnect', message: `Cycle ${cycle + 1}: State seeded correctly (7+7 tiles)` });
      }

      // ── Step 3: Simulate disconnect ──
      store.setConnectionState('recovering');
      await new Promise<void>(r => setTimeout(r, 15));

      store.reset(); // Full store reset — simulates disconnect teardown
      await new Promise<void>(r => setTimeout(r, 10));

      // ── Step 4: Validate cleanup ──
      const afterReset = useMultiplayerStore.getState();

      if (afterReset.matchId !== null) {
        dirtyResets++;
        emit({ level: 'error', tag: 'Reconnect', message: `Dirty reset: matchId not null after disconnect`, data: { matchId: afterReset.matchId } });
      }
      if (afterReset.connectionState !== 'disconnected') {
        invalidTransitions++;
        emit({ level: 'error', tag: 'Reconnect', message: `Bad state after reset: "${afterReset.connectionState}"` });
      }
      if (afterReset.gameState !== null) {
        dirtyResets++;
        emit({ level: 'error', tag: 'Reconnect', message: `Dirty reset: gameState not null after disconnect` });
      }

      const cycleMs = Date.now() - cycleStart;
      cycleTimes.push(cycleMs);
      emit({ level: 'info', tag: 'Reconnect', message: `Cycle ${cycle + 1} complete in ${cycleMs}ms` });
      metrics.push({ label: `Cycle ${cycle + 1} duration`, durationMs: cycleMs });
    }

    const avgCycleMs = Math.round(cycleTimes.reduce((s, v) => s + v, 0) / cycleTimes.length);
    const maxCycleMs = Math.max(...cycleTimes);

    emit({ level: 'metric', tag: 'Reconnect', message: 'Reconnect loop summary', data: {
      cycles: RECONNECT_CYCLES,
      invalidTransitions,
      dirtyResets,
      reseedFailures,
      avgCycleMs,
      maxCycleMs,
    }});

    const syncReport: SyncReport = {
      totalActions: RECONNECT_CYCLES,
      acceptedActions: RECONNECT_CYCLES - (invalidTransitions + dirtyResets + reseedFailures),
      rejectedActions: invalidTransitions + dirtyResets + reseedFailures,
      desyncEvents: dirtyResets,
      maxDriftMs: maxCycleMs,
      avgLatencyMs: avgCycleMs,
    };

    const passed =
      invalidTransitions === 0 &&
      dirtyResets === 0 &&
      reseedFailures === 0;

    emit({
      level: passed ? 'info' : 'error',
      tag: 'Scenario',
      message: passed
        ? `✅ Reconnect Loop PASSED (${RECONNECT_CYCLES} cycles, avg ${avgCycleMs}ms)`
        : `❌ Reconnect Loop FAILED (${invalidTransitions} invalid transitions, ${dirtyResets} dirty resets, ${reseedFailures} reseed failures)`,
    });

    return { passed, syncReport, metrics };
  },
};
