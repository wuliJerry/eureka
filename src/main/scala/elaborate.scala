import Core._
import chisel3.stage.ChiselStage

object elaborate extends App {
  (new ChiselStage).emitVerilog(
    new ProgramCounter,
    Array("--target-dir", "./generate/")
  )
}
