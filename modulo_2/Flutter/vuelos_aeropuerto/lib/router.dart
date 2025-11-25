import 'package:go_router/go_router.dart';
import 'package:vuelos_aeropuerto/features/bookings/screens/booking_screen.dart';
import 'package:vuelos_aeropuerto/features/flights/screens/flight_details_screen.dart';
import 'package:vuelos_aeropuerto/features/flights/screens/flight_list_screen.dart';

final router = GoRouter(
  routes: [
    GoRoute(
      path: '/',
      builder: (context, state) => const FlightListScreen(),
    ),
    GoRoute(
      path: '/flight/:id',
      builder: (context, state) {
        final id = state.pathParameters['id']!;
        return FlightDetailsScreen(flightId: id);
      },
    ),
    GoRoute(
      path: '/book/:id',
      builder: (context, state) {
        final id = state.pathParameters['id']!;
        return BookingScreen(flightId: id);
      },
    ),
  ],
);
