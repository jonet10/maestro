import {
  GameState,
  Player,
  PlayerRoomState,
  PublicRoomState,
  Room,
  RoomSettings,
} from './types';

const DEFAULT_ROOM_SETTINGS: RoomSettings = {
  maxPlayers: 4,
  tilesPerPlayer: 7,
  targetScore: 100,
  isPrivate: false,
};

/**
 * RoomManager owns the in-memory room registry.
 * It never persists realtime state; every room lives in this Map until deleted.
 */
export class RoomManager {
  private readonly rooms = new Map<string, Room>();

  createRoom(hostId: string, settings: Partial<RoomSettings> = {}): Room {
    const roomId = this.generateRoomId();
    const host: Player = {
      id: hostId,
      hand: [],
      isHost: true,
      isConnected: true,
      score: 0,
    };

    const gameState: GameState = {
      board: [],
      boneyard: [],
      currentTurnIndex: 0,
      startedAt: null,
      endedAt: null,
      winnerId: null,
      scores: { [hostId]: 0 },
    };

    const room: Room = {
      id: roomId,
      players: [host],
      status: 'waiting',
      settings: { ...DEFAULT_ROOM_SETTINGS, ...settings },
      gameState,
      createdAt: new Date().toISOString(),
    };

    this.rooms.set(roomId, room);
    return room;
  }

  joinRoom(roomId: string, playerId: string): Room {
    const room = this.getRoomOrThrow(roomId);

    if (room.status !== 'waiting') {
      throw new Error('Impossible de rejoindre une partie deja demarree.');
    }

    const existingPlayer = room.players.find((player) => player.id === playerId);
    if (existingPlayer) {
      existingPlayer.isConnected = true;
      return room;
    }

    if (room.players.length >= room.settings.maxPlayers) {
      throw new Error('La room est complete.');
    }

    room.players.push({
      id: playerId,
      hand: [],
      isHost: false,
      isConnected: true,
      score: 0,
    });
    room.gameState.scores[playerId] = 0;

    return room;
  }

  leaveRoom(roomId: string, playerId: string): Room | null {
    const room = this.rooms.get(roomId);
    if (!room) {
      return null;
    }

    const leavingPlayer = room.players.find((player) => player.id === playerId);
    room.players = room.players.filter((player) => player.id !== playerId);
    delete room.gameState.scores[playerId];

    if (room.players.length === 0) {
      this.rooms.delete(roomId);
      return null;
    }

    if (leavingPlayer?.isHost && room.players[0]) {
      room.players[0].isHost = true;
    }

    if (room.status === 'playing') {
      room.status = 'finished';
      room.gameState.endedAt = new Date().toISOString();
      room.gameState.winnerId = room.players[0]?.id ?? null;
    }

    return room;
  }

  getRoomState(roomId: string): PublicRoomState {
    return this.toPublicState(this.getRoomOrThrow(roomId));
  }

  getRoomStateForPlayer(roomId: string, playerId: string): PlayerRoomState {
    const room = this.getRoomOrThrow(roomId);
    const player = room.players.find((candidate) => candidate.id === playerId);

    if (!player) {
      throw new Error('Joueur introuvable dans cette room.');
    }

    return {
      ...this.toPublicState(room),
      playerHand: player.hand,
    };
  }

  getRoom(roomId: string): Room | undefined {
    return this.rooms.get(roomId);
  }

  getRoomOrThrow(roomId: string): Room {
    const room = this.rooms.get(roomId);
    if (!room) {
      throw new Error('Room introuvable.');
    }
    return room;
  }

  markConnected(roomId: string, playerId: string, isConnected: boolean): Room {
    const room = this.getRoomOrThrow(roomId);
    const player = room.players.find((candidate) => candidate.id === playerId);

    if (!player) {
      throw new Error('Joueur introuvable dans cette room.');
    }

    player.isConnected = isConnected;
    return room;
  }

  findRoomsByPlayer(playerId: string): Room[] {
    return [...this.rooms.values()].filter((room) =>
      room.players.some((player) => player.id === playerId),
    );
  }

  private toPublicState(room: Room): PublicRoomState {
    return {
      id: room.id,
      players: room.players.map((player) => ({
        id: player.id,
        isHost: player.isHost,
        isConnected: player.isConnected,
        score: player.score,
        handCount: player.hand.length,
      })),
      status: room.status,
      settings: room.settings,
      gameState: {
        board: room.gameState.board,
        boneyardCount: room.gameState.boneyard.length,
        currentTurnIndex: room.gameState.currentTurnIndex,
        startedAt: room.gameState.startedAt,
        endedAt: room.gameState.endedAt,
        winnerId: room.gameState.winnerId,
        scores: room.gameState.scores,
      },
    };
  }

  private generateRoomId(): string {
    const alphabet = 'ABCDEFGHJKLMNPQRSTUVWXYZ23456789';
    let roomId = '';

    do {
      roomId = Array.from({ length: 6 }, () =>
        alphabet[Math.floor(Math.random() * alphabet.length)],
      ).join('');
    } while (this.rooms.has(roomId));

    return roomId;
  }
}

export const roomManager = new RoomManager();
