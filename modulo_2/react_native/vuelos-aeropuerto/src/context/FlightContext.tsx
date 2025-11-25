import React, { createContext, useContext, ReactNode } from 'react';
import { Flight, FlightContextType } from '../types/flight.types';

const FlightContext = createContext<FlightContextType | undefined>(undefined);

const departures: Flight[] = [
  {
    id: '1',
    flightNumber: 'IB304',
    airline: 'Iberia',
    origin: 'Madrid',
    destination: 'New York',
    departureTime: '14:30',
    arrivalTime: '18:45',
    gate: 'A12',
    terminal: 'T1',
    status: 'onTime',
    date: '2025-11-25',
  },
  {
    id: '2',
    flightNumber: 'AA101',
    airline: 'American Airlines',
    origin: 'Madrid',
    destination: 'Miami',
    departureTime: '15:15',
    arrivalTime: '19:30',
    gate: 'B4',
    terminal: 'T2',
    status: 'boarding',
    date: '2025-11-25',
  },
  {
    id: '3',
    flightNumber: 'LH205',
    airline: 'Lufthansa',
    origin: 'Madrid',
    destination: 'Frankfurt',
    departureTime: '16:00',
    arrivalTime: '18:20',
    gate: 'C7',
    terminal: 'T1',
    status: 'delayed',
    date: '2025-11-25',
  },
  {
    id: '4',
    flightNumber: 'BA890',
    airline: 'British Airways',
    origin: 'Madrid',
    destination: 'London',
    departureTime: '17:30',
    arrivalTime: '19:00',
    gate: 'A5',
    terminal: 'T1',
    status: 'onTime',
    date: '2025-11-25',
  },
  {
    id: '5',
    flightNumber: 'AF452',
    airline: 'Air France',
    origin: 'Madrid',
    destination: 'Paris',
    departureTime: '18:00',
    arrivalTime: '19:45',
    gate: 'B12',
    terminal: 'T2',
    status: 'cancelled',
    date: '2025-11-25',
  },
  {
    id: '6',
    flightNumber: 'DL123',
    airline: 'Delta',
    origin: 'Madrid',
    destination: 'Atlanta',
    departureTime: '19:15',
    arrivalTime: '23:30',
    gate: 'C3',
    terminal: 'T1',
    status: 'onTime',
    date: '2025-11-25',
  },
];

const arrivals: Flight[] = [
  {
    id: '7',
    flightNumber: 'IB305',
    airline: 'Iberia',
    origin: 'New York',
    destination: 'Madrid',
    departureTime: '10:30',
    arrivalTime: '14:45',
    gate: 'A8',
    terminal: 'T1',
    status: 'departed',
    date: '2025-11-25',
  },
  {
    id: '8',
    flightNumber: 'AA102',
    airline: 'American Airlines',
    origin: 'Miami',
    destination: 'Madrid',
    departureTime: '11:15',
    arrivalTime: '15:30',
    gate: 'B6',
    terminal: 'T2',
    status: 'onTime',
    date: '2025-11-25',
  },
  {
    id: '9',
    flightNumber: 'LH206',
    airline: 'Lufthansa',
    origin: 'Frankfurt',
    destination: 'Madrid',
    departureTime: '12:00',
    arrivalTime: '14:20',
    gate: 'C9',
    terminal: 'T1',
    status: 'delayed',
    date: '2025-11-25',
  },
  {
    id: '10',
    flightNumber: 'BA891',
    airline: 'British Airways',
    origin: 'London',
    destination: 'Madrid',
    departureTime: '13:30',
    arrivalTime: '15:00',
    gate: 'A3',
    terminal: 'T1',
    status: 'boarding',
    date: '2025-11-25',
  },
  {
    id: '11',
    flightNumber: 'AF453',
    airline: 'Air France',
    origin: 'Paris',
    destination: 'Madrid',
    departureTime: '14:00',
    arrivalTime: '15:45',
    gate: 'B10',
    terminal: 'T2',
    status: 'onTime',
    date: '2025-11-25',
  },
];

export const FlightProvider: React.FC<{ children: ReactNode }> = ({ children }) => {
  const searchFlights = (query: string): Flight[] => {
    if (!query.trim()) return [];
    
    const allFlights = [...departures, ...arrivals];
    const lowerQuery = query.toLowerCase();
    
    return allFlights.filter(
      (flight) =>
        flight.flightNumber.toLowerCase().includes(lowerQuery) ||
        flight.origin.toLowerCase().includes(lowerQuery) ||
        flight.destination.toLowerCase().includes(lowerQuery) ||
        flight.airline.toLowerCase().includes(lowerQuery)
    );
  };

  return (
    <FlightContext.Provider value={{ departures, arrivals, searchFlights }}>
      {children}
    </FlightContext.Provider>
  );
};

export const useFlights = () => {
  const context = useContext(FlightContext);
  if (!context) {
    throw new Error('useFlights must be used within a FlightProvider');
  }
  return context;
};
