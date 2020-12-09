package task8

data class Instruction(val name: String, val argument: Int, private val operation: (State, Int) -> State) {

    fun performOperation(currentState: State): State {
        return operation(currentState, argument)
    }
}