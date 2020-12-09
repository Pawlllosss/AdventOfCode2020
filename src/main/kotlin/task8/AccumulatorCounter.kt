package task8

class AccumulatorCounter {

    fun countUntilLoopOrEnd(instructions: List<Instruction>, startIndex: Int = 0): Pair<Int, Boolean> {
        val executedInstructionsIndexes = HashSet<Int>()
        val numberOfInstructions = instructions.size
        var currentState = State(startIndex, 0)

        while (hasInstructionsToExecute(currentState, numberOfInstructions)
            && !hasAlreadyExecutedInstruction(executedInstructionsIndexes, currentState)
        ) {
            executedInstructionsIndexes.add(currentState.instructionIndex)
            val currentInstruction = instructions[currentState.instructionIndex]
            val newState = currentInstruction.performOperation(currentState)
            currentState = newState
        }

        val completed = hasCompleted(currentState.instructionIndex, numberOfInstructions)
        return currentState.accumulator to completed
    }

    private fun hasInstructionsToExecute(currentState: State, numberOfInstructions: Int) =
        currentState.instructionIndex < numberOfInstructions

    private fun hasAlreadyExecutedInstruction(
        executedInstructionsIndexes: HashSet<Int>,
        currentState: State
    ) = executedInstructionsIndexes.contains(currentState.instructionIndex)

    private fun hasCompleted(instructionIndex: Int, numberOfInstructions: Int): Boolean =
        instructionIndex == numberOfInstructions
}