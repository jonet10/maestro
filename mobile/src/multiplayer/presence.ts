import { RealtimePresenceState } from '@supabase/supabase-js';
import { PlayerPresence } from './types';
import { useMultiplayerStore } from './store';
import { mpLogger } from './logger';

export const handlePresenceSync = (presenceState: RealtimePresenceState) => {
  const activePlayers: PlayerPresence[] = [];

  Object.keys(presenceState).forEach((key) => {
    const presences = presenceState[key];
    if (presences && presences.length > 0) {
      // The latest presence info for this user
      const info = presences[0] as any;
      activePlayers.push({
        id: key,
        username: info.username || 'Unknown',
        isOnline: true,
        lastSeenAt: info.lastSeenAt || new Date().toISOString(),
      });
    }
  });

  mpLogger.log('Presence', 'Active players synced', activePlayers);
  useMultiplayerStore.getState().updatePresence(activePlayers);

  // Future logic: Check if required players dropped.
  // E.g. If it's a 1v1 and the other player dropped, start a disconnect timer.
};
