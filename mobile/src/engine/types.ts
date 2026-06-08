import { Database } from '../types/supabase';

export type Tile = [number, number];
export type GameMode = 'fives' | 'draw' | 'block';

export interface BoardTile {
  tile: Tile;
  // 'up' and 'down' are branches from the spinner (first double played)
  side: 'left' | 'right' | 'first' | 'up' | 'down';
  isSpinner?: boolean;
  orientedTile?: Tile;
  x?: number;
  y?: number;
  direction?: 'horizontal' | 'vertical';
  isDouble?: boolean;
}

export type PlayerId = string;

export interface EngineGameState {
  id: string;
  match_id: string;
  board_state: BoardTile[];
  player1_id: PlayerId;
  player2_id: PlayerId;
  player1_hand: Tile[];
  player2_hand: Tile[];
  boneyard: Tile[];
  current_turn: PlayerId;
  round_number: number;
  player1_score: number;
  player2_score: number;
  game_mode?: GameMode;
  target_score?: number;
  last_player_id?: PlayerId | null;
  match_status: Database['public']['Enums']['match_status'];
  last_action_timestamp: number;
  consecutive_passes: number;
}

export type EngineActionType = 'PLAY' | 'DRAW' | 'PASS' | 'TIMEOUT';

export interface EngineAction {
  type: EngineActionType;
  playerId: PlayerId;
  payload?: {
    tile?: Tile;
    side?: 'left' | 'right' | 'up' | 'down' | 'first';
  };
  timestamp: number;
}
