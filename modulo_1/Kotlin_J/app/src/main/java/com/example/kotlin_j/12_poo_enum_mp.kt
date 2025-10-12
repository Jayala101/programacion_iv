package com.example.kotlin_j

enum class TipoVuelo(val codigo: String, val prioridad: Int) {
    COMERCIAL("COME", 3) {
        override fun descripcion() = "Un vuelo regular de pasajeros"
    },
    CARGA("CARG", 2) {
        override fun descripcion() = "Un vuelo de transporte de mercancías"
    },
    PRIVADO("PRIV", 1) {
        override fun descripcion() = "Un vuelo ejecutivo o charter"
    },
    EMERGENCIA("EMER", 5) {
        override fun descripcion() = "Un vuelo medico o de evacuacion"
    };
    abstract fun descripcion(): String
    companion object {
        fun porCodigo(codigo: String) = values().find { it.codigo == codigo }
    }
}
class Vuelo_ej(val tipo: TipoVuelo, val numero: String, val piloto: String) {
    fun despegar() = "El vuelo $numero (${tipo.codigo}) pilotado por $piloto está despegando"
    fun info() = "${tipo.descripcion()} - Prioridad: ${tipo.prioridad}"
}

fun main() {
    val vuelo1 = Vuelo_ej(TipoVuelo.COMERCIAL, "HK345", "Jose Garrido")
    println(vuelo1.despegar())
    println(vuelo1.info())
    val vuelo2 = Vuelo_ej(TipoVuelo.EMERGENCIA, "EM957", "Max Hinostroza")
    println(vuelo2.despegar())
    println(vuelo2.info())
    val tipoEncontrado = TipoVuelo.porCodigo("PRI")
    println("Tipo encontrado: ${tipoEncontrado?.descripcion()}")
}
