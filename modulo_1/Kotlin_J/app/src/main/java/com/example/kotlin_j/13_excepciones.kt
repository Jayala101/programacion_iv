package com.example.kotlin_j


fun main(){
    try{
        val resultado  = 8/0;
    }catch (e:Exception){
        println(e)
        println("Error en division")
    }
}
