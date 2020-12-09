package task8.part1

import task8.AccumulatorCounter
import task8.InstructionConverter
import task8.InstructionReader
import task8.InstructionRepository

fun main() {
    val instructionRepository = InstructionRepository()
    val instructionsConverter = InstructionConverter(instructionRepository)
    val instructionReader = InstructionReader(instructionsConverter)
    val accumulatorCounter = AccumulatorCounter()
    val instructionsPath = "src/main/kotlin/task8/resource/input"
    val instructions = instructionReader.getInstructions(instructionsPath)
    println(accumulatorCounter.countUntilLoopOrEnd(instructions))
}