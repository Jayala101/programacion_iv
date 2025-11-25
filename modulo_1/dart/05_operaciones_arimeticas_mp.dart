void main() {
  print("Operadores arimeticos Aeropeurto");
  
  int pasajeros = 180;
  int asientos = 200;
  double combustible = 10000.0;
  double consumo = 2500.0;
  
  print("Asientos disponibles en el avion: ${asientos - pasajeros}");
  print("Combustible usado: ${combustible - consumo}");
  print("Total maletas cargadas: ${pasajeros * 2}");
  print("Consumo por persona: ${consumo / pasajeros}");
}