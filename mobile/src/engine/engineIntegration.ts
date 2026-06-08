import { EngineAction, EngineGameState } from './types';
import { dominoEngine } from './dominoEngine';
import { useMultiplayerStore } from '../multiplayer/store';
import { turnManager } from './turnManager';
import { mpLogger } from '../multiplayer/logger';
import { supabase } from '../services/supabase';

export const engineIntegration = {
  dispatchAction: (action: EngineAction) => {
    const currentState = useMultiplayerStore.getState().gameState as EngineGameState | null;
    
    if (!currentState) {
      mpLogger.warn('Engine', 'Cannot dispatch action without an active game state');
      return;
    }

    // 1. Run the pure engine reducer optimistically
    const nextState = dominoEngine(currentState, action);

    // 2. Prevent dispatching if the state didn't change (e.g., invalid move)
    if (nextState === currentState) {
      mpLogger.warn('Engine', 'Action was ignored (invalid or out of turn)', action);
      return;
    }

    // 3. Update the local Zustand store (Optimistic Update)
    useMultiplayerStore.getState().updateGameState(nextState as any, action.timestamp);

    // 4. Send action to Authoritative Server (Edge Function)
    // The Edge Function will validate the move and update PostgreSQL.
    // Supabase Realtime (Postgres changes) will notify the other player.
    const isLocalMatch = currentState.match_id.startsWith('local_match_') || currentState.match_id.startsWith('debug_match_');
    const isLocalPlayer = action.playerId.startsWith('local_player_') || action.playerId.startsWith('debug_player_');

    // Local/dev matches are offline by design: keep optimistic state and skip server validation.
    if (!isLocalMatch && !isLocalPlayer) {
      supabase.functions.invoke('play-move', {
        body: { matchId: currentState.match_id, action }
      }).then(async ({ data, error }) => {
        if (error) {
          let details: unknown = null;
          try {
            // functions-js attaches the raw Response on error.context in most runtimes.
            const ctx = (error as any)?.context;
            const res: Response | undefined = ctx?.response;
            if (res?.json) {
              details = await res.json();
            } else if (ctx?.json) {
              details = await ctx.json();
            } else {
              details = null;
            }
          } catch {
            details = null;
          }
          const ctx = (error as any)?.context;
          const status = (ctx?.response && typeof ctx.response.status === 'number') ? ctx.response.status : undefined;
          mpLogger.error('Engine', 'Server rejected move', {
            message: error.message,
            status,
            details,
          });
          // If rejected, the upcoming Realtime sync from DB will rollback our optimistic state
        }
        // (Optional) Keep for debugging; do not spam prod logs.
        void data;
      });
    }

    // 5. Manage Turn Timer
    if (nextState.match_status === 'in_progress') {
      turnManager.startTimer(nextState);
    } else {
      turnManager.clearTimer();
    }
  },

  syncState: (newState: EngineGameState, timestamp: number) => {
    // Called when a GAME_SYNC is received from the network
    useMultiplayerStore.getState().updateGameState(newState as any, timestamp);

    // Manage Turn Timer for the newly received state
    if (newState.match_status === 'in_progress') {
      turnManager.startTimer(newState);
    } else {
      turnManager.clearTimer();
    }
  }
};

turnManager.setDispatchCallback((action) => {
  engineIntegration.dispatchAction(action);
});
