package com.example.kotlin_j

fun main(){
    println("¡Estructurass de control!")
    println("¡Condicionales!")
    val value1 = 10
    val value2 = 15
    if (value1>value2){
        println("El mayor es ${value1}")
    } else {
        println("El mayor es ${value2}")
    }

    println("Rango segun nivel de la fuerza")
    var fuerza: Int = 10
    if (fuerza > 10){
        println("Maestro")
    } else if (fuerza > 5){
        println("Caballero Jedi")
    } else {
        println("Padawam")
    }


    var tipoDroide: String = "R2-D2"
    when(tipoDroide){
        "R2-D2", "R2-Q5"->println("Droide astromecánico")
        "C-3PO", "C-3PA"->println("Droide de protocolo")
        "BB-8", "BB-9E"->println("Droide de nueva generación")
    }

    var peligro: Int = 5
    var recompensa: Int = 5
    when{
        peligro > 8 && recompensa < 1000->println("Misión Rechazada")
        peligro <= 3->println("Misión Aceptada")
        else->println("Requiere Evaluación Adicional")
    }

    var rojo: String = "Rojo"
    var verde: String = "Verde"
    var amarillo: String = "Amarillo"
    var semaforo: String = "Verde"
    var calle: Boolean = false
    when{
        semaforo == rojo->println("Esperar")
        semaforo == amarillo->println("Precaución")
        semaforo == verde->println("Avanzar")
        semaforo == rojo && calle->println("Esperar")
        semaforo == amarillo && calle->println("Esperar")
        semaforo == verde && calle->println("Esperar")
    }

    var mes: String = "enero"

    when(mes) {
            "enero" -> println("Acuario")
            "febrero" -> println("Piscis")
            "marzo" -> println("Aries")
            "abril" -> println("Tauro")
            "mayo" -> println("Géminis")
            "junio" -> println("Cáncer")
            "julio" -> println("Leo")
            "agosto" -> println("Virgo")
            "septiembre" -> println("Libra")
            "octubre" -> println("Escorpio")
            "noviembre" -> println("Sagitario")
            "diciembre" -> println("Capricornio")
            else -> "Mes no válido"
        }

}