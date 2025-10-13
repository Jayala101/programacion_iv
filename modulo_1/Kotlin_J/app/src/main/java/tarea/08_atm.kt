fun main() {
    var saldo = 1000.0

    println("Bienvenido al ATM!")
    println("Saldo inicial: $$saldo")
    println("Menu: " +
            "\n1) Depositar  " +
            "\n2) Retirar  " +
            "\n3) Salir")

    while (true) {
        print("Elige una opcion: ")
        val opcionStr = readLine()?.trim()?: ""
        val opcion = opcionStr.toIntOrNull()?: 0

        if (opcion ==1) {
            print("Ingresa monto a depositar: ")
            val montoStr = readLine()?.trim()?: "0"
            val monto = montoStr.toDoubleOrNull()?: 0.0
            if (monto >0) {
                saldo += monto
                println("Deposito exitoso. Saldo actual: $$saldo")
            } else {
                println("Monto invalido. Intente nuevamente")
            }
        } else if (opcion ==2) {
            print("Ingresa monto a retirar: ")
            val montoStr = readLine()?.trim()?: "0"
            val monto = montoStr.toDoubleOrNull()?: 0.0
            if (monto > 0 && saldo >= monto) {
                saldo -= monto
                println("Retiro exitoso. Saldo actual: $$saldo")
            } else if (monto > saldo) {
                println("Fondos son insuficientes. Saldo actual: $$saldo")
            } else {
                println("Monto invalido. Intente nuevmanete")
            }
        } else if (opcion ==3) {
            println("Sesion terminada")
            break
        } else {
            println("Opcion invalida. Elija nuevamente: ")
        }
    }
}
