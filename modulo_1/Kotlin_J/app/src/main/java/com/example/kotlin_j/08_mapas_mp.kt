package com.example.kotlin_j



fun main() {
    println("Mapas")
    val vuelosPorDestino = mapOf(
        "V001" to "Quito",
        "V002" to "Cuenca",
        "V003" to "Guayaquil",
        "V004" to "Galapagos"
    )


    val pasajerosPorVuelo = mutableMapOf<String, Int>()
    pasajerosPorVuelo["V001"] = 120
    pasajerosPorVuelo["V002"] = 85
    pasajerosPorVuelo["V003"] = 150
    pasajerosPorVuelo["V004"] = 200

    println("Destinos de vuelos: $vuelosPorDestino")
    println("Pasajeros por vuelo: $pasajerosPorVuelo")


    for((vuelo, destino) in vuelosPorDestino) {
        val pasajeros = pasajerosPorVuelo[vuelo] ?: 0
        println("Vuelo $vuelo a $destino: $pasajeros pasajeros")
    }

    val aeropuertosCiudadesNacionales = setOf("UIO", "GUA", "CUE", "GAL")
    val aeropuertosCiudadesInternacionales = setOf("HUS", "MAD", "PAR", "VEN", "UIO")

    val aeropuertosConVuelosDirectos = aeropuertosCiudadesNacionales union aeropuertosCiudadesInternacionales
    val aeropuertosSoloNacionales = aeropuertosCiudadesNacionales - aeropuertosCiudadesInternacionales

    println("Todos los aeropuertos disponibles: $aeropuertosConVuelosDirectos")
    println("Aeropuertos que son solo nacionales: $aeropuertosSoloNacionales")
}
