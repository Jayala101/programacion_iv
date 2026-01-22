import React from 'react';
import { View, Text, StyleSheet, Pressable } from 'react-native';
import { Flight } from '../types/flight.types';
import colors from '../theme/colors';
import { spacing, borderRadius, fontSize } from '../theme/spacing';

interface FlightCardProps {
  flight: Flight;
  onPress?: () => void;
  isDeparture?: boolean;
}

const getStatusColor = (status: string) => {
  switch (status) {
    case 'onTime': return colors.onTime;
    case 'delayed': return colors.delayed;
    case 'boarding': return colors.boarding;
    case 'cancelled': return colors.cancelled;
    case 'departed': return colors.departed;
    default: return colors.textSecondary;
  }
};

const getStatusText = (status: string) => {
  switch (status) {
    case 'onTime': return 'A Tiempo';
    case 'delayed': return 'Retrasado';
    case 'boarding': return 'Abordando';
    case 'cancelled': return 'Cancelado';
    case 'departed': return 'Despegado';
    default: return status;
  }
};

export default function FlightCard({ flight, onPress, isDeparture = true }: FlightCardProps) {
  return (
    <Pressable
      onPress={onPress}
      style={({ pressed }) => [
        styles.container,
        pressed && styles.pressed,
      ]}
    >
      <View style={styles.header}>
        <View style={styles.flightInfo}>
          <Text style={styles.flightNumber}>{flight.flightNumber}</Text>
          <View style={[styles.statusBadge, { backgroundColor: getStatusColor(flight.status) }]}>
            <Text style={styles.statusText}>{getStatusText(flight.status)}</Text>
          </View>
        </View>
        <Text style={styles.time}>
          {isDeparture ? flight.departureTime : flight.arrivalTime}
        </Text>
      </View>

      <Text style={styles.airline}>{flight.airline}</Text>

      <View style={styles.routeContainer}>
        <Text style={styles.routeText}>
          {isDeparture ? flight.origin : flight.destination}
        </Text>
        <Text style={styles.arrow}>→</Text>
        <Text style={styles.routeText}>
          {isDeparture ? flight.destination : flight.origin}
        </Text>
      </View>

      <View style={styles.footer}>
        <View style={styles.gateInfo}>
          <Text style={styles.label}>Puerta:</Text>
          <Text style={styles.value}>{flight.gate}</Text>
        </View>
        <View style={styles.terminalInfo}>
          <Text style={styles.label}>Terminal:</Text>
          <Text style={styles.value}>{flight.terminal}</Text>
        </View>
      </View>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  container: {
    backgroundColor: colors.cardBg,
    borderRadius: borderRadius.md,
    padding: spacing.md,
    marginBottom: spacing.md,
    borderWidth: 1,
    borderColor: colors.border,
  },
  pressed: {
    opacity: 0.7,
  },
  header: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'flex-start',
    marginBottom: spacing.sm,
  },
  flightInfo: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: spacing.sm,
  },
  flightNumber: {
    fontSize: fontSize.xl,
    fontWeight: 'bold',
    color: colors.text,
  },
  statusBadge: {
    paddingHorizontal: spacing.sm,
    paddingVertical: 4,
    borderRadius: borderRadius.sm,
  },
  statusText: {
    fontSize: fontSize.xs,
    fontWeight: 'bold',
    color: '#fff',
  },
  time: {
    fontSize: fontSize.xl,
    fontWeight: 'bold',
    color: colors.primary,
  },
  airline: {
    fontSize: fontSize.sm,
    color: colors.textSecondary,
    marginBottom: spacing.sm,
  },
  routeContainer: {
    flexDirection: 'row',
    alignItems: 'center',
    gap: spacing.sm,
    marginBottom: spacing.md,
  },
  routeText: {
    fontSize: fontSize.md,
    fontWeight: '600',
    color: colors.text,
  },
  arrow: {
    fontSize: fontSize.md,
    color: colors.textSecondary,
  },
  footer: {
    flexDirection: 'row',
    gap: spacing.lg,
  },
  gateInfo: {
    flexDirection: 'row',
    gap: spacing.xs,
  },
  terminalInfo: {
    flexDirection: 'row',
    gap: spacing.xs,
  },
  label: {
    fontSize: fontSize.sm,
    color: colors.textSecondary,
  },
  value: {
    fontSize: fontSize.sm,
    fontWeight: '600',
    color: colors.text,
  },
});
