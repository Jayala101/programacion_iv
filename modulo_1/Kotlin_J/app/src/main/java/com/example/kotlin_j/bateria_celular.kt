package com.example.kotlin_j

fun main() {
    val bat: Int = 100

    for (bat in 100 downTo 0 step 10){
        if (bat == 100) {
            println("Cargado")
        } else if (bat == 50) {
            println("mitad de bateria")
        } else if (bat == 10) {
            println("conecta cargador")
        } else if (bat == 0) {
            println("apagado")
        } else (println(bat))
    }
}