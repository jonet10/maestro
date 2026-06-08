import { RealtimeChannel } from '@supabase/supabase-js';
import { supabase } from '../services/supabase';
import { useMultiplayerStore } from './store';
import { mpLogger } from './logger';
import { BroadcastMessage, RealtimeEvent } from './types';

class RealtimeManager {
  private channel: RealtimeChannel | null = null;
  private matchId: string | null = null;
  private userId: string | null = null;

  connect(matchId: string, userId: string, username: string) {
    if (this.channel) {
      mpLogger.warn('Manager', 'Already connected or connecting. Disconnect first.');
      return;
    }

    this.matchId = matchId;
    this.userId = userId;
    useMultiplayerStore.getState().setMatchId(matchId);
    useMultiplayerStore.getState().setConnectionState('connecting');

    mpLogger.log('Manager', `Connecting to match ${matchId}`);

    this.channel = supabase.channel(`match:${matchId}`, {
      config: {
        presence: { key: userId },
      },
    });

    // Handle Presence
    this.channel.on('presence', { event: 'sync' }, () => {
      const state = this.channel?.presenceState() || {};
      this.handlePresenceSync(state);
    });

    // Handle incoming Broadcasts
    this.channel.on('broadcast', { event: '*' }, (payload: any) => {
      this.handleBroadcast(payload as BroadcastMessage);
    });

    // Listen to authoritative DB state changes (board, scores, etc.)
    // Hands are stripped here — read from player_hands subscription instead
    this.channel.on(
      'postgres_changes',
      {
        event: 'UPDATE',
        schema: 'public',
        table: 'game_states',
        filter: `match_id=eq.${matchId}`,
      },
      (payload: any) => {
        const row = payload?.new;
        if (!row) return;
        // Strip opponent hand data from shared state
        const safeRow = {
          ...row,
          player1_hand: [],
          player2_hand: [],
        };
        const ts = Number(row.last_action_timestamp ?? new Date(row.updated_at ?? Date.now()).getTime());
        useMultiplayerStore.getState().updateGameState(safeRow, ts);
      }
    );

    // Listen to player's own hand changes via secure player_hands table (RLS-protected)
    this.channel.on(
      'postgres_changes',
      {
        event: '*',
        schema: 'public',
        table: 'player_hands',
        filter: `match_id=eq.${matchId}`,
      },
      (payload: any) => {
        const row = payload?.new;
        if (!row || row.player_id !== userId) return;
        const currentState = useMultiplayerStore.getState().gameState;
        if (!currentState) return;
        const updatedState = { ...currentState };
        if (row.player_id === updatedState.player1_id) {
          updatedState.player1_hand = row.hand;
        } else {
          updatedState.player2_hand = row.hand;
        }
        useMultiplayerStore.getState().updateGameState(updatedState, Date.now());
      }
    );

    // Subscribe
    this.channel.subscribe(async (status) => {
      if (status === 'SUBSCRIBED') {
        mpLogger.log('Manager', 'Successfully subscribed to channel');
        useMultiplayerStore.getState().setConnectionState('connected');
        
        await this.channel?.track({
          username,
          isOnline: true,
          lastSeenAt: new Date().toISOString(),
        });
      } else if (status === 'CHANNEL_ERROR' || status === 'TIMED_OUT' || status === 'CLOSED') {
        mpLogger.error('Manager', `Channel status changed to ${status}`);
        this.handleDisconnect();
      }
    });
  }

  private handlePresenceSync(state: Record<string, any>) {
    const presences = Object.entries(state).map(([key, value]) => ({
      id: key,
      ...(Array.isArray(value) ? value[0] : value),
    }));
    useMultiplayerStore.getState().updatePresence(presences);
    mpLogger.log('Presence', 'Synced', presences);
  }

  private handleDisconnect() {
    const currentState = useMultiplayerStore.getState().connectionState;
    if (currentState === 'disconnected') return;

    useMultiplayerStore.getState().setConnectionState('recovering');
    mpLogger.log('Manager', 'Attempting recovery via hard sync...');
    
    if (this.matchId) {
      import('./sync').then(({ handleReconnectSync }) => {
        handleReconnectSync(this.matchId!);
      });
    }
  }

  private handleBroadcast(message: BroadcastMessage) {
    mpLogger.log('Broadcast Received', message.event, message.payload);

    if (message.event === 'GAME_SYNC') {
      const safeState = {
        ...message.payload.state,
        player1_hand: [],
        player2_hand: [],
      };
      useMultiplayerStore.getState().updateGameState(safeState, message.payload.timestamp);
    } else if (message.event === 'DRAG_PREVIEW') {
      if (message.payload?.playerId === this.userId) return;
      useMultiplayerStore.getState().setRemoteDragPreview(message.payload);
    } else if (message.event === 'DRAG_RELEASE') {
      if (message.payload?.playerId === this.userId) return;
      useMultiplayerStore.getState().setRemoteDragPreview(null);
    }
  }

  broadcast(event: RealtimeEvent) {
    if (!this.channel) {
      mpLogger.warn('Manager', 'Cannot broadcast without an active channel');
      return;
    }

    mpLogger.log('Broadcast Sent', event.type, event.payload);
    this.channel.send({
      type: 'broadcast',
      event: event.type,
      payload: event.payload,
    });
  }

  disconnect() {
    mpLogger.log('Manager', 'Disconnecting...');
    if (this.channel) {
      this.channel.unsubscribe();
      this.channel = null;
    }
    this.matchId = null;
    this.userId = null;
    useMultiplayerStore.getState().reset();
  }
}

export const realtimeManager = new RealtimeManager();
