/**
 * Shared game contracts for Maestro Domino.
 * These interfaces describe the public realtime state exchanged between the
 * Node.js/Socket.io backend and the React Native client.
 */

/** Allowed lifecycle statuses for a room or game. */
export type GameStatus = 'waiting' | 'playing' | 'finished';

/** Allowed visual orientation values for a tile placed on the board. */
export type BoardTileOrientation = 'horizontal' | 'vertical';

/** Allowed room capacities for a multiplayer domino match. */
export type RoomMaxPlayers = 2 | 3 | 4;

/**
 * A standard double-six domino tile.
 */
export interface Tile {
  /** Left pip value, from 0 to 6. */
  left: number;
  /** Right pip value, from 0 to 6. */
  right: number;
  /** Stable unique identifier for this tile instance. */
  id: string;
  /** Whether the left and right pip values are equal. */
  isDouble: boolean;
}

/**
 * A player connected to a room or participating in a game.
 */
export interface Player {
  /** Stable player identifier, usually the Supabase user id or socket fallback id. */
  id: string;
  /** Public display name shown to other players. */
  username: string;
  /** Tiles currently held by the player. */
  hand: Tile[];
  /** Current accumulated score for the match. */
  score: number;
  /** Whether the player's realtime socket is currently connected. */
  isConnected: boolean;
  /** Whether the player has marked themselves ready to start. */
  isReady: boolean;
}

/**
 * Board coordinates for a played tile.
 */
export interface BoardPosition {
  /** Horizontal board coordinate. */
  x: number;
  /** Vertical board coordinate. */
  y: number;
}

/**
 * A domino tile already placed on the board.
 */
export interface BoardTile {
  /** Tile data placed on the board. */
  tile: Tile;
  /** Visual orientation used by the client renderer. */
  orientation: BoardTileOrientation;
  /** Board coordinate where the tile is rendered. */
  position: BoardPosition;
}

/**
 * Complete realtime state for a domino game round.
 */
export interface GameState {
  /** Room identifier that owns this game state. */
  roomId: string;
  /** Ordered players participating in the game. */
  players: Player[];
  /** Ordered list of tiles placed on the board. */
  board: BoardTile[];
  /** Remaining tiles available to draw. */
  boneyard: Tile[];
  /** Identifier of the player whose turn is active. */
  currentPlayerId: string;
  /** Exposed pip value on the left end of the board. */
  leftEnd: number;
  /** Exposed pip value on the right end of the board. */
  rightEnd: number;
  /** Current lifecycle status of the game. */
  status: GameStatus;
  /** Winner player id, or null while the game is still unresolved. */
  winner: string | null;
  /** Current round number, starting at 1. */
  round: number;
}

/**
 * Multiplayer room containing players and optional active game state.
 */
export interface Room {
  /** Unique room identifier shared with clients. */
  id: string;
  /** Player id of the room creator and host. */
  hostId: string;
  /** Players currently present in the room. */
  players: Player[];
  /** Active game state, or null before the match starts. */
  gameState: GameState | null;
  /** Maximum number of players allowed in this room. */
  maxPlayers: RoomMaxPlayers;
  /** Current lifecycle status of the room. */
  status: GameStatus;
  /** Date and time when the room was created. */
  createdAt: Date;
}

/**
 * Socket.io event names used by the generated gameSocket.ts module.
 */
export enum SocketEvents {
  /** Client asks the server to create a room. */
  RoomCreate = 'room:create',
  /** Server confirms that a room was created. */
  RoomCreated = 'room:created',
  /** Client asks to join an existing room. */
  RoomJoin = 'room:join',
  /** Server confirms that the client joined a room. */
  RoomJoined = 'room:joined',
  /** Server broadcasts that a player joined a room. */
  RoomPlayerJoined = 'room:playerJoined',
  /** Client asks to leave a room. */
  RoomLeave = 'room:leave',
  /** Server broadcasts that a player left a room. */
  RoomPlayerLeft = 'room:playerLeft',
  /** Client host asks to start the game. */
  GameStart = 'game:start',
  /** Server sends the initial game state to players. */
  GameStarted = 'game:started',
  /** Client asks to play a tile. */
  GamePlayTile = 'game:playTile',
  /** Server broadcasts that a tile was played. */
  GameTileePlayed = 'game:tileePlayed',
  /** Client asks to draw a tile from the boneyard. */
  GameDraw = 'game:draw',
  /** Server sends the drawn tile to the drawing player. */
  GameTileDrawn = 'game:tileDrawn',
  /** Server broadcasts that another player drew a tile. */
  GamePlayerDrew = 'game:playerDrew',
  /** Client asks to force-end the game. */
  GameEnd = 'game:end',
  /** Server broadcasts that the game ended. */
  GameEnded = 'game:ended',
  /** Client asks to reconnect to an existing game. */
  GameReconnect = 'game:reconnect',
  /** Server returns the current state to a reconnected player. */
  GameReconnected = 'game:reconnected',
  /** Socket.io lifecycle event fired when a socket disconnects. */
  Disconnect = 'disconnect',
  /** Server sends a game-specific error message. */
  GameError = 'game:error',
}
