package task8

class AccumulatorCounter {

    fun countUntilLoopOrEnd(instructions: List<Instruction>): Int {
        val executedInstructionsIndexes = HashSet<Int>()
        val numberOfInstructions = instructions.size
        var currentState = State(0, 0)

        while (hasInstructionsToExecute(currentState, numberOfInstructions)
            && !hasAlreadyExecutedInstruction(executedInstructionsIndexes, currentState)
        ) {
            executedInstructionsIndexes.add(currentState.instructionIndex)
            val currentInstruction = instructions[currentState.instructionIndex]
            val newState = currentInstruction.performOperation(currentState)
            currentState = newState
        }

        return currentState.accumulator
    }

    private fun hasInstructionsToExecute(currentState: State, numberOfInstructions: Int) =
        currentState.instructionIndex < numberOfInstructions

    private fun hasAlreadyExecutedInstruction(
        executedInstructionsIndexes: HashSet<Int>,
        currentState: State
    ) = executedInstructionsIndexes.contains(currentState.instructionIndex)
}