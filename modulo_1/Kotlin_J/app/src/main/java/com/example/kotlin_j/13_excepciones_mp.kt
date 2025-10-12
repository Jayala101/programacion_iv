package com.example.kotlin_j

fun calcularTiempoVuelo1(distancia: Int, velocidad: Int): Int {
    if (velocidad == 0) throw IllegalArgumentException("La velocidad no puede menor a ser cero")
    if (distancia < 0) throw IllegalArgumentException("La distancia no puede ser un valor negativo")
    return distancia / velocidad
}

fun main() {
    // Manejo de excepciones en cálculo de tiempo de vuelo
    try {
        val tiempo = calcularTiempoVuelo1(800, 0)
        println("Tiempo de vuelo: $tiempo horas")
    } catch (e: IllegalArgumentException) {
        println("Error en cálculo: ${e.message}")
    }
}
