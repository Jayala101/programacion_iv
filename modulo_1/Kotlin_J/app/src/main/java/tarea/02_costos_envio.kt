fun main(){
    print("Ingrese la distancia (km): ")
    val distancia = readLine()?.toIntOrNull()?:0
    println("Esta lloviendo>" +
            "\n1. Si" +
            "\n2. No")
    val siLlueve = readLine()?.toIntOrNull()?:0

    val costoBase = when {
        distancia <= 5 -> 2.5
        distancia <= 15 -> 5.0
        else -> 8.0
    }

    val costoTotal = costoBase + if(siLlueve == 1) 1.5 else 0.0

    println("Costo toal es: ${costoTotal}")
}

