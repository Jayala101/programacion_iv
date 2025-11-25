package com.example.kotlin_j

import kotlin.random.Random

fun main(){
// Escribe un programa que pida un número y muestre todos los números pares desde 1 hasta ese número
// y luego todos los impares

    print("Ingrese un numero: ")
    val numero: Int =  readLine()?.toIntOrNull()?:0

    println("Los numeros pares son:")
    for (n in 1..numero) {
        if (n % 2 == 0) {
            println("El numero ${n}")
        }
    }

    println("Los numeros impares son:")
    for (n in 1..numero){
        if (n % 2 != 0){
            println("El numero ${n}")
        }
    }

    // Crea un programa que pida dos números y una operación (+, -, *, /)
    // Usa when para realizar la operación correspondiente

    print("Ingresa el primer valor: ")
    val numero1: Int = readLine()?.toIntOrNull()?:0
    print("Ingresa el segundo valor: ")
    val numero2: Int = readLine()?.toIntOrNull()?:0
    print("Ingresa el signo (+,-,*,/): ")
    val signo: String = readLine()?.toString()?:""

    val calculadora = when(signo) {
        "+" -> numero1+numero2
        "-" -> numero1-numero2
        "*" -> numero1*numero2
        "/" -> numero1/numero2
        else -> "operador invalido"
    }
    println(calculadora)

    // Pide un número y muestra su tabla de multiplicar del 1 al 10 usando for
    print("Ingresa el numero para la tabla de multiplicacion: ")
    val numero_mul: Int = readLine()?.toIntOrNull()?:0

    println("Tabla del ${numero_mul}")
    for (i in 1..10){
        println("${numero_mul} por ${i} es ${numero_mul*i}")
    }

    // Escribe una función que determine si un número es primo
    // Luego pide un número y muestra todos los primos hasta ese número
    print("Ingrese un numero: ")
    val valor : Int = readLine()?.toIntOrNull()?:0

    println("Los primos son: ")
    for (i in 2..valor){
        if(esPrimo(i)){
            print("$i ")
        }
    }

    // Crea un juego donde la computadora elija un número aleatorio entre 1-100
    // El usuario debe adivinarlo. El programa debe dar pistas "más alto" o "más bajo"
    // y contar los intentos
    print("\nAdivina el numero: ")

    val numeroRandom = Random.nextInt(1,101)
    var intentos = 0
    var acierto = false

    while(!acierto){
        val input : Int = readLine()?.toIntOrNull()?:0
        intentos++
        when{
            input > numeroRandom -> println("mas bajo")
            input < numeroRandom -> println("mas alto")
            else -> {
                println("Felicidades si es $numeroRandom")
                acierto = true
            }
        }
    }

    // Pide un número y cuenta cuántos dígitos tiene usando while
    // Ejemplo: 1234 tiene 4 dígitos

    print("\nIngrese un numero para contar sus digitos: ")
    val digito : Int = readLine()?.toIntOrNull()?:0

    do {
        val length = digito.toString().length
        println(length)
    } while (length != length)
/*
    // Crea un sistema que pida una contraseña y la verifique según estas reglas:
    // - Al menos 8 caracteres
    // - Al menos una mayúscula
    // - Al menos un número
    // - Al menos un carácter especial (!@#$%^&*)
    // Usa bucles para verificar cada condición

    val password: String = readLine()?.toString()?:""
    do {
        when(casos){
            1 -> contentEquals()
        }
    } while ()
    */
}

fun esPrimo(primo: Int): Boolean {
    if (primo <= 1) return false
    for (i in 2 until primo){
        if (primo % i == 0){
            return false
        }
    }
    return true
}

