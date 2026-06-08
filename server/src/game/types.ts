/**
 * Shared TypeScript contracts for the in-memory realtime domino engine.
 * These types are intentionally transport-friendly so they can be emitted
 * directly through Socket.io without requiring database state.
 */

export type Tile = [number, number];

export type BoardSide = 'left' | 'right';

export type RoomStatus = 'waiting' | 'playing' | 'finished';

export interface RoomSettings {
  maxPlayers: number;
  tilesPerPlayer: number;
  targetScore: number;
  isPrivate: boolean;
}

export interface Player {
  id: string;
  hand: Tile[];
  isHost: boolean;
  isConnected: boolean;
  score: number;
}

export interface BoardTile {
  tile: Tile;
  side: BoardSide | 'first';
}

export interface GameState {
  board: BoardTile[];
  boneyard: Tile[];
  currentTurnIndex: number;
  startedAt: string | null;
  endedAt: string | null;
  winnerId: string | null;
  scores: Record<string, number>;
}

export interface Room {
  id: string;
  players: Player[];
  status: RoomStatus;
  settings: RoomSettings;
  gameState: GameState;
  createdAt: string;
}

export interface PublicPlayerState {
  id: string;
  isHost: boolean;
  isConnected: boolean;
  score: number;
  handCount: number;
}

export interface PublicRoomState {
  id: string;
  players: PublicPlayerState[];
  status: RoomStatus;
  settings: RoomSettings;
  gameState: Omit<GameState, 'boneyard'> & {
    boneyardCount: number;
  };
}

export interface PlayerRoomState extends PublicRoomState {
  playerHand: Tile[];
}

export interface PlayTileResult {
  room: Room;
  player: Player;
  tile: Tile;
  side: BoardSide | 'first';
  scores: Record<string, number>;
  winner: Player | null;
}

export interface DrawTileResult {
  room: Room;
  player: Player;
  tile: Tile | null;
}
