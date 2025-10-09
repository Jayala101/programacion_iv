package com.example.kotlin_j

enum class TipoSable(val color: String, val poder: Int) {
    AZUL("azul", 85){
       override fun descripcion() = "Sable tradicional de los Jedi"
    },
    VERDE("verde", 90){
       override fun descripcion() = "Sable tradicional de los Jedi consulado"
    },
    MORADO("morado", 95){
      override  fun descripcion() = "Sable equilibra luz y ocuridad"
    },
    ROJO("azul", 95){
       override fun descripcion() = "Sable de lo sSith"
    };
    abstract fun descripcion(): String
    companion object{
        fun porColor(color: String) = values().find { it.color==color }
    }
}

class SableDeLuz(val tipo: TipoSable, val portador: String){
    fun activar() = "!ZZZrum! El sable color ${tipo.color} de ${portador} se enciende"
    fun info() = "${tipo.descripcion()} - tipo poder ${tipo.poder}"
}

fun main(){
    val sableWindoo = SableDeLuz(TipoSable.MORADO, "Windoo")
    println(sableWindoo)
    println(sableWindoo.activar())
    println(sableWindoo.info())

    val sableLuke = SableDeLuz(TipoSable.VERDE, "Luke Skywalker")
    println(sableWindoo)
    println(sableWindoo.activar())
    println(sableWindoo.info())
}

