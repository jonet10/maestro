/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

export type Tile = [number, number];

export interface PlacedTile {
  id: string;
  tile: Tile;
  connectedAs: [number, number]; // [inner_number, outer_number] after rotation/matching (inner connects to parent, outer has the open value)
  isDouble: boolean;
  playedAt: "left" | "right" | "top" | "bottom" | "start";
}

export type GameMode = "draw" | "block" | "all-fives";

export type Difficulty = "easy" | "medium" | "hard";

export type MatchStatus = "ongoing" | "domino" | "blocked" | "not-started" | "revealing";

export type AppScreen = "home" | "game" | "scores" | "settings" | "auth" | "online-lobby" | "online-game" | "profile-stats" | "admin-dashboard" | "tournament-lobby" | "leaderboard";

export interface Player {
  id: "user" | "ai";
  name: string;
  hand: Tile[];
  score: number;
  isAi: boolean;
}

export interface GameLog {
  id: string;
  timestamp: string;
  player: "user" | "ai" | "system";
  message: string;
  type: "play" | "draw" | "pass" | "score" | "win" | "system";
}

export interface GameHistoryEvent {
  eventId: string;
  sequenceNumber: number;
  timestamp: string;
  type: "play" | "draw" | "pass" | "timeout" | "autoplay" | "round_end" | "score_tally";
  player: "user" | "ai" | "system";
  details: any;
}

export interface DominoGameState {
  mode: GameMode;
  difficulty: Difficulty;
  status: MatchStatus;
  winner: "user" | "ai" | "draw" | null;
  placedTiles: PlacedTile[];
  players: {
    user: Player;
    ai: Player;
  };
  boneyard: Tile[];
  currentPlayer: "user" | "ai";
  logs: GameLog[];
  round: number;
}

// Types for analysis engine
export interface PipCount {
  pip: number;
  total: number;       // total in double-six set (always 7 for each pip, plus double)
  played: number;      // count of this pip placed on the board
  inHand: number;      // count of this pip in the user's hand
  unknown: number;     // total - played - inHand
}

export interface TileAnalysis {
  tile: Tile;
  isPlayable: boolean;
  scorePotential: number; // For All-Fives, how many points it scores. For other modes, pip weight.
  blockingIndex: number;  // How effective it is at blocking opponent's possible tiles
  safetyScore: number;    // How safe is it to play this (e.g. keeps options open for us)
  playRecommendation: "best" | "good" | "neutral" | "risky" | "unplayable";
  playDescription: string;
}

export interface GeneralAnalysis {
  openLeft: number | null;
  openRight: number | null;
  playedCount: number;
  boneyardCount: number;
  pipStats: PipCount[];
  recommendations: TileAnalysis[];
  estimatedOpponentStrengths: {
    [key: number]: number; // Probability weight opponent has pip Key (0..6)
  };
  dominantPips: number[];  // Pips that have been played a lot (high risk of being blocked)
  handSafetyAverage: number; // Percentage score of hand's flexibility
}

export interface AdminConfig {
  defaultTarget: 50 | 100 | 150 | 200;
  allowCustomTarget: boolean;
  enabledTargets: {
    50: boolean;
    100: boolean;
    150: boolean;
    200: boolean;
  };
}

export interface MatchHistoryEntry {
  id: string;
  date: string;
  gameType: "individual" | "team";
  targetScore: number;
  scoreUser: number;
  scoreAi: number;
  winner: "user" | "ai" | "draw";
}

export interface Profile {
  id: string;
  username: string;
  avatar_url: string | null;
  games_played: number;
  games_won: number;
  games_lost: number;
  win_rate: number;
  created_at: string;
  role?: "player" | "admin" | "super-admin";
  is_banned?: boolean;
  elo_rating?: number;
  tournaments_won?: number;
  current_streak?: number;
  max_streak?: number;
  onboarding_completed?: boolean;
  availability?: {
    timezone?: string;
    days?: string[];
    timeSlots?: string[];
  };
  league_id?: string;
}

export interface OnlineGameState {
  placedTiles: PlacedTile[];
  boneyard_count: number;
  currentPlayer: string;
  score_creator: number;
  score_opponent: number;
  round: number;
  matchStatus: "not-started" | "ongoing" | "revealing" | "scoring" | "finished";
  revealPhase: "none" | "revealing" | "scoring";
  revealData: {
    result: "domino" | "blocked";
    roundWinner: string;
    creatorHand: Tile[];
    opponentHand: Tile[];
    creatorPipsSum: number;
    opponentPipsSum: number;
    scoreGained: number;
    tieBreakExplained?: string;
  } | null;
  nextRoundStarter: string | null;
}

export interface OnlineRoom {
  id: string;
  name: string;
  creator_id: string;
  opponent_id: string | null;
  status: "waiting" | "active" | "finished";
  visibility: "public" | "private";
  room_code: string | null;
  target_score: number;
  deal_option: "auto" | "manual";
  winner_id: string | null;
  game_state: OnlineGameState;
  creator_disconnected_at: string | null;
  opponent_disconnected_at: string | null;
  created_at: string;
  updated_at: string;
  creator?: Profile;
  opponent?: Profile;
}

export interface Tournament {
  id: string;
  name: string;
  status: "upcoming" | "active" | "finished";
  max_participants: number;
  target_score: number;
  winner_id: string | null;
  created_at: string;
  winner?: Profile;
}

export interface TournamentMatch {
  id: string;
  tournament_id: string;
  round_number: number;
  match_index: number;
  player1_id: string | null;
  player2_id: string | null;
  room_id: string | null;
  winner_id: string | null;
  status: "scheduled" | "ongoing" | "finished";
  created_at: string;
  player1?: Profile;
  player2?: Profile;
  room?: OnlineRoom;
}

export interface AdminLog {
  id: string;
  admin_id: string | null;
  action: string;
  target_type: "player" | "tournament" | "system";
  target_id: string | null;
  details: string | null;
  created_at: string;
  admin?: Profile;
}

export interface Achievement {
  id: string;
  title: string;
  description: string;
  icon: string;
}

export interface UserAchievement {
  player_id: string;
  achievement_id: string;
  unlocked_at: string;
  achievement?: Achievement;
}


