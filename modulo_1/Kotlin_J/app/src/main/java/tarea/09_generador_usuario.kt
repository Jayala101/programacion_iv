fun main() {
    println("Generador de username!")
    print("Ingrese nombre: ")
    val nombre = readLine()?.trim()?.lowercase() ?: ""
    print("Ingrese apellido: ")
    val apellido = readLine()?.trim()?.lowercase() ?: ""

    if (nombre.isEmpty() && apellido.isEmpty()) {
        println("No hay datos, username por defecto: 123456789")
        return
    }

    var username = ""
    var n = 0
    var a = 0
    var turnoNombre = true

    while (n < nombre.length || a < apellido.length) {
        if (turnoNombre) {
            val letrasDisponibles = nombre.length - n
            if (letrasDisponibles > 0) {
                val cantidadTomar = minOf(2, letrasDisponibles)
                username += nombre.substring(n, n + cantidadTomar)
                n += cantidadTomar
            }
        } else {
            val letrasDisponibles = apellido.length - a
            if (letrasDisponibles > 0) {
                val cantidadTomar = minOf(2, letrasDisponibles)
                username += apellido.substring(a, a + cantidadTomar)
                a += cantidadTomar
            }
        }
        turnoNombre = !turnoNombre
    }

    var numero = 1
    while (username.length < 6) {
        username += numero.toString()
        numero++
    }

    println("Tu username generado: $username (longitud: ${username.length})")
}
