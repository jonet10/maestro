export type Json =
  | string
  | number
  | boolean
  | null
  | { [key: string]: Json | undefined }
  | Json[]

export interface Database {
  public: {
    Tables: {
      players: {
        Row: {
          id: string
          username: string
          email: string
          avatar_url: string | null
          elo_points: number
          rank: 'Debitant' | 'Mwayen' | 'Avanse' | 'Met' | 'Gran Met' | 'Dominolog'
          timezone_slot: number | null
          total_matches: number
          wins: number
          losses: number
          capot_wins: number
          created_at: string
          updated_at: string
        }
        Insert: {
          id: string
          username: string
          email: string
          avatar_url?: string | null
          elo_points?: number
          rank?: 'Debitant' | 'Mwayen' | 'Avanse' | 'Met' | 'Gran Met' | 'Dominolog'
          timezone_slot?: number | null
          total_matches?: number
          wins?: number
          losses?: number
          capot_wins?: number
          created_at?: string
          updated_at?: string
        }
        Update: {
          id?: string
          username?: string
          email?: string
          avatar_url?: string | null
          elo_points?: number
          rank?: 'Debitant' | 'Mwayen' | 'Avanse' | 'Met' | 'Gran Met' | 'Dominolog'
          timezone_slot?: number | null
          total_matches?: number
          wins?: number
          losses?: number
          capot_wins?: number
          created_at?: string
          updated_at?: string
        }
      }
      matches: {
        Row: {
          id: string
          player1_id: string
          player2_id: string
          winner_id: string | null
          player1_score: number
          player2_score: number
          match_status: 'waiting' | 'in_progress' | 'completed' | 'cancelled'
          match_type: 'casual' | 'ranked' | 'league' | 'tournament'
          league_id: string | null
          started_at: string | null
          ended_at: string | null
          created_at: string
        }
        Insert: {
          id?: string
          player1_id: string
          player2_id: string
          winner_id?: string | null
          player1_score?: number
          player2_score?: number
          match_status?: 'waiting' | 'in_progress' | 'completed' | 'cancelled'
          match_type?: 'casual' | 'ranked' | 'league' | 'tournament'
          league_id?: string | null
          started_at?: string | null
          ended_at?: string | null
          created_at?: string
        }
        Update: {
          id?: string
          player1_id?: string
          player2_id?: string
          winner_id?: string | null
          player1_score?: number
          player2_score?: number
          match_status?: 'waiting' | 'in_progress' | 'completed' | 'cancelled'
          match_type?: 'casual' | 'ranked' | 'league' | 'tournament'
          league_id?: string | null
          started_at?: string | null
          ended_at?: string | null
          created_at?: string
        }
      }
      game_states: {
        Row: {
          id: string
          match_id: string
          board_state: Json
          player1_id: string
          player2_id: string
          player1_hand: Json
          player2_hand: Json
          boneyard: Json
          current_turn: string
          round_number: number
          player1_score: number
          player2_score: number
          match_status: 'waiting' | 'in_progress' | 'completed' | 'cancelled'
          last_action_timestamp: number
          consecutive_passes: number
          created_at: string
          updated_at: string
        }
        Insert: {
          [key: string]: any
        }
        Update: {
          [key: string]: any
        }
      }
      leagues: {
        Row: {
          id: string
          name: string
          tier: string
          timezone_slot: number | null
          season_id: string | null
          created_at: string
        }
        Insert: {
          id?: string
          name: string
          tier: string
          timezone_slot?: number | null
          season_id?: string | null
          created_at?: string
        }
        Update: {
          id?: string
          name?: string
          tier?: string
          timezone_slot?: number | null
          season_id?: string | null
          created_at?: string
        }
      }
      league_players: {
        Row: {
          league_id: string
          player_id: string
          points: number
          wins: number
          losses: number
          rank: number
        }
        Insert: {
          league_id: string
          player_id: string
          points?: number
          wins?: number
          losses?: number
          rank?: number
        }
        Update: {
          league_id?: string
          player_id?: string
          points?: number
          wins?: number
          losses?: number
          rank?: number
        }
      }
      matchmaking_queue: {
        Row: {
          id: string
          player_id: string
          elo: number
          league_id: string | null
          division: string | null
          match_type: 'Liga' | 'Kopa' | 'LDC' | 'Diamond' | 'Pro' | 'Battle'
          joined_at: string
          status: 'searching' | 'matched' | 'timeout'
        }
        Insert: {
          id?: string
          player_id: string
          elo: number
          league_id?: string | null
          division?: string | null
          match_type: 'Liga' | 'Kopa' | 'LDC' | 'Diamond' | 'Pro' | 'Battle'
          joined_at?: string
          status?: 'searching' | 'matched' | 'timeout'
        }
        Update: {
          id?: string
          player_id?: string
          elo?: number
          league_id?: string | null
          division?: string | null
          match_type?: 'Liga' | 'Kopa' | 'LDC' | 'Diamond' | 'Pro' | 'Battle'
          joined_at?: string
          status?: 'searching' | 'matched' | 'timeout'
        }
      }
    }
    Views: {
      [_ in never]: never
    }
    Functions: {
      calculate_rank: {
        Args: {
          elo: number
        }
        Returns: 'Debitant' | 'Mwayen' | 'Avanse' | 'Met' | 'Gran Met' | 'Dominolog'
      }
    }
    Enums: {
      match_status: 'waiting' | 'in_progress' | 'completed' | 'cancelled'
      match_type: 'casual' | 'ranked' | 'league' | 'tournament'
      move_type: 'play_tile' | 'pass' | 'draw'
      player_rank: 'Debitant' | 'Mwayen' | 'Avanse' | 'Met' | 'Gran Met' | 'Dominolog'
      queue_status: 'searching' | 'matched' | 'timeout'
      queue_match_type: 'Liga' | 'Kopa' | 'LDC' | 'Diamond' | 'Pro' | 'Battle'
    }
  }
}
