// src/screens/TypeScriptDemo.tsx
import React from 'react';
import { View, Text, StyleSheet, ScrollView, ActivityIndicator, TouchableOpacity } from 'react-native';
import { LoadState, ProductDTO, successState } from '../types';

// Simple button component
const AppButton: React.FC<{
  title: string;
  onPress: () => void;
  variant?: 'primary' | 'outline';
  style?: any;
}> = ({ title, onPress, variant = 'primary', style }) => (
  <TouchableOpacity
    style={[
      styles.button,
      variant === 'outline' && styles.buttonOutline,
      style
    ]}
    onPress={onPress}
  >
    <Text style={[
      styles.buttonText,
      variant === 'outline' && styles.buttonTextOutline
    ]}>
      {title}
    </Text>
  </TouchableOpacity>
);

// State example component
function StateExample() {
  const [state, setState] = React.useState<LoadState<ProductDTO[]>>(successState);
  
  const renderContent = () => {
    // TypeScript INFIERE el tipo exacto basado en 'type'
    switch (state.type) {
      case "idle":
        return <Text style={styles.value}>Presiona cargar para comenzar</Text>;
        
      case "loading":
        return (
          <View style={{ flexDirection: 'row', alignItems: 'center' }}>
            <ActivityIndicator size="small" color="#58a6ff" />
            <Text style={[styles.value, { marginLeft: 10 }]}>Cargando productos...</Text>
          </View>
        );
        
      case "success":
        return (
          <View>
            <Text style={styles.value}>✓ {state.data.length} productos cargados</Text>
            {state.data.map(product => (
              <View key={product.id} style={styles.productItem}>
                <Text style={styles.value}>{product.name}</Text>
                <Text style={styles.label}>${product.price.toFixed(2)}</Text>
              </View>
            ))}
          </View>
        );
        
      case "error":
        return (
          <View>
            <Text style={[styles.value, styles.error]}>✗ {state.message}</Text>
            {state.code && (
              <Text style={styles.label}>Código: {state.code}</Text>
            )}
          </View>
        );
        
      default:
        // TypeScript asegura que cubrimos todos los casos
        const _exhaustiveCheck: never = state;
        return null;
    }
  };
  
  return (
    <View style={styles.section}>
      <Text style={styles.sectionTitle}>5. Union Types para Estado</Text>
      <View style={styles.card}>
        {renderContent()}
      </View>
      
      <View style={{ flexDirection: 'row', justifyContent: 'space-between', marginTop: 10 }}>
        <AppButton
          title="Idle"
          onPress={() => setState({ type: "idle" })}
          variant="outline"
          style={{ flex: 1, marginRight: 5 }}
        />
        <AppButton
          title="Loading"
          onPress={() => setState({ type: "loading" })}
          variant="outline"
          style={{ flex: 1, marginHorizontal: 5 }}
        />
        <AppButton
          title="Success"
          onPress={() => setState(successState)}
          variant="outline"
          style={{ flex: 1, marginLeft: 5 }}
        />
      </View>
    </View>
  );
}

export function TypeScriptDemo() {
  // ===== EJEMPLO 1: TIPOS BÁSICOS =====
  const appName: string = "MiApp React Native";
  const version: number = 3.0;
  const isActive: boolean = true;
  const tags: string[] = ["react", "native", "typescript"];
  const scores: Record<string, number> = { 
    "juan": 95, 
    "ana": 88 
  };

  // Union type para estado
  type Status = "IDLE" | "LOADING" | "SUCCESS" | "ERROR";
  const currentStatus: Status = "SUCCESS";

  return (
    <ScrollView style={styles.container}>
      <Text style={styles.title}>Demo TypeScript en React Native</Text>
      
      <View style={styles.section}>
        <Text style={styles.sectionTitle}>1. Tipos Básicos</Text>
        
        <View style={styles.card}>
          <Text style={styles.label}>App Name:</Text>
          <Text style={styles.value}>{appName}</Text>
          
          <Text style={styles.label}>Version:</Text>
          <Text style={styles.value}>{version}</Text>
          
          <Text style={styles.label}>¿Activo?:</Text>
          <Text style={styles.value}>{isActive ? "Sí" : "No"}</Text>
          
          <Text style={styles.label}>Tags:</Text>
          <Text style={styles.value}>{tags.join(", ")}</Text>
          
          <Text style={styles.label}>Estado actual:</Text>
          <Text style={[
            styles.value,
            currentStatus === "SUCCESS" && styles.success,
            currentStatus === "ERROR" && styles.error
          ]}>
            {currentStatus}
          </Text>
        </View>
        
        <Text style={styles.codeComment}>
          // Mira la consola para ver los scores
        </Text>
      </View>
      
      <StateExample />
    </ScrollView>
  );

}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#0d1117',
    padding: 20,
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#58a6ff',
    marginBottom: 20,
    textAlign: 'center',
  },
  section: {
    marginBottom: 30,
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: '600',
    color: '#c9d1d9',
    marginBottom: 10,
    borderLeftWidth: 3,
    borderLeftColor: '#58a6ff',
    paddingLeft: 10,
  },
  card: {
    backgroundColor: '#161b22',
    borderWidth: 1,
    borderColor: '#30363d',
    borderRadius: 8,
    padding: 16,
  },
  label: {
    color: '#8b949e',
    fontSize: 14,
    marginTop: 8,
  },
  value: {
    color: '#c9d1d9',
    fontSize: 16,
    fontWeight: '500',
  },
  success: {
    color: '#3fb950',
  },
  error: {
    color: '#f85149',
  },
  codeComment: {
    color: '#8b949e',
    fontStyle: 'italic',
    fontSize: 12,
    marginTop: 8,
  },
  productItem: {
    flexDirection: 'row' as 'row',
    justifyContent: 'space-between' as 'space-between',
    alignItems: 'center' as 'center',
    paddingVertical: 8,
    borderBottomWidth: 1,
    borderBottomColor: '#30363d',
  },
  button: {
    backgroundColor: '#58a6ff',
    paddingVertical: 10,
    paddingHorizontal: 16,
    borderRadius: 6,
    alignItems: 'center' as 'center',
  },
  buttonOutline: {
    backgroundColor: 'transparent',
    borderWidth: 1,
    borderColor: '#58a6ff',
  },
  buttonText: {
    color: '#0d1117',
    fontSize: 14,
    fontWeight: '600' as '600',
  },
  buttonTextOutline: {
    color: '#58a6ff',
  },
});

export default TypeScriptDemo;