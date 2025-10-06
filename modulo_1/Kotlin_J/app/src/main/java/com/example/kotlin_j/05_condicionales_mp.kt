package com.example.kotlin_j

fun main() {
    println("¡Estructuras de Control!")
    println("¡Condicionales en Vuelos!")

    val capacidadAvion1 = 175
    val capacidadAvion2 = 210
    if (capacidadAvion1 > capacidadAvion2) {
        println("El avión 1 tiene mayor capacidad: ${capacidadAvion1} pasajeros")
    } else {
        println("El avión 2 tiene mayor capacidad: ${capacidadAvion2} pasajeros")
    }

    println("Nivel de Prioridad de Vuelo")
    var nivelEmergencia: Int = 7
    if (nivelEmergencia > 8) {
        println("Aterrizaje inmediato")
    } else if (nivelEmergencia > 5) {
        println("Prioridad de aterrizaje")
    } else if (nivelEmergencia > 3) {
        println("Monitoreo especial")
    } else {
        println("Procedimiento estándar")
    }

    println("Tipos de Aeronaves")
    var tipoAeronave: String = "Boeing 777"
    when (tipoAeronave) {
        "Boeing 777", "Airbus A350" -> println("Avión comercial de largo alcance")
        "Cessna 172", "Piper Archer" -> println("Avioneta de aviación general")
        "Boeing 747", "Airbus A380" -> println("Avión comercial de gran capacidad")
        else -> println("Tipo de aeronave no se pudo identificar")
    }

    println("Autorización de Despegue")
    var condicionesMeteorologicas: Int = 4
    var nivelCombustible: Int = 85
    when {
        condicionesMeteorologicas < 3 || nivelCombustible < 20 -> println("Despegue cancelado")
        condicionesMeteorologicas <= 5 -> println("despegue con precauciones")
        condicionesMeteorologicas > 5 && nivelCombustible > 50 -> println("despegue autorizado")
        else -> println("Esperando torre central")
    }

    println("Sistema de Luces de Pista")
    var luzVerde: String = "Verde"
    var luzRoja: String = "Roja"
    var luzAmarilla: String = "Amarilla"
    var estadoPista: String = "Verde"
    var mantenimiento: Boolean = false

    when {
        estadoPista == luzRoja -> println("pista cerrada")
        estadoPista == luzAmarilla -> println("pista con restricciones")
        estadoPista == luzVerde -> println("pista abierta")
        mantenimiento -> println("pista en mantenimiento")
        estadoPista == luzRoja && mantenimiento -> println("pista no disponible")
    }
}