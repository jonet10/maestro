import { Database } from '../types/supabase';

export type GameState = Database['public']['Tables']['game_states']['Row'];
export type MoveType = Database['public']['Enums']['move_type'];

export type ConnectionState = 'disconnected' | 'connecting' | 'connected' | 'recovering';

export interface PlayerPresence {
  id: string;
  username: string;
  isOnline: boolean;
  lastSeenAt: string;
}

export interface DragPreview {
  playerId: string;
  tile: [number, number];
  x: number;
  y: number;
}

// Events broadcasted through the channel
export type RealtimeEvent =
  | { type: 'MOVE_PLAYED'; payload: { playerId: string; moveType: MoveType; tilePlayed?: any; sidePlayed?: string; timestamp: number } }
  | { type: 'TURN_CHANGED'; payload: { nextTurnPlayerId: string; roundNumber: number } }
  | { type: 'GAME_SYNC'; payload: { state: GameState; timestamp: number } }
  | { type: 'GAME_ENDED'; payload: { winnerId: string | null } }
  | { type: 'DRAG_PREVIEW'; payload: DragPreview }
  | { type: 'DRAG_RELEASE'; payload: { playerId: string } };

// Defines the shape of the broadcast message
export interface BroadcastMessage {
  type: 'broadcast';
  event: RealtimeEvent['type'];
  payload: any;
}
