import { Stack } from "expo-router";
import { AuthProvider } from "../src/features/auth/presentation/authContext";

export default function RootLayout() {
  return (
    <AuthProvider>
      <Stack screenOptions={{ headerShown: true }}>
        <Stack.Screen name="index" options={{ headerShown: false }} />

        <Stack.Screen name="public/home" options={{ title: "Catálogo" }} />
        <Stack.Screen name="public/login" options={{ title: "Login" }} />
        <Stack.Screen name="public/register" options={{ title: "Registro" }} />

        <Stack.Screen name="private/home" options={{ headerShown: false }} />
        <Stack.Screen name="private/categories" options={{ headerShown: false }} />
        <Stack.Screen name="private/products" options={{ headerShown: false }} />
      </Stack>
    </AuthProvider>
  );
}
