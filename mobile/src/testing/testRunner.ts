/**
 * testRunner.ts
 *
 * Core test execution engine.
 * Runs a given TestScenario, handles cancellation, catches errors,
 * formats logs, and produces a final TestResult.
 */

import { TestScenario, TestResult, TestLogEntry } from './types';
import { testLogger } from './testLogger';

export class TestRunner {
  private abortController: AbortController | null = null;
  private currentResult: TestResult | null = null;
  private onResultUpdate?: (result: TestResult) => void;

  /** Listen for live state updates while a test is running. */
  onUpdate(fn: (result: TestResult) => void) {
    this.onResultUpdate = fn;
  }

  /**
   * Run a test scenario.
   */
  async run(scenario: TestScenario): Promise<TestResult> {
    this.cancel(); // Cancel any existing run

    this.abortController = new AbortController();
    const signal = this.abortController.signal;

    testLogger.clear();

    const t0 = Date.now();
    this.currentResult = {
      id: `${scenario.id}_${t0}`,
      name: scenario.name,
      status: 'running',
      startedAt: t0,
      finishedAt: null,
      durationMs: null,
      logs: [],
      metrics: [],
      syncReport: null,
      errorSummary: null,
    };

    this.emitUpdate();

    // Subscribe to logger to keep currentResult.logs up to date
    const unsubLogger = testLogger.subscribe((entry) => {
      if (this.currentResult) {
        this.currentResult.logs.push(entry);
        this.emitUpdate();
      }
    });

    try {
      // Execute the scenario
      const { passed, syncReport, metrics } = await scenario.run(
        (entry) => testLogger.emit(entry),
        signal
      );

      if (signal.aborted) {
        this.currentResult.status = 'warning';
        this.currentResult.errorSummary = 'Test was cancelled.';
        testLogger.emit({ level: 'warn', tag: 'Runner', message: 'Test execution cancelled by user' });
      } else {
        this.currentResult.status = passed ? 'pass' : 'fail';
        this.currentResult.syncReport = syncReport ?? null;
        this.currentResult.metrics = metrics ?? [];
      }
    } catch (err: any) {
      this.currentResult.status = 'fail';
      this.currentResult.errorSummary = err.message ?? String(err);
      testLogger.emit({ level: 'error', tag: 'Runner', message: `Test threw exception: ${err.message}`, data: { stack: err.stack } });
    } finally {
      unsubLogger();
      const t1 = Date.now();
      this.currentResult.finishedAt = t1;
      this.currentResult.durationMs = t1 - t0;
      this.abortController = null;
      this.emitUpdate();
    }

    return this.currentResult;
  }

  /** Cancel a currently running test. */
  cancel() {
    if (this.abortController) {
      this.abortController.abort();
      this.abortController = null;
    }
  }

  private emitUpdate() {
    if (this.currentResult && this.onResultUpdate) {
      // Provide a clone so React detects the update
      this.onResultUpdate({ ...this.currentResult, logs: [...this.currentResult.logs] });
    }
  }
}

// Singleton runner instance for the UI to use
export const testRunner = new TestRunner();
