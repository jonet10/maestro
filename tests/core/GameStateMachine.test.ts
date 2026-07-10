import { describe, it, expect } from 'vitest';
import { GameStateMachine } from '../../src/engine/core/GameStateMachine';
import { EventQueue } from '../../src/engine/core/EventQueue';

describe('GameStateMachine', () => {

  it('devrait s\'initialiser dans l\'état INIT', () => {
    const queue = new EventQueue();
    const machine = new GameStateMachine(queue);
    expect(machine.getState()).toBe('INIT');
  });

  it('devrait autoriser une transition valide et émettre un événement', () => {
    const queue = new EventQueue();
    const machine = new GameStateMachine(queue);
    
    const success = machine.transitionTo('WAITING_PLAYERS');
    expect(success).toBe(true);
    expect(machine.getState()).toBe('WAITING_PLAYERS');

    const history = queue.getHistory();
    expect(history.length).toBe(1);
    expect(history[0].type).toBe('STATE_CHANGE');
    expect(history[0].payload.from).toBe('INIT');
    expect(history[0].payload.to).toBe('WAITING_PLAYERS');
  });

  it('devrait refuser une transition invalide', () => {
    const queue = new EventQueue();
    const machine = new GameStateMachine(queue);
    
    // Depuis INIT, on ne peut pas aller directement à ROUND_END sans l'avoir configuré
    const success = machine.transitionTo('ROUND_END');
    expect(success).toBe(false);
    expect(machine.getState()).toBe('INIT');
    expect(queue.getHistory().length).toBe(0);
  });

  it('devrait permettre les transitions avec joker *', () => {
    const queue = new EventQueue();
    const machine = new GameStateMachine(queue);
    
    // RECONNECTING est accessible depuis *
    machine.transitionTo('WAITING_PLAYERS');
    const success = machine.transitionTo('RECONNECTING');
    
    expect(success).toBe(true);
    expect(machine.getState()).toBe('RECONNECTING');
  });

});
