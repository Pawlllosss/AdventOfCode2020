package task8

class Instruction(val argument: Int, val operation: (State, Int) -> State) {

    fun performOperation(currentState: State): State {
        return operation(currentState, argument)
    }
}