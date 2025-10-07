package com.example.kotlin_j

import kotlin.io.println

fun main() {
    println("Mapas")

    val fuerzaJedis = mapOf(
        "Luke" to 85,
        "Leia" to 80,
        "Obi-wan" to 95,
        "Yoda" to 100
    )

    println("Fuerza de los jedis: ${fuerzaJedis}")

    println("Mapa mutable")

    val misionesCompletadas = mutableMapOf<String, Int>()
    misionesCompletadas["Luke"] = 15
    misionesCompletadas["Leia"] = 12
    misionesCompletadas.put("Han", 20)

    println("Misiones: ${misionesCompletadas}")

    for((jedi,fuerza) in fuerzaJedis)
        println("$jedi tiene nivel de fuerza $fuerza")

    val planetasVisitados = setOf("Mustafar", "Corruscant", "Krribam")
    println("Planetas visitados: ${planetasVisitados}")

    val planetasPeligrosos = setOf("Tatooine", "Corruscant", "Dagobah")
    println("Planetas visitados: ${planetasVisitados}")


    println("Operaciones de Conjuntos")
    val interseccion = planetasPeligrosos intersect planetasVisitados
    val union = planetasPeligrosos union planetasVisitados
    val diferencia = planetasPeligrosos - planetasVisitados
    println("Planetas visitados y peligrosos: ${interseccion}")
    println("Todos os planetas: ${union}")
    println("Planetas Seguros: ${diferencia}")

}
