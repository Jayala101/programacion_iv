import { StyleSheet, Text, View } from "react-native";

export function WelcomeScreen() {
  return (
    <View style={styles.container}>
      <Text style={styles.title}>¡Bienvenido!</Text>
      <Text style={styles.subtitle}>Ejemplo de Componente con Props</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#161b22",
    alignItems: "center",
    justifyContent: "center",
    padding: 20,
  },
  title: {
    color: "#58a6ff",
    fontSize: 24,
    fontWeight: "bold",
    marginBottom: 10,
  },
  subtitle: {
    color: "#8b949e",
    fontSize: 16,
  },
});
