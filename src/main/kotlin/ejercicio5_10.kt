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

    override fun toString(): String {
        return "\"$titulo\", escrito por $autor."
    }

}

class ConjuntoLibros(tamanio: Int) {
    private val size = tamanio
    var libros = arrayOfNulls<Libro>(size)

    fun add(libro: Libro) {
        if (libro !in libros) {
            var counter = 0
            while (counter in 0 until size) {
                if (libros[counter] == null) {
                    libros[counter] = libro
                    counter = size
                } else counter++
            }
            println("Tu libro ha sido añadido.")
        } else println("Ya has introducido ese libro.")
    }

    fun almacenados(): Int {
        var cantidad = 0
        for (i in 0 until size) {
            if (libros[i] != null) cantidad++
        }
        return cantidad
    }

    fun delete(titulo: String) {
        val cantidadinicial = almacenados()
        var counter = 0
        while (counter in 0 until size) {
            if (libros[counter]?.titulo == titulo) {
                libros[counter] = null
                counter = size
            } else counter++
        }
        if (cantidadinicial != almacenados()) println("Tu libro ha sido eliminado con éxito.")
        else println("Tu libro no se ha encontrado entre la lista.")
    }

    fun deleteautor(autor: String) {
        val cantidadinicial = almacenados()
        for (i in 0 until size) {
            if (libros[i]?.autor == autor) libros[i] = null
        }
        if (cantidadinicial != almacenados()) println("Se ha eliminado ${cantidadinicial - almacenados()} libro(s) con éxito.")
        else println("No se encontró a ese autor.")
    }

    fun maxmin() {
        if (almacenados() > 1) {
            var min: Int? = null
            var max: Int? = null
            for (i in 0 until size) {
                if (libros[i] != null) {
                    if ((libros[i]?.calif ?: -1) > (max ?: -1)) max = i
                    if ((libros[i]?.calif ?: 11) < (min ?: 11)) min = i

                }
            }
            println("El libro con la calificación más alta es ${libros[max ?: -1]} con una calificación de ${libros[max ?: -1]?.calif} y el libro con la calificación más baja es ${libros[min?: -1]} con una calificación de ${libros[min?: -1]?.calif}.")
            //TODO: CONTEMPLAR SI HAY MÁS DE UN LIBRO CON LA MISMA CALIFICACIÓN
        } else if (almacenados() == 1) {
            var counter = 0
            var position = 0
            while (counter in 0 until size) {
                if (libros[counter] != null) {
                    position = counter
                    counter = size
                } else counter++
            }
            println("Sólo hay almacenado un libro: ${libros[position]}. Su calificación es ${libros[position]?.calif}")
        } else println("No hay libros almacenados")
    }

    override fun toString(): String {
        val listapos = mutableListOf<Int>()
        var listalibros = "Libros añadidos:"
        return if (almacenados() > 0) {
            for (i in 0 until size) {
                if (libros[i] != null) listapos.add(i)
            }
            for (i in 0 until listapos.size) {
                listalibros += "\n- ${libros[listapos[i]]}"
            }
            listalibros
        } else "No hay libros almacenados"
    }

}


fun main() {
    val libreria = ConjuntoLibros(10)
    val libro = Libro("Caperucita", "JK", 200, 8)
    val libro2 = Libro("Prueba", "Alex", 100, 10)

    libreria.add(libro)
    libreria.add(libro2)
    libreria.maxmin()
}