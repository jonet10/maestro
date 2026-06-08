/**
 * testLogger.ts
 *
 * In-memory logger for the test framework.
 * Collects structured log entries per-test-run, enabling export and display
 * without writing to disk or modifying the existing mpLogger.
 */

import { TestLogEntry } from './types';

class TestLogger {
  private entries: TestLogEntry[] = [];
  private subscribers: Array<(entry: TestLogEntry) => void> = [];

  /**
   * Append a log entry. Timestamps are set automatically.
   */
  emit(entry: Omit<TestLogEntry, 'ts'>): TestLogEntry {
    const stamped: TestLogEntry = { ts: Date.now(), ...entry };
    this.entries.push(stamped);
    this.subscribers.forEach((fn) => fn(stamped));
    return stamped;
  }

  /** Subscribe to live log emissions (for UI streaming). Returns unsubscribe fn. */
  subscribe(fn: (entry: TestLogEntry) => void): () => void {
    this.subscribers.push(fn);
    return () => {
      this.subscribers = this.subscribers.filter((s) => s !== fn);
    };
  }

  /** Snapshot all collected log entries (for a completed test run). */
  flush(): TestLogEntry[] {
    return [...this.entries];
  }

  /** Clear for a fresh test run. */
  clear(): void {
    this.entries = [];
  }

  /** Return entries as a single formatted string (for export). */
  toText(): string {
    return this.entries
      .map((e) => {
        const time = new Date(e.ts).toISOString().split('T')[1].slice(0, 12);
        const dataStr = e.data ? ` ${JSON.stringify(e.data)}` : '';
        return `[${time}] [${e.level.toUpperCase().padEnd(6)}] [${e.tag}] ${e.message}${dataStr}`;
      })
      .join('\n');
  }
}

// Singleton — one logger shared across the test run, cleared between runs
export const testLogger = new TestLogger();
