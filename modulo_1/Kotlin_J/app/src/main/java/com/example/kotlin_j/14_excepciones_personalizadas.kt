package com.example.kotlin_j

import java.util.MissingResourceException

class FuerzaInsuficienteException(message: String): Exception(message)
class MisionPeligrosaExceptionException(message: String): Exception(message)

fun realizarMision(nivelFuerza: Int, peligroMision: Int): String{
    return try{
        when {
            nivelFuerza < 30 -> throw FuerzaInsuficienteException("Nivel de fuerza muy bajo: ${nivelFuerza}")
            nivelFuerza > 80 -> throw MisionPeligrosaExceptionException("Mision extremadamente peligrosa")
            else -> {
                "Error inesperado"
            }
        }
    } catch (e: FuerzaInsuficienteException){
        "error: ${e.message}. Se requiere entrenamiento adicional"
    } catch (e: MisionPeligrosaExceptionException){
        "error: ${e.message}. Niviel de peligro ${peligroMision}"
    } finally {
        "Reporte enviado"
    }
}

fun main(){
    println(realizarMision(20,60))
    println(realizarMision(100,60))
}

