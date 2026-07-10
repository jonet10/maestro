import { describe, it, expect, vi } from 'vitest';
import { EventQueue } from '../../src/engine/core/EventQueue';

describe('EventQueue', () => {

  it('devrait ajouter un événement avec un UUID et un timestamp', () => {
    const queue = new EventQueue();
    const event = queue.push('TEST_EVENT', { foo: 'bar' });

    expect(event.id).toBeDefined();
    expect(typeof event.id).toBe('string');
    expect(event.timestamp).toBeDefined();
    expect(typeof event.timestamp).toBe('number');
    expect(event.type).toBe('TEST_EVENT');
    expect(event.payload).toEqual({ foo: 'bar' });

    const history = queue.getHistory();
    expect(history.length).toBe(1);
    expect(history[0]).toEqual(event);
  });

  it('devrait notifier les abonnés lors d\'un nouvel événement', () => {
    const queue = new EventQueue();
    const callback = vi.fn();
    
    queue.subscribe(callback);
    queue.push('ACTION_PLAY', { tile: [6, 6] });

    expect(callback).toHaveBeenCalledTimes(1);
    expect(callback.mock.calls[0][0].type).toBe('ACTION_PLAY');
  });

  it('devrait permettre de se désabonner', () => {
    const queue = new EventQueue();
    const callback = vi.fn();
    
    const unsubscribe = queue.subscribe(callback);
    unsubscribe();
    
    queue.push('ACTION_DRAW');
    expect(callback).not.toHaveBeenCalled();
  });

  it('devrait vider l\'historique', () => {
    const queue = new EventQueue();
    queue.push('EVENT_1');
    queue.push('EVENT_2');
    
    expect(queue.getHistory().length).toBe(2);
    queue.clear();
    expect(queue.getHistory().length).toBe(0);
  });

});
