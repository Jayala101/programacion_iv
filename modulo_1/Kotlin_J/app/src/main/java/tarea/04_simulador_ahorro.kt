fun main() {
    print("Ingrese tu meta de ahorro: ")
    val meta = readLine()?.toIntOrNull() ?: 0

    print("Ingrese tu ahorro inicial: ")
    var ahorroActual = readLine()?.toIntOrNull() ?: 0

    var depositoSemanal = 5
    var semana = 1

    while (ahorroActual < meta) {
        ahorroActual += depositoSemanal
        println("Semana $semana: Depósito = $depositoSemanal, Ahorro Total = $ahorroActual")
        depositoSemanal += 10
        semana++
    }
    println("¡Meta alcanzada en ${semana - 1} semanas!")
}