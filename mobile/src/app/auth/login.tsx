import React, { useState } from 'react';
import {
  View, Text, TextInput, TouchableOpacity, StyleSheet,
  Alert, ActivityIndicator, ScrollView, KeyboardAvoidingView, Platform,
} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { router } from 'expo-router';
import { supabase } from '../../services/supabase';
import { useAuthStore } from '../../store/authStore';

const BG = '#080808';
const SURFACE = '#111111';
const SURFACE2 = '#1A1A1A';
const TEXT = '#FFFFFF';
const TEXT_DIM = '#888888';
const GOLD = '#F5A623';

export default function LoginScreen() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [loading, setLoading] = useState(false);
  const { setSession } = useAuthStore();

  const handleLogin = async () => {
    if (!email.trim() || !password.trim()) {
      Alert.alert('Erreur', 'Veuillez remplir tous les champs');
      return;
    }
    setLoading(true);
    try {
      const { data, error } = await supabase.auth.signInWithPassword({
        email: email.trim(),
        password,
      });
      if (error) throw error;
      setSession(data.session);
      router.replace('/(tabs)' as any);
    } catch (err: any) {
      Alert.alert('Erreur', err?.message || 'Une erreur est survenue');
    } finally {
      setLoading(false);
    }
  };

  return (
    <SafeAreaView style={styles.container}>
      <KeyboardAvoidingView
        style={{ flex: 1 }}
        behavior={Platform.OS === 'ios' ? 'padding' : undefined}
      >
        <ScrollView
          contentContainerStyle={styles.scroll}
          keyboardShouldPersistTaps="handled"
        >
          <View style={styles.header}>
            <Text style={styles.title}>MAESTRO DOMINO</Text>
            <Text style={styles.subtitle}>Connectez-vous</Text>
          </View>

          <View style={styles.form}>
            <Text style={styles.label}>Email</Text>
            <TextInput
              style={styles.input}
              value={email}
              onChangeText={setEmail}
              placeholder="votre@email.com"
              placeholderTextColor={TEXT_DIM}
              keyboardType="email-address"
              autoCapitalize="none"
              autoCorrect={false}
            />

            <Text style={styles.label}>Mot de passe</Text>
            <TextInput
              style={styles.input}
              value={password}
              onChangeText={setPassword}
              placeholder="••••••••"
              placeholderTextColor={TEXT_DIM}
              secureTextEntry
              autoCapitalize="none"
            />

            <TouchableOpacity
              style={[styles.button, loading && styles.buttonDisabled]}
              onPress={handleLogin}
              disabled={loading}
              activeOpacity={0.8}
            >
              {loading ? (
                <ActivityIndicator color="#000" />
              ) : (
                <Text style={styles.buttonText}>Se connecter</Text>
              )}
            </TouchableOpacity>

            <TouchableOpacity
              onPress={() => router.push('/auth/register' as any)}
              style={styles.link}
            >
              <Text style={styles.linkText}>
                Pas encore de compte ?{' '}
                <Text style={styles.linkHighlight}>Créer un compte</Text>
              </Text>
            </TouchableOpacity>

            <TouchableOpacity
              onPress={() => router.push('/auth/forgot-password' as any)}
              style={styles.link}
            >
              <Text style={styles.linkDim}>Mot de passe oublié ?</Text>
            </TouchableOpacity>
          </View>
        </ScrollView>
      </KeyboardAvoidingView>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, backgroundColor: BG },
  scroll: {
    flexGrow: 1,
    paddingHorizontal: 24,
    justifyContent: 'center',
    paddingVertical: 40,
  },
  header: { alignItems: 'center', marginBottom: 40 },
  title: {
    fontSize: 28,
    fontWeight: '900',
    color: GOLD,
    letterSpacing: 3,
    textAlign: 'center',
  },
  subtitle: {
    fontSize: 16,
    color: TEXT_DIM,
    marginTop: 8,
  },
  form: { gap: 4 },
  label: {
    color: TEXT,
    fontSize: 14,
    fontWeight: '600',
    marginBottom: 8,
    marginTop: 12,
  },
  input: {
    backgroundColor: SURFACE,
    borderWidth: 1,
    borderColor: SURFACE2,
    borderRadius: 14,
    padding: 16,
    color: TEXT,
    fontSize: 16,
  },
  button: {
    backgroundColor: GOLD,
    borderRadius: 14,
    paddingVertical: 16,
    alignItems: 'center',
    justifyContent: 'center',
    marginTop: 24,
  },
  buttonDisabled: { opacity: 0.6 },
  buttonText: { color: '#000', fontSize: 17, fontWeight: '800' },
  link: { alignItems: 'center', marginTop: 20 },
  linkText: { color: TEXT_DIM, fontSize: 14 },
  linkHighlight: { color: GOLD, fontWeight: '700' },
  linkDim: { color: TEXT_DIM, fontSize: 13, marginTop: 4 },
});
