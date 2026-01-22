void main() {
  final Vuelo madrid = Vuelo(destino: "Miami", pasajeros: 180);
  print(madrid);
  print(madrid.capacidadDisponible());
  final Avion boeing = Avion(modelo: "Boeing 737", capacidad: 200);
  print(boeing.infoAvion());
}

class Vuelo {
  String destino = "";
  int pasajeros = 0;
  Vuelo({required this.destino, required this.pasajeros});
  int capacidadDisponible() => 200 - pasajeros;
  @override
  String toString() => '$destino con $pasajeros pasajeros';
}

class Avion {
  String modelo = "";
  int capacidad = 0;
  Avion({required this.modelo, required this.capacidad});
  String infoAvion() => '$modelo con capacidad: $capacidad';
}