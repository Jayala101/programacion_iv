package com.example.kotlin_j

fun main() {
    println("¡Operadores Aritmeticos!")
    println("Calculadora de vuelos")
    println("Ingresa la distancia del vuelo (km): ")
    val distancia: Double = readLine()?.toDoubleOrNull()?:0.0
    println("Ingresa la velocidad promedio (km/h): ")
    val velocidad: Double = readLine()?.toDoubleOrNull()?:0.0
    println("Ingresa el consumo de combustible (L/h): ")
    val consumo: Double = readLine()?.toDoubleOrNull()?:0.0
    println("Ingresa el número de pasajeros: ")
    val pasajeros: Double = readLine()?.toDoubleOrNull()?:0.0

    println("Resultados")
    println("Tiempo estimado de vuelo: ${distancia / velocidad} horas")
    println("Combustible necesario: ${(distancia / velocidad) * consumo} litros")
    println("Eficiencia por pasajero: ${((distancia / velocidad) * consumo) / pasajeros} L/pasajero")
}