void main() {
  print("Maps iterables Aeropuerto");
  
  final vuelos = ['VM255', 'IB901', 'IB901', 'LH437', 'LH437', 'AF120'];
  print("Lista Original: $vuelos");
  print("Total: ${vuelos.length}");
  print("Vuelo en posición 2: ${vuelos[2]}");
  print("Primer vuelo: ${vuelos.first}");
  
  final vuelosInvertidos = vuelos.reversed;
  print("Orden inverso: ${vuelosInvertidos}");
  print("Lista: ${vuelosInvertidos.toList()}");
  print("Vuelos únicos: ${vuelosInvertidos.toSet()}");
}