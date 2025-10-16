void main() {
  int n = 9;
  double tabla=2;
  int i = 0;
  while (i<=n){
    i++;
    print("$i * $tabla = ${i*tabla}");
  }
  
  i = 1;
    do {
    i++;
    print("$i * $tabla = ${i*tabla}");
  } while (i<n);
}

