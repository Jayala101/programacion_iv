package com.example.kotlin_j

class VueloSobrecargadoException(message: String) : Exception(message)
class CombustibleInsuficienteException(message: String) : Exception(message)
class DestinoNoDisponibleException(message: String) : Exception(message)
fun autorizarDespegue(pasajeros: Int, capacidad: Int, combustible: Double, destino: String): String {
    return try {
        when {
            pasajeros > capacidad -> throw VueloSobrecargadoException("Demasiados pasajeros a borde: $pasajeros/$capacidad")
            combustible < 1000.0 -> throw CombustibleInsuficienteException("Combustible critico de $combustible litros")
            destino == "Barcelona" -> throw DestinoNoDisponibleException("Destino $destino con mal tiempo")
            else -> "Despegue autorizado para $destino"
        }
    } catch (e: VueloSobrecargadoException) {
        "Error: ${e.message}. Diminuir pasajeros por favor"
    } catch (e: CombustibleInsuficienteException) {
        "Error: ${e.message}. Requiere recargar"
    } catch (e: DestinoNoDisponibleException) {
        "Error: ${e.message}. Cambiar ruta mas cercana"
    } finally {
        "Registro completado"
    }
}

fun main() {
    println(autorizarDespegue(200, 180, 1500.0, "Quito"))
    println(autorizarDespegue(150, 180, 500.0, "Cuenca"))
    println(autorizarDespegue(170, 180, 1200.0, "Barcelona"))
    println(autorizarDespegue(160, 180, 1500.0, "Venecia"))
}
