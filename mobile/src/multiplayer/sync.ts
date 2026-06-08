import { supabase } from '../services/supabase';
import { useMultiplayerStore } from './store';
import { useAuthStore } from '../store/authStore';
import { mpLogger } from './logger';

export const handleReconnectSync = async (matchId: string) => {
  try {
    mpLogger.log('Sync', 'Fetching authoritative state from database...');

    const userId = useAuthStore.getState().profile?.id;
    
    const { data, error } = await supabase
      .from('game_states')
      .select('*')
      .eq('match_id', matchId)
      .single();

    if (error) throw error;

    if (data) {
      // Strip hands from game_states — read from player_hands instead
      const stateData = { ...data as any, player1_hand: [], player2_hand: [] };
      mpLogger.log('Sync', 'Hard sync successful. State recovered.');

      // Fetch own hand from secure player_hands table
      if (userId) {
        const { data: handData } = await supabase
          .from('player_hands')
          .select('hand')
          .eq('match_id', matchId)
          .eq('player_id', userId)
          .single();
        if (handData) {
          const h = handData as any;
          if (stateData.player1_id === userId) {
            stateData.player1_hand = h.hand;
          } else {
            stateData.player2_hand = h.hand;
          }
        }
      }

      const timestamp = Number(stateData.last_action_timestamp ?? new Date(stateData.updated_at ?? stateData.created_at).getTime());
      useMultiplayerStore.getState().updateGameState(stateData, timestamp);
      useMultiplayerStore.getState().setConnectionState('connected');
    }
  } catch (err) {
    mpLogger.error('Sync', 'Hard sync failed', err);
  }
};
