import kotlin.random.Random

fun main() {
    println("Bienvenido al Rally de Resistencia!")

    print("Cuantas etapas tiene el rally? (N): ")
    val N = readLine()?.toIntOrNull() ?: 0

    if (N <= 0) {
        println("Numero de etapas invalido. Rally cancelado")
        return
    }

    var energia = 100
    val random = Random(42)
    println("Iniciando rally con 100 de energia")

    for (etapa in 1..N) {
        val terreno = random.nextInt(1, 4)

        val (consumo, descripcion) = when (terreno) {
            1 -> Pair(5, "asfalto")
            2 -> Pair(10, "tierra")
            3 -> Pair(15, "barro")
            else -> Pair(0, "desconocido")
        }

        energia -= consumo
        println("Etapa $etapa: Terreno $descripcion, consumes $consumo energia. Energia actual: $energia")

        if (energia <= 0) {
            println("Abandona en etapa $etapa")
            return
        }
    }
    println("Rally completado con energia $energia")
}
