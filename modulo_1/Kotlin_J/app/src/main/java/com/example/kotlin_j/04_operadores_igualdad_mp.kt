package com.example.kotlin_j

fun main(){
    println("¡Operadores de Igualdad!")

    val vuelo1: String = "IB2345"
    val vuelo2: String = "IB2345"
    val vuelo3: String = String("IB2345".toCharArray())
    val vuelo4: String = "LH6789"

    println("Codigos de vuelos")
    println("Vuelo1: $vuelo1")
    println("Vuelo2: $vuelo2")
    println("Vuelo3: $vuelo3")
    println("Vuelo4: $vuelo4")

    println("Igualdad Estructural (contenido)")
    println("¿Vuelo1 y Vuelo2 son el mismo codigo? ${vuelo1 == vuelo2}")
    println("¿Vuelo1 y Vuelo3 son el mismo codigo? ${vuelo1 == vuelo3}")
    println("¿Vuelo1 y Vuelo4 son el mismo codigo? ${vuelo1 == vuelo4}")

    println("Igualdad Referencial (misma instancia)")
    println("¿Vuelo1 y Vuelo2 son la misma instancia? ${vuelo1 === vuelo2}")
    println("¿Vuelo1 y Vuelo3 son la misma instancia? ${vuelo1 === vuelo3}")
    println("¿Vuelo1 y Vuelo4 son la misma instancia? ${vuelo1 === vuelo4}")
}