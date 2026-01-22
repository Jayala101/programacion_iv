import React from 'react';
import { Text } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { FlightProvider } from '../context/FlightContext';
import DeparturesScreen from '../screens/DeparturesScreen';
import ArrivalsScreen from '../screens/ArrivalsScreen';
import SearchScreen from '../screens/SearchScreen';
import InfoScreen from '../screens/InfoScreen';
import colors from '../theme/colors';

const Tab = createBottomTabNavigator();

export default function AppNavigator() {
  return (
    <FlightProvider>
      <NavigationContainer>
        <Tab.Navigator
          screenOptions={{
            headerShown: false,
            tabBarStyle: {
              backgroundColor: colors.surface,
              borderTopColor: colors.border,
              borderTopWidth: 1,
              height: 60,
              paddingBottom: 8,
              paddingTop: 8,
            },
            tabBarActiveTintColor: colors.primary,
            tabBarInactiveTintColor: colors.textSecondary,
            tabBarLabelStyle: {
              fontSize: 12,
              fontWeight: '600',
            },
          }}
        >
          <Tab.Screen
            name="Departures"
            component={DeparturesScreen}
            options={{
              tabBarLabel: 'Salidas',
              tabBarIcon: ({ color }) => (
                <Text style={{ fontSize: 24 }}>✈️</Text>
              ),
            }}
          />
          <Tab.Screen
            name="Arrivals"
            component={ArrivalsScreen}
            options={{
              tabBarLabel: 'Llegadas',
              tabBarIcon: ({ color }) => (
                <Text style={{ fontSize: 24 }}>🛬</Text>
              ),
            }}
          />
          <Tab.Screen
            name="Search"
            component={SearchScreen}
            options={{
              tabBarLabel: 'Buscar',
              tabBarIcon: ({ color }) => (
                <Text style={{ fontSize: 24 }}>🔍</Text>
              ),
            }}
          />
          <Tab.Screen
            name="Info"
            component={InfoScreen}
            options={{
              tabBarLabel: 'Info',
              tabBarIcon: ({ color }) => (
                <Text style={{ fontSize: 24 }}>ℹ️</Text>
              ),
            }}
          />
        </Tab.Navigator>
      </NavigationContainer>
    </FlightProvider>
  );
}
