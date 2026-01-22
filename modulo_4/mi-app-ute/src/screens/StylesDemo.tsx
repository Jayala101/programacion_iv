import { StyleSheet, Text, View } from "react-native";

export function StylesDemo() {
  return (
    <View style={styles.container}>
      <View style={styles.box1}>
        <Text style={styles.text}>Box 1 - Rojo</Text>
      </View>
      <View style={styles.box2}>
        <Text style={styles.text}>Box 2 - Azul</Text>
      </View>
      <View style={styles.box3}>
        <Text style={styles.text}>Box 3 - Verde</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#161b22",
    padding: 20,
    justifyContent: "space-around",
  },
  box1: {
    backgroundColor: "#da3633",
    padding: 20,
    borderRadius: 8,
    alignItems: "center",
  },
  box2: {
    backgroundColor: "#58a6ff",
    padding: 20,
    borderRadius: 8,
    alignItems: "center",
  },
  box3: {
    backgroundColor: "#2ea043",
    padding: 20,
    borderRadius: 8,
    alignItems: "center",
  },
  text: {
    color: "#ffffff",
    fontSize: 16,
    fontWeight: "600",
  },
});
