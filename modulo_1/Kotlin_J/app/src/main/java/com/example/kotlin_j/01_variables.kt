package com.example.kotlin_j

import androidx.annotation.Nullable

fun main(){
    println("Variables")
    val planeta = "Tatooine"
    var jedi = "Anakin"

    jedi = "Obiwan"
    //planeta = "Tierra"
    println("Tipos de variables")
    println("Tipos numericos")
    println("Tipo entero")
    val edad: Int = 25
    println(edad)

    println("Tipo double")
    val altura: Double = 25.5
    println(altura)

    println("Tipo Float")
    val peso: Double = 25.5
    println(peso)

    println("Tipo Long")
    val poblacion: Long = 20_000_000_000L
    println(poblacion)

    println("Tipo String")
    val  nombre: String = "20_000_000_000L"
    println(nombre)

    println("Tipo Char")
    val  inicial: Char = 'O'
    println(inicial)

    println("Tipo Logico")
    val  esJedi: Boolean = true
    println(esJedi)

    println("Nulidad")
    val  apellido: String? = null
    println(apellido)

    println("Nulidad")
    val  ciudad: String? = ""
    println(ciudad?.length)

    println("Operacion de asercion no null")
    //val longitudSegura = apellido!!.length

    println("Interpolacion de strings")
    val nombrePrincesa: String = "Leia"
    val edadPrincesa: Int = 19
    val planetaPrincesa: String = "Alderan"
    println("${nombrePrincesa.uppercase()} nacion en ${planetaPrincesa}")
    println("En 10 años tendra : ${edadPrincesa+10}")

    println("String Multilenea")
    val mensaje = """
        Querido $nombre
        Tu mision en $planeta
        ha sido completada exitosamente
        Que la fuerza te acompañe
    """
    println(mensaje)

    println("Conversiones")
    val textoEdad: String = "25"
    val edadConvertida: Int = textoEdad.toInt()
    println(edadConvertida)
    val numerotoString: Double = 50.8
    val numeroconvertido: String = numerotoString.toString()
    println(numeroconvertido)

}