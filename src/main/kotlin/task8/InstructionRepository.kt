package task8

class InstructionRepository {

    fun getInstructionsOperations(): Map<String, (State, Int) -> State> {
        return mapOf(
            "nop" to { state: State, _: Int -> State(
                state.instructionIndex + 1,
                state.accumulator)
            },
            "jmp" to { state: State, argument: Int ->
                State(
                    state.instructionIndex + argument,
                    state.accumulator)
            },
            "acc" to { state: State, argument: Int ->
                State(
                    state.instructionIndex + 1,
                    state.accumulator + argument)
            }
        )
    }
}