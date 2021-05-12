package ar.edu.unahur.obj2.socios

import kotlin.math.max

abstract class EstadoDeAnimo{
   abstract fun calcularPropina(cliente: Cliente, montoPedido:Double): Double
}
object Enojado: EstadoDeAnimo(){
    override fun calcularPropina(cliente: Cliente,montoPedido:Double)= 0.0
}
object Feliz: EstadoDeAnimo(){
    override fun calcularPropina(cliente: Cliente,montoPedido: Double)= montoPedido*0.25
}
object Indiferente: EstadoDeAnimo(){
    override fun calcularPropina(cliente: Cliente,montoPedido: Double)= cliente.dineroEnBolsillo
}
object Resfriado: EstadoDeAnimo(){
    override fun calcularPropina(cliente: Cliente,montoPedido: Double)= montoPedido
}
class Cliente(var dineroEnBolsillo: Double, var barrioEnElQueVive: Barrio, var estadoDeAnimo: EstadoDeAnimo) {

    fun propinaSegunEstadoDeAnimo(montoPedido:Double)= estadoDeAnimo.calcularPropina(this, montoPedido)
    fun propinaTotalADar(montoPedido: Double)= barrioEnElQueVive.calcularPropina(this, montoPedido)

}
abstract class Barrio {
    abstract fun calcularPropina(cliente: Cliente, montoPedido: Double): Double
}
object LasRosas: Barrio() {
    override fun calcularPropina(cliente: Cliente, montoPedido: Double)= cliente.propinaSegunEstadoDeAnimo(montoPedido) + 50
}
object LasLauchas: Barrio() {
    override fun calcularPropina(cliente: Cliente, montoPedido: Double)= cliente.propinaSegunEstadoDeAnimo(montoPedido) /2
}
object BarrioVerde: Barrio() {
    override fun calcularPropina(cliente: Cliente, montoPedido: Double)= max(cliente.propinaSegunEstadoDeAnimo(montoPedido),200.0)
}
object LasTorres: Barrio() {
    override fun calcularPropina(cliente: Cliente, montoPedido: Double)= cliente.propinaSegunEstadoDeAnimo(montoPedido)
}

