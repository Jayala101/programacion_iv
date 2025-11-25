void main() {
  print("Maps Aeropuerto");
  
  final Map<String, dynamic> vuelo = {
    'numero': 'FX2345',
    'aerolinea': 'American Airways',
    'despegado': true,
    'pasajeros': 200,
    'rutas': ['MIA', 'UIO'],
    'horarios': {
      'salida': '08:00',
      'llegada': '16:00'
    }
  };
  
  print(vuelo);
  print('Número: ${vuelo['numero']}');
  print('Aerolínea: ${vuelo['aerolinea']}');
  print('Horarios: ${vuelo['horarios']}');
}