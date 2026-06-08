import { useEffect, useRef, useState, useCallback } from 'react';
import { io, Socket } from 'socket.io-client';
import type { Tile, Player, BoardTile, GameState, Room } from '../types/game.types';

// ─── Wire format types (server ↔ client) ───────────────────────────
type ServerTile = [number, number];
type ServerPlayer = {
  id: string;
  name: string;
  isHost: boolean;
  isReady: boolean;
  totalScore: number;
  isConnected: boolean;
  handCount: number;
};
type ServerBoardTile = {
  tile: ServerTile;
  orientedTile: ServerTile;
  side: string;
  isDouble: boolean;
  isSpinner: boolean;
};
type ServerGameState = {
  board: ServerBoardTile[];
  boneyardCount: number;
  currentTurnIndex: number;
  roundNumber: number;
  consecutivePasses: number;
  lastPlayedPlayerIndex: number | null;
  roundStarterIndex: number;
  winnerId: string | null;
  roundEnded: boolean;
};
type ServerRoomSettings = {
  gameMode: string;
  targetScore: number;
  maxPlayers: 2 | 4;
  isPrivate: boolean;
};
type ServerRoomPublicState = {
  id: string;
  players: ServerPlayer[];
  settings: ServerRoomSettings;
  status: 'waiting' | 'playing' | 'finished';
  gameState: ServerGameState | null;
};

// ─── Private tile counter for generating stable IDs ────────────────
let tileCounter = 0;

function tileFromServer(t: ServerTile): Tile {
  return {
    left: t[0],
    right: t[1],
    id: `tile_${t[0]}_${t[1]}_${++tileCounter}`,
    isDouble: t[0] === t[1],
  };
}

function tileToServer(t: Tile): ServerTile {
  return [t.left, t.right];
}

// ─── Options & Return types ────────────────────────────────────────

export interface UseGameSocketOptions {
  /** Called when the match ends (final round finished). */
  onGameEnd?: (winner: Player, scores: Array<{ id: string; name: string; score: number }>) => void;
  /** Called when an error is emitted by the server. */
  onError?: (message: string) => void;
  /** Called when another player joins the room. */
  onPlayerJoined?: (player: Player) => void;
  /** Called when a player leaves the room. */
  onPlayerLeft?: (playerId: string) => void;
}

export interface UseGameSocketReturn {
  isConnected: boolean;
  currentRoom: Room | null;
  gameState: GameState | null;
  playerHand: Tile[];
  player: { id: string; name: string } | null;

  connect: (serverUrl: string, playerName: string) => void;
  disconnect: () => void;

  createRoom: (playerName: string, settings?: { gameMode?: string; targetScore?: number; maxPlayers?: 2 | 3 | 4 }) => void;
  joinRoom: (roomId: string, playerName: string) => void;
  leaveRoom: () => void;

  startGame: () => void;
  playTile: (tile: Tile, side: 'left' | 'right') => void;
  drawTile: () => void;
}

// ─── Hook ──────────────────────────────────────────────────────────

export function useGameSocket(options: UseGameSocketOptions = {}): UseGameSocketReturn {
  const { onGameEnd, onError, onPlayerJoined, onPlayerLeft } = options;

  const socketRef = useRef<Socket | null>(null);
  const playerNameRef = useRef<string>('');
  const currentRoomIdRef = useRef<string | null>(null);

  const [isConnected, setIsConnected] = useState(false);
  const [currentRoom, setCurrentRoom] = useState<Room | null>(null);
  const [gameState, setGameState] = useState<GameState | null>(null);
  const [playerHand, setPlayerHand] = useState<Tile[]>([]);
  const [player, setPlayer] = useState<{ id: string; name: string } | null>(null);

  // ─────────────────────────────────────────────────────────────────
  //  Server → Client model mapper
  // ─────────────────────────────────────────────────────────────────
  const mapServerRoom = useCallback((
    s: ServerRoomPublicState,
    yourHand: ServerTile[],
  ): { room: Room; game: GameState | null; tiles: Tile[] } => {
    const host = s.players.find((p) => p.isHost) ?? s.players[0];

    const mappedPlayers: Player[] = s.players.map((sp) => ({
      id: sp.id,
      username: sp.name,
      hand: [],
      score: sp.totalScore,
      isConnected: sp.isConnected,
      isReady: sp.isReady,
    }));

    const room: Room = {
      id: s.id,
      hostId: host?.id ?? '',
      players: mappedPlayers,
      gameState: null,
      maxPlayers: s.settings.maxPlayers <= 2 ? 2 : 4,
      status: s.status,
      createdAt: new Date(),
    };

    if (!s.gameState) return { room, game: null, tiles: [] };

    const ss = s.gameState;
    const tiles: Tile[] = (yourHand ?? []).map(tileFromServer);

    const board: BoardTile[] = (ss.board ?? []).map((bt, i) => ({
      tile: tileFromServer(bt.tile),
      orientation: bt.side === 'up' || bt.side === 'down' ? 'vertical' : 'horizontal',
      position: { x: i * 80, y: 0 },
    }));

    const currentPlayerId = s.players[ss.currentTurnIndex]?.id ?? '';

    const game: GameState = {
      roomId: s.id,
      players: mappedPlayers,
      board,
      boneyard: [],
      currentPlayerId,
      leftEnd: board[0]?.tile.left ?? 0,
      rightEnd: board[board.length - 1]?.tile.right ?? 0,
      status: ss.roundEnded ? 'finished' : 'playing',
      winner: ss.winnerId,
      round: ss.roundNumber,
    };

    return { room, game, tiles };
  }, []);

  // ─────────────────────────────────────────────────────────────────
  //  Socket event wiring
  // ─────────────────────────────────────────────────────────────────
  useEffect(() => {
    const socket = socketRef.current;
    if (!socket) return;

    // room:created
    socket.on('room:created', (data: { roomId: string; state: ServerRoomPublicState }) => {
      const { room, game, tiles } = mapServerRoom(data.state, data.state.gameState ? [] : []);
      currentRoomIdRef.current = data.roomId;
      setCurrentRoom(room);
      setGameState(game);
      setPlayerHand(tiles);
    });

    // room:joined
    socket.on('room:joined', (data: { state: ServerRoomPublicState }) => {
      const { room, game, tiles } = mapServerRoom(data.state, data.state.gameState ? [] : []);
      currentRoomIdRef.current = room.id;
      setCurrentRoom(room);
      setGameState(game);
      setPlayerHand(tiles);
    });

    // room:playerJoined
    socket.on('room:playerJoined', (data: { player: ServerPlayer }) => {
      const p: Player = {
        id: data.player.id,
        username: data.player.name,
        hand: [],
        score: data.player.totalScore,
        isConnected: data.player.isConnected,
        isReady: data.player.isReady,
      };
      onPlayerJoined?.(p);
      setCurrentRoom((prev: Room | null) => {
        if (!prev || prev.players.some((pl) => pl.id === p.id)) return prev;
        return { ...prev, players: [...prev.players, p] };
      });
    });

    // room:playerLeft
    socket.on('room:playerLeft', (data: { playerId: string }) => {
      onPlayerLeft?.(data.playerId);
      setCurrentRoom((prev: Room | null) => {
        if (!prev) return prev;
        return { ...prev, players: prev.players.filter((pl) => pl.id !== data.playerId) };
      });
    });

    // room:updated
    socket.on('room:updated', (data: { state: ServerRoomPublicState }) => {
      const { room, game, tiles } = mapServerRoom(data.state, data.state.gameState ? [] : []);
      setCurrentRoom(room);
      setGameState(game);
      if (tiles.length > 0) setPlayerHand(tiles);
    });

    // game:started
    socket.on('game:started', (data: { state: ServerRoomPublicState & { yourHand: ServerTile[] } }) => {
      const { room, game, tiles } = mapServerRoom(data.state, data.state.yourHand ?? []);
      setCurrentRoom(room);
      setGameState(game);
      setPlayerHand(tiles);
    });

    // game:tilePlayed
    socket.on('game:tilePlayed', (data: {
      playerId: string;
      tile: ServerTile;
      side: string;
      board: ServerBoardTile[];
      playerScores: Array<{ id: string; score: number }>;
    }) => {
      setCurrentRoom((prev: Room | null) => {
        if (!prev) return prev;
        return {
          ...prev,
          players: prev.players.map((p) => {
            const s = data.playerScores.find((ps) => ps.id === p.id);
            return s ? { ...p, score: s.score } : p;
          }),
        };
      });

      setGameState((prev: GameState | null) => {
        if (!prev) return prev;
        const board: BoardTile[] = data.board.map((bt, i) => ({
          tile: tileFromServer(bt.tile),
          orientation: bt.side === 'up' || bt.side === 'down' ? 'vertical' : 'horizontal',
          position: { x: i * 80, y: 0 },
        }));
        return {
          ...prev,
          board,
          leftEnd: board[0]?.tile.left ?? 0,
          rightEnd: board[board.length - 1]?.tile.right ?? 0,
        };
      });

      if (data.playerId === player?.id) {
        setPlayerHand((prev: Tile[]) => prev.filter((t) => {
          const st = tileToServer(t);
          return st[0] !== data.tile[0] || st[1] !== data.tile[1];
        }));
      }
    });

    // game:tileDrawn (private → { tile, hand, boneyardCount } OR public → { playerId, handCount, boneyardCount })
    socket.on('game:tileDrawn', (data: {
      tile?: ServerTile;
      hand?: ServerTile[];
      boneyardCount?: number;
      playerId?: string;
      handCount?: number;
    }) => {
      if (data.hand) {
        setPlayerHand(data.hand.map(tileFromServer));
      }
      if (data.playerId && data.handCount !== undefined) {
        setCurrentRoom((prev: Room | null) => {
          if (!prev) return prev;
          return {
            ...prev,
            players: prev.players.map((p) =>
              p.id === data.playerId ? { ...p, hand: [] as Tile[] } : p,
            ),
          };
        });
      }
    });

    // game:turnChanged
    socket.on('game:turnChanged', (data: { currentTurnIndex: number }) => {
      setGameState((prev: GameState | null) => {
        if (!prev || !currentRoom) return prev;
        const pid = currentRoom.players[data.currentTurnIndex]?.id ?? '';
        return { ...prev, currentPlayerId: pid };
      });
    });

    // game:passed
    socket.on('game:passed', (_data: { playerId: string }) => {
      // Turn change is handled by game:turnChanged
    });

    // game:roundEnded
    socket.on('game:roundEnded', (data: {
      winnerId: string;
      scores: Array<{ id: string; score: number }>;
      isMatchEnd: boolean;
    }) => {
      setCurrentRoom((prev: Room | null) => {
        if (!prev) return prev;
        return {
          ...prev,
          players: prev.players.map((p) => {
            const s = data.scores.find((sc) => sc.id === p.id);
            return s ? { ...p, score: s.score } : p;
          }),
        };
      });

      setGameState((prev: GameState | null) => {
        if (!prev) return prev;
        return { ...prev, status: data.isMatchEnd ? 'finished' : prev.status, winner: data.winnerId };
      });

      setPlayerHand([]);
    });

    // game:ended
    socket.on('game:ended', (data: {
      winnerId: string;
      winnerName: string;
      scores: Array<{ id: string; name: string; score: number }>;
    }) => {
      setGameState((prev: GameState | null) => {
        if (!prev) return prev;
        return { ...prev, status: 'finished', winner: data.winnerId };
      });

      const winnerEntry = data.scores.find((s) => s.id === data.winnerId);
      if (winnerEntry && currentRoom) {
        const winnerPlayer: Player = {
          id: data.winnerId,
          username: data.winnerName,
          hand: [],
          score: winnerEntry.score,
          isConnected: true,
          isReady: false,
        };
        onGameEnd?.(winnerPlayer, data.scores);
      }

      setPlayerHand([]);
    });

    // error
    socket.on('error', (data: { message: string }) => {
      onError?.(data.message);
    });

    return () => {
      socket.removeAllListeners();
    };
    // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [mapServerRoom, onGameEnd, onError, onPlayerJoined, onPlayerLeft, player?.id, currentRoom]);

  // ─────────────────────────────────────────────────────────────────
  //  Public API
  // ─────────────────────────────────────────────────────────────────

  const connect = useCallback((serverUrl: string, playerName: string) => {
    if (socketRef.current?.connected) return;
    playerNameRef.current = playerName;

    const socket = io(serverUrl, {
      autoConnect: true,
      reconnection: true,
      reconnectionAttempts: Infinity,
      reconnectionDelay: 1000,
      reconnectionDelayMax: 5000,
      timeout: 10000,
    });

    socket.on('connect', () => {
      setIsConnected(true);
      setPlayer({ id: socket.id ?? '', name: playerNameRef.current });
    });

    socket.on('disconnect', () => {
      setIsConnected(false);
    });

    socket.on('connect_error', (err: Error) => {
      onError?.(`Connexion impossible : ${err.message}`);
    });

    socketRef.current = socket;
  }, [onError]);

  const disconnect = useCallback(() => {
    socketRef.current?.disconnect();
    socketRef.current = null;
    setIsConnected(false);
    setCurrentRoom(null);
    setGameState(null);
    setPlayerHand([]);
    setPlayer(null);
    currentRoomIdRef.current = null;
  }, []);

  const createRoom = useCallback((
    playerName: string,
    settings?: { gameMode?: string; targetScore?: number; maxPlayers?: 2 | 3 | 4 },
  ) => {
    socketRef.current?.emit('room:create', {
      playerName: playerName || playerNameRef.current,
      settings,
    });
  }, []);

  const joinRoom = useCallback((roomId: string, playerName: string) => {
    socketRef.current?.emit('room:join', {
      roomId,
      playerName: playerName || playerNameRef.current,
    });
  }, []);

  const leaveRoom = useCallback(() => {
    const roomId = currentRoomIdRef.current;
    if (!roomId) return;
    socketRef.current?.emit('room:leave', { roomId });
    currentRoomIdRef.current = null;
    setCurrentRoom(null);
    setGameState(null);
    setPlayerHand([]);
  }, []);

  const startGame = useCallback(() => {
    const roomId = currentRoomIdRef.current;
    if (!roomId) return;
    socketRef.current?.emit('game:start', { roomId });
  }, []);

  const playTile = useCallback((tile: Tile, side: 'left' | 'right') => {
    const roomId = currentRoomIdRef.current;
    if (!roomId) return;
    socketRef.current?.emit('game:playTile', {
      roomId,
      tile: tileToServer(tile),
      side,
    });
  }, []);

  const drawTile = useCallback(() => {
    const roomId = currentRoomIdRef.current;
    if (!roomId) return;
    socketRef.current?.emit('game:draw', { roomId });
  }, []);

  return {
    isConnected,
    currentRoom,
    gameState,
    playerHand,
    player,
    connect,
    disconnect,
    createRoom,
    joinRoom,
    leaveRoom,
    startGame,
    playTile,
    drawTile,
  };
}
