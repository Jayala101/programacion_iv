import React, { useState } from 'react';
import { View, Text, FlatList, StyleSheet, Modal, Pressable, ScrollView } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import GradientBg from '../components/GradientBg';
import FlightCard from '../components/FlightCard';
import { useFlights } from '../context/FlightContext';
import colors from '../theme/colors';
import { spacing, borderRadius, fontSize } from '../theme/spacing';
import { Flight } from '../types/flight.types';

export default function ArrivalsScreen() {
  const { arrivals } = useFlights();
  const [selectedFlight, setSelectedFlight] = useState<Flight | null>(null);

  return (
    <GradientBg>
      <SafeAreaView style={styles.container} edges={['top']}>
        <View style={styles.header}>
          <Text style={styles.title}>🛬 Llegadas</Text>
          <Text style={styles.subtitle}>Vuelos que llegan al aeropuerto</Text>
        </View>

        <FlatList
          data={arrivals}
          keyExtractor={(item) => item.id}
          renderItem={({ item }) => (
            <FlightCard
              flight={item}
              isDeparture={false}
              onPress={() => setSelectedFlight(item)}
            />
          )}
          contentContainerStyle={styles.listContent}
        />

        {/* Modal de detalles */}
        <Modal
          visible={selectedFlight !== null}
          transparent={true}
          animationType="fade"
          onRequestClose={() => setSelectedFlight(null)}
        >
          <Pressable
            style={styles.modalOverlay}
            onPress={() => setSelectedFlight(null)}
          >
            <Pressable style={styles.modalContent} onPress={(e) => e.stopPropagation()}>
              {selectedFlight && (
                <ScrollView>
                  <View style={styles.modalHeader}>
                    <Text style={styles.modalTitle}>Detalles del Vuelo</Text>
                    <Pressable onPress={() => setSelectedFlight(null)}>
                      <Text style={styles.closeButton}>✕</Text>
                    </Pressable>
                  </View>

                  <View style={styles.detailRow}>
                    <Text style={styles.detailLabel}>Número de Vuelo:</Text>
                    <Text style={styles.detailValue}>{selectedFlight.flightNumber}</Text>
                  </View>
                  <View style={styles.detailRow}>
                    <Text style={styles.detailLabel}>Aerolínea:</Text>
                    <Text style={styles.detailValue}>{selectedFlight.airline}</Text>
                  </View>
                  <View style={styles.detailRow}>
                    <Text style={styles.detailLabel}>Origen:</Text>
                    <Text style={styles.detailValue}>{selectedFlight.origin}</Text>
                  </View>
                  <View style={styles.detailRow}>
                    <Text style={styles.detailLabel}>Destino:</Text>
                    <Text style={styles.detailValue}>{selectedFlight.destination}</Text>
                  </View>
                  <View style={styles.detailRow}>
                    <Text style={styles.detailLabel}>Salida:</Text>
                    <Text style={styles.detailValue}>{selectedFlight.departureTime}</Text>
                  </View>
                  <View style={styles.detailRow}>
                    <Text style={styles.detailLabel}>Llegada:</Text>
                    <Text style={styles.detailValue}>{selectedFlight.arrivalTime}</Text>
                  </View>
                  <View style={styles.detailRow}>
                    <Text style={styles.detailLabel}>Puerta:</Text>
                    <Text style={styles.detailValue}>{selectedFlight.gate}</Text>
                  </View>
                  <View style={styles.detailRow}>
                    <Text style={styles.detailLabel}>Terminal:</Text>
                    <Text style={styles.detailValue}>{selectedFlight.terminal}</Text>
                  </View>
                  <View style={styles.detailRow}>
                    <Text style={styles.detailLabel}>Fecha:</Text>
                    <Text style={styles.detailValue}>{selectedFlight.date}</Text>
                  </View>
                </ScrollView>
              )}
            </Pressable>
          </Pressable>
        </Modal>
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
  listContent: {
    padding: spacing.md,
  },
  modalOverlay: {
    flex: 1,
    backgroundColor: 'rgba(0, 0, 0, 0.7)',
    justifyContent: 'center',
    alignItems: 'center',
    padding: spacing.md,
  },
  modalContent: {
    backgroundColor: colors.surface,
    borderRadius: borderRadius.lg,
    padding: spacing.lg,
    width: '100%',
    maxHeight: '80%',
    borderWidth: 1,
    borderColor: colors.border,
  },
  modalHeader: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    alignItems: 'center',
    marginBottom: spacing.lg,
    paddingBottom: spacing.md,
    borderBottomWidth: 1,
    borderBottomColor: colors.border,
  },
  modalTitle: {
    fontSize: fontSize.xl,
    fontWeight: 'bold',
    color: colors.text,
  },
  closeButton: {
    fontSize: fontSize.xl,
    color: colors.textSecondary,
    padding: spacing.xs,
  },
  detailRow: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    paddingVertical: spacing.sm,
    borderBottomWidth: 1,
    borderBottomColor: colors.border,
  },
  detailLabel: {
    fontSize: fontSize.md,
    color: colors.textSecondary,
  },
  detailValue: {
    fontSize: fontSize.md,
    fontWeight: '600',
    color: colors.text,
  },
});
