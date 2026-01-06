import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View, ScrollView, SafeAreaView } from 'react-native';
import TypeScriptDemo from './src/screens/TypeScriptDemo';
import AppButton from './src/components/AppButton';
import { AppTitle } from "@/components/common/AppTitle";
import { Parte05Lab } from "./src/screens/Parte05Lab";
import { Parte06Lab } from "./src/screens/Parte06Lab";

export default function App() {
  return (
    <SafeAreaView style={styles.container}>
      <ScrollView 
        style={styles.scrollView}
        contentContainerStyle={styles.scrollContent}
      >
        <AppTitle value="Estructura lista" />
        <Text style={styles.title}>React Native + TypeScript</Text>
        <Text style={styles.subtitle}>Entorno listo ✅</Text>
        
        <View style={{ height: 20 }} />
        
        <AppButton
          title="Presionar aquí"
          onPress={() => console.log('Botón presionado!')}
          variant="primary"
        />
        
        <View style={{ height: 10 }} />
        
        <AppButton
          title="Cargando..."
          onPress={() => {}}
          loading={true}
          variant="secondary"
        />
        
        <View style={{ height: 10 }} />
        
        <AppButton
          title="Deshabilitado"
          onPress={() => {}}
          disabled={true}
          variant="outline"
        />

        <View style={{ height: 20 }} />
        
        <View style={styles.demoContainer}>
          <TypeScriptDemo />
        </View>
        
        <View style={{ height: 400 }}>
          <Parte05Lab />
        </View>

        <View style={{ height: 400 }}>
          <Parte06Lab />
        </View>
      </ScrollView>
      <StatusBar style="light" />
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#0d1117",
  },
  scrollView: {
    flex: 1,
  },
  scrollContent: {
    alignItems: "center",
    padding: 16,
    paddingBottom: 40,
  },
  title: {
    fontSize: 18,
    fontWeight: "600",
    marginBottom: 8,
    color: "#c9d1d9",
  },
  subtitle: {
    color: "#8b949e",
    fontSize: 14,
  },
  demoContainer: {
    width: '100%',
  },
});