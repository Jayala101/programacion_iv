fun main() {
    println("Ingresa una oracion:")
    val texto = readLine() ?: ""
    var contador = 0


    fun esVocal(char: Char): Boolean {
        val vocales = "aeiouAEIOU"
        return vocales.contains(char)
    }

    for (i in 0 until texto.length - 1) {
        val charActual = texto[i]
        val charSiguiente = texto[i + 1]

        if (esVocal(charActual) && esVocal(charSiguiente)) {
            contador++
        }
    }
    println("El numero total de vocales es: $contador")
}
