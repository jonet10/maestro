import { realtimeManager } from './realtime';
import { useMultiplayerStore } from './store';
import { mpLogger } from './logger';
import { GameState } from './types';

export const testUtils = {
  // Simulate receiving a broadcast from the opponent
  simulateOpponentMove: (playerId: string, tile: any, side: string) => {
    mpLogger.log('TestUtils', `Simulating opponent move...`);
    // Note: Since the manager's channel handles incoming broadcasts, we can simulate
    // it by bypassing the network and directly invoking the handler if we exposed it, 
    // or by broadcasting it to ourselves (Supabase channels receive their own broadcasts if configured, 
    // but typically we'd just update the store directly for testing).
    
    // Simulating a GAME_SYNC from the server after the move is validated
    const mockState: GameState = {
      id: 'test-game-state',
      match_id: useMultiplayerStore.getState().matchId || 'test-match',
      board_state: [{ tile, side }],
      player1_hand: [],
      player2_hand: [],
      boneyard: [],
      current_turn: 'my-player-id', // Turn passes back to me
      round_number: 1,
      created_at: new Date().toISOString(),
    } as unknown as GameState;

    useMultiplayerStore.getState().updateGameState(mockState, Date.now());
  },

  // Simulates a network disconnect
  simulateDisconnect: () => {
    mpLogger.warn('TestUtils', 'Simulating network disconnect');
    realtimeManager.disconnect();
    useMultiplayerStore.getState().setConnectionState('disconnected');
  },

  // Simulates latency by wrapping a broadcast call
  broadcastWithLatency: (event: any, latencyMs: number = 1000) => {
    mpLogger.log('TestUtils', `Queueing broadcast with ${latencyMs}ms latency`);
    setTimeout(() => {
      realtimeManager.broadcast(event);
    }, latencyMs);
  }
};
