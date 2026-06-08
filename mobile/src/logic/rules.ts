// src/logic/rules.ts
/**
 * Pure game‑play rule helpers for the domino game.
 * All functions are deterministic and have no side‑effects – perfect for
 * server‑side validation or AI simulation.
 */

type DominoValue = string; // e.g. "6-5"

type Hand = DominoValue[];

type Ends = { left: number; right: number };

type GameState = {
  chain: DominoValue[]; // ordered values on the table
  hands: Record<string, Hand>; // playerId -> hand
  boneyard: Hand;
  currentPlayer: string;
};

/** Extract the two numbers from a domino value. */
export const parseDomino = (value: DominoValue): [number, number] => {
  const [a, b] = value.split('-').map(Number);
  return [a, b];
};

/** Returns true if the domino can be placed on either end of the chain. */
export const canPlace = (value: DominoValue, ends: Ends): boolean => {
  const [a, b] = parseDomino(value);
  return a === ends.left || b === ends.left || a === ends.right || b === ends.right;
};

/** Compute the numeric ends of the current chain. */
export const getChainEnds = (chain: DominoValue[]): Ends | null => {
  if (chain.length === 0) return null;
  const first = parseDomino(chain[0]);
  const last = parseDomino(chain[chain.length - 1]);
  return { left: first[0], right: last[1] };
};

/** Determine the highest double in a hand. Returns null if none. */
export const highestDouble = (hand: Hand): DominoValue | null => {
  const doubles = hand.filter(v => {
    const [a, b] = parseDomino(v);
    return a === b;
  });
  if (doubles.length === 0) return null;
  // sort descending by pip count
  doubles.sort((a, b) => parseDomino(b)[0] - parseDomino(a)[0]);
  return doubles[0];
};

/** Checks whether any player can make a move. */
export const isBlocked = (state: GameState): boolean => {
  const ends = getChainEnds(state.chain);
  if (!ends) return false; // no tiles on table yet
  const players = Object.keys(state.hands);
  return players.every(pid => {
    const hand = state.hands[pid];
    return !hand.some(v => canPlace(v, ends));
  });
};

/** Determine the next player index (clockwise). */
export const nextPlayer = (players: string[], current: string): string => {
  const idx = players.indexOf(current);
  return players[(idx + 1) % players.length];
};

/** Interface for future AI integration. */
export interface AIPlayer {
  /**
   * Choose a domino to play or return null to draw/pass.
   * Must return a domino value from the provided hand that is legal.
   */
  chooseMove(state: GameState, playerId: string): DominoValue | null;
}
