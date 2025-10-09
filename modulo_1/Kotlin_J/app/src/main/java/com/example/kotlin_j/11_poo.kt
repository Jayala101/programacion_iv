package com.example.kotlin_j

data class Jedi(
    val nombre: String,
    val edad: Int,
    val nivelFuerza: Int,
    val maestro: String?=null,
) {
    val rango: String
        get() = when {
            nivelFuerza>=90->"Maestro"
            nivelFuerza>=70->"Caballero"
            nivelFuerza>=50->"Padawan"
            else -> {
                "Iniciando"
            }
        }
    fun puedeEsenciar(): Boolean = nivelFuerza >= 70

    fun entrenar(): Boolean = edad <= 5
}

fun main(){
    val luke = Jedi(
        "Anakin Skywalker",
        25,
        75,
        "Obiwan")
    println(luke)
    //Descentralización de un objeto
    val(nombre,edad,nivelFuerza) = luke
    println("Nombre del jedi ${nombre}, edad: ${edad}, nivel de la fuerza${nivelFuerza}")
    //copiar objetos
    val ashoka = luke.copy("ashoka", nivelFuerza = 80)
    println(ashoka)
    //propidades calculada
    println("Rango de Ashoka ${ashoka.rango}")

}

