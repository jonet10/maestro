import * as Haptics from 'expo-haptics';
import { Platform } from 'react-native';

class HapticsManager {
  private isEnabled = true;

  setEnabled(enabled: boolean) {
    this.isEnabled = enabled;
  }

  getEnabled() {
    return this.isEnabled;
  }

  // Used for successful tile placement
  playSnap() {
    if (!this.isEnabled || Platform.OS === 'web') return;
    Haptics.impactAsync(Haptics.ImpactFeedbackStyle.Light);
  }

  // Used when it becomes the local player's turn
  playTurnStart() {
    if (!this.isEnabled || Platform.OS === 'web') return;
    Haptics.impactAsync(Haptics.ImpactFeedbackStyle.Medium);
  }

  // Used for dragging to an invalid zone or drawing when empty
  playError() {
    if (!this.isEnabled || Platform.OS === 'web') return;
    Haptics.notificationAsync(Haptics.NotificationFeedbackType.Error);
  }

  // Used for game win
  playVictory() {
    if (!this.isEnabled || Platform.OS === 'web') return;
    Haptics.notificationAsync(Haptics.NotificationFeedbackType.Success);
  }

  // Used for game loss
  playDefeat() {
    if (!this.isEnabled || Platform.OS === 'web') return;
    Haptics.notificationAsync(Haptics.NotificationFeedbackType.Warning);
  }
}

export const haptics = new HapticsManager();
