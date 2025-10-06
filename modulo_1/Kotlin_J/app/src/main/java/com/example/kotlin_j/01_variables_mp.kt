package com.example.kotlin_j

fun main() {
    println("Variables Aeropuerto")
    val aeropuerto = "Aeropuerto Internacional Quito"
    var vueloActual = "JF1345"

    vueloActual = "SK90231"
    println("Datos del vuelo actual: $vueloActual")

    println("Tipos de variables aeropuerto")
    println("Tipos numéricos")
    println("Tipo entero")
    val numeroPasajeros: Int = 183
    println("Pasajeros: $numeroPasajeros")

    println("Tipo Double")
    val altitud: Double = 35300.75
    println("Altitud: $altitud")

    println("Tipo Float")
    val combustible: Float = 44.8f
    println("Combustible: $combustible")

    println("Tipo Long")
    val numeroVuelo: Long = 1234567890L
    println("Número de vuelo: $numeroVuelo")

    println("Tipo String")
    val destino: String = "Miami"
    println("Destino: $destino")

    println("Tipo Char")
    val terminal: Char = 'A'
    println("Terminal: $terminal")

    println("Tipo Lógico")
    val despegueAutorizado: Boolean = true
    println("Despegue autorizado: $despegueAutorizado")

    println("Nulidad")
    val puertaEmbarque: String? = null
    println("Puerta de embarque: $puertaEmbarque")

    val horaSalida: String? = "14:30"
    println("Longitud de la hora de salida: ${horaSalida?.length}")

    println("Operación de aserción no null")
    //val puertaSegura = puertaEmbarque!!.length

    println("Interpolación de strings")
    val aerolinea: String = "LAN"
    val duracionVuelo: Int = 125
    val ciudadOrigen: String = "Lima"
    println("${aerolinea.uppercase()} vuela desde ${ciudadOrigen.uppercase()}")
    println("Tiempo estimado de llegada: ${duracionVuelo + 15} minutos")

    println("String Multilínea - Anuncio de vuelo")
    val anuncioVuelo = """
        INFORMACIÓN DE VUELO  
         Aerolínea: $aerolinea               
         Vuelo: $vueloActual                  
         Origen: $ciudadOrigen                
         Destino: $destino                    
         Pasajeros: $numeroPasajeros          
         Estado: ${if (despegueAutorizado) "AUTORIZADO" else "EN ESPERA"}
    """.trimIndent()
    println(anuncioVuelo)

    println("Conversiones")
    val textoCapacidad: String = "320"
    val capacidadAvion: Int = textoCapacidad.toInt()
    println("Capacidad del avión: $capacidadAvion pasajeros")

    val pesoCombustible: Double = 85.5
    val pesoTexto: String = pesoCombustible.toString()
    println("Peso del combustible: $pesoTexto toneladas")

}