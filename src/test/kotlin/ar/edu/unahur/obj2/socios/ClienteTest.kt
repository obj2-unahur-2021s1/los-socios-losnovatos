package ar.edu.unahur.obj2.socios

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ClienteTest: DescribeSpec ({

  describe("Un cliente resfriado de barrio las lauchas da $500 de propina a un pedido de $1000") {
    val pepe = Cliente(100.0, LasLauchas, Resfriado)
    pepe.propinaSegunBarrio(1000.0).shouldBe(500.0)
  }
  describe("Un cliente enojado de lasLauchas no da propina"){
    val pepa = Cliente(500000.0, LasLauchas, Enojado)
    pepa.propinaSegunBarrio(5000.0).shouldBe(0)
  }
  describe("Un cliente enojado de barrio lasRosas da $50 pesos de propina"){
    val pepinha = Cliente(125.0, LasRosas, Enojado)
    pepinha.propinaSegunBarrio(50.0).shouldBe(50)
  }
  describe("Un cliente feliz de barrio verde da $200 de propina a un pedido menor a $200"){
    val pipo = Cliente(125.0, BarrioVerde, Feliz)
    pipo.propinaSegunBarrio(125.0).shouldBe(200)
  }
  describe("Un cliente feliz de barrioVerde da $ de propina a un pedido mayor a $200"){
    val pipo = Cliente(125.0, BarrioVerde, Feliz)
    pipo.propinaSegunBarrio(125.0).shouldBe(200)
  }
  describe("Un cliente indiferente de lasTorres da $30 de propina a un pedido de $800"){
    val pipo = Cliente(30.0, LasTorres, Indiferente)
    pipo.propinaSegunBarrio(800.0).shouldBe(30)
  }
})
