/**
 * networkSimulator.ts
 *
 * Simulates adverse network conditions without modifying the real Realtime layer.
 *
 * Works by wrapping broadcast calls through a delay + packet-drop filter.
 * Provides an interceptor that can be injected into test scenarios.
 * The actual realtimeManager is NEVER modified — we only simulate locally.
 */

import { NetworkCondition, NetworkPreset, NETWORK_PRESETS } from './types';
import { TestLogEntry } from './types';

export interface NetworkSimStats {
  totalPackets: number;
  droppedPackets: number;
  deliveredPackets: number;
  avgLatencyMs: number;
  minLatencyMs: number;
  maxLatencyMs: number;
}

class NetworkSimulator {
  private condition: NetworkCondition = NETWORK_PRESETS.perfect;
  private stats: NetworkSimStats = this.freshStats();
  private latencySamples: number[] = [];

  private freshStats(): NetworkSimStats {
    return {
      totalPackets: 0,
      droppedPackets: 0,
      deliveredPackets: 0,
      avgLatencyMs: 0,
      minLatencyMs: Infinity,
      maxLatencyMs: 0,
    };
  }

  /** Set the current network condition preset. */
  applyPreset(preset: NetworkPreset): void {
    this.condition = NETWORK_PRESETS[preset];
    this.stats = this.freshStats();
    this.latencySamples = [];
  }

  /** Set a custom condition. */
  applyCustom(condition: NetworkCondition): void {
    this.condition = condition;
    this.stats = this.freshStats();
    this.latencySamples = [];
  }

  /** Reset to perfect network. */
  reset(): void {
    this.applyPreset('perfect');
  }

  /**
   * Simulate delivering a packet through current network conditions.
   * Returns a promise that resolves after the simulated latency,
   * or rejects if the packet is "dropped".
   */
  simulatePacket<T>(
    work: () => T,
    emit?: (entry: Omit<TestLogEntry, 'ts'>) => void,
  ): Promise<T> {
    this.stats.totalPackets++;

    // Packet loss check
    if (Math.random() * 100 < this.condition.packetLossPercent) {
      this.stats.droppedPackets++;
      emit?.({ level: 'warn', tag: 'Network', message: `Packet dropped (loss: ${this.condition.packetLossPercent}%)` });
      return Promise.reject(new Error('PACKET_DROPPED'));
    }

    // Compute latency with jitter
    const jitter = (Math.random() * 2 - 1) * this.condition.jitterMs;
    const latency = Math.max(0, this.condition.latencyMs + jitter);

    // Track stats
    this.latencySamples.push(latency);
    this.stats.deliveredPackets++;
    this.stats.minLatencyMs = Math.min(this.stats.minLatencyMs, latency);
    this.stats.maxLatencyMs = Math.max(this.stats.maxLatencyMs, latency);
    this.stats.avgLatencyMs = this.latencySamples.reduce((s, v) => s + v, 0) / this.latencySamples.length;

    if (latency > 0) {
      emit?.({ level: 'info', tag: 'Network', message: `Packet delayed ${latency.toFixed(0)}ms` });
    }

    return new Promise<T>((resolve) => {
      setTimeout(() => resolve(work()), latency);
    });
  }

  /** Simulate a full disconnect event. */
  simulateDisconnect(durationMs: number, emit?: (entry: Omit<TestLogEntry, 'ts'>) => void): Promise<void> {
    const prev = this.condition;
    this.applyPreset('offline');
    emit?.({ level: 'warn', tag: 'Network', message: `Simulated disconnect for ${durationMs}ms` });

    return new Promise<void>((resolve) => {
      setTimeout(() => {
        this.condition = prev;
        emit?.({ level: 'info', tag: 'Network', message: `Reconnected after ${durationMs}ms` });
        resolve();
      }, durationMs);
    });
  }

  /** Get current network condition. */
  getCondition(): NetworkCondition {
    return { ...this.condition };
  }

  /** Get accumulated network statistics. */
  getStats(): NetworkSimStats {
    return { ...this.stats };
  }
}

// Singleton — shared across all test scenarios
export const networkSim = new NetworkSimulator();
