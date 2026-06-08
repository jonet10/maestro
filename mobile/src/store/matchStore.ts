import { create } from 'zustand';
import { persist, createJSONStorage } from 'zustand/middleware';
import AsyncStorage from '@react-native-async-storage/async-storage';
import { EngineGameState, GameMode } from '../engine/types';
import type { AIDifficulty } from '../engine/aiPlayer';

interface MatchSession {
  matchId: string;
  localPlayerId: string;
  opponentId: string;
  engineState: EngineGameState;
}

interface MatchStoreState {
  activeMatch: MatchSession | null;
  isMatchmaking: boolean;
  gameMode: GameMode;
  aiDifficulty: AIDifficulty;

  startMatchmaking: () => void;
  setActiveMatch: (session: MatchSession) => void;
  updateEngineState: (state: EngineGameState) => void;
  setGameMode: (mode: GameMode) => void;
  setAIDifficulty: (level: AIDifficulty) => void;
  clearMatch: () => void;
}

export const useMatchStore = create<MatchStoreState>()(
  persist(
    (set) => ({
      activeMatch: null,
      isMatchmaking: false,
      gameMode: 'fives',
      aiDifficulty: 'medium',

      startMatchmaking: () => set({ isMatchmaking: true }),

      setActiveMatch: (session) =>
        set({ activeMatch: session, isMatchmaking: false }),

      updateEngineState: (state) =>
        set((s) => {
          if (!s.activeMatch) return s;
          return { activeMatch: { ...s.activeMatch, engineState: state } };
        }),

      setGameMode: (mode) => set({ gameMode: mode }),

      setAIDifficulty: (level) => set({ aiDifficulty: level }),

      clearMatch: () =>
        set({ activeMatch: null, isMatchmaking: false }),
    }),
    {
      name: 'maestro-match-storage',
      storage: createJSONStorage(() => AsyncStorage),
      partialize: (state) => ({
        // Only persist local matches (not online ones with real matchIds)
        activeMatch: state.activeMatch?.matchId?.startsWith('local_')
          ? state.activeMatch
          : null,
        gameMode: state.gameMode,
        aiDifficulty: state.aiDifficulty,
      }),
    }
  )
);
