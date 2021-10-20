//Ejercicio 5.6

class Rectangulo(val base:Int,val altura:Int){

    init {
        require(base>0 && altura>0){"Los valores no pueden ser menores a 0"}
    }

    fun area():Int {return base*altura}
    fun perimetro():Int {return (base*2+altura*2)}
    override fun toString(): String {
        return "$base" + "x" + "$altura"
    }
}


fun main() {
    val rectangulo1 = Rectangulo(4,5)
    val rectangulo2 = Rectangulo(10,5)
    println("El primer rectángulo tiene estas características: $rectangulo1. ${rectangulo1.base} como base y ${rectangulo1.altura} como altura.")
    println("Su área es ${rectangulo1.area()} y su perímetro es ${rectangulo1.perimetro()}")

    println("Para el segundo rectángulo: $rectangulo2. ${rectangulo2.base} como base y ${rectangulo2.altura} como altura.")
    println("Su área es ${rectangulo2.area()} y su perímetro es ${rectangulo2.perimetro()}")
}