import React, { useState, useEffect } from 'react';
import { View, Text, StyleSheet, ScrollView, Pressable, ActivityIndicator, Share } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { router } from 'expo-router';
import { TEST_SCENARIOS, testRunner, testLogger, TestResult, TestScenario } from '../testing';

const BG       = '#030810';
const SURFACE  = '#0D1117';
const SURFACE2 = '#161B22';
const GREEN    = '#39D353';
const ORANGE   = '#F5A623';
const RED      = '#F85149';
const BLUE     = '#58A6FF';
const TEXT     = '#FFFFFF';
const TEXT_DIM = '#8B949E';

function StatusBadge({ status }: { status: TestResult['status'] | undefined }) {
  if (!status) return null;
  const colors: Record<string, string> = {
    idle: TEXT_DIM,
    running: ORANGE,
    pass: GREEN,
    fail: RED,
    warning: ORANGE,
  };
  return (
    <View style={[styles.badge, { backgroundColor: colors[status] }]}>
      <Text style={styles.badgeText}>{status.toUpperCase()}</Text>
    </View>
  );
}

export default function TestDashboardScreen() {
  const [activeResult, setActiveResult] = useState<TestResult | null>(null);

  useEffect(() => {
    testRunner.onUpdate((result) => {
      setActiveResult(result);
    });
  }, []);

  const handleRunTest = async (scenario: TestScenario) => {
    await testRunner.run(scenario);
  };

  const handleCancel = () => {
    testRunner.cancel();
  };

  const exportLogs = async () => {
    const text = testLogger.toText();
    if (!text) return;
    try {
      await Share.share({
        message: text,
        title: 'Maestro Domino Test Logs',
      });
    } catch (err: any) {
      console.error('Failed to share logs:', err);
    }
  };

  return (
    <View style={styles.container}>
      <SafeAreaView style={{ flex: 1 }}>
        <View style={styles.topBar}>
          <Text style={styles.screenTitle}>🧪 QA Dashboard</Text>
          <Pressable style={styles.exitBtn} onPress={() => router.back()}>
            <Text style={styles.exitBtnText}>Exit</Text>
          </Pressable>
        </View>

        <ScrollView contentContainerStyle={styles.scroll} showsVerticalScrollIndicator>
          
          <Text style={styles.sectionTitle}>Test Scenarios</Text>
          <View style={styles.scenariosGrid}>
            {TEST_SCENARIOS.map((scenario) => {
              const isRunningThis = activeResult?.status === 'running' && activeResult.name === scenario.name;
              return (
                <View key={scenario.id} style={styles.scenarioCard}>
                  <View style={styles.scenarioHeader}>
                    <Text style={styles.scenarioName}>{scenario.name}</Text>
                    {isRunningThis && <ActivityIndicator color={ORANGE} size="small" />}
                  </View>
                  <Text style={styles.scenarioDesc}>{scenario.description}</Text>
                  <Pressable
                    style={[styles.runBtn, isRunningThis && styles.runBtnDisabled]}
                    onPress={() => handleRunTest(scenario)}
                    disabled={activeResult?.status === 'running'}
                  >
                    <Text style={styles.runBtnText}>Run Test</Text>
                  </Pressable>
                </View>
              );
            })}
          </View>

          {activeResult && (
            <View style={styles.resultContainer}>
              <View style={styles.resultHeader}>
                <Text style={styles.resultTitle}>{activeResult.name}</Text>
                <StatusBadge status={activeResult.status} />
              </View>
              
              {activeResult.status === 'running' && (
                <Pressable style={styles.cancelBtn} onPress={handleCancel}>
                  <Text style={styles.cancelBtnText}>Cancel</Text>
                </Pressable>
              )}

              {activeResult.durationMs !== null && (
                <Text style={styles.durationText}>Completed in {activeResult.durationMs}ms</Text>
              )}

              {activeResult.errorSummary && (
                <Text style={styles.errorText}>{activeResult.errorSummary}</Text>
              )}

              {activeResult.metrics && activeResult.metrics.length > 0 && (
                <View style={styles.metricsBox}>
                  <Text style={styles.boxTitle}>Metrics</Text>
                  {activeResult.metrics.map((m, i) => (
                    <View key={i} style={styles.metricRow}>
                      <Text style={styles.metricLabel}>{m.label}</Text>
                      <Text style={styles.metricValue}>{m.durationMs}ms</Text>
                    </View>
                  ))}
                </View>
              )}

              {activeResult.syncReport && (
                <View style={styles.metricsBox}>
                  <Text style={styles.boxTitle}>Sync Report</Text>
                  <View style={styles.metricRow}>
                    <Text style={styles.metricLabel}>Total Actions</Text>
                    <Text style={styles.metricValue}>{activeResult.syncReport.totalActions}</Text>
                  </View>
                  <View style={styles.metricRow}>
                    <Text style={styles.metricLabel}>Accepted</Text>
                    <Text style={[styles.metricValue, {color: GREEN}]}>{activeResult.syncReport.acceptedActions}</Text>
                  </View>
                  <View style={styles.metricRow}>
                    <Text style={styles.metricLabel}>Rejected</Text>
                    <Text style={[styles.metricValue, activeResult.syncReport.rejectedActions > 0 ? {color: RED} : {}]}>{activeResult.syncReport.rejectedActions}</Text>
                  </View>
                  <View style={styles.metricRow}>
                    <Text style={styles.metricLabel}>Desync Events</Text>
                    <Text style={[styles.metricValue, activeResult.syncReport.desyncEvents > 0 ? {color: RED} : {}]}>{activeResult.syncReport.desyncEvents}</Text>
                  </View>
                  <View style={styles.metricRow}>
                    <Text style={styles.metricLabel}>Avg Latency</Text>
                    <Text style={styles.metricValue}>{activeResult.syncReport.avgLatencyMs}ms</Text>
                  </View>
                  <View style={styles.metricRow}>
                    <Text style={styles.metricLabel}>Max Drift</Text>
                    <Text style={styles.metricValue}>{activeResult.syncReport.maxDriftMs}ms</Text>
                  </View>
                </View>
              )}

              <View style={styles.logsBox}>
                <View style={styles.logsHeader}>
                  <Text style={styles.boxTitle}>Logs ({activeResult.logs.length})</Text>
                  <Pressable style={styles.exportBtn} onPress={exportLogs}>
                    <Text style={styles.exportBtnText}>Export</Text>
                  </Pressable>
                </View>
                <View style={styles.logContent}>
                  {activeResult.logs.slice(-50).map((log, i) => { // show last 50
                    const time = new Date(log.ts).toISOString().split('T')[1].slice(0, 12);
                    let color = TEXT_DIM;
                    if (log.level === 'error') color = RED;
                    if (log.level === 'warn') color = ORANGE;
                    if (log.level === 'info') color = GREEN;
                    if (log.level === 'metric') color = BLUE;
                    return (
                      <Text key={i} style={[styles.logLine, { color }]}>
                        [{time}] [{log.tag}] {log.message}
                      </Text>
                    );
                  })}
                </View>
              </View>

            </View>
          )}

        </ScrollView>
      </SafeAreaView>
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: BG },
  topBar: {
    flexDirection: 'row',
    alignItems: 'center',
    justifyContent: 'space-between',
    padding: 16,
    borderBottomWidth: 1,
    borderBottomColor: SURFACE2,
  },
  screenTitle: { fontSize: 20, fontWeight: '800', color: TEXT },
  exitBtn: { padding: 8 },
  exitBtnText: { color: RED, fontWeight: '700' },
  scroll: { padding: 16, gap: 24, paddingBottom: 60 },
  sectionTitle: { fontSize: 18, fontWeight: '700', color: TEXT, marginBottom: 8 },
  scenariosGrid: { gap: 12 },
  scenarioCard: {
    backgroundColor: SURFACE,
    borderRadius: 12,
    padding: 16,
    borderWidth: 1,
    borderColor: SURFACE2,
    gap: 8,
  },
  scenarioHeader: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' },
  scenarioName: { fontSize: 16, fontWeight: '700', color: TEXT },
  scenarioDesc: { fontSize: 13, color: TEXT_DIM, lineHeight: 18 },
  runBtn: {
    backgroundColor: SURFACE2,
    paddingVertical: 10,
    borderRadius: 8,
    alignItems: 'center',
    marginTop: 4,
  },
  runBtnDisabled: { opacity: 0.5 },
  runBtnText: { color: BLUE, fontWeight: '700' },
  resultContainer: {
    backgroundColor: SURFACE,
    borderRadius: 12,
    padding: 16,
    borderWidth: 1,
    borderColor: SURFACE2,
    gap: 16,
  },
  resultHeader: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' },
  resultTitle: { fontSize: 16, fontWeight: '700', color: TEXT, flex: 1 },
  badge: { paddingHorizontal: 8, paddingVertical: 4, borderRadius: 4 },
  badgeText: { fontSize: 10, fontWeight: '800', color: '#000' },
  durationText: { fontSize: 12, color: TEXT_DIM },
  errorText: { fontSize: 14, color: RED, fontWeight: '600' },
  cancelBtn: { backgroundColor: RED, padding: 8, borderRadius: 6, alignSelf: 'flex-start' },
  cancelBtnText: { color: '#000', fontWeight: '700', fontSize: 12 },
  metricsBox: { backgroundColor: '#000', borderRadius: 8, padding: 12, borderWidth: 1, borderColor: SURFACE2, gap: 8 },
  boxTitle: { fontSize: 14, fontWeight: '700', color: TEXT_DIM, marginBottom: 4 },
  metricRow: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' },
  metricLabel: { fontSize: 13, color: TEXT },
  metricValue: { fontSize: 13, fontWeight: '700', color: TEXT },
  logsBox: { backgroundColor: '#000', borderRadius: 8, padding: 12, borderWidth: 1, borderColor: SURFACE2, gap: 8 },
  logsHeader: { flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center' },
  exportBtn: { paddingHorizontal: 12, paddingVertical: 6, backgroundColor: SURFACE2, borderRadius: 6 },
  exportBtnText: { color: TEXT, fontSize: 12, fontWeight: '600' },
  logContent: { gap: 2 },
  logLine: { fontFamily: 'monospace', fontSize: 10 },
});
