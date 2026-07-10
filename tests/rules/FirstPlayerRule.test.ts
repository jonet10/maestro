import { describe, it, expect } from 'vitest';
import { determineFirstPlayer } from '../../src/engine/rules/FirstPlayerRule';
import { Tile } from '../../src/types';

describe('FirstPlayerRule', () => {

  it('Priorité 1: Le joueur avec le plus grand double commence', () => {
    const userHand: Tile[] = [[5, 5], [1, 2], [3, 4]];
    const aiHand: Tile[] = [[6, 6], [0, 1], [2, 3]];
    
    const result = determineFirstPlayer(userHand, aiHand, null);
    expect(result.starter).toBe("ai");
    expect(result.tile).toEqual([6, 6]);
  });

  it('Priorité 1: Fonctionne avec le double 0-0', () => {
    const userHand: Tile[] = [[0, 0], [1, 2], [3, 4]];
    const aiHand: Tile[] = [[0, 1], [2, 3]];
    
    const result = determineFirstPlayer(userHand, aiHand, null);
    expect(result.starter).toBe("user");
    expect(result.tile).toEqual([0, 0]);
  });

  it('Priorité 2: Sans double, le domino avec la plus grande somme gagne', () => {
    const userHand: Tile[] = [[4, 3], [1, 2], [0, 1]]; // Somme max = 7
    const aiHand: Tile[] = [[5, 3], [2, 1]]; // Somme max = 8
    
    const result = determineFirstPlayer(userHand, aiHand, null);
    expect(result.starter).toBe("ai");
    expect(result.tile).toEqual([5, 3]);
  });

  it('Priorité 2: Sans double, si somme égale, la plus grande extrémité gagne', () => {
    const userHand: Tile[] = [[6, 4], [1, 2]]; // Somme 10, Ext max 6
    const aiHand: Tile[] = [[5, 5]]; // Wait, we assume NO doubles are present. Let's provide no doubles.
    
    const uHand: Tile[] = [[6, 4], [1, 2]]; // Somme 10, ext 6
    const aHand: Tile[] = [[5, 5]]; // Wait, 5-5 is a double.
    
    const uHandNoDouble: Tile[] = [[6, 4], [1, 2]]; // Somme 10, Ext max 6
    const aHandNoDouble: Tile[] = [[7, 3], [2, 1]]; // Somme 10, Ext max 7
    // Standard dominoes don't have 7, but for logic test it's fine.
    
    // Better real-life example: 6-3 (sum 9, max 6) vs 5-4 (sum 9, max 5)
    const uReal: Tile[] = [[6, 3], [1, 2]]; // Sum 9, Max 6
    const aReal: Tile[] = [[5, 4], [1, 1]]; // Wait, 1-1 is double. No doubles allowed in this test.
    const aRealNoDouble: Tile[] = [[5, 4], [2, 1]]; // Sum 9, Max 5
    
    const result = determineFirstPlayer(uReal, aRealNoDouble, null);
    expect(result.starter).toBe("user");
    expect(result.tile).toEqual([6, 3]);
  });

  it('Priorité 2: Si somme et ext max sont égales, on regarde la deuxième extrémité', () => {
    // 6-3 vs 6-3 is impossible with a single standard set, but let's test the logic.
    const uHand: Tile[] = [[5, 4], [1, 2]]; // Somme 9, max 5, min 4
    const aHand: Tile[] = [[5, 3], [1, 2]]; // Somme 8 -> will lose by sum.
    
    // So 6-3 (sum 9, ext 6, 3) vs 6-2 (sum 8). Wait, sum has priority.
    // Is it possible to have same sum and same max?
    // Sum = A + B. Max = A. So B = Sum - A.
    // If Sum is equal, and Max is equal, then Min MUST be equal.
    // Therefore, the dominoes are identical.
    // So the rule "puis la seconde" is mathematically redundant but good to have.
    const result = determineFirstPlayer([[6,3]], [[6,3]], null);
    expect(result.starter).toBe("user"); // Tie goes to user as fallback.
  });

  it('Début des manches suivantes: Le gagnant précédent commence avec n\'importe quel domino', () => {
    const userHand: Tile[] = [[1, 2]]; 
    const aiHand: Tile[] = [[6, 6]]; 
    
    // Même si AI a le 6-6, user a gagné avant.
    const result = determineFirstPlayer(userHand, aiHand, "user");
    expect(result.starter).toBe("user");
    expect(result.reason).toBe("Vainqueur de la manche précédente.");
  });

});
