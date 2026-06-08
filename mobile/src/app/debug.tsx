import React, { useState } from 'react';
import {
  View,
  Text,
  StyleSheet,
  ScrollView,
  Pressable,
  Dimensions,
} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { router } from 'expo-router';
import { useMatchStore } from '../store/matchStore';
import { useMultiplayerStore } from '../multiplayer/store';
import { useMultiplayerMatch } from '../multiplayer/hooks';
import { engineIntegration } from '../engine/engineIntegration';
import { getBotAction } from '../engine/botLogic';
import { EngineGameState } from '../engine/types';
import { DominoBoard } from '../components/game';

const BG       = '#030810';
const SURFACE  = '#0D1117';
const SURFACE2 = '#161B22';
const GREEN    = '#39D353';
const ORANGE   = '#F5A623';
const RED      = '#F85149';
const BLUE     = '#58A6FF';
const TEXT     = '#FFFFFF';
const TEXT_DIM = '#8B949E';

// ─── Debug panel helpers ──────────────────────────────────────────────────────
function Label({ text }: { text: string }) {
  return <Text style={styles.panelLabel}>{text}</Text>;
}

function Value({ text, color }: { text: string; color?: string }) {
  return <Text style={[styles.panelValue, color ? { color } : {}]}>{text}</Text>;
}

function Row({ label, value, color }: { label: string; value: string; color?: string }) {
  return (
    <View style={styles.row}>
      <Label text={label} />
      <Value text={value} color={color} />
    </View>
  );
}

function SectionHeader({ title }: { title: string }) {
  return (
    <View style={styles.sectionHeader}>
      <Text style={styles.sectionHeaderText}>{title}</Text>
    </View>
  );
}

function DebugButton({
  label,
  onPress,
  color = SURFACE2,
  textColor = TEXT,
  disabled = false,
}: {
  label: string;
  onPress: () => void;
  color?: string;
  textColor?: string;
  disabled?: boolean;
}) {
  return (
    <Pressable
      style={[styles.debugBtn, { backgroundColor: color, opacity: disabled ? 0.4 : 1 }]}
      onPress={onPress}
      disabled={disabled}
    >
      <Text style={[styles.debugBtnText, { color: textColor }]}>{label}</Text>
    </Pressable>
  );
}

// ─── Debug Match Screen ───────────────────────────────────────────────────────
export default function DebugScreen() {
  const activeMatch = useMatchStore((s) => s.activeMatch);
  const clearMatch  = useMatchStore((s) => s.clearMatch);
  const updateEngineState = useMatchStore((s) => s.updateEngineState);

  const connectionState = useMultiplayerStore((s) => s.connectionState);
  const players         = useMultiplayerStore((s) => s.players);
  const gameStateRaw    = useMultiplayerStore((s) => s.gameState);
  const lastTs          = useMultiplayerStore((s) => s.lastEventTimestamp);

  const [log, setLog] = useState<string[]>(['[Debug] Screen mounted']);

  const addLog = (msg: string) => {
    const ts = new Date().toISOString().split('T')[1].slice(0, 12);
    setLog((prev) => [`[${ts}] ${msg}`, ...prev.slice(0, 49)]);
  };

  useMultiplayerMatch(activeMatch?.matchId ?? '');

  // Seed store on mount
  React.useEffect(() => {
    if (activeMatch?.engineState) {
      useMultiplayerStore
        .getState()
        .updateGameState(activeMatch.engineState as any, activeMatch.engineState.last_action_timestamp);
    }
  }, [activeMatch?.matchId]);

  React.useEffect(() => {
    if (gameStateRaw) {
      updateEngineState(gameStateRaw as unknown as EngineGameState);
    }
  }, [gameStateRaw]);

  if (!activeMatch) {
    return (
      <View style={styles.container}>
        <SafeAreaView style={styles.center}>
          <Text style={{ color: TEXT }}>No active match. Start from Home.</Text>
          <DebugButton label="← Back" onPress={() => router.back()} />
        </SafeAreaView>
      </View>
    );
  }

  const es = activeMatch.engineState;
  const localId    = activeMatch.localPlayerId;
  const opponentId = activeMatch.opponentId;

  const myHand       = es.player1_id === localId ? es.player1_hand : es.player2_hand;
  const oppHandCount = es.player1_id === localId ? es.player2_hand.length : es.player1_hand.length;

  const connColor: Record<string, string> = {
    disconnected: RED,
    connecting:   ORANGE,
    connected:    GREEN,
    recovering:   ORANGE,
  };

  const dispatch = (type: 'PLAY' | 'DRAW' | 'PASS' | 'TIMEOUT', extra?: any) => {
    addLog(`Dispatching action: ${type}`);
    engineIntegration.dispatchAction({
      type,
      playerId: localId,
      payload: extra,
      timestamp: Date.now(),
    });
  };

  const handleBotMove = () => {
    addLog('Executing bot move for opponent…');
    const botAction = getBotAction({ ...es, current_turn: opponentId });
    if (botAction) {
      addLog(`Bot action: ${botAction.type} ${JSON.stringify(botAction.payload ?? {})}`);
      engineIntegration.dispatchAction(botAction);
    } else {
      addLog('Bot has no valid action.');
    }
  };

  const handleManualSync = () => {
    addLog('Manual sync triggered — re-broadcasting current state');
    useMultiplayerStore.getState().updateGameState(es as any, Date.now());
  };

  const handlePlayFirst = () => {
    const firstTile = myHand[0];
    if (!firstTile) { addLog('No tiles in hand'); return; }
    dispatch('PLAY', { tile: firstTile, side: 'right' });
    addLog(`Played tile [${firstTile[0]}|${firstTile[1]}]`);
  };

  return (
    <View style={styles.container}>
      <SafeAreaView style={{ flex: 1 }}>
        <ScrollView contentContainerStyle={styles.scroll} showsVerticalScrollIndicator>

          {/* ── Top bar ── */}
          <View style={styles.topBar}>
            <Text style={styles.screenTitle}>🐛 Debug Match</Text>
            <DebugButton
              label="← Exit"
              onPress={() => { clearMatch(); router.replace('/(tabs)'); }}
              color={RED}
              textColor="#fff"
            />
          </View>

          {/* ── Connection State ── */}
          <SectionHeader title="Connection" />
          <View style={styles.panel}>
            <Row label="Status"    value={connectionState} color={connColor[connectionState] ?? TEXT} />
            <Row label="Match ID"  value={activeMatch.matchId} />
            <Row label="Players"   value={`${Object.keys(players).length} online`} />
            <Row label="Last Event TS" value={lastTs ? new Date(lastTs).toISOString().split('T')[1].slice(0, 12) : '—'} />
          </View>

          {/* ── Engine State ── */}
          <SectionHeader title="Engine State" />
          <View style={styles.panel}>
            <Row label="Status"      value={es.match_status} color={es.match_status === 'in_progress' ? GREEN : RED} />
            <Row label="Round"       value={String(es.round_number)} />
            <Row label="Turn"        value={es.current_turn === localId ? 'YOU' : 'OPPONENT'} color={es.current_turn === localId ? GREEN : ORANGE} />
            <Row label="Board Tiles" value={String(es.board_state.length)} />
            <Row label="Boneyard"    value={String(es.boneyard.length)} />
            <Row label="My Hand"     value={String(myHand.length)} />
            <Row label="Opp Hand"    value={String(oppHandCount)} />
            <Row label="Passes"      value={String(es.consecutive_passes)} />
            <Row label="Score"       value={`${es.player1_score} : ${es.player2_score}`} />
          </View>

          {/* ── My Hand ── */}
          <SectionHeader title={`My Hand (${myHand.length})`} />
          <View style={styles.panel}>
            {myHand.length === 0 ? (
              <Text style={styles.dimText}>Empty</Text>
            ) : (
              myHand.map(([a, b], i) => (
                <Text key={i} style={styles.tileText}>[{a}|{b}]</Text>
              ))
            )}
          </View>

          {/* ── Board ── */}
          <SectionHeader title={`Board (${es.board_state.length} tiles)`} />
          <View style={styles.panel}>
            {es.board_state.length === 0 ? (
              <Text style={styles.dimText}>Empty</Text>
            ) : (
              es.board_state.map((bt, i) => (
                <Text key={i} style={styles.tileText}>[{bt.tile[0]}|{bt.tile[1]}] {bt.side}</Text>
              ))
            )}
          </View>

          {/* ── Visual Board Preview ── */}
          {es.board_state.length > 0 && (
            <>
              <SectionHeader title="Visual Board" />
              <View style={styles.boardPreviewContainer}>
                <DominoBoard boardState={es.board_state} />
              </View>
            </>
          )}

          {/* ── Engine Actions ── */}
          <SectionHeader title="Engine Actions" />
          <View style={styles.btnGrid}>
            <DebugButton label="▶ Play First Tile" onPress={handlePlayFirst} color="#0D2B1A" textColor={GREEN} />
            <DebugButton label="⬇ Draw Tile"       onPress={() => dispatch('DRAW')}  color="#1A1A0D" textColor={ORANGE} />
            <DebugButton label="⏭ Pass Turn"       onPress={() => dispatch('PASS')}  color="#1A0D0D" textColor={RED} />
            <DebugButton label="🤖 Bot Move"        onPress={handleBotMove}           color="#0D0D2B" textColor={BLUE} />
            <DebugButton label="⏰ Force Timeout"   onPress={() => dispatch('TIMEOUT')} color={SURFACE2} />
            <DebugButton label="🔄 Manual Sync"    onPress={handleManualSync}        color={SURFACE2} />
          </View>

          {/* ── Event Log ── */}
          <SectionHeader title="Event Log" />
          <View style={styles.logPanel}>
            {log.map((line, i) => (
              <Text key={i} style={styles.logLine}>{line}</Text>
            ))}
          </View>

        </ScrollView>
      </SafeAreaView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: BG },
  center:    { flex: 1, alignItems: 'center', justifyContent: 'center', gap: 16, padding: 24 },
  scroll:    { paddingHorizontal: 12, paddingBottom: 40, gap: 4 },

  topBar: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    paddingVertical: 12,
  },
  screenTitle: { fontSize: 18, fontWeight: '800', color: TEXT },

  sectionHeader: {
    backgroundColor: SURFACE2,
    paddingHorizontal: 12,
    paddingVertical: 6,
    marginTop: 8,
    borderRadius: 6,
  },
  sectionHeaderText: {
    fontSize: 11,
    fontWeight: '700',
    color: BLUE,
    letterSpacing: 1.5,
    textTransform: 'uppercase',
  },

  panel: {
    backgroundColor: SURFACE,
    borderRadius: 8,
    padding: 12,
    gap: 6,
    borderWidth: 1,
    borderColor: SURFACE2,
  },
  row: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
  },
  panelLabel: { fontSize: 12, color: TEXT_DIM },
  panelValue: { fontSize: 12, fontWeight: '700', color: TEXT },

  btnGrid: {
    gap: 8,
  },
  debugBtn: {
    borderRadius: 8,
    paddingVertical: 12,
    paddingHorizontal: 16,
    alignItems: 'center',
  },
  debugBtnText: { fontSize: 13, fontWeight: '700' },

  logPanel: {
    backgroundColor: '#000',
    borderRadius: 8,
    padding: 12,
    borderWidth: 1,
    borderColor: '#1A1A1A',
    gap: 2,
    fontFamily: 'monospace',
  },
  logLine: {
    fontSize: 11,
    color: GREEN,
    fontFamily: 'monospace',
  },

  tileText: { fontSize: 13, color: TEXT, fontFamily: 'monospace' },
  dimText:  { fontSize: 12, color: TEXT_DIM, fontStyle: 'italic' },

  boardPreviewContainer: {
    backgroundColor: '#1a5a3a',
    borderRadius: 12,
    padding: 8,
    minHeight: 200,
    overflow: 'hidden',
  },
});
