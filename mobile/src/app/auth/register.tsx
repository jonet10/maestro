import React, { useState } from 'react';
import {
  View, Text, TextInput, TouchableOpacity, StyleSheet,
  Alert, ActivityIndicator, ScrollView, KeyboardAvoidingView, Platform,
} from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import { router } from 'expo-router';
import { supabase } from '../../services/supabase';

const BG = '#080808';
const SURFACE = '#111111';
const SURFACE2 = '#1A1A1A';
const TEXT = '#FFFFFF';
const TEXT_DIM = '#888888';
const GOLD = '#F5A623';

export default function RegisterScreen() {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [loading, setLoading] = useState(false);

  const handleRegister = async () => {
    if (!username.trim() || !email.trim() || !password || !confirmPassword) {
      Alert.alert('Erreur', 'Veuillez remplir tous les champs');
      return;
    }
    if (password !== confirmPassword) {
      Alert.alert('Erreur', 'Les mots de passe ne correspondent pas');
      return;
    }
    if (password.length < 6) {
      Alert.alert('Erreur', 'Le mot de passe doit contenir au moins 6 caractères');
      return;
    }
    if (username.trim().length < 3) {
      Alert.alert('Erreur', 'Le nom d\'utilisateur doit contenir au moins 3 caractères');
      return;
    }
    setLoading(true);
    try {
      const { data, error } = await supabase.auth.signUp({
        email: email.trim(),
        password,
      });
      if (error) throw error;
      if (!data.user) throw new Error('Erreur lors de la création du compte');

      const { error: insertError } = await supabase.from('players').insert([{
        id: data.user.id,
        username: username.trim(),
        email: email.trim(),
      }] as any);
      if (insertError) throw insertError;

      Alert.alert('Succès', 'Compte créé ! Connectez-vous', [
        { text: 'OK', onPress: () => router.replace('/auth/login' as any) },
      ]);
    } catch (err: any) {
      const msg = err?.message || 'Une erreur est survenue';
      if (msg.toLowerCase().includes('already registered')) {
        Alert.alert('Erreur', 'Cet email est déjà utilisé');
      } else if (msg.toLowerCase().includes('username')) {
        Alert.alert('Erreur', 'Ce nom d\'utilisateur est déjà pris');
      } else if (msg.includes('429') || msg.toLowerCase().includes('too many')) {
        Alert.alert('Trop de tentatives', 'Attendez quelques minutes avant de réessayer.');
      } else {
        Alert.alert('Erreur', msg);
      }
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
            <Text style={styles.subtitle}>Créez votre compte</Text>
          </View>

          <View style={styles.form}>
            <Text style={styles.label}>Nom d'utilisateur</Text>
            <TextInput
              style={styles.input}
              value={username}
              onChangeText={setUsername}
              placeholder="Votre pseudo"
              placeholderTextColor={TEXT_DIM}
              autoCapitalize="none"
              autoCorrect={false}
            />

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

            <Text style={styles.label}>Confirmer le mot de passe</Text>
            <TextInput
              style={styles.input}
              value={confirmPassword}
              onChangeText={setConfirmPassword}
              placeholder="••••••••"
              placeholderTextColor={TEXT_DIM}
              secureTextEntry
              autoCapitalize="none"
            />

            <TouchableOpacity
              style={[styles.button, loading && styles.buttonDisabled]}
              onPress={handleRegister}
              disabled={loading}
              activeOpacity={0.8}
            >
              {loading ? (
                <ActivityIndicator color="#000" />
              ) : (
                <Text style={styles.buttonText}>Créer un compte</Text>
              )}
            </TouchableOpacity>

            <TouchableOpacity
              onPress={() => router.push('/auth/login' as any)}
              style={styles.link}
            >
              <Text style={styles.linkText}>
                Déjà un compte ?{' '}
                <Text style={styles.linkHighlight}>Se connecter</Text>
              </Text>
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
});
