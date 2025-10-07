package com.example.kotlin_j

fun saludar(){
    println("Hola desda una función de Kotlin")
}

// funcion con parametros y retorno
fun sumar(a: Int, b: Int): Int{
    return a + b
}

//funcion con expresion single-expression function
fun cuadrado(numero: Int) = numero * numero

//Funcion con retorno multiple
fun retornoMultiple(a: Int, b: Int): Pair<Int,Int> {
    val suma = a + b
    val resta = a - b
    return Pair(suma, resta)
}


fun main(){
    saludar()
    val resultado = sumar(5,6)
    println(cuadrado(5))
    println(retornoMultiple(15,5))
    val cuadradoLambda = {x: Int-> x*x}
    val saludoLambda = {nombre: String-> "Good morning, ${nombre}"}
    println(saludoLambda("Juan Luis Guerra"))
}