package com.example.kotlin_j


    fun main() {
        println("Listas")
        val aeropuertos: List<String> = listOf("King Fahd", "Pekín-Daxing", "Denver", "Dallas",
            "Chareles De Gaulle")
        println("Aeropuertos disponibles: $aeropuertos")
        val vuelosProgramados: MutableList<String> = mutableListOf("IB183", "IB496", "AF786")
        println("Vuelos programados: $vuelosProgramados")
        vuelosProgramados.add("BA321")
        println("Despues de agregar: $vuelosProgramados")
        vuelosProgramados.removeAt(0)
        println("Despues de eliminar: $vuelosProgramados")

        for (vuelo in vuelosProgramados) {
            println("Vuelo: $vuelo")
        }

        val pasajeros = mutableListOf(150, 125, 185, 200)
        pasajeros += 160
        println("Pasajeros por vuelo: $pasajeros")
        pasajeros.add(2, 170)
        println("Despues de insertar: $pasajeros")
        pasajeros[0] = 140
        println("Despues de modificar: $pasajeros")


        val destinos = mutableListOf("Madrid", "Londres", "París", "Berlín")
        println("Vuelo a Londres: ${destinos.find { it.startsWith("L") }}")
        println("¿Hay vuelos a París?: ${destinos.any { it.contains("París") }}")
        println("¿No hay vuelos a Tokio?: ${destinos.none { it == "Tokio" }}")


        val tiemposVuelo = mutableListOf(120, 90, 180, 60, 150)
        println("Tiempos ordenados: ${tiemposVuelo.sorted()}")
        println("Tiempos descendente: ${tiemposVuelo.sortedDescending()}")
        println("Tiempos unicos: ${tiemposVuelo.distinct()}")

}