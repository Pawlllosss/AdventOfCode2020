package task8

import utils.FileUtils
import java.io.BufferedReader

class InstructionReader(private val instructionConverter: InstructionConverter) {

    fun getInstructions(instructionsPath: String): List<Instruction> {
        val bufferedReader = FileUtils.getBufferedReader(instructionsPath)
        return readBoardingPassesFromFile(bufferedReader)
    }

    private fun readBoardingPassesFromFile(bufferedReader: BufferedReader): List<Instruction> {
        val instructions = ArrayList<Instruction>()
        bufferedReader.useLines { lines ->
            lines.forEach {
                val airplaneSeat = instructionConverter.convertToInstruction(it)
                instructions.add(airplaneSeat)
            }
        }
        return instructions
    }
}