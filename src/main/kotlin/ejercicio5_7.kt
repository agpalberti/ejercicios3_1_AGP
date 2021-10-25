//Ejercicio 5.7

class Coche(var color:String, val marca: String, modelo: String, val caballos:Int, val puertas:Byte, val matricula:String){
    var modelo:String = modelo.uppercase()
    set(value) {
        field = value.uppercase()
    }

    override fun toString(): String {
        return "Coche matrícula: $matricula, marca: $marca, modelo: $modelo, color: $color, puertas: $puertas, caballos: $caballos"
    }

}

fun main(){
    val coche1 = Coche("Blanco","Citroen","Passat",50,4,"JKA9401")
    val coche2 = Coche("Negro","Volkswagen","A2",80,4,"HVI1975")
    println("Coche 1.\n$coche1")
    println("Coche 2.\n$coche2")
    coche1.color="Rojo"
    println("Hemos cambiado el color del coche 1. $coche1")
}
