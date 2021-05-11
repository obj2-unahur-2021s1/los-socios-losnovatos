package ar.edu.unahur.obj2.socios

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ClienteTest : DescribeSpec({
  describe("cliente resfriado de barrio las lauchas da 500 de propina a un pedido de 1000") {
    val pepe=Cliente(100.0,LasLauchas,Resfriado)
    pepe.propinaTotalADar(1000.0).shouldBe(500.0)
  }
  describe("cliente enojado de las lauchas no da propina"){
    val pepa=Cliente(500000.0,LasLauchas,Enojado)
    pepa.propinaTotalADar(5000.0).shouldBe(0)
  }
  describe("cliente enojado de barrio las rosas da 50 pesos de propina"){
    val pepinha=Cliente(125.0,LasRosas,Enojado)
    pepinha.propinaTotalADar(50.0).shouldBe(50)
  }
  describe("cliente feliz de barrio verde da 200 de propina a un pedido menor a 200"){
    val pipo=Cliente(125.0,BarrioVerde,Feliz)
    pipo.propinaTotalADar(125.0).shouldBe(200)
  }
})
