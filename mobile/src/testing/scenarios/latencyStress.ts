/**
 * scenarios/latencyStress.ts
 *
 * TEST: Latency Stress Test (0ms → 3000ms)
 * ─────────────────────────────────────────
 * Progressively increases simulated network latency across 6 presets
 * and runs a mini-match at each level.
 *
 * Validates:
 *  - State consistency is maintained regardless of latency
 *  - No desync occurs at any latency level
 *  - Captures per-preset timing metrics for comparison
 *
 * PASS criteria:
 *  - Zero desync events at any latency level
 *  - All mini-matches reach terminal state
 */

import { TestScenario, SyncReport, TimingMetric, NetworkPreset } from '../types';
import { initializeGame } from '../../engine/gameInitializer';
import { dominoEngine } from '../../engine/dominoEngine';
import { getBotAction } from '../../engine/botLogic';
import { networkSim } from '../networkSimulator';
import { EngineGameState } from '../../engine/types';
import { NETWORK_PRESETS } from '../types';

const PRESETS: NetworkPreset[] = ['perfect', 'good', 'average', 'poor', 'terrible'];

const statesEqual = (a: EngineGameState, b: EngineGameState): boolean =>
  a.board_state.length === b.board_state.length &&
  a.current_turn === b.current_turn &&
  a.match_status === b.match_status;

export const latencyStressScenario: TestScenario = {
  id: 'latency_stress',
  name: 'Latency Stress Test (0ms → 3000ms)',
  description: 'Runs mini-matches at 5 latency presets from perfect to terrible, measuring impact on sync accuracy.',
  category: 'network',

  async run(emit, signal) {
    const metrics: TimingMetric[] = [];
    let totalDesync = 0;
    let totalActions = 0;
    let totalAccepted = 0;
    let maxDriftMs = 0;
    const latencySamples: number[] = [];

    for (const preset of PRESETS) {
      if (signal.aborted) return { passed: false };

      const condition = NETWORK_PRESETS[preset];
      networkSim.applyPreset(preset);

      emit({ level: 'info', tag: 'Latency', message: `── Testing preset: ${condition.label} (${condition.latencyMs}ms, ±${condition.jitterMs}ms jitter, ${condition.packetLossPercent}% loss)` });

      let deviceA: EngineGameState = initializeGame(
        `latency_${preset}`,
        'lat_p1',
        'lat_p2',
        PRESETS.indexOf(preset),
      );
      let deviceB: EngineGameState = { ...deviceA };

      let actionCount = 0;
      let desyncCount = 0;
      const presetStart = Date.now();

      while (deviceA.match_status === 'in_progress' && actionCount < 100) {
        if (signal.aborted) return { passed: false };

        const action = getBotAction(deviceA);
        const actionStart = Date.now();
        deviceA = dominoEngine(deviceA, action);

        // Simulate network delivery with current latency preset
        const syncPayload = { ...deviceA };
        try {
          await networkSim.simulatePacket(() => {
            deviceB = syncPayload;
          }, emit);
        } catch {
          // Packet dropped under "terrible" conditions
          desyncCount++;
        }

        const latency = Date.now() - actionStart;
        latencySamples.push(latency);
        maxDriftMs = Math.max(maxDriftMs, latency);

        if (!statesEqual(deviceA, deviceB)) {
          desyncCount++;
        }

        actionCount++;
        totalActions++;
      }

      if (deviceA === deviceB || statesEqual(deviceA, deviceB)) {
        totalAccepted += actionCount;
      }

      const presetMs = Date.now() - presetStart;
      const netStats = networkSim.getStats();
      totalDesync += desyncCount;

      emit({ level: desyncCount === 0 ? 'info' : 'warn', tag: 'Latency', message: `${condition.label}: ${actionCount} actions, ${desyncCount} desyncs, ${presetMs}ms`, data: {
        dropped: netStats.droppedPackets,
        delivered: netStats.deliveredPackets,
        desync: desyncCount,
      }});

      metrics.push({ label: `${condition.label} (${condition.latencyMs}ms) match time`, durationMs: presetMs });
    }

    networkSim.reset();

    const avgLatency = latencySamples.length > 0
      ? Math.round(latencySamples.reduce((s, v) => s + v, 0) / latencySamples.length)
      : 0;

    const syncReport: SyncReport = {
      totalActions,
      acceptedActions: totalAccepted,
      rejectedActions: totalDesync,
      desyncEvents: totalDesync,
      maxDriftMs,
      avgLatencyMs: avgLatency,
    };

    // PASS = no desyncs on perfect/good/average; warn on poor/terrible (packet loss expected)
    const criticalDesync = totalDesync === 0;
    const passed = criticalDesync;

    emit({
      level: passed ? 'info' : 'error',
      tag: 'Scenario',
      message: passed
        ? `✅ Latency Stress PASSED (avg: ${avgLatency}ms, max drift: ${maxDriftMs}ms)`
        : `❌ Latency Stress FAILED (${totalDesync} desyncs detected)`,
    });

    return { passed, syncReport, metrics };
  },
};
