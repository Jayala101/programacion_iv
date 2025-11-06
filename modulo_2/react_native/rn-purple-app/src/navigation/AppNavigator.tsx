import React from "react";
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import colors from "../theme/colors";

export type RootStackParamList = {
  MediaPicker: undefined;
  VideoPlayer: undefined;
  YouTube: undefined;
};

const Stack = createNativeStackNavigator<RootStackParamList>();

export default function AppNavigator() {
  return (
    <NavigationContainer>
      <Stack.Navigator
        screenOptions={{
          headerStyle: { backgroundColor: colors.card },
          headerTintColor: colors.primary,
          contentStyle: { backgroundColor: colors.bg },
        }}
      >
        <Stack.Screen name="MediaPicker" component={MediaPickerScreen} options={{ title: "Galería y Video local" }} />
        <Stack.Screen name="VideoPlayer" component={VideoPlayerScreen} options={{ title: "Video remoto" }} />
        <Stack.Screen name="YouTube" component={YouTubeScreen} options={{ title: "YouTube" }} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}