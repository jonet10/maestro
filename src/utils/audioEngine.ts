// Simple Web Audio API synthesizer for domino sound effects

let audioCtx: AudioContext | null = null;
let hasUserInteracted = false;

// Initialize user interaction listener
if (typeof window !== 'undefined') {
  const handleInteraction = () => {
    hasUserInteracted = true;
    window.removeEventListener('click', handleInteraction);
    window.removeEventListener('keydown', handleInteraction);
    window.removeEventListener('touchstart', handleInteraction);
    // We don't pre-warm here because some browsers (like Safari) can still be picky 
    // about which event types unlock audio. We just record that an interaction happened.
  };
  window.addEventListener('click', handleInteraction, { once: true });
  window.addEventListener('keydown', handleInteraction, { once: true });
  window.addEventListener('touchend', handleInteraction, { once: true });
  window.addEventListener('pointerdown', handleInteraction, { once: true });
}

const initAudio = () => {
  if (!hasUserInteracted) return null;
  
  if (!audioCtx) {
    audioCtx = new (window.AudioContext || (window as any).webkitAudioContext)();
  }
  if (audioCtx.state === 'suspended' && !document.hidden) {
    audioCtx.resume().catch(() => {});
  }
  return audioCtx;
};

export const suspendAudio = () => {
  if (audioCtx && audioCtx.state === 'running') {
    audioCtx.suspend();
  }
};

export const resumeAudio = () => {
  if (audioCtx && audioCtx.state === 'suspended' && !document.hidden) {
    audioCtx.resume().catch(() => {});
  }
};

export const playTilePlacementSound = () => {
  try {
    const ctx = initAudio();
    if (!ctx) return;

    // Prevent warnings if browser blocks audio before user interaction
    if (ctx.state !== 'running') return;

    // We create two oscillators to simulate the hollow "clack" of dominoes
    const osc1 = ctx.createOscillator();
    const osc2 = ctx.createOscillator();
    const gainNode = ctx.createGain();
    
    // High frequency attack
    osc1.type = 'triangle';
    osc1.frequency.setValueAtTime(800, ctx.currentTime);
    osc1.frequency.exponentialRampToValueAtTime(100, ctx.currentTime + 0.03);

    // Lower body resonance
    osc2.type = 'sine';
    osc2.frequency.setValueAtTime(400, ctx.currentTime);
    osc2.frequency.exponentialRampToValueAtTime(50, ctx.currentTime + 0.05);

    // Sharp decay envelope for the "clack"
    gainNode.gain.setValueAtTime(0, ctx.currentTime);
    gainNode.gain.linearRampToValueAtTime(0.7, ctx.currentTime + 0.005);
    gainNode.gain.exponentialRampToValueAtTime(0.001, ctx.currentTime + 0.05);

    // Optional: Add a very short noise burst for texture (we'll just use the oscillators for simplicity)

    osc1.connect(gainNode);
    osc2.connect(gainNode);
    gainNode.connect(ctx.destination);

    osc1.start(ctx.currentTime);
    osc2.start(ctx.currentTime);
    
    osc1.stop(ctx.currentTime + 0.06);
    osc2.stop(ctx.currentTime + 0.06);

  } catch (err) {
    console.warn("Audio playback failed:", err);
  }
};
