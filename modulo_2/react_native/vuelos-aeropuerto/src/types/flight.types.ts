export type FlightStatus = 'onTime' | 'delayed' | 'boarding' | 'cancelled' | 'departed';

export interface Flight {
  id: string;
  flightNumber: string;
  airline: string;
  origin: string;
  destination: string;
  departureTime: string;
  arrivalTime: string;
  gate: string;
  terminal: string;
  status: FlightStatus;
  date: string;
}

export interface FlightContextType {
  departures: Flight[];
  arrivals: Flight[];
  searchFlights: (query: string) => Flight[];
}
