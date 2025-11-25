void main() {
  print(estadoVuelo());
  print(combustibleNecesario(2000, 150));
  print(calcularTiempoVuelo(800));
}

String estadoVuelo() => 'Despegado';
double combustibleNecesario(double distancia, int pasajeros) => distancia * pasajeros * 0.1;
double calcularTiempoVuelo(double km, [double velocidad = 800]) => km / velocidad;
String infoVuelo({required String numero, String estado = "a tiempo"}) => 'Vuelo $numero: $estado';