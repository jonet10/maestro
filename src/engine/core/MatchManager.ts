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

      // Check if match winner condition is met
      if (this.state.roundsWon[winnerId] >= this.state.settings.targetManches) {
        this.state.isMatchFinished = true;
        this.state.matchWinnerId = winnerId;
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
