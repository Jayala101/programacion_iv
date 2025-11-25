void main() {
  print(greetEveryone());
  print(sumar(2,8));
  print(greetEveryone());
  print(addTwoNumbersOptional(8));
  print(greetPerson(message:'Holaa',name:'Jimmy'));
}

String greetEveryone()=>'Hello everyone';
int sumar(int a, int b)=>a+b;
int addTwoNumbersOptional(int a, [int b=0]) {
  return a+b;
}

String greetPerson({required String name, String message="Hola"}) {
  return '$message $name'; 
}