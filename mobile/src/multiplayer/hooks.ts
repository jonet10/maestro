import { useEffect } from 'react';
import { realtimeManager } from './realtime';
import { useMultiplayerStore } from './store';
import { useAuthStore } from '../store/authStore';

export const useMultiplayerMatch = (matchId: string) => {
  const { profile } = useAuthStore();
  const state = useMultiplayerStore();

  useEffect(() => {
    if (matchId && profile && !matchId.startsWith('debug_match_') && !matchId.startsWith('local_match_')) {
      realtimeManager.connect(matchId, profile.id, profile.username);
    }

    return () => {
      realtimeManager.disconnect();
    };
  }, [matchId, profile]);

  return {
    connectionState: state.connectionState,
    players: state.players,
    gameState: state.gameState,
    broadcast: realtimeManager.broadcast.bind(realtimeManager),
  };
};
