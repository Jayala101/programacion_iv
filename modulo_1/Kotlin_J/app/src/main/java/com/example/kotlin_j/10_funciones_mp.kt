package com.example.kotlin_j

// Funcion basica
fun mostrarEstadoSistema() {
    println("Sistema de Gestión de Vuelos Aeropuerto X")
}

// Funcion con con entradas y salida
fun calcularTiempoVuelo(distancia: Int, velocidad: Int): Int {
    return distancia / velocidad
}

// Funcion de expresion unica
fun calcularCombustible(distancia: Int) = distancia * 2

// Funcion con retorno multiple
fun calcularEstadisticasVuelo(pasajeros: Int, distancia: Int): Pair<Int, Double> {
    val ingresos = pasajeros * 150
    val eficiencia = distancia / pasajeros.toDouble()
    return Pair(ingresos, eficiencia)
}

// Funciones de lambda
val calcularImpuestos = { precio: Double -> precio * 0.21 }
val generarCodigoVuelo = { aerolinea: String, numero: Int -> "$aerolinea$numero" }

fun main() {
    mostrarEstadoSistema()

    val tiempoVuelo = calcularTiempoVuelo(800, 200)
    println("Tiempo de vuelo total es: $tiempoVuelo horas")
    val combustible = calcularCombustible(800)
    println("Combustible necesario para llegar es: $combustible litros")
    val (ingresos, eficiencia) = calcularEstadisticasVuelo(150, 800)
    println("Ingresos: $$ingresos, Eficiencia: $eficiencia km/pasajero")
    val precioConImpuestos = calcularImpuestos(200.0)
    println("Precio con impuestos: $${200.0 + precioConImpuestos}")
    val codigoVuelo = generarCodigoVuelo("IB", 123)
    println("Código de vuelo es: $codigoVuelo")
}