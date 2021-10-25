//Ejercicio 5.9
class Cuenta(val numerocuenta:String, var saldo:Double = .0){

    fun pago(cantidad:Double){
        this.saldo -= cantidad
    }

    fun abono(cantidad: Double){
        this.saldo += cantidad
    }

    fun transfer(cantidad:Double, cuentadestino:Cuenta){
        cuentadestino.abono(cantidad)
        this.saldo -= cantidad

    }

    override fun toString(): String {
        return "[${this.numerocuenta}]"
    }
}

class Persona(val DNI:String, val cuentas:MutableList<Cuenta> = mutableListOf()){

    init {
        require(cuentas.size<=3){"No puedes añadir más de 3 cuentas"}
    }

    fun addcuenta(nuevacuenta:Cuenta){
        if(cuentas.size<3){
        this.cuentas.add(nuevacuenta)}
        else throw IndexOutOfBoundsException("No puedes añadir más de 3 cuentas")
    }

    fun esmorosa():String{
        for(i in 0..2){
            if (this.cuentas[i].saldo<0) return "Es moroso"
        }
        return "No es moroso"
    }

    override fun toString(): String {
        return this.DNI
    }

}

fun saldos(cuenta:Cuenta){
    println("Saldo de la cuenta $cuenta: ${cuenta.saldo}")
}


fun main(){
    val persona1 = Persona("ASDFSADF")
    val cuenta1 = Cuenta("4774 7887 2929 9010")
    val cuenta2 = Cuenta("4851 9461 9471 5794",700.00)
    persona1.addcuenta(cuenta1)
    persona1.addcuenta(cuenta2)

    saldos(cuenta1)
    saldos(cuenta2)

    println("Abono de 1100€ a la cuenta $cuenta1")
    cuenta1.abono(1100.00)
    println("Pago de 750€ a la cuenta $cuenta2")
    cuenta2.pago(750.00)
    saldos(cuenta1)
    saldos(cuenta2)
    println(persona1.esmorosa())

    println("Transferencia de 500€ de la cuenta $cuenta1 a la cuenta $cuenta2")
    cuenta1.transfer(500.00,cuenta2)
    saldos(cuenta1)
    saldos(cuenta2)
}


