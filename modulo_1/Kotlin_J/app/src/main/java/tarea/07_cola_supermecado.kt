fun main() {
    var ventaDelDia = 0.0
    var cantidadClientes = 0
    println("Bienvenido al supermercado. Ingrese 'nuevo cliente total items' o 'fin'")

    while (true) {
        val ingreso = readLine()?.trim() ?: ""
        if (ingreso.lowercase() == "fin") {
            break
        }

        val partes = ingreso.split(" ")
        if (partes.size < 3 || partes[0].lowercase() != "nuevo" || partes[1].lowercase() != "cliente") {
            println("Input invalido. Usa 'nuevo cliente total items' o 'fin'.")
            continue
        }

        val totalStr = partes[2]
        val itemsStr = if (partes.size > 3) partes[3] else "0"

        val total = totalStr.toDoubleOrNull() ?: 0.0
        val items = itemsStr.toIntOrNull() ?: 0

        var totalConDesc = total
        if (total > 100) {
            totalConDesc = total * 0.95
            println("Descuento del 5% aplicado. Total: $totalConDesc")
        }

        if (items > 10) {
            println("Caja rapida no disponible")
        }

        ventaDelDia += totalConDesc
        cantidadClientes++
        println("Total pagado: $totalConDesc")
    }

    println("Total ventas: $ventaDelDia. Clientes atendidos: $cantidadClientes")
}
