package com.example.kotlin_j

fun main() {
    println("Operadores Aritméticos!")

    val distanciaVuelo: Double = 1250.8
    val velocidadPromedio: Double = 850.0
    val consumoCombustible: Double = 3.5
    val capacidadPasajeros: Double = 180.0

    println("Valores de un vuelo")
    println("Distancia del vuelo: ${distanciaVuelo} km")
    println("Velocidad promedio: ${velocidadPromedio} km/h")
    println("Consumo de combustible: ${consumoCombustible} L/km")
    println("Capacidad de pasajeros: ${capacidadPasajeros}")

    println("Operaciones Básicas")
    println("Tiempo del vuelo: ${distanciaVuelo / velocidadPromedio} horas")
    println("Combustible necesario: ${distanciaVuelo * consumoCombustible} litros")
    println("Distancia con reserva: ${distanciaVuelo + 200.0} km")
    println("Velocidad reducida: ${velocidadPromedio - 100.0} km/h")
}