import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class FlightDetailsScreen extends StatelessWidget {
  const FlightDetailsScreen({super.key, required this.flightId});

  final String flightId;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Detalles del Vuelo $flightId'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text('Información detallada del vuelo $flightId'),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                GoRouter.of(context).go('/book/$flightId');
              },
              child: const Text('Reservar Vuelo'),
            ),
          ],
        ),
      ),
    );
  }
}
