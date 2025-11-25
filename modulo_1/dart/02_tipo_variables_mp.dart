void main() {
  print("Variables para el Aeropuerto");
  
  final String aerolinea = "LATAM";
  String destino = 'Quito';
  destino = 'Miami';
  const String estado = "Booked";
  bool despegado = false;
  int pasajeros = 185;
  double combustible = 25000.5;
  List<String> tripulacion = ["Piloto", "Copiloto", "Azafata"];
  
  print("""
  Aerolínea: $aerolinea
  Destino: $destino
  Estado: $estado
  Despegado: $despegado
  Pasajeros: $pasajeros
  Combustible: $combustible
  Tripulación: $tripulacion
  """);
}