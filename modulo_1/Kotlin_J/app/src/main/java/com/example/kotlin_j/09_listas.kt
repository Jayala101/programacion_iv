package com.example.kotlin_j

fun main(){

    println("Listas")
    val inmutable: List<Int> = listOf(1,2,3)
    println("Lista inmutable ${inmutable}")

    val mutableLista: MutableList<Int> = mutableListOf(4,5,6)
    println("Lista Mutable: ${mutableLista}")
    mutableLista.add(7)
    println("Lista Mutable: ${mutableLista}")
    mutableLista.removeAt(0)
    println("Lista Mutable: ${mutableLista}")

    for(mutable in mutableLista) println(mutable)

    println("Operaciones con Mutable List")

    val colores = mutableListOf("rojo","verde")
    colores.add("azul")
    println(colores)
    colores+="amarillo"
    println(colores)
    colores.add(1,"blanco")
    println(colores)
    colores.removeAt(0)
    println(colores)
    colores[0] = "nregro"
    println(colores)
    colores.clear()
    println(colores.isEmpty())

    println("Busqueda con Mutable List")
    val nombres = mutableListOf("juan","luis","pedro")
    println(nombres.find { it.startsWith("L") })
    println(nombres.firstOrNull{it.length>4})
    println(nombres.any{it.contains('p')})
    println(nombres.none{it == "x"})

    println("Busqueda con Mutable List")
    val numerosDesordenados = mutableListOf(8,3,2,4,7,2,7,0,6)
    println(numerosDesordenados)
    println(numerosDesordenados.sorted())
    print(numerosDesordenados.sortedDescending())
    println(numerosDesordenados.distinct())

}