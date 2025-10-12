package com.example.kotlin_j

data class Vuelo(
    val numeroVuelo: String,
    val destino: String,
    val pasajeros: Int,
    val capacidad: Int = 180,
    val aerolinea: String? = null
) {
    val asientosDisponibles: Int
        get() = capacidad - pasajeros
    val estado: String
        get() = when {
            asientosDisponibles == 0 -> "Completo (capacidad maxima)"
            asientosDisponibles < 20 -> "Por completar ${asientosDisponibles}"
            else -> "Disponible"
        }
    fun puedeDespegar(): Boolean = pasajeros >= 10
    fun necesitaEscala(): Boolean = pasajeros > capacidad * 0.8
}

fun main() {
    val vuelo1 = Vuelo(
        "FK835",
        "Guayaquil",
        150,
        180,
        "LAN"
    )
    println(vuelo1)
    // Desestructuracion de objeto
    val (numero, destino, pasajeros) = vuelo1
    println("Vuelo $numero a $destino con $pasajeros pasajeros")
    // Copiar un objeto
    val vuelo2 = vuelo1.copy("FK369", "Tampa", pasajeros = 170)
    println(vuelo2)
    // Resulatdos
    println("Asientos disponibles es: ${vuelo2.asientosDisponibles}")
    println("Estado del vuelo es: ${vuelo2.estado}")
    println("Puede despegar? ${vuelo2.puedeDespegar()}")
    println("Necesita escala? ${vuelo2.necesitaEscala()}")
}

