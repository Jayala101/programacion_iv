import 'package:flutter/material.dart';

class BookingScreen extends StatefulWidget {
  const BookingScreen({super.key, required this.flightId});

  final String flightId;

  @override
  State<BookingScreen> createState() => _BookingScreenState();
}

class _BookingScreenState extends State<BookingScreen> {
  final _formKey = GlobalKey<FormState>();
  String _passengerName = '';
  String _passportNumber = '';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Reservar Vuelo ${widget.flightId}'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            children: [
              TextFormField(
                decoration: const InputDecoration(labelText: 'Nombre del Pasajero'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Por favor ingrese un nombre';
                  }
                  return null;
                },
                onSaved: (value) {
                  _passengerName = value!;
                },
              ),
              TextFormField(
                decoration: const InputDecoration(labelText: 'Número de Pasaporte'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Por favor ingrese un número de pasaporte';
                  }
                  return null;
                },
                onSaved: (value) {
                  _passportNumber = value!;
                },
              ),
              const SizedBox(height: 20),
              ElevatedButton(
                onPressed: () {
                  if (_formKey.currentState!.validate()) {
                    _formKey.currentState!.save();
                    // Aquí se podría agregar la lógica para guardar la reserva
                    ScaffoldMessenger.of(context).showSnackBar(
                      SnackBar(
                        content: Text(
                            'Reserva para $_passengerName con pasaporte $_passportNumber en el vuelo ${widget.flightId} realizada con éxito'),
                      ),
                    );
                    Navigator.of(context).pop();
                  }
                },
                child: const Text('Confirmar Reserva'),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
