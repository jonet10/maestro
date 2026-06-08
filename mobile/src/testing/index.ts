export * from './types';
export * from './testLogger';
export * from './testRunner';
export * from './matchSimulator';
export * from './networkSimulator';

import { fullMatchSimulationScenario } from './scenarios/fullMatchSimulation';
import { syncSimulationScenario } from './scenarios/syncSimulation';
import { disconnectRecoveryScenario } from './scenarios/disconnectRecovery';
import { latencyStressScenario } from './scenarios/latencyStress';
import { actionSpamScenario } from './scenarios/actionSpam';
import { reconnectLoopScenario } from './scenarios/reconnectLoop';
import { stateConsistencyScenario } from './scenarios/stateConsistency';

export const TEST_SCENARIOS = [
  fullMatchSimulationScenario,
  syncSimulationScenario,
  disconnectRecoveryScenario,
  latencyStressScenario,
  actionSpamScenario,
  reconnectLoopScenario,
  stateConsistencyScenario,
];
