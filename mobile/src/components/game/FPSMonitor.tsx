import React, { useEffect, useState } from 'react';
import { View, Text, StyleSheet } from 'react-native';

export function FPSMonitor() {
  const [fps, setFps] = useState(0);

  useEffect(() => {
    if (!__DEV__) return; // Only run in dev mode

    let frameCount = 0;
    let lastTime = performance.now();
    let animationFrameId: number;

    const measureFPS = () => {
      frameCount++;
      const now = performance.now();
      
      if (now - lastTime >= 1000) {
        setFps(frameCount);
        frameCount = 0;
        lastTime = now;
      }
      animationFrameId = requestAnimationFrame(measureFPS);
    };

    animationFrameId = requestAnimationFrame(measureFPS);

    return () => cancelAnimationFrame(animationFrameId);
  }, []);

  if (!__DEV__) return null;

  return (
    <View style={styles.container}>
      <Text style={[styles.text, fps < 55 ? styles.warn : styles.good]}>
        {fps} FPS
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    position: 'absolute',
    top: 50,
    right: 16,
    backgroundColor: 'rgba(0,0,0,0.8)',
    paddingHorizontal: 8,
    paddingVertical: 4,
    borderRadius: 4,
    zIndex: 9999,
    borderWidth: 1,
    borderColor: '#30363D',
  },
  text: {
    fontFamily: 'monospace',
    fontWeight: 'bold',
    fontSize: 10,
  },
  good: { color: '#39D353' },
  warn: { color: '#F85149' },
});
