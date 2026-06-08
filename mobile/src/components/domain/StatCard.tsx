import React from 'react';
import { View, Text, StyleSheet } from 'react-native';

interface StatCardProps {
  title: string;
  value: string | number;
}

export const StatCard = ({ title, value }: StatCardProps) => {
  return (
    <View style={styles.card}>
      <Text style={styles.value}>{value}</Text>
      <Text style={styles.title}>{title}</Text>
    </View>
  );
};

const styles = StyleSheet.create({
  card: {
    backgroundColor: '#1E1E1E',
    borderRadius: 16,
    padding: 16,
    alignItems: 'center',
    justifyContent: 'center',
    flex: 1,
    margin: 4,
    borderWidth: 1,
    borderColor: '#333',
  },
  value: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#FFF',
    marginBottom: 4,
  },
  title: {
    fontSize: 12,
    color: '#A0A0A0',
    textTransform: 'uppercase',
    letterSpacing: 0.5,
  },
});
