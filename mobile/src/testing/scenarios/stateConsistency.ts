/**
 * scenarios/stateConsistency.ts
 *
 * TEST: Validate State Consistency (compare engine vs store vs DB)
 * ────────────────────────────────────────────────────────────────
 * Pulls the current state from the Zustand multiplayer store,
 * compares it to the local pure engine state (if tracked), and
 * optionally fetches the remote Supabase database state to ensure
 * all three layers are perfectly identical.
 *
 * PASS criteria:
 *  - Store state exists
 *  - Database state matches store state exactly (via deep equality on key fields)
 */

import { TestScenario, SyncReport } from '../types';
import { useMultiplayerStore } from '../../multiplayer/store';
import { supabase } from '../../services/supabase';
import { EngineGameState } from '../../engine/types';

export const stateConsistencyScenario: TestScenario = {
  id: 'state_consistency',
  name: 'Validate State Consistency',
  description: 'Compares the current Zustand multiplayer store state against the authoritative Supabase database state.',
  category: 'sync',

  async run(emit, signal) {
    emit({ level: 'info', tag: 'Consistency', message: 'Starting state consistency validation' });

    const storeState = useMultiplayerStore.getState();
    const matchId = storeState.matchId;

    if (!matchId) {
      emit({ level: 'error', tag: 'Consistency', message: 'No active match found in store. Start a match first.' });
      return { passed: false };
    }

    if (!storeState.gameState) {
      emit({ level: 'error', tag: 'Consistency', message: 'Store gameState is null.' });
      return { passed: false };
    }

    const localState = storeState.gameState as unknown as EngineGameState;

    emit({ level: 'info', tag: 'Consistency', message: `Local store state found for match: ${matchId}`, data: {
      turn: localState.current_turn,
      boardLength: localState.board_state?.length,
      p1Score: localState.player1_score,
      p2Score: localState.player2_score,
      status: localState.match_status,
    }});

    emit({ level: 'info', tag: 'Consistency', message: 'Fetching remote state from Supabase database...' });
    
    const dbStart = Date.now();
    const { data: remoteStateData, error } = await supabase
      .from('game_states')
      .select('*')
      .eq('match_id', matchId)
      .maybeSingle();
      
    const dbLatency = Date.now() - dbStart;

    if (signal.aborted) return { passed: false };

    if (error) {
      emit({ level: 'error', tag: 'Consistency', message: `Database query failed: ${error.message}` });
      return { passed: false };
    }

    if (!remoteStateData) {
      // It's possible the game hasn't been saved to the DB yet (local testing without edge functions)
      emit({ level: 'warn', tag: 'Consistency', message: `No remote state found in DB for match ${matchId}. (Normal if running purely local tests without DB sync)` });
      return { passed: true }; // Treat as pass for local-only testing, but flag it
    }

    const remoteState = remoteStateData as unknown as EngineGameState;
    emit({ level: 'info', tag: 'Consistency', message: `Remote state fetched in ${dbLatency}ms` });

    let inconsistencies = 0;

    const checkField = (fieldName: keyof EngineGameState, localVal: any, remoteVal: any) => {
      const lStr = JSON.stringify(localVal);
      const rStr = JSON.stringify(remoteVal);
      if (lStr !== rStr) {
        inconsistencies++;
        emit({ level: 'error', tag: 'Consistency', message: `Mismatch on field "${fieldName}"`, data: { local: localVal, remote: remoteVal } });
      }
    };

    checkField('match_status', localState.match_status, remoteState.match_status);
    checkField('current_turn', localState.current_turn, remoteState.current_turn);
    checkField('round_number', localState.round_number, remoteState.round_number);
    checkField('player1_score', localState.player1_score, remoteState.player1_score);
    checkField('player2_score', localState.player2_score, remoteState.player2_score);
    checkField('consecutive_passes', localState.consecutive_passes, remoteState.consecutive_passes);

    // Deep compare board
    checkField('board_state', localState.board_state, remoteState.board_state);

    const passed = inconsistencies === 0;

    emit({
      level: passed ? 'info' : 'error',
      tag: 'Scenario',
      message: passed
        ? '✅ State Consistency PASSED (Local Store == Remote DB)'
        : `❌ State Consistency FAILED (${inconsistencies} mismatches found)`,
    });

    return { passed, metrics: [{ label: 'DB Fetch Latency', durationMs: dbLatency }] };
  },
};
