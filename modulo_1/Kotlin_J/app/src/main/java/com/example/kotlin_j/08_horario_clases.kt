package com.example.kotlin_j

import kotlin.io.println

fun main() {
    println("Mapas")
    val value1: Int = readLine()?.toIntOrNull()?:0

    if (value1 >= 7 && value1 <= 13) {
        println("Clase en la mañana")
    } else if (value1 >= 14 && value1 <= 23) {
        println("Clase en la tarde")
    } else {
        println("horario electivo")
    }
}
