// ─── Core test framework types ─────────────────────────────────────────────

export type TestStatus = 'idle' | 'running' | 'pass' | 'fail' | 'warning';

export interface TestLogEntry {
  ts: number;             // Unix ms timestamp
  level: 'info' | 'warn' | 'error' | 'metric';
  tag: string;            // Source tag e.g. "Engine" | "Sync" | "Network"
  message: string;
  data?: Record<string, unknown>;
}

export interface TimingMetric {
  label: string;
  durationMs: number;
}

export interface SyncReport {
  totalActions: number;
  acceptedActions: number;
  rejectedActions: number;
  desyncEvents: number;
  maxDriftMs: number;
  avgLatencyMs: number;
}

export interface TestResult {
  id: string;
  name: string;
  status: TestStatus;
  startedAt: number;
  finishedAt: number | null;
  durationMs: number | null;
  logs: TestLogEntry[];
  metrics: TimingMetric[];
  syncReport: SyncReport | null;
  errorSummary: string | null;
}

export interface TestScenario {
  id: string;
  name: string;
  description: string;
  category: 'engine' | 'network' | 'sync' | 'reliability';
  run: (
    emit: (entry: Omit<TestLogEntry, 'ts'>) => void,
    signal: AbortSignal,
  ) => Promise<{ passed: boolean; syncReport?: SyncReport; metrics?: TimingMetric[] }>;
}

// Network simulation presets
export type NetworkPreset =
  | 'perfect'      // 0ms latency, 0% loss
  | 'good'         // 50ms, 0% loss
  | 'average'      // 200ms, 2% loss
  | 'poor'         // 800ms, 10% loss
  | 'terrible'     // 2000ms, 25% loss
  | 'offline';     // Complete disconnect

export interface NetworkCondition {
  latencyMs: number;
  jitterMs: number;       // ± random variance on latency
  packetLossPercent: number;
  label: string;
}

export const NETWORK_PRESETS: Record<NetworkPreset, NetworkCondition> = {
  perfect:  { latencyMs: 0,    jitterMs: 0,   packetLossPercent: 0,  label: 'Perfect'  },
  good:     { latencyMs: 50,   jitterMs: 10,  packetLossPercent: 0,  label: 'Good'     },
  average:  { latencyMs: 200,  jitterMs: 50,  packetLossPercent: 2,  label: 'Average'  },
  poor:     { latencyMs: 800,  jitterMs: 150, packetLossPercent: 10, label: 'Poor'     },
  terrible: { latencyMs: 2000, jitterMs: 400, packetLossPercent: 25, label: 'Terrible' },
  offline:  { latencyMs: 0,    jitterMs: 0,   packetLossPercent: 100, label: 'Offline' },
};
