fun main() {
    print("Ingrese la hora entre 0 y 23: ")
    val hora = readLine()?.toIntOrNull() ?: 0

    print("Ingrese el rol de admin, invitado o empleado: ")
    val rol = readLine().toString()?:""

    val accesoPermitido = when (rol.lowercase()) {
        "admin" -> true
        "invitado" -> hora in 9..17
        "empleado" -> hora in 6..20
        else -> false
    }

    val mensaje = if (accesoPermitido) "Permitido" else "Denegado"
    println(mensaje)
}