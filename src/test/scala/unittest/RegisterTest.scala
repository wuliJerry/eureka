package unittest

import Core.GeneralPurposeRegister
import chisel3._
import chiseltest._
import org.scalatest.flatspec._

class RegisterTest extends AnyFlatSpec with ChiselScalatestTester {
  behavior of "GeneralPurposeRegister"
    it should "store and output value" in {
      test(new GeneralPurposeRegister).withAnnotations(Seq(WriteVcdAnnotation)){ dut =>
        dut.io.writeIdx.poke(3.U)
        dut.io.writeEnable.poke(true.B)
        dut.io.writeData.poke("h80000000".U)
        dut.clock.step(10)
        dut.io.readIdxA.poke(3.U)
        dut.clock.step(10)
      }
    }
}
