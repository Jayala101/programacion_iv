import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class FlightListScreen extends StatelessWidget {
  const FlightListScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final flights = List.generate(20, (index) => 'Vuelo ${index + 1}');

    return Scaffold(
      appBar: AppBar(
        title: const Text('Vuelos Disponibles'),
      ),
      body: ListView.builder(
        itemCount: flights.length,
        itemBuilder: (context, index) {
          final flight = flights[index];
          return ListTile(
            title: Text(flight),
            onTap: () {
              GoRouter.of(context).go('/flight/${index + 1}');
            },
          );
        },
      ),
    );
  }
}
