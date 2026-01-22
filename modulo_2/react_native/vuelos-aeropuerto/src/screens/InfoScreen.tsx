import React from 'react';
import { View, Text, ScrollView, StyleSheet } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import GradientBg from '../components/GradientBg';
import colors from '../theme/colors';
import { spacing, borderRadius, fontSize } from '../theme/spacing';

export default function InfoScreen() {
  return (
    <GradientBg>
      <SafeAreaView style={styles.container} edges={['top']}>
        <View style={styles.header}>
          <Text style={styles.title}>ℹ️ Información</Text>
          <Text style={styles.subtitle}>Aeropuerto UTE</Text>
        </View>

        <ScrollView contentContainerStyle={styles.scrollContent}>
          {/* Card principal */}
          <View style={styles.mainCard}>
            <Text style={styles.airportIcon}>✈️</Text>
            <Text style={styles.airportName}>Aeropuerto UTE</Text>
            <Text style={styles.airportSubtitle}>Sistema de Información de Vuelos</Text>
          </View>

          {/* Servicios */}
          <View style={styles.card}>
            <Text style={styles.cardTitle}>⭐ Servicios</Text>
            <View style={styles.divider} />
            {[
              'WiFi gratuito en todas las terminales',
              'Salas VIP disponibles',
              'Restaurantes y cafeterías',
              'Tiendas duty-free',
              'Servicios médicos 24/7',
            ].map((item, index) => (
              <View key={index} style={styles.listItem}>
                <Text style={styles.bullet}>•</Text>
                <Text style={styles.itemText}>{item}</Text>
              </View>
            ))}
          </View>

          {/* Información General */}
          <View style={styles.card}>
            <Text style={styles.cardTitle}>📋 Información General</Text>
            <View style={styles.divider} />
            {[
              'Terminal 1: Vuelos nacionales',
              'Terminal 2: Vuelos internacionales',
              'Check-in: 2 horas antes del vuelo',
              'Puerta de embarque: 45 min antes',
              'Contacto: +34 900 123 456',
            ].map((item, index) => (
              <View key={index} style={styles.listItem}>
                <Text style={styles.bullet}>•</Text>
                <Text style={styles.itemText}>{item}</Text>
              </View>
            ))}
          </View>

          {/* Transporte */}
          <View style={styles.card}>
            <Text style={styles.cardTitle}>🚌 Transporte</Text>
            <View style={styles.divider} />
            {[
              'Metro: Línea 8 (cada 15 min)',
              'Autobuses: Líneas 101, 200, 203',
              'Taxis disponibles 24/7',
              'Parking: P1, P2, P3 (Larga estancia)',
              'Alquiler de coches en Terminal 1',
            ].map((item, index) => (
              <View key={index} style={styles.listItem}>
                <Text style={styles.bullet}>•</Text>
                <Text style={styles.itemText}>{item}</Text>
              </View>
            ))}
          </View>

          {/* Estados de vuelo */}
          <View style={styles.card}>
            <Text style={styles.cardTitle}>🏷️ Estados de Vuelo</Text>
            <View style={styles.divider} />
            <View style={styles.statusRow}>
              <View style={[styles.statusBadge, { backgroundColor: colors.onTime }]} />
              <Text style={styles.itemText}>A Tiempo</Text>
            </View>
            <View style={styles.statusRow}>
              <View style={[styles.statusBadge, { backgroundColor: colors.delayed }]} />
              <Text style={styles.itemText}>Retrasado</Text>
            </View>
            <View style={styles.statusRow}>
              <View style={[styles.statusBadge, { backgroundColor: colors.boarding }]} />
              <Text style={styles.itemText}>Abordando</Text>
            </View>
            <View style={styles.statusRow}>
              <View style={[styles.statusBadge, { backgroundColor: colors.cancelled }]} />
              <Text style={styles.itemText}>Cancelado</Text>
            </View>
            <View style={styles.statusRow}>
              <View style={[styles.statusBadge, { backgroundColor: colors.departed }]} />
              <Text style={styles.itemText}>Despegado</Text>
            </View>
          </View>
        </ScrollView>
      </SafeAreaView>
    </GradientBg>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  header: {
    padding: spacing.md,
    borderBottomWidth: 1,
    borderBottomColor: colors.border,
  },
  title: {
    fontSize: fontSize.xxl,
    fontWeight: 'bold',
    color: colors.text,
    marginBottom: spacing.xs,
  },
  subtitle: {
    fontSize: fontSize.sm,
    color: colors.textSecondary,
  },
  scrollContent: {
    padding: spacing.md,
  },
  mainCard: {
    backgroundColor: colors.primary + '20',
    borderRadius: borderRadius.lg,
    padding: spacing.xl,
    alignItems: 'center',
    marginBottom: spacing.md,
    borderWidth: 1,
    borderColor: colors.primary + '40',
  },
  airportIcon: {
    fontSize: 64,
    marginBottom: spacing.md,
  },
  airportName: {
    fontSize: fontSize.xl,
    fontWeight: 'bold',
    color: colors.text,
    marginBottom: spacing.xs,
  },
  airportSubtitle: {
    fontSize: fontSize.md,
    color: colors.textSecondary,
  },
  card: {
    backgroundColor: colors.cardBg,
    borderRadius: borderRadius.md,
    padding: spacing.md,
    marginBottom: spacing.md,
    borderWidth: 1,
    borderColor: colors.border,
  },
  cardTitle: {
    fontSize: fontSize.lg,
    fontWeight: 'bold',
    color: colors.text,
    marginBottom: spacing.sm,
  },
  divider: {
    height: 1,
    backgroundColor: colors.border,
    marginBottom: spacing.md,
  },
  listItem: {
    flexDirection: 'row',
    marginBottom: spacing.sm,
  },
  bullet: {
    fontSize: fontSize.md,
    color: colors.primary,
    marginRight: spacing.sm,
  },
  itemText: {
    fontSize: fontSize.md,
    color: colors.text,
    flex: 1,
  },
  statusRow: {
    flexDirection: 'row',
    alignItems: 'center',
    marginBottom: spacing.sm,
  },
  statusBadge: {
    width: 12,
    height: 12,
    borderRadius: 6,
    marginRight: spacing.sm,
  },
});
