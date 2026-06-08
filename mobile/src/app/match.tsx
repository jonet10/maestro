import React, { useEffect, useRef, useState } from 'react';
import { View, StyleSheet, Pressable, Text } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { router } from 'expo-router';
import { GestureHandlerRootView } from 'react-native-gesture-handler';

import { useMatchStore } from '../store/matchStore';
import { useAuthStore } from '../store/authStore';
import { useMultiplayerStore } from '../multiplayer/store';
import { useMultiplayerMatch } from '../multiplayer/hooks';
import { realtimeManager } from '../multiplayer/realtime';
import { engineIntegration } from '../engine/engineIntegration';
import { EngineGameState, Tile } from '../engine/types';
import { getAIAction, getAIThinkDelay } from '../engine/aiPlayer';
import { hasPlayableTile, canPlayTile } from '../engine/moveValidator';

import {
  DominoBoard,
  PlayerHand,
  OpponentHand,
  MatchHUD,
  GameOverOverlay,
  FPSMonitor,
  ErrorBoundary,
  BoneyardPrompt
} from '../components/game';
import { sounds } from '../utils/SoundManager';
import { haptics } from '../utils/HapticsManager';

const BG = '#277A38'; // Flat green

export default function MatchScreen() {
  const activeMatch = useMatchStore((s) => s.activeMatch);
  const aiDifficulty = useMatchStore((s) => s.aiDifficulty);
  const updateEngineState = useMatchStore((s) => s.updateEngineState);
  const clearMatch = useMatchStore((s) => s.clearMatch);

  const gameStateFromStore = useMultiplayerStore((s) => s.gameState);
  const connectionState = useMultiplayerStore((s) => s.connectionState);
  const remoteDragPreview = useMultiplayerStore((s) => s.remoteDragPreview);

  const [selectedTile, setSelectedTile] = useState<Tile | null>(null);
  const [dragPreviewEnds, setDragPreviewEnds] = useState<{
    valid: { left: boolean; right: boolean; up: boolean; down: boolean };
    invalid: { left: boolean; right: boolean; up: boolean; down: boolean };
  } | null>(null);
  const [scorePopupPoints, setScorePopupPoints] = useState<number | null>(null);
  const prevScoresRef = useRef<{ my: number; opp: number }>({ my: 0, opp: 0 });

  useMultiplayerMatch(activeMatch?.matchId ?? '');

  // Bootstrap the multiplayerStore ONCE when a match starts (from matchStore initial state)
  useEffect(() => {
    if (activeMatch?.engineState) {
      const seedTs = Number(activeMatch.engineState.last_action_timestamp ?? 0) || Date.now();
      // Only seed if multiplayer store has no state yet (don't overwrite ongoing sync)
      if (!useMultiplayerStore.getState().gameState) {
        useMultiplayerStore.getState().updateGameState(activeMatch.engineState as any, seedTs);
      }
    }
  }, [activeMatch?.matchId]);

  // Single direction: multiplayerStore → matchStore.
  // The multiplayerStore is updated by engine dispatches and realtime events;
  // the matchStore follows it so the rest of the app stays consistent.
  useEffect(() => {
    if (gameStateFromStore) {
      updateEngineState(gameStateFromStore as unknown as EngineGameState);
    }
  }, [gameStateFromStore, updateEngineState]);

  useEffect(() => {
    if (!activeMatch) return;
    const es = activeMatch.engineState;
    const localId = activeMatch.localPlayerId;
    const myScore = es.player1_id === localId ? es.player1_score : es.player2_score;
    const opponentScore = es.player1_id === localId ? es.player2_score : es.player1_score;
    const prev = prevScoresRef.current;
    const delta = Math.max(myScore - prev.my, opponentScore - prev.opp);
    if (delta > 0) {
      setScorePopupPoints(delta);
      const t = setTimeout(() => setScorePopupPoints(null), 1000);
      prevScoresRef.current = { my: myScore, opp: opponentScore };
      return () => clearTimeout(t);
    }
    prevScoresRef.current = { my: myScore, opp: opponentScore };
  }, [activeMatch?.engineState]);

  useEffect(() => {
    if (!activeMatch) return;

    const es = activeMatch.engineState;
    const localId = activeMatch.localPlayerId;
    const botId = activeMatch.opponentId;
    const localOfflineMode = activeMatch.matchId.startsWith('local_match_') || activeMatch.matchId.startsWith('debug_match_');
    const localGameOver = es.match_status === 'completed' || es.match_status === 'cancelled';
    const localMyTurn = es.current_turn === localId;

    if (!localOfflineMode || localGameOver || localMyTurn || es.current_turn !== botId) return;

    const botHand = es.player1_id === botId ? es.player1_hand : es.player2_hand;
    if (!botHand.length) return;

    const delay = getAIThinkDelay({ difficulty: aiDifficulty });

    const timer = setTimeout(() => {
      const action = getAIAction(es, botId, { difficulty: aiDifficulty });
      engineIntegration.dispatchAction(action);
    }, delay);

    return () => clearTimeout(timer);
  }, [activeMatch, aiDifficulty]);

  if (!activeMatch) {
    return (
      <View style={styles.container}>
        <SafeAreaView style={styles.center}>
          <Text style={styles.errorText}>Aucune partie active.</Text>
          <Pressable style={styles.backBtn} onPress={() => router.back()}>
            <Text style={styles.backBtnText}>← Retour</Text>
          </Pressable>
        </SafeAreaView>
      </View>
    );
  }

  const engineState = activeMatch.engineState;
  const mode = engineState.game_mode ?? 'fives';
  const localId = activeMatch.localPlayerId;
  const isMyTurn = engineState.current_turn === localId;
  const isOfflineMode = activeMatch.matchId.startsWith('local_match_') || activeMatch.matchId.startsWith('debug_match_');
  const opponentDragPreview = remoteDragPreview?.playerId === localId ? null : remoteDragPreview;

  const profile = useAuthStore((s) => s.profile);
  const myName = profile?.username ?? 'Vous';
  // Attempt to make opponent name somewhat real based on ID if no profile available
  const oppId = activeMatch.opponentId;
  const opponentName = oppId && oppId.length > 5 ? oppId.substring(0, 6) : 'Adversaire';

  const myHand = engineState.player1_id === localId ? engineState.player1_hand : engineState.player2_hand;
  const hasPlayable = hasPlayableTile(engineState.board_state, myHand);
  const canDraw = isMyTurn && mode !== 'block' && engineState.boneyard.length > 0 && !hasPlayable;
  const canPass = isMyTurn && !hasPlayable && (mode === 'block' || engineState.boneyard.length === 0);
  const opponentHand = engineState.player1_id === localId ? engineState.player2_hand : engineState.player1_hand;
  const opponentHandCount = opponentHand.length;
  const myScore = engineState.player1_id === localId ? engineState.player1_score : engineState.player2_score;
  const opponentScore = engineState.player1_id === localId ? engineState.player2_score : engineState.player1_score;
  const selectedPlayability = selectedTile
    ? canPlayTile(engineState.board_state, selectedTile)
    : { left: false, right: false, up: false, down: false };
  const boardPlayableEnds = dragPreviewEnds?.valid ?? (selectedTile ? selectedPlayability : undefined);
  const boardInvalidEnds = dragPreviewEnds?.invalid;

  const handlePlayTile = (tile: Tile, requestedSide: 'left' | 'right' | 'up' | 'down') => {
    if (!isMyTurn) return;
    const playability = canPlayTile(engineState.board_state, tile);
    let finalSide: 'left' | 'right' | 'up' | 'down' | 'first' = requestedSide;

    // Empty board — place as first tile
    if (engineState.board_state.length === 0) {
      finalSide = 'first';
    } else {
      // Auto-resolve if only one side is valid
      const validSides = (['left', 'right', 'up', 'down'] as const).filter((s) => playability[s]);
      if (validSides.length === 0) return; // nothing playable
      if (!playability[requestedSide] && validSides.length === 1) {
        finalSide = validSides[0];
      }
    }

    sounds.play('tile_place');
    haptics.playSnap();
    engineIntegration.dispatchAction({
      type: 'PLAY',
      playerId: localId,
      payload: { tile, side: finalSide as any },
      timestamp: Date.now(),
    });
    setSelectedTile(null);
  };

  const handleDraw = () => engineIntegration.dispatchAction({ type: 'DRAW', playerId: localId, timestamp: Date.now() });
  const handlePass = () => engineIntegration.dispatchAction({ type: 'PASS', playerId: localId, timestamp: Date.now() });

  const isGameOver = engineState.match_status === 'completed' || engineState.match_status === 'cancelled';
  let winnerId = null;
  if (isGameOver) {
    if (engineState.player1_score > engineState.player2_score) winnerId = engineState.player1_id;
    else if (engineState.player2_score > engineState.player1_score) winnerId = engineState.player2_id;
    else winnerId = 'tie';
  }

  return (
    <GestureHandlerRootView style={styles.container}>
      <SafeAreaView style={styles.safeArea}>
        {__DEV__ && <FPSMonitor />}

        <MatchHUD
          myScore={myScore}
          opponentScore={opponentScore}
          isMyTurn={isMyTurn}
          matchStatus={engineState.match_status}
          connectionState={connectionState}
          isOfflineMode={isOfflineMode}
          isOpponentDragging={!!opponentDragPreview}
          targetScore={mode === 'fives' ? 150 : 50}
          myName={myName}
          opponentName={opponentName}
        />

        <OpponentHand count={opponentHandCount} hand={opponentHand} faceDown />

        <ErrorBoundary>
          <DominoBoard
            boardState={engineState.board_state}
            isMyTurn={isMyTurn}
            remoteDragPreview={opponentDragPreview}
            showPlayableEnds={boardPlayableEnds}
            showInvalidEnds={boardInvalidEnds}
            scorePopupPoints={scorePopupPoints}
            onSelectEnd={(side) => {
              if (!selectedTile || !isMyTurn || isGameOver) return;
              handlePlayTile(selectedTile, side);
            }}
          />
        </ErrorBoundary>

        <BoneyardPrompt 
          visible={canDraw} 
          onDraw={handleDraw} 
          boneyardCount={engineState.boneyard.length} 
        />

        {isMyTurn && !isGameOver && (
          <View style={styles.actionRow}>
            <Pressable style={[styles.actionBtn, !canDraw && styles.actionBtnDisabled]} onPress={handleDraw} disabled={!canDraw}>
              <Text style={styles.actionBtnText}>Piocher ({engineState.boneyard.length})</Text>
            </Pressable>
            <Pressable style={[styles.actionBtn, !canPass && styles.actionBtnDisabled]} onPress={handlePass} disabled={!canPass}>
              <Text style={styles.actionBtnText}>Passer</Text>
            </Pressable>
          </View>
        )}

        <View style={styles.boardInfoBanner}>
          <Text style={styles.boardInfoText}>Board {engineState.board_state.length} <Text style={styles.boardInfoDivider}>|</Text> Boneyard {engineState.boneyard.length}</Text>
        </View>

        <View style={{ zIndex: 9999, elevation: 9999 }}>
          <PlayerHand
            hand={myHand}
            isMyTurn={isMyTurn && !isGameOver}
            onPlayTile={handlePlayTile}
            selectedTile={selectedTile}
            isTilePlayable={(tile) => {
              const p = canPlayTile(engineState.board_state, tile);
              return p.left || p.right || p.up || p.down;
            }}
            onSelectTile={(tile) => {
              if (!isMyTurn || isGameOver) return;
              const play = canPlayTile(engineState.board_state, tile);
              if (engineState.board_state.length === 0) return handlePlayTile(tile, 'right');
              const validSides = (['left', 'right', 'up', 'down'] as const).filter((s) => play[s]);
              if (validSides.length === 0) return setSelectedTile(null);
              if (validSides.length === 1) return handlePlayTile(tile, validSides[0]);
              // Multiple valid ends — let the user tap an end indicator
              setSelectedTile(tile);
            }}
            onDragPreview={isOfflineMode ? undefined : ({ tile, x, y, side, isDropZone }) => {
              const p = canPlayTile(engineState.board_state, tile);
              if (!isDropZone) {
                setDragPreviewEnds(null);
              } else if (side === 'left') {
                setDragPreviewEnds({
                  valid: { left: p.left, right: false, up: false, down: false },
                  invalid: { left: !p.left, right: false, up: false, down: false },
                });
              } else if (side === 'right') {
                setDragPreviewEnds({
                  valid: { left: false, right: p.right, up: false, down: false },
                  invalid: { left: false, right: !p.right, up: false, down: false },
                });
              } else {
                setDragPreviewEnds(null);
              }
              realtimeManager.broadcast({ type: 'DRAG_PREVIEW', payload: { playerId: localId, tile, x, y } });
            }}
            onDragRelease={isOfflineMode ? undefined : () => {
              setDragPreviewEnds(null);
              realtimeManager.broadcast({ type: 'DRAG_RELEASE', payload: { playerId: localId } });
            }}
          />
        </View>

        {isGameOver && (
          <GameOverOverlay
            winnerId={winnerId}
            localPlayerId={localId}
            myScore={myScore}
            opponentScore={opponentScore}
            onRematch={() => {
              clearMatch();
              router.replace('/(tabs)');
            }}
            onHome={() => {
              clearMatch();
              router.replace('/(tabs)');
            }}
          />
        )}
      </SafeAreaView>
    </GestureHandlerRootView>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: BG },
  safeArea: { flex: 1, backgroundColor: '#863614' }, // Make safe area match wood color to avoid white gaps, DominoBoard will draw green
  center: { flex: 1, alignItems: 'center', justifyContent: 'center', gap: 16 },
  errorText: { color: '#FFF', fontSize: 18 },
  backBtn: { backgroundColor: '#161B22', borderRadius: 10, padding: 14, borderWidth: 1, borderColor: '#30363D' },
  backBtnText: { color: '#58A6FF', fontWeight: '700' },
  actionRow: {
    flexDirection: 'row',
    paddingHorizontal: 16,
    paddingVertical: 12,
    gap: 12,
    backgroundColor: '#863614', // Match wood theme
    borderTopWidth: 1,
    borderTopColor: '#a64a20',
  },
  actionBtn: {
    flex: 1,
    backgroundColor: '#5c2209', // Dark wood
    borderWidth: 1,
    borderColor: '#3c1704',
    borderRadius: 8,
    paddingVertical: 12,
    alignItems: 'center',
  },
  actionBtnDisabled: { opacity: 0.4 },
  actionBtnText: { color: '#FFF', fontWeight: '700', fontSize: 14 },
  boardInfoBanner: {
    backgroundColor: 'rgba(15, 60, 25, 0.8)', // Dark green semitransparent
    paddingVertical: 6,
    width: '100%',
    alignItems: 'center',
    borderBottomWidth: 1,
    borderBottomColor: '#2b1003',
    zIndex: 1,
    elevation: 1,
  },
  boardInfoText: {
    color: '#FFF',
    fontSize: 14,
    fontWeight: '600',
  },
  boardInfoDivider: {
    color: '#86efac',
    fontWeight: '300',
    marginHorizontal: 8,
  },
});
