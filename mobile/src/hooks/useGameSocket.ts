import { useEffect } from 'react';
import { io, Socket } from 'socket.io-client';
import { create } from 'zustand';
import type {
  BoardTile,
  GameState,
  Player,
  Room,
  Tile,
} from '../../../server/src/types/game.types';

/** Side of the board where a tile can be played. */
export type PlaySide = 'left' | 'right';

/** Score item returned by the server when a match ends. */
export interface Score {
  /** Player identifier for this score row. */
  playerId: string;
  /** Final or current score for the player. */
  score: number;
}

/** Optional callbacks fired by socket listeners. */
export interface UseGameSocketCallbacks {
  /** Fired when the server announces the end of a game. */
  onGameEnd?: (winner: Player, scores: Score[]) => void;
  /** Fired when the server sends a game-level error. */
  onError?: (message: string) => void;
  /** Fired when another player joins the current room. */
  onPlayerJoined?: (player: Player) => void;
}

/** Settings accepted by the room:create event. */
export interface CreateRoomSettings {
  /** Maximum number of players allowed in the room. */
  maxPlayers?: 2 | 3 | 4;
  /** Number of tiles dealt to each player. */
  tilesPerPlayer?: number;
  /** Target score required to win the match. */
  targetScore?: number;
  /** Whether the room should be hidden from public listings. */
  isPrivate?: boolean;
}

interface RoomCreatedPayload {
  roomId: string;
  state: Room;
}

interface RoomStatePayload {
  state: Room;
}

interface PlayerJoinedPayload {
  player?: Player;
  state?: Room;
}

interface TilePlayedPayload {
  board?: BoardTile[];
  state?: Room;
}

interface TileDrawnPayload {
  tile?: Tile | null;
  state?: Room;
}

interface GameEndedPayload {
  winner?: Player;
  winnerId?: string;
  scores?: Score[] | Record<string, number>;
  state?: Room;
}

interface ErrorPayload {
  message?: string;
}

interface GameSocketStore {
  socket: Socket | null;
  playerId: string | null;
  isConnected: boolean;
  currentRoom: Room | null;
  gameState: GameState | null;
  callbacks: UseGameSocketCallbacks;
  setCallbacks: (callbacks: UseGameSocketCallbacks) => void;
  connect: (serverUrl: string, playerId: string) => void;
  disconnect: () => void;
  createRoom: (settings?: CreateRoomSettings) => void;
  joinRoom: (roomId: string) => void;
  leaveRoom: () => void;
  startGame: () => void;
  playTile: (tile: Tile, side: PlaySide) => void;
  drawTile: () => void;
}

const events = {
  roomCreate: 'room:create',
  roomCreated: 'room:created',
  roomJoin: 'room:join',
  roomJoined: 'room:joined',
  roomPlayerJoined: 'room:playerJoined',
  roomLeave: 'room:leave',
  roomPlayerLeft: 'room:playerLeft',
  gameStart: 'game:start',
  gameStarted: 'game:started',
  gamePlayTile: 'game:playTile',
  gameTilePlayed: 'game:tilePlayed',
  gameTileePlayed: 'game:tileePlayed',
  gameDraw: 'game:draw',
  gameTileDrawn: 'game:tileDrawn',
  gameEnded: 'game:ended',
  gameError: 'game:error',
} as const;

/**
 * Zustand store that owns the Socket.io client and shared realtime state.
 */
const useGameSocketStore = create<GameSocketStore>((set, get) => ({
  socket: null,
  playerId: null,
  isConnected: false,
  currentRoom: null,
  gameState: null,
  callbacks: {},

  /** Updates callbacks without reconnecting the socket. */
  setCallbacks: (callbacks) => {
    set({ callbacks });
  },

  /** Connects to the Maestro Domino backend with automatic reconnection. */
  connect: (serverUrl, playerId) => {
    const existingSocket = get().socket;
    if (existingSocket) {
      existingSocket.disconnect();
    }

    const socket = io(serverUrl, {
      autoConnect: true,
      reconnection: true,
      reconnectionAttempts: Infinity,
      reconnectionDelay: 750,
      reconnectionDelayMax: 5000,
      transports: ['websocket'],
      query: { playerId },
    });

    registerSocketListeners(socket, set, get);
    set({ socket, playerId, isConnected: false });
  },

  /** Disconnects cleanly and clears local realtime state. */
  disconnect: () => {
    const socket = get().socket;
    socket?.removeAllListeners();
    socket?.disconnect();
    set({
      socket: null,
      playerId: null,
      isConnected: false,
      currentRoom: null,
      gameState: null,
    });
  },

  /** Emits room:create and lets room:created update currentRoom. */
  createRoom: (settings = {}) => {
    const { socket, playerId } = get();
    if (!socket || !playerId) {
      notifyError('Socket non connectee.');
      return;
    }

    socket.emit(events.roomCreate, { playerId, settings });
  },

  /** Emits room:join for the requested room id. */
  joinRoom: (roomId) => {
    const { socket, playerId } = get();
    if (!socket || !playerId) {
      notifyError('Socket non connectee.');
      return;
    }

    socket.emit(events.roomJoin, { roomId, playerId });
  },

  /** Emits room:leave for the current room and clears local room state. */
  leaveRoom: () => {
    const { socket, playerId, currentRoom } = get();
    if (!socket || !playerId || !currentRoom) {
      return;
    }

    socket.emit(events.roomLeave, { roomId: currentRoom.id, playerId });
    set({ currentRoom: null, gameState: null });
  },

  /** Emits game:start for the current room. */
  startGame: () => {
    const { socket, playerId, currentRoom } = get();
    if (!socket || !playerId || !currentRoom) {
      notifyError('Aucune room active.');
      return;
    }

    socket.emit(events.gameStart, { roomId: currentRoom.id, playerId });
  },

  /** Emits game:playTile for the active room. */
  playTile: (tile, side) => {
    const { socket, playerId, currentRoom } = get();
    if (!socket || !playerId || !currentRoom) {
      notifyError('Aucune room active.');
      return;
    }

    socket.emit(events.gamePlayTile, {
      roomId: currentRoom.id,
      playerId,
      tile,
      side,
    });
  },

  /** Emits game:draw for the active room. */
  drawTile: () => {
    const { socket, playerId, currentRoom } = get();
    if (!socket || !playerId || !currentRoom) {
      notifyError('Aucune room active.');
      return;
    }

    socket.emit(events.gameDraw, { roomId: currentRoom.id, playerId });
  },
}));

/**
 * Public hook used by screens/components.
 */
export function useGameSocket(callbacks: UseGameSocketCallbacks = {}) {
  const store = useGameSocketStore();

  /** Keeps optional callbacks fresh without resetting the connection. */
  useEffect(() => {
    store.setCallbacks(callbacks);
  }, [callbacks, store]);

  return {
    isConnected: store.isConnected,
    currentRoom: store.currentRoom,
    gameState: store.gameState,
    connect: store.connect,
    disconnect: store.disconnect,
    createRoom: store.createRoom,
    joinRoom: store.joinRoom,
    leaveRoom: store.leaveRoom,
    startGame: store.startGame,
    playTile: store.playTile,
    drawTile: store.drawTile,
  };
}

/**
 * Registers every server listener used by the hook.
 */
function registerSocketListeners(
  socket: Socket,
  set: (partial: Partial<GameSocketStore>) => void,
  get: () => GameSocketStore,
): void {
  socket.on('connect', () => {
    set({ isConnected: true });
  });

  socket.on('disconnect', () => {
    set({ isConnected: false });
  });

  socket.on('reconnect', () => {
    const { currentRoom, playerId } = get();
    if (currentRoom && playerId) {
      socket.emit('game:reconnect', { roomId: currentRoom.id, playerId });
    }
  });

  socket.on(events.roomCreated, (payload: RoomCreatedPayload) => {
    setRoomState(payload.state, set);
  });

  socket.on(events.roomJoined, (payload: RoomStatePayload) => {
    setRoomState(payload.state, set);
  });

  socket.on(events.roomPlayerJoined, (payload: PlayerJoinedPayload) => {
    if (payload.state) {
      setRoomState(payload.state, set);
    }

    if (payload.player) {
      get().callbacks.onPlayerJoined?.(payload.player);
    }
  });

  socket.on(events.roomPlayerLeft, (payload: RoomStatePayload) => {
    if (payload.state) {
      setRoomState(payload.state, set);
    }
  });

  socket.on(events.gameStarted, (payload: RoomStatePayload) => {
    setRoomState(payload.state, set);
  });

  socket.on(events.gameTilePlayed, (payload: TilePlayedPayload) => {
    mergeTilePlayed(payload, set, get);
  });

  socket.on(events.gameTileePlayed, (payload: TilePlayedPayload) => {
    mergeTilePlayed(payload, set, get);
  });

  socket.on(events.gameTileDrawn, (payload: TileDrawnPayload) => {
    if (payload.state) {
      setRoomState(payload.state, set);
    }
  });

  socket.on(events.gameEnded, (payload: GameEndedPayload) => {
    if (payload.state) {
      setRoomState(payload.state, set);
    }

    const winner = resolveWinner(payload, get().currentRoom);
    const scores = normalizeScores(payload.scores);
    if (winner) {
      get().callbacks.onGameEnd?.(winner, scores);
    }
  });

  socket.on(events.gameError, (payload: ErrorPayload) => {
    notifyError(payload.message ?? 'Erreur inconnue.');
  });
}

/**
 * Writes a full room snapshot into hook state.
 */
function setRoomState(
  room: Room,
  set: (partial: Partial<GameSocketStore>) => void,
): void {
  set({
    currentRoom: room,
    gameState: room.gameState,
  });
}

/**
 * Merges a tile-played event into the local board when no full room snapshot is provided.
 */
function mergeTilePlayed(
  payload: TilePlayedPayload,
  set: (partial: Partial<GameSocketStore>) => void,
  get: () => GameSocketStore,
): void {
  if (payload.state) {
    setRoomState(payload.state, set);
    return;
  }

  const currentGameState = get().gameState;
  if (!currentGameState || !payload.board) {
    return;
  }

  set({
    gameState: {
      ...currentGameState,
      board: payload.board,
    },
  });
}

/**
 * Resolves the winner object from a game:ended payload.
 */
function resolveWinner(payload: GameEndedPayload, room: Room | null): Player | null {
  if (payload.winner) {
    return payload.winner;
  }

  if (!payload.winnerId || !room) {
    return null;
  }

  return room.players.find((player) => player.id === payload.winnerId) ?? null;
}

/**
 * Normalizes score payloads from arrays or score maps.
 */
function normalizeScores(scores: GameEndedPayload['scores']): Score[] {
  if (!scores) {
    return [];
  }

  if (Array.isArray(scores)) {
    return scores;
  }

  return Object.entries(scores).map(([playerId, score]) => ({ playerId, score }));
}

/**
 * Sends errors to the active callback when one is registered.
 */
function notifyError(message: string): void {
  useGameSocketStore.getState().callbacks.onError?.(message);
}

/*
Example:

const {
  isConnected,
  currentRoom,
  gameState,
  connect,
  createRoom,
  joinRoom,
  startGame,
  playTile,
  drawTile,
  disconnect,
} = useGameSocket({
  onPlayerJoined: (player) => console.log('Player joined', player.username),
  onGameEnd: (winner, scores) => console.log('Winner', winner.username, scores),
  onError: (message) => console.warn(message),
});

useEffect(() => {
  connect('http://localhost:3000', user.id);
  return disconnect;
}, [connect, disconnect, user.id]);

createRoom({ maxPlayers: 4, targetScore: 100 });
joinRoom('ABC123');
startGame();
playTile(tile, 'left');
drawTile();
*/
