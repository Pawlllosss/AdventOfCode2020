package task8.part2

import task8.AccumulatorCounter
import task8.Instruction
import task8.InstructionRepository
import task8.State
import java.lang.IllegalStateException

class InstructionFixer(
    private val accumulatorCounter: AccumulatorCounter,
    private val instructionRepository: InstructionRepository
) {
    private val jmpName = "jmp"
    private val nopName = "nop"
    private val nopOperation: (State, Int) -> State
    private val jmpOperation: (State, Int) -> State
    init {
        val operationByName = instructionRepository.getInstructionsOperations()
        jmpOperation = operationByName[jmpName]!!
        nopOperation = operationByName[nopName]!!
    }

    fun getAccumulatorOfFixedInstructions(instructions: List<Instruction>): Int {
        val instructionsNumber = instructions.size

        // TODO: check if works if doesnt need to change
        val (accumulator, completed) = accumulatorCounter.countUntilLoopOrEnd(instructions)
        if (completed) {
            return accumulator
        }

        var currentState = State(1, 0)
        var newInstruction: Instruction // TODO: move to while, or method....


        while (currentState.instructionIndex < instructionsNumber) {
            val index = currentState.instructionIndex
            val currentInstruction = instructions[index]
            if (isJmpInstruction(currentInstruction)) {
                newInstruction = Instruction(nopName, currentInstruction.argument, nopOperation)
            } else if (isNopInstruction(currentInstruction)) {
                newInstruction = Instruction(jmpName, currentInstruction.argument, jmpOperation)
            } else {
                currentState = currentInstruction.performOperation(currentState)
                continue
            }

            // TODO: handle edge cases
            val modifiedInstructions = instructions.subList(0, index) + newInstruction + instructions.subList(index + 1, instructionsNumber)

            val (accumulator, completed) = accumulatorCounter.countUntilLoopOrEnd(modifiedInstructions, index)
            if (completed) {
                return accumulator + currentState.accumulator
            }
            currentState = currentInstruction.performOperation(currentState)
        }

        throw IllegalStateException("Unable to fix instructions")
    }

    private fun isJmpInstruction(currentInstruction: Instruction): Boolean =
        currentInstruction.name == jmpName

    private fun isNopInstruction(currentInstruction: Instruction): Boolean = currentInstruction.name == nopName
}