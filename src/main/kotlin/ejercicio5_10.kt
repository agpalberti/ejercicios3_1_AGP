//Ejercicio 5.10

class Libro(val titulo: String, val autor: String, val numpag: Int, var calif: Byte) {
    init {
        require(calif in 0..10){"La calificación debe estar entre 0 y 10"}
    }

}

class ConjuntoLibros(){
    var libros:Array<Libro> = arrayOf()
}


fun main() {}