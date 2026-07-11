/**
 * @license
 * SPDX-License-Identifier: Apache-2.0
 */

export interface DomainPlayer {
  id: string;
  name: string;
}

export interface DomainRoundResult {
  roundNumber: number;
  winnerId: string | null;
  scores: Record<string, number>;
}

export interface MatchSettings {
  targetManches: number; // ex: 3 (Best of 5)
  targetScorePerManche: number; // ex: 100
  gameMode: string;
  matchMode?: "single" | "first_to" | "fixed";
}

export interface MatchState {
  settings: MatchSettings;
  players: DomainPlayer[];
  roundsWon: Record<string, number>;
  roundsHistory: DomainRoundResult[];
  isMatchFinished: boolean;
  matchWinnerId: string | null;
}

export type MatchEventType = "MATCH_STARTED" | "ROUND_COMPLETED" | "MATCH_COMPLETED";

export class MatchManager {
  private state: MatchState;
  private listeners: Record<string, ((event: any) => void)[]> = {};

  constructor(players: DomainPlayer[], settings: MatchSettings) {
    const roundsWon: Record<string, number> = {};
    players.forEach(p => {
      roundsWon[p.id] = 0;
    });

    this.state = {
      settings,
      players,
      roundsWon,
      roundsHistory: [],
      isMatchFinished: false,
      matchWinnerId: null
    };

    this.emit("MATCH_STARTED", this.state);
  }

  public subscribe(event: MatchEventType, callback: (payload: any) => void): () => void {
    if (!this.listeners[event]) {
      this.listeners[event] = [];
    }
    this.listeners[event].push(callback);
    return () => {
      this.listeners[event] = this.listeners[event].filter(cb => cb !== callback);
    };
  }

  private emit(event: MatchEventType, payload: any) {
    if (this.listeners[event]) {
      this.listeners[event].forEach(callback => callback(payload));
    }
  }

  public commitRound(winnerId: string | null, scores: Record<string, number>): void {
    if (this.state.isMatchFinished) return;

    const roundNumber = this.state.roundsHistory.length + 1;
    const roundResult: DomainRoundResult = {
      roundNumber,
      winnerId,
      scores: { ...scores }
    };

    this.state.roundsHistory.push(roundResult);

    if (winnerId !== null && this.state.roundsWon[winnerId] !== undefined) {
      this.state.roundsWon[winnerId] += 1;
    }

    const mode = this.state.settings.matchMode || "first_to";
    const target = this.state.settings.targetManches;

    if (mode === "single") {
      if (winnerId !== null && this.state.roundsWon[winnerId] >= 1) {
        this.state.isMatchFinished = true;
        this.state.matchWinnerId = winnerId;
      }
    } else if (mode === "first_to") {
      if (winnerId !== null && this.state.roundsWon[winnerId] >= target) {
        this.state.isMatchFinished = true;
        this.state.matchWinnerId = winnerId;
      }
    } else if (mode === "fixed") {
      if (this.state.roundsHistory.length >= target) {
        const players = this.state.players;
        const p1 = players[0].id;
        const p2 = players[1].id;
        const w1 = this.state.roundsWon[p1] || 0;
        const w2 = this.state.roundsWon[p2] || 0;

        if (w1 > w2) {
          this.state.isMatchFinished = true;
          this.state.matchWinnerId = p1;
        } else if (w2 > w1) {
          this.state.isMatchFinished = true;
          this.state.matchWinnerId = p2;
        } else {
          // Tie: play decisive extra round (do not set isMatchFinished to true)
          this.state.isMatchFinished = false;
          this.state.matchWinnerId = null;
        }
      }
    }

    this.emit("ROUND_COMPLETED", { roundResult, matchState: this.state });

    if (this.state.isMatchFinished) {
      this.emit("MATCH_COMPLETED", this.state);
    }
  }

  public nextRound(): void {
    // Round transition triggers clean state representation retrieval
    // Handled at the adapter layer, but manager registers progression
  }

  public getMatchState(): MatchState {
    return {
      ...this.state,
      roundsWon: { ...this.state.roundsWon },
      roundsHistory: [...this.state.roundsHistory]
    };
  }
}
