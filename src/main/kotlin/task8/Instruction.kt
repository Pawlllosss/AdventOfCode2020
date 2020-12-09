package task8

class Instruction(private val argument: Int, private val operation: (State, Int) -> State) {

    fun performOperation(currentState: State): State {
        return operation(currentState, argument)
    }
}