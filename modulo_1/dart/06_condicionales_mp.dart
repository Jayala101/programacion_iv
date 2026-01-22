void main() {
  int pasajeros = 180;
  int capacidad = 200;
  
  if (pasajeros > capacidad) {
    print('Vuelo lleno');
  } else if (pasajeros == capacidad) {
    print('Último asiento');
  } else {
    print('Asientos disponibles');
  }
  
  String estado = pasajeros >= 150 ? 'Ocupación alta' : 'ocupación baja';
  print(estado);
}