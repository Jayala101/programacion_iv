fun main(){
    println("A que temperatura desea? ")
    val temperatura = readLine()?.toIntOrNull()?:0
    println("Escoja las siguientes ociones:" +
            "\n1. frio" +
            "\n2. Caliente" +
            "\n2. Templado")
    val preferencia = readLine()?.toIntOrNull()?:0

    if (temperatura > 22 && preferencia == 1){
        println("Encender aire")
    } else if (temperatura < 18 && preferencia == 2){
        println("Encender calefaccion")
    } else if(temperatura >= 18 && temperatura <= 22 && preferencia == 3){
        println("En confort")
    } else {
        println("Ventilar")
    }
}