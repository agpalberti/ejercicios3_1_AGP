//Ejercicio 5.8

class Tiempo(var hour: Int, var min: Int = 0, var sec: Int = 0) {

    init {
        require(hour >= 0 && min >= 0 && sec >= 0) { "Has introducido valores no permitidos" }

        while (sec >= 60) {
            sec -= 60
            min += 1
        }
        while (min >= 60) {
            min -= 60
            hour += 1
        }
    }

    override fun toString(): String {
        return "${this.hour}h ${this.min}m ${this.sec}s"
    }
}

fun introducirdato(param: String): Int {
    return if (param == "") {
        0
    } else {
        try {
            param.toInt()
        } catch (_: Exception) {
            -1
        }
    }
}

fun main() {
    val hora: Tiempo
    val hour: Int
    val min: Int
    val sec: Int

    println("Introduce las horas")
    hour = introducirdato(readLine()!!)
    println("Introduce los minutos")
    min = introducirdato(readLine()!!)
    println("Introduce los segundos")
    sec = introducirdato(readLine()!!)

    hora = Tiempo(hour, min, sec)
    println(hora)
}