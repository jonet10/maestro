import { useCallback, useState } from 'react';
import { router } from 'expo-router';
import { useAuthStore } from '../store/authStore';
import { useMatchStore } from '../store/matchStore';
import { initializeGame } from '../engine/gameInitializer';
import { GameMode } from '../engine/types';
import { mpLogger } from '../multiplayer/logger';

/**
 * useMatchCreation
 *
 * Creates a local test match immediately (no matchmaking server needed yet).
 * Generates two player IDs, initializes the engine, populates the match store,
 * and navigates to the match screen.
 *
 * This is intentionally temporary — future versions will call a Supabase Edge
 * Function to queue a real matchmaking session and receive a server-assigned matchId.
 */
export const useMatchCreation = () => {
  const [isLoading, setIsLoading] = useState(false);
  const { profile } = useAuthStore();
  const { setActiveMatch, startMatchmaking } = useMatchStore();

  const createLocalTestMatch = useCallback(async (mode?: GameMode) => {
    setIsLoading(true);
    startMatchmaking();

    try {
      const gameMode = mode ?? 'fives';

      const localPlayerId = `local_player_${Date.now()}`;
      const opponentId = `bot_opponent_${Date.now()}`;
      const matchId = `local_match_${Date.now()}`;
      const engineState = initializeGame(matchId, localPlayerId, opponentId, undefined, gameMode);

      setActiveMatch({
        matchId,
        localPlayerId,
        opponentId,
        engineState,
      });

      mpLogger.log('MatchCreation', 'Match ready, opening game screen');
      router.push('/match');
    } catch (err) {
      mpLogger.error('MatchCreation', 'Failed to create match', err);
    } finally {
      setIsLoading(false);
    }
  }, [setActiveMatch, startMatchmaking]);

  const navigateToDebug = useCallback(() => {
    const localPlayerId = profile?.id ?? `debug_player_${Date.now()}`;
    const opponentId = `debug_opponent_${Date.now()}`;
    const matchId = `debug_match_${Date.now()}`;

    const engineState = initializeGame(matchId, localPlayerId, opponentId);

    setActiveMatch({ matchId, localPlayerId, opponentId, engineState });
    router.push('/debug');
  }, [profile, setActiveMatch]);

  return {
    isLoading,
    createLocalTestMatch,
    navigateToDebug,
  };
};
