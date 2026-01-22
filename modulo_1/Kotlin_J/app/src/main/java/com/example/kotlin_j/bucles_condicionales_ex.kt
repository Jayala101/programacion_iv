fun main() {
       /*Semáforo peatonal
    Pide color del semáforo ("rojo", "amarillo", "verde") y si el peatón presionó el botón ("si"/"no").


    Si está verde y presionó → “Espera a rojo”.


    Si está rojo → “Cruza”.


    Si amarillo → “Prepárate”.


    En otros casos → “Espera”.*/

    print("Ingrese el color del semaforo (verde, amarillo, rojo): ")
    var semaforo: String = readLine()?.toString()?:""
    print("Quiere presionar el boton? (si/no): ")
    var boton: String = readLine()?.toString()?:""

    if (semaforo == "verde" && boton.lowercase() == "si"){
        println("Esperar a rojo")
    } else if (semaforo == "rojo"){
        println("Esperar rojo")
    } else if (semaforo == "amarillo"){
        println("Preparate")
    } else {
        println("Esperar")
    }
    /*
    Entrada de cine con descuento por edad
    Pide edad. Base $5.


    <12 → $3


    ≥65 → $4


    Si no, $5.
     */
    print("Ingresa tu edad: ")
    var edad: Int = readLine()?.toIntOrNull()?:0
    var base = 5

    if (edad < 12) {
        print("el precio es: 3$")
    } else if (edad >= 65) {
        print("el precio es: 4$")
    } else {
        print("el precio es: 5$")
    }

    /*
    Contador de pares hasta N
    Pide N y cuenta cuántos números pares hay entre 1 y N.
    */
    print("\nIngrese un numero: ")
    val numero: Int =  readLine()?.toIntOrNull()?:0

    println("Los numeros pares son:")
    for (n in 1..numero) {
        if (n % 2 == 0) {
            println("El numero ${n}")
        }
    }

    /*
    Suma de múltiplos de 3
    Pide N y suma los múltiplos de 3 desde 1..N.
    */
    var suma = 0
    print("\nIngresa un numero N: ")
    val numero_mul: Int = readLine()?.toIntOrNull()?:0

    for (n in 1..numero_mul) {
        if (n % 3 == 0) {
            suma += n
        }
    }

    println("Su suma es: $suma")

    /*
    Estado del agua por temperatura
    Pide °C.


    ≤0 → “Sólido”


    1..99 → “Líquido”


    ≥100 → “Gas”
     */
    print("\nIngrese la temperatura (C):")
    var temperatura: Int = readLine()?.toIntOrNull()?:0

    if (temperatura <= 0) {
        print("Solido")
    } else if (temperatura >= 1 && temperatura <= 99 ){
        print("Liquido")
    } else if (temperatura >= 100){
        print("Gas")
    } else {
        print("N/A")
    }

    /*
    Calculadora mínima (+ / −)
    Bucle de menú: 1) Sumar 2) Restar 3) Salir. Tras cada operación, mostrar resultado.
    */
    while (true) {
        print(
            "\nBucle de menu:" +
                    "\n1. Sumar" +
                    "\n2. Restar" +
                    "\n3. Salir\n" +
                    "Escoja una opcion: "
        )
        var opcion: Int = readLine()?.toIntOrNull() ?: 0

        if (opcion == 3) {
            println("Nos vemos luego")
            break
        }

        print("Ingrese el primer valor: ")
        var valor1: Int = readLine()?.toIntOrNull() ?: 0
        print("Ingrese el segundo valor: ")
        var valor2: Int = readLine()?.toIntOrNull() ?: 0

        val resultado = when (opcion) {
            1 -> valor1 + valor2
            2 -> valor1 - valor2
            else -> {
                println("Opcion invalida. Intente de nuevo")
                continue
            }
        }

        println("El resultado es: $resultado")
    }

    /*
    Validador simple de contraseña
    Pide contraseña. Válida si tiene ≥8 caracteres y contiene al menos un dígito
     */
    /*
    Validador simple de contraseña
    Pide contraseña. Válida si tiene ≥8 caracteres y contiene al menos un dígito
     */

    print("Ingresa un password: ")
    val contraseña = readLine()?:""

    val tieneLongitud = contraseña.length >= 8
    val tieneDigito = contraseña.any {it.isDigit()}

    if (tieneLongitud && tieneDigito) {
        println("Password valido")
    } else {
        println("Password invalido")
        if (!tieneLongitud) {
            println("Debe tener al menos 8 caracteres")
        }
        if (!tieneDigito) {
            println("Debe contener al menos un dígito")
        }
    }
    /*
    Contar vocales en una palabra
    Pide texto y cuenta vocales (a,e,i,o,u) sin tildes.
     */
    println("Ingresa una palabra para contar las vocales:")
    var input: String = readLine()?.toString()?:""
    var contador = 0

    for (caracter in input.lowercase()) {
        if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
            contador++
        }
    }

    println("La palabra '$input' tiene $contador vocales")

    /*
    Tabla de multiplicar (1..10)
    Pide un número y muestra su tabla hasta 10.
     */
    print("Ingresa el numero de la tabla de multiplicacion: ")
    val numero_tbl = readLine()?.toIntOrNull()?:0
    println("Tabla del $numero_tbl:")

    for (i in 1..10) {
        val resultado = numero_tbl * i
        println("$numero_tbl x $i = $resultado")
    }
    /*
    Promedio y aprobación
    Pide 3 notas (0–20). Promedia y dice “Aprobado” si ≥ 14, si no “Reprobado”.
     */
    var sumarNotas = 0.0

    for (i in 1..3) {
        print("Ingresa la nota $i (0-20): ")
        val nota = readLine()?.toDoubleOrNull()?:0.0
        when {
            nota < 0 -> {
                println("Nota no válida, Menor a 0")
                sumarNotas += 0.0
            }
            nota > 20 -> {
                println("Nota no válida, Mayor a 20")
                sumarNotas += 20.0
            }
            else -> sumarNotas += nota
        }
    }

    val promedio = sumarNotas / 3
    val estado = if (promedio >= 14) "Aprobado" else "Reprobado"
    println("Nota 1: ${"%.1f".format(sumarNotas / 3 * 0.333 * 3)}")
    println("Nota 2: ${"%.1f".format(sumarNotas / 3 * 0.333 * 3)}")
    println("Nota 3: ${"%.1f".format(sumarNotas / 3 * 0.333 * 3)}")
    println("Promedio: ${"%.2f".format(promedio)}")
    println("Estado: $estado")
}