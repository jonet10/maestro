import { Platform } from 'react-native';

let Audio: any = null;
try {
  Audio = require('expo-av').Audio;
} catch (err) {
  console.warn("expo-av native module not found, sound will be disabled", err);
}

type SoundKey = 'tile_place' | 'tile_draw' | 'invalid_move' | 'turn_start' | 'victory' | 'defeat';

// Temporary remote placeholders so the bundler doesn't crash on missing local assets.
// Replace these with require('../../assets/sounds/...') when assets are ready.
const SOUND_ASSETS: Record<SoundKey, string> = {
  tile_place: 'https://cdn.pixabay.com/download/audio/2021/08/04/audio_0625c1539c.mp3', // snap
  tile_draw: 'https://cdn.pixabay.com/download/audio/2022/03/15/audio_2490eb93b0.mp3', // swoosh
  invalid_move: 'https://cdn.pixabay.com/download/audio/2022/03/15/audio_b8c9103636.mp3', // error
  turn_start: 'https://cdn.pixabay.com/download/audio/2021/08/09/audio_82c2b0e9fc.mp3', // pop
  victory: 'https://cdn.pixabay.com/download/audio/2021/08/04/audio_bb630cc098.mp3', // win
  defeat: 'https://cdn.pixabay.com/download/audio/2022/03/15/audio_9671181f08.mp3', // loss
};

class SoundManager {
  private sounds: Partial<Record<SoundKey, any>> = {};
  private isEnabled = true;

  setEnabled(enabled: boolean) {
    this.isEnabled = enabled;
  }

  getEnabled() {
    return this.isEnabled;
  }

  async preload() {
    if (Platform.OS === 'web' || !Audio) return;
    try {
      await Audio.setAudioModeAsync({
        playsInSilentModeIOS: true,
        staysActiveInBackground: false,
        shouldDuckAndroid: true,
      });

      // Preload all sounds
      const loadPromises = Object.entries(SOUND_ASSETS).map(async ([key, uri]) => {
        try {
          const { sound } = await Audio.Sound.createAsync({ uri });
          this.sounds[key as SoundKey] = sound;
        } catch (err) {
          console.warn(`Failed to preload sound: ${key}`, err);
        }
      });

      await Promise.all(loadPromises);
    } catch (err) {
      console.warn('Failed to initialize SoundManager', err);
    }
  }

  private lastPlayed: Record<SoundKey, number> = {} as Record<SoundKey, number>;
  private readonly THROTTLE_MS = 150;

  async play(key: SoundKey) {
    if (!this.isEnabled || Platform.OS === 'web' || !Audio) return;
    
    const now = Date.now();
    const last = this.lastPlayed[key] || 0;
    if (now - last < this.THROTTLE_MS) {
      return; // prevent spam
    }
    this.lastPlayed[key] = now;

    const sound = this.sounds[key];
    if (sound) {
      try {
        await sound.replayAsync();
      } catch (err) {
        console.warn(`Failed to play sound: ${key}`, err);
      }
    }
    // Sound not loaded (web or preload not done yet) — silently skip
  }

  async unload() {
    Object.values(this.sounds).forEach(async (sound) => {
      if (sound) {
        await sound.unloadAsync();
      }
    });
    this.sounds = {};
  }
}

export const sounds = new SoundManager();
