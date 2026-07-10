export interface GameEvent {
  id: string;
  timestamp: number;
  type: string;
  payload?: any;
}

export class EventQueue {
  private events: GameEvent[] = [];
  private listeners: ((event: GameEvent) => void)[] = [];

  /**
   * Ajoute un événement à la file.
   * Cet événement recevra automatiquement un identifiant unique (UUID) et un timestamp.
   */
  public push(type: string, payload?: any): GameEvent {
    const event: GameEvent = {
      id: crypto.randomUUID(),
      timestamp: Date.now(),
      type,
      payload,
    };
    this.events.push(event);
    this.notifyListeners(event);
    return event;
  }

  /**
   * Récupère l'historique complet des événements.
   */
  public getHistory(): GameEvent[] {
    return [...this.events];
  }

  /**
   * Efface l'historique (par exemple lors d'un nouveau match complet).
   */
  public clear(): void {
    this.events = [];
  }

  /**
   * S'abonne aux nouveaux événements ajoutés à la file.
   */
  public subscribe(callback: (event: GameEvent) => void): () => void {
    this.listeners.push(callback);
    return () => {
      this.listeners = this.listeners.filter((cb) => cb !== callback);
    };
  }

  private notifyListeners(event: GameEvent): void {
    for (const listener of this.listeners) {
      listener(event);
    }
  }
}
