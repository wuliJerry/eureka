package Core

import chisel3._
import chisel3.util._

class ProgramCounter extends Module{
  val io = IO(new Bundle() {
    val outAddr = Output(UInt(64.W))
  })

  val regAddr = RegInit("h7fff_fffc".U)

  val curAddr = WireInit(0.U(64.W))
  curAddr := regAddr + 4.U(64.W)
  regAddr := curAddr

  io.outAddr := curAddr
}
