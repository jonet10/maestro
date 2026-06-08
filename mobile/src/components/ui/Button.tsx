import React from 'react';
import { TouchableOpacity, Text, StyleSheet, ActivityIndicator, TouchableOpacityProps } from 'react-native';

interface ButtonProps extends TouchableOpacityProps {
  title: string;
  loading?: boolean;
  variant?: 'primary' | 'secondary' | 'outline';
}

export const Button = ({ title, loading, variant = 'primary', style, disabled, ...props }: ButtonProps) => {
  const getBackgroundColor = () => {
    if (variant === 'primary') return '#FFF';
    if (variant === 'secondary') return '#333';
    return 'transparent';
  };

  const getTextColor = () => {
    if (variant === 'primary') return '#000';
    return '#FFF';
  };

  return (
    <TouchableOpacity
      style={[
        styles.button,
        { backgroundColor: getBackgroundColor() },
        variant === 'outline' && styles.outline,
        (disabled || loading) && styles.disabled,
        style,
      ]}
      disabled={disabled || loading}
      {...props}
    >
      {loading ? (
        <ActivityIndicator color={getTextColor()} />
      ) : (
        <Text style={[styles.text, { color: getTextColor() }]}>{title}</Text>
      )}
    </TouchableOpacity>
  );
};

const styles = StyleSheet.create({
  button: {
    paddingVertical: 16,
    paddingHorizontal: 24,
    borderRadius: 12,
    alignItems: 'center',
    justifyContent: 'center',
    flexDirection: 'row',
  },
  text: {
    fontSize: 16,
    fontWeight: '700',
  },
  outline: {
    borderWidth: 1,
    borderColor: '#FFF',
  },
  disabled: {
    opacity: 0.5,
  },
});
