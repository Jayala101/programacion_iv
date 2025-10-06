package com.example.kotlin_j

fun main() {
    println("¡Operadores Lógicos!")

    val altitud: Int = 34500
    val condicionesMeteorologicas: Boolean = true
    val nivelCombustible: Int = 8

    val despegueAutorizado = altitud >= 10000 && condicionesMeteorologicas && nivelCombustible > 5
    val necesitaReabastecimiento = !condicionesMeteorologicas || nivelCombustible < 3

    println("Despegue autorizado: ${despegueAutorizado}")
    println("Necesita reabastecimiento: ${necesitaReabastecimiento}")
}