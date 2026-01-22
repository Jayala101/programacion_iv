import React from 'react';
import { View, StyleSheet, ViewStyle } from 'react-native';
import { LinearGradient } from 'expo-linear-gradient';
import colors from '../theme/colors';

interface GradientBgProps {
  children: React.ReactNode;
  style?: ViewStyle;
}

export default function GradientBg({ children, style }: GradientBgProps) {
  return (
    <LinearGradient
      colors={['#0a0e27', '#1a1f3a', '#0a0e27']}
      style={[styles.container, style]}
    >
      {children}
    </LinearGradient>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});
