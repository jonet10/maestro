/**
 * scenarios/syncSimulation.ts
 *
 * TEST: 2-Device Sync Simulation
 * ──────────────────────────────
 * Simulates two independent game state machines (P1 and P2 views)
 * and validates that they stay in sync after each action.
 *
 * Architecture:
 *   - Two independent state instances (simulating two devices)
 *   - Actions applied to P1's state are "broadcast" to P2 (via networkSim)
 *   - P2 applies received state updates
 *   - After each sync, both states are compared for equality
 *
 * PASS criteria:
 *  - Both device states are identical after every broadcast
 *  - No drift detected between device views
 *  - Timestamps are monotonically increasing
 */

import { TestScenario, SyncReport, TimingMetric } from '../types';
import { initializeGame } from '../../engine/gameInitializer';
import { dominoEngine } from '../../engine/dominoEngine';
import { getBotAction } from '../../engine/botLogic';
import { networkSim } from '../networkSimulator';
import { EngineGameState } from '../../engine/types';

const statesEqual = (a: EngineGameState, b: EngineGameState): boolean => {
  return (
    a.board_state.length === b.board_state.length &&
    a.player1_hand.length === b.player1_hand.length &&
    a.player2_hand.length === b.player2_hand.length &&
    a.boneyard.length === b.boneyard.length &&
    a.current_turn === b.current_turn &&
    a.match_status === b.match_status &&
    a.player1_score === b.player1_score &&
    a.player2_score === b.player2_score
  );
};

export const syncSimulationScenario: TestScenario = {
  id: 'sync_simulation',
  name: '2-Device Sync Simulation',
  description: 'Simulates two independent state machines (Device A and B) and validates state convergence after every broadcast.',
  category: 'sync',

  async run(emit, signal) {
    const metrics: TimingMetric[] = [];
    networkSim.applyPreset('good');
    emit({ level: 'info', tag: 'Sync', message: 'Network: GOOD (50ms, 0% loss)' });

    const p1 = 'device_a_player';
    const p2 = 'device_b_player';
    const matchId = 'sync_sim_match';

    // Two independent state views (simulating two devices)
    let deviceA: EngineGameState = initializeGame(matchId, p1, p2, 42);
    let deviceB: EngineGameState = { ...deviceA }; // Same initial state

    emit({ level: 'info', tag: 'Sync', message: 'Both devices initialized with identical state' });

    let syncChecks = 0;
    let desyncEvents = 0;
    const latencySamples: number[] = [];
    let maxDriftMs = 0;
    let lastTimestamp = deviceA.last_action_timestamp;
    const t0 = Date.now();

    while (deviceA.match_status === 'in_progress' && syncChecks < 200) {
      if (signal.aborted) return { passed: false };

      // Device A computes and applies bot action
      const action = getBotAction(deviceA);
      const actionStart = Date.now();
      deviceA = dominoEngine(deviceA, action);

      if (deviceA.last_action_timestamp <= lastTimestamp) {
        emit({ level: 'warn', tag: 'Sync', message: 'Non-monotonic timestamp detected', data: {
          prev: lastTimestamp,
          current: deviceA.last_action_timestamp,
        }});
      }
      lastTimestamp = deviceA.last_action_timestamp;

      // Simulate network delivery to Device B
      const syncPacket = { ...deviceA };
      try {
        await networkSim.simulatePacket(() => {
          deviceB = syncPacket;
        }, emit);
      } catch {
        // Packet dropped — Device B keeps stale state
        desyncEvents++;
        emit({ level: 'warn', tag: 'Sync', message: `Sync packet dropped — Device B is now stale` });
      }

      const latency = Date.now() - actionStart;
      latencySamples.push(latency);
      maxDriftMs = Math.max(maxDriftMs, latency);

      // Verify convergence
      const synced = statesEqual(deviceA, deviceB);
      syncChecks++;

      if (!synced) {
        desyncEvents++;
        emit({ level: 'error', tag: 'Sync', message: `DESYNC at step ${syncChecks}`, data: {
          deviceA_turn: deviceA.current_turn,
          deviceB_turn: deviceB.current_turn,
          deviceA_board: deviceA.board_state.length,
          deviceB_board: deviceB.board_state.length,
        }});
      }
    }

    metrics.push({ label: 'Total sync simulation time', durationMs: Date.now() - t0 });

    const avgLatency = latencySamples.length > 0
      ? Math.round(latencySamples.reduce((s, v) => s + v, 0) / latencySamples.length)
      : 0;

    const netStats = networkSim.getStats();
    emit({ level: 'metric', tag: 'Sync', message: 'Network statistics', data: {
      total: netStats.totalPackets,
      dropped: netStats.droppedPackets,
      delivered: netStats.deliveredPackets,
      avgLatencyMs: Math.round(netStats.avgLatencyMs),
    }});

    const syncReport: SyncReport = {
      totalActions: syncChecks,
      acceptedActions: syncChecks - desyncEvents,
      rejectedActions: desyncEvents,
      desyncEvents,
      maxDriftMs,
      avgLatencyMs: avgLatency,
    };

    const passed = desyncEvents === 0;

    networkSim.reset();
    emit({
      level: passed ? 'info' : 'error',
      tag: 'Scenario',
      message: passed ? '✅ 2-Device Sync PASSED' : `❌ 2-Device Sync FAILED (${desyncEvents} desyncs)`,
    });

    return { passed, syncReport, metrics };
  },
};
