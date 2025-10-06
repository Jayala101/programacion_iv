package com.example.kotlin_j

import kotlin.io.println

fun main(){
    println("¡Bucles!")

    val vuelos = listOf("IB2345 - Madrid", "LH6789 - Frankfurt", "BA1234 - Londres", "AF5678 - París", "UA9012 - Nueva York")

    println("Lista de vuelos programados")
    for ((index, vuelo) in vuelos.withIndex()){
        println("${index+1}.$vuelo")
    }

    println("Monitoreo de combustible")
    for (i in 0 .. 100 step 10){
        println("Nivel de combustible: $i%")
    }

    println("Secuencia de despegue")
    for (countdown in 10 downTo 1){
        println("Despegue en: $countdown")
    }
    println("¡DESPEGUE!")

    println("Procesamiento de vuelos")
    for (vuelo in vuelos){
        if(vuelo.contains("Madrid")) {
            println("Saltando verificación especial para: $vuelo")
            continue
        }
        if(vuelo.contains("Nueva York")) {
            println("Deteniendo procesamiento para: $vuelo")
            break
        }
        println("Procesando vuelo: $vuelo")
    }

    println("Monitoreo del ascenso")
    for (altitud in 0 .. 35000 step 5000){
        println("Ascendiendo: $altitud pies")
        when (altitud) {
            10000 -> println("Nivel de transición - Ajustar presión de cabina")
            18000 -> println("Entrando en espacio aéreo controlado")
            25000 -> println("Altitud de crucero inicial")
            35000 -> println("Altitud de crucero alcanzada")
        }
    }
}