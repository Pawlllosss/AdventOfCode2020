package task8.part2

import task8.AccumulatorCounter
import task8.Instruction
import task8.InstructionRepository
import task8.State
import java.lang.IllegalStateException

class InstructionFixer(
    private val accumulatorCounter: AccumulatorCounter,
    instructionRepository: InstructionRepository
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
        val (accumulator, completed) = accumulatorCounter.countUntilLoopOrEnd(instructions)
        if (completed) {
            return accumulator
        }

        return tryToFixAndReturnAccumulator(instructions)
    }

    private fun tryToFixAndReturnAccumulator(instructions: List<Instruction>): Int {
        var currentState = State(0, 0)
        while (hasInstructionsToProcess(currentState, instructions)) {
            val newInstruction: Instruction
            val index = currentState.instructionIndex
            val currentInstruction = getCurrentInstruction(instructions, currentState)
            if (isJmpInstruction(currentInstruction)) {
                newInstruction = Instruction(nopName, currentInstruction.argument, nopOperation)
            } else if (isNopInstruction(currentInstruction)) {
                newInstruction = Instruction(jmpName, currentInstruction.argument, jmpOperation)
            } else {
                currentState = currentInstruction.performOperation(currentState)
                continue
            }

            val modifiedInstructions = getListOfModifiedInstructions(instructions, index, newInstruction)

            val (accumulator, completed) = accumulatorCounter.countUntilLoopOrEnd(modifiedInstructions, index)
            if (completed) {
                return accumulator + currentState.accumulator
            }
            currentState = currentInstruction.performOperation(currentState)
        }

        throw IllegalStateException("Unable to fix instructions")
    }

    private fun hasInstructionsToProcess(
        currentState: State,
        instructions: List<Instruction>
    ) = currentState.instructionIndex < instructions.size

    private fun getCurrentInstruction(
        instructions: List<Instruction>,
        currentState: State
    ) = instructions[currentState.instructionIndex]

    private fun getListOfModifiedInstructions(
        instructions: List<Instruction>,
        index: Int,
        newInstruction: Instruction
    ) = instructions.subList(0, index) + newInstruction + instructions.subList(index + 1, instructions.size)

    private fun isJmpInstruction(currentInstruction: Instruction): Boolean =
        currentInstruction.name == jmpName

    private fun isNopInstruction(currentInstruction: Instruction): Boolean = currentInstruction.name == nopName
}