package ar.edu.unahur.obj2.socios

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ClienteTest: DescribeSpec ({

  //Requerimiento 1
  describe("Un cliente") {
    val pepe = Cliente(100.0, LasTorres, Resfriado)

    it("resfriado da el 100% de propina de lo que salió el pedido") {
      pepe.propinaTotalADar(1000.0).shouldBe(1000.0)
    }
    it("enojado no da nada propina") {
      pepe.estadoDeAnimo = Enojado
      pepe.propinaTotalADar(1000.0).shouldBe(0.0)
    }
    it("feliz da el 25% de un pedido") {
      pepe.estadoDeAnimo = Feliz
      pepe.propinaTotalADar(1000.0).shouldBe(250.0)
    }
    it("indiferente da lo que tiene en el bolsillo de propina") {
      pepe.estadoDeAnimo = Indiferente
      pepe.propinaTotalADar(1000.0).shouldBe(100.0)
    }
  }
  //Requerimiento 2
  describe("Un cliente enojado de LasLauchas no da propina"){
    val pepa = Cliente(500000.0, LasLauchas, Enojado)
    pepa.propinaTotalADar(5000.0).shouldBe(0)
  }
  describe("Un cliente enojado de LasRosas da $50 pesos de propina"){
    val pepinha = Cliente(125.0, LasRosas, Enojado)
    pepinha.propinaTotalADar(50.0).shouldBe(50)
  }
  describe("Un cliente feliz de BarrioVerde da $200 de propina a un pedido menor a $200"){
    val pipo = Cliente(125.0, BarrioVerde, Feliz)
    pipo.propinaTotalADar(125.0).shouldBe(200)
  }
  describe("Un cliente feliz de BarrioVerde da $ de propina a un pedido mayor a $200"){
    val pipo = Cliente(125.0, BarrioVerde, Feliz)
    pipo.propinaTotalADar(125.0).shouldBe(200)
  }
  describe("Un cliente indiferente de LasTorres da $30 de propina a un pedido de $800"){
    val pipo = Cliente(30.0, LasTorres, Indiferente)
    pipo.propinaTotalADar(800.0).shouldBe(30)
  }
})
