package Core

import chisel3._
import chisel3.util._
class GeneralPurposeRegister extends Module {
  val io = IO(new Bundle() {
    val writeIdx = Input(UInt(5.W))
    val writeData = Input(UInt(64.W))
    val writeEnable = Input(Bool())
    val readIdxA = Input(UInt(5.W))
    val readIdxB = Input(UInt(5.W))
    val readDataA = Output(UInt(64.W))
    val readDataB = Output(UInt(64.W))
  })

  // Rules use Reg of Vec not Vec of Reg
  // All register all initialized as 0
  val generalPurposeRegister = RegInit(VecInit(Seq.fill(32)(0.U(64.W))))

  when (io.writeIdx === 0.U(5.W)) {
    io.writeData := DontCare
  } .otherwise {
    generalPurposeRegister(io.writeIdx) := Mux(!io.writeEnable, generalPurposeRegister(io.writeIdx), io.writeData)
  }

  io.readDataA := generalPurposeRegister(io.readIdxA)
  io.readDataB := generalPurposeRegister(io.readIdxB)
}
