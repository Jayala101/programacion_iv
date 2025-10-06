package com.example.kotlin_j

import kotlin.io.println

fun main(){
    println("¡Bucles!")
    val jedis = listOf("Luke", "Leia", "Obi-wan", "Yoda", "Ashoka")
    for ((index,jedi) in jedis.withIndex()){
        println("${index+1}.$jedi")
    }
    for (i in 0 .. 20 step 2){
        println("Energia: $i%")
    }
    //rangos descendentes
    for (countdown in 10 downTo 1){
        println("Despegue en: $countdown")
    }
    //Control de flujo
    for (jedi in jedis){
        if(jedi == "Obi-wan") continue //saltar esa interacción
        if(jedi == "Yoda") break //saltar esta interacción
        println("entrenando a $jedi")
    }
}