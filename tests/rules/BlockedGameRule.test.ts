import { describe, it, expect } from 'vitest';
import { resolveBlockedGame } from '../../src/engine/rules/BlockedGameRule';
import { Tile } from '../../src/types';

describe('BlockedGameRule', () => {

  it('Gagnant avec le moins de points restants', () => {
    const userHand: Tile[] = [[1, 1], [0, 1]]; // Somme: 3
    const aiHand: Tile[] = [[6, 6]]; // Somme: 12
    
    const result = resolveBlockedGame(userHand, aiHand);
    expect(result.winner).toBe("user");
    expect(result.userPips).toBe(3);
    expect(result.aiPips).toBe(12);
  });

  it('Égalité parfaite : Départage par le plus grand double', () => {
    const userHand: Tile[] = [[5, 5]]; // Somme: 10, Double: 5-5
    const aiHand: Tile[] = [[6, 4]]; // Somme: 10, Pas de double
    
    const result = resolveBlockedGame(userHand, aiHand);
    expect(result.winner).toBe("user");
    expect(result.reason).toBe("Égalité : Départage par double");
  });

  it('Égalité parfaite : Départage par le plus grand double (les deux ont un double)', () => {
    const userHand: Tile[] = [[4, 4], [1, 1]]; // Somme: 10, Double: 4-4
    const aiHand: Tile[] = [[5, 5], [0, 0]]; // Somme: 10, Double: 5-5
    
    const result = resolveBlockedGame(userHand, aiHand);
    expect(result.winner).toBe("ai");
    expect(result.reason).toBe("Égalité : Départage par double");
  });

  it('Égalité parfaite et aucun double : Départage par le plus grand domino', () => {
    const userHand: Tile[] = [[6, 3], [1, 0]]; // Somme: 10, Max tile: 6-3
    const aiHand: Tile[] = [[5, 4], [1, 0]]; // Somme: 10, Max tile: 5-4
    
    const result = resolveBlockedGame(userHand, aiHand);
    // 6-3 and 5-4 have same sum (9). Max end of 6-3 is 6. Max end of 5-4 is 5. So 6-3 wins.
    expect(result.winner).toBe("user");
    expect(result.reason).toBe("Égalité : Départage par plus grand domino");
  });

});
