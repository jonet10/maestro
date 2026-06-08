import { Server, Socket } from 'socket.io';
import { DominoGame } from '../game/DominoGame';
import { RoomManager, roomManager as defaultRoomManager } from '../game/RoomManager';
import { BoardSide, RoomSettings, Tile } from '../game/types';

interface PlayerPayload {
  playerId?: string;
}

interface RoomPayload extends PlayerPayload {
  roomId: string;
}

/**
 * Registers all realtime room and game events.
 * The module keeps Socket.io concerns here and delegates rules/state changes
 * to RoomManager and DominoGame.
 */
export function gameSocket(
  io: Server,
  roomManager: RoomManager = defaultRoomManager,
): void {
  const dominoGame = new DominoGame(roomManager);

  io.on('connection', (socket: Socket) => {
    socket.on('room:create', (payload: PlayerPayload & { settings?: Partial<RoomSettings> }) => {
      try {
        const playerId = getPlayerId(socket, payload);
        rememberPlayer(socket, playerId);
        const room = roomManager.createRoom(playerId, payload.settings);

        socket.join(playerId);
        socket.join(room.id);
        socket.emit('room:created', {
          roomId: room.id,
          state: roomManager.getRoomStateForPlayer(room.id, playerId),
        });
      } catch (error) {
        emitError(socket, error);
      }
    });

    socket.on('room:join', (payload: RoomPayload) => {
      try {
        const playerId = getPlayerId(socket, payload);
        rememberPlayer(socket, playerId);
        const room = roomManager.joinRoom(payload.roomId, playerId);

        socket.join(playerId);
        socket.join(room.id);
        socket.emit('room:joined', {
          state: roomManager.getRoomStateForPlayer(room.id, playerId),
        });
        socket.to(room.id).emit('room:playerJoined', {
          playerId,
          state: roomManager.getRoomState(room.id),
        });
      } catch (error) {
        emitError(socket, error);
      }
    });

    socket.on('room:leave', (payload: RoomPayload) => {
      try {
        const playerId = getPlayerId(socket, payload);
        rememberPlayer(socket, playerId);
        const room = roomManager.leaveRoom(payload.roomId, playerId);

        socket.leave(payload.roomId);
        io.to(payload.roomId).emit('room:playerLeft', {
          playerId,
          state: room ? roomManager.getRoomState(payload.roomId) : null,
        });
      } catch (error) {
        emitError(socket, error);
      }
    });

    socket.on('game:start', (payload: RoomPayload) => {
      try {
        const playerId = getPlayerId(socket, payload);
        rememberPlayer(socket, playerId);
        socket.join(playerId);
        const room = roomManager.getRoomOrThrow(payload.roomId);
        const player = room.players.find((candidate) => candidate.id === playerId);

        if (!player?.isHost) {
          throw new Error('Seul le host peut demarrer la partie.');
        }

        dominoGame.startGame(payload.roomId);
        broadcastPrivateStates(io, roomManager, payload.roomId, 'game:started');
      } catch (error) {
        emitError(socket, error);
      }
    });

    socket.on(
      'game:playTile',
      (payload: RoomPayload & { tile: Tile; side: BoardSide }) => {
        try {
          const playerId = getPlayerId(socket, payload);
          rememberPlayer(socket, playerId);
          const result = dominoGame.playTile(
            payload.roomId,
            playerId,
            payload.tile,
            payload.side,
          );

          io.to(payload.roomId).emit('game:tileePlayed', {
            playerId,
            tile: result.tile,
            side: result.side,
            board: result.room.gameState.board,
            scores: result.scores,
            currentTurnIndex: result.room.gameState.currentTurnIndex,
          });

          if (result.winner) {
            io.to(payload.roomId).emit('game:ended', {
              winnerId: result.winner.id,
              scores: result.scores,
              state: roomManager.getRoomState(payload.roomId),
            });
          }
        } catch (error) {
          emitError(socket, error);
        }
      },
    );

    socket.on('game:draw', (payload: RoomPayload) => {
      try {
        const playerId = getPlayerId(socket, payload);
        rememberPlayer(socket, playerId);
        const result = dominoGame.drawTile(payload.roomId, playerId);

        socket.emit('game:tileDrawn', {
          tile: result.tile,
          state: roomManager.getRoomStateForPlayer(payload.roomId, playerId),
        });
        socket.to(payload.roomId).emit('game:playerDrew', {
          playerId,
          handCount: result.player.hand.length,
          boneyardCount: result.room.gameState.boneyard.length,
        });
      } catch (error) {
        emitError(socket, error);
      }
    });

    socket.on('game:end', (payload: RoomPayload) => {
      try {
        const room = roomManager.getRoomOrThrow(payload.roomId);

        room.status = 'finished';
        room.gameState.endedAt = new Date().toISOString();
        room.gameState.winnerId =
          room.players.reduce((leader, player) =>
            player.score > leader.score ? player : leader,
          ).id ?? null;

        io.to(payload.roomId).emit('game:ended', {
          winnerId: room.gameState.winnerId,
          scores: room.gameState.scores,
          state: roomManager.getRoomState(payload.roomId),
        });
      } catch (error) {
        emitError(socket, error);
      }
    });

    socket.on('game:reconnect', (payload: RoomPayload) => {
      try {
        const playerId = getPlayerId(socket, payload);
        rememberPlayer(socket, playerId);
        roomManager.markConnected(payload.roomId, playerId, true);
        socket.join(playerId);
        socket.join(payload.roomId);

        socket.emit('game:reconnected', {
          state: roomManager.getRoomStateForPlayer(payload.roomId, playerId),
        });
      } catch (error) {
        emitError(socket, error);
      }
    });

    socket.on('disconnect', () => {
      const playerId = getRememberedPlayer(socket);
      roomManager.findRoomsByPlayer(playerId).forEach((room) => {
        roomManager.markConnected(room.id, playerId, false);
        socket.to(room.id).emit('room:playerLeft', {
          playerId,
          state: roomManager.getRoomState(room.id),
        });
      });
    });
  });
}

export const registerGameSocket = gameSocket;

function getPlayerId(socket: Socket, payload?: PlayerPayload): string {
  return payload?.playerId?.trim() || socket.id;
}

function rememberPlayer(socket: Socket, playerId: string): void {
  socket.data.playerId = playerId;
}

function getRememberedPlayer(socket: Socket): string {
  return typeof socket.data.playerId === 'string' ? socket.data.playerId : socket.id;
}

function emitError(socket: Socket, error: unknown): void {
  const message = error instanceof Error ? error.message : 'Erreur Socket.io inconnue.';
  socket.emit('game:error', { message });
}

function broadcastPrivateStates(
  io: Server,
  roomManager: RoomManager,
  roomId: string,
  eventName: string,
): void {
  const room = roomManager.getRoomOrThrow(roomId);

  room.players.forEach((player) => {
    io.to(player.id).emit(eventName, {
      state: roomManager.getRoomStateForPlayer(roomId, player.id),
    });
  });
}
