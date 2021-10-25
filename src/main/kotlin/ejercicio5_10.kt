//Ejercicio 5.10

class Libro(val titulo: String, val autor: String, val numpag: Int, calificacion: Byte) {
    var calif: Byte = calificacion
        set(value) {
            if (value in 0..10) field = value
            else throw IndexOutOfBoundsException("La calificación debe estar entre 0 y 10")
        }

    init {
        require(calif in 0..10) { "La calificación debe estar entre 0 y 10" }
    }

}

class ConjuntoLibros() {
    var libros: Array<Libro?> = arrayOfNulls<Libro>(10)

    fun add(libro: Libro) {
        for (i in 0..10){

        }
    }

}


fun main() {}