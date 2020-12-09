package task8

import java.lang.IllegalArgumentException

class InstructionConverter(instructionRepository: InstructionRepository) {

    private val operationByName = instructionRepository.getInstructionsOperations()

    fun convertToInstruction(instructionLine: String): Instruction {
        val (operationName, argument) = instructionLine.split(" ")
        val argumentAsNumber = argument.toInt()
        val operation =
            operationByName[operationName] ?: throw IllegalArgumentException("Operation $operationName does not exist")

        return Instruction(argumentAsNumber, operation)
    }
}