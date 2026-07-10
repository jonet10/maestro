import { EventQueue } from "./EventQueue";

export type GameState = 
  | "INIT" 
  | "WAITING_PLAYERS" 
  | "ROUND_START" 
  | "TURN_PLAYER" 
  | "TURN_OPPONENT" 
  | "ANIMATING" 
  | "CALCULATING_SCORE" 
  | "ROUND_END" 
  | "MATCH_END"
  | "PAUSED"
  | "SPECTATING"
  | "RECONNECTING";

export interface StateTransition {
  from: GameState | "*";
  to: GameState;
  action?: string;
}

export class GameStateMachine {
  private currentState: GameState = "INIT";
  private eventQueue: EventQueue;
  private allowedTransitions: StateTransition[] = [];

  constructor(eventQueue: EventQueue) {
    this.eventQueue = eventQueue;
    this.setupDefaultTransitions();
  }

  private setupDefaultTransitions() {
    // Définition des transitions de base (extensibles)
    this.addTransition("*", "RECONNECTING");
    this.addTransition("RECONNECTING", "WAITING_PLAYERS");
    this.addTransition("RECONNECTING", "TURN_PLAYER");
    this.addTransition("RECONNECTING", "TURN_OPPONENT");
    
    this.addTransition("INIT", "WAITING_PLAYERS");
    this.addTransition("WAITING_PLAYERS", "ROUND_START");
    this.addTransition("ROUND_START", "TURN_PLAYER");
    this.addTransition("ROUND_START", "TURN_OPPONENT");

    this.addTransition("TURN_PLAYER", "ANIMATING");
    this.addTransition("TURN_OPPONENT", "ANIMATING");

    this.addTransition("ANIMATING", "TURN_PLAYER");
    this.addTransition("ANIMATING", "TURN_OPPONENT");
    this.addTransition("ANIMATING", "CALCULATING_SCORE");

    this.addTransition("CALCULATING_SCORE", "ROUND_END");
    this.addTransition("ROUND_END", "ROUND_START");
    this.addTransition("ROUND_END", "MATCH_END");
  }

  public addTransition(from: GameState | "*", to: GameState, action?: string) {
    this.allowedTransitions.push({ from, to, action });
  }

  public getState(): GameState {
    return this.currentState;
  }

  public canTransitionTo(newState: GameState): boolean {
    return this.allowedTransitions.some(
      (t) => (t.from === this.currentState || t.from === "*") && t.to === newState
    );
  }

  public transitionTo(newState: GameState, payload?: any): boolean {
    if (!this.canTransitionTo(newState)) {
      console.warn(`[GameStateMachine] Transition interdite: ${this.currentState} -> ${newState}`);
      return false;
    }

    const oldState = this.currentState;
    this.currentState = newState;

    this.eventQueue.push("STATE_CHANGE", {
      from: oldState,
      to: newState,
      ...payload
    });

    return true;
  }
}
