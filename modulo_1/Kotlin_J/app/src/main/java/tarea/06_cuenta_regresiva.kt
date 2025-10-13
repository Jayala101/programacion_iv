fun main() {
    println("Iniciando cuenta regresiva...")
    var numero = 30

    while (numero >= 0) {
        if (numero == 20) {
            println("Chequeo de sistemas")
        } else if (numero == 10) {
            println("Ultimos ajustes")
        } else if (numero == 0) {
            println("Despegue")
        } else {
            println(numero)
        }
        numero--
    }
}
