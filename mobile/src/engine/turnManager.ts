import { EngineGameState } from './types';
import { getBotAction } from './botLogic';
import { useMultiplayerStore } from '../multiplayer/store';

class TurnManager {
  private dispatchActionCb: ((action: any) => void) | null = null;
  private timerId: ReturnType<typeof setTimeout> | null = null;
  private readonly TURN_TIMEOUT_MS = 10000; // 10 seconds

  setDispatchCallback(cb: (action: any) => void) {
    this.dispatchActionCb = cb;
  }

  startTimer(state: EngineGameState) {
    this.clearTimer();

    if (state.match_status !== 'in_progress') return;

    const expectedTurnPlayerId = state.current_turn;
    this.timerId = setTimeout(() => {
      this.handleTimeout(expectedTurnPlayerId);
    }, this.TURN_TIMEOUT_MS);
  }

  clearTimer() {
    if (this.timerId) {
      clearTimeout(this.timerId);
      this.timerId = null;
    }
  }

  private handleTimeout(expectedTurnPlayerId: string) {
    const latest = useMultiplayerStore.getState().gameState as EngineGameState | null;
    if (!latest) return;
    if (latest.match_status !== 'in_progress') return;
    if (latest.current_turn !== expectedTurnPlayerId) return;

    // Compute fallback from freshest state so automatic action remains legal.
    const botAction = getBotAction(latest);
    if (botAction.type === 'TIMEOUT') return;

    if (this.dispatchActionCb) {
      this.dispatchActionCb(botAction);
    }
  }
}

export const turnManager = new TurnManager();
