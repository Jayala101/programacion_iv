import React, { useState } from 'react';
import { View, Text, TextInput, FlatList, StyleSheet } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';
import GradientBg from '../components/GradientBg';
import FlightCard from '../components/FlightCard';
import { useFlights } from '../context/FlightContext';
import colors from '../theme/colors';
import { spacing, borderRadius, fontSize } from '../theme/spacing';

export default function SearchScreen() {
  const { searchFlights } = useFlights();
  const [query, setQuery] = useState('');
  const results = searchFlights(query);

  return (
    <GradientBg>
      <SafeAreaView style={styles.container} edges={['top']}>
        <View style={styles.header}>
          <Text style={styles.title}>🔍 Buscar Vuelos</Text>
        </View>

        <View style={styles.searchContainer}>
          <TextInput
            style={styles.searchInput}
            placeholder="Número de vuelo, origen o destino..."
            placeholderTextColor={colors.textSecondary}
            value={query}
            onChangeText={setQuery}
          />
        </View>

        {query.trim() === '' ? (
          <View style={styles.emptyContainer}>
            <Text style={styles.emptyIcon}>🔎</Text>
            <Text style={styles.emptyTitle}>Busca tu vuelo</Text>
            <Text style={styles.emptySubtitle}>
              Ingresa el número de vuelo, ciudad de origen o destino
            </Text>
          </View>
        ) : results.length === 0 ? (
          <View style={styles.emptyContainer}>
            <Text style={styles.emptyIcon}>❌</Text>
            <Text style={styles.emptyTitle}>No se encontraron vuelos</Text>
            <Text style={styles.emptySubtitle}>
              Intenta con otro término de búsqueda
            </Text>
          </View>
        ) : (
          <>
            <Text style={styles.resultsText}>
              {results.length} resultado{results.length !== 1 ? 's' : ''} encontrado{results.length !== 1 ? 's' : ''}
            </Text>
            <FlatList
              data={results}
              keyExtractor={(item) => item.id}
              renderItem={({ item }) => (
                <FlightCard flight={item} isDeparture={true} />
              )}
              contentContainerStyle={styles.listContent}
            />
          </>
        )}
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
  },
  searchContainer: {
    padding: spacing.md,
  },
  searchInput: {
    backgroundColor: colors.surface,
    borderRadius: borderRadius.md,
    padding: spacing.md,
    fontSize: fontSize.md,
    color: colors.text,
    borderWidth: 1,
    borderColor: colors.border,
  },
  emptyContainer: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    padding: spacing.xl,
  },
  emptyIcon: {
    fontSize: 64,
    marginBottom: spacing.md,
  },
  emptyTitle: {
    fontSize: fontSize.xl,
    fontWeight: 'bold',
    color: colors.text,
    marginBottom: spacing.sm,
  },
  emptySubtitle: {
    fontSize: fontSize.md,
    color: colors.textSecondary,
    textAlign: 'center',
  },
  resultsText: {
    fontSize: fontSize.md,
    fontWeight: '600',
    color: colors.text,
    paddingHorizontal: spacing.md,
    marginBottom: spacing.sm,
  },
  listContent: {
    padding: spacing.md,
  },
});
