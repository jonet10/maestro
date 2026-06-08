import { create } from 'zustand';
import { GameState, ConnectionState, DragPreview, PlayerPresence } from './types';

interface MultiplayerState {
  matchId: string | null;
  connectionState: ConnectionState;
  players: Record<string, PlayerPresence>;
  remoteDragPreview: DragPreview | null;
  gameState: GameState | null;
  lastEventTimestamp: number;
  
  // Actions
  setMatchId: (id: string | null) => void;
  setConnectionState: (state: ConnectionState) => void;
  updatePresence: (presences: PlayerPresence[]) => void;
  updateGameState: (state: GameState, timestamp: number) => void;
  setRemoteDragPreview: (preview: DragPreview | null) => void;
  reset: () => void;
}

export const useMultiplayerStore = create<MultiplayerState>((set) => ({
  matchId: null,
  connectionState: 'disconnected',
  players: {},
  remoteDragPreview: null,
  gameState: null,
  lastEventTimestamp: 0,

  setMatchId: (id) => set({ matchId: id }),
  setConnectionState: (state) => set({ connectionState: state }),
  updatePresence: (presences) => set((state) => {
    const newPlayers = { ...state.players };
    presences.forEach((p) => {
      newPlayers[p.id] = p;
    });
    return { players: newPlayers };
  }),
  updateGameState: (gameState, timestamp) => set((state) => {
    // Always accept the first snapshot, even if timestamp is 0.
    if (!state.gameState) {
      return { gameState, lastEventTimestamp: timestamp };
    }
    // Then only accept strictly newer updates to prevent desync.
    if (timestamp > state.lastEventTimestamp) {
      return { gameState, lastEventTimestamp: timestamp };
    }
    return state;
  }),
  setRemoteDragPreview: (preview) => set({ remoteDragPreview: preview }),
  reset: () => set({
    matchId: null,
    connectionState: 'disconnected',
    players: {},
    remoteDragPreview: null,
    gameState: null,
    lastEventTimestamp: 0
  }),
}));
