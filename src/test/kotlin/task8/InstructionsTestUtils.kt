package task8

internal object InstructionsTestUtils {

    private val accInstr = "acc"
    private val jmpInstr = "jmp"
    private val nopInstr = "nop"
    private val repository = InstructionRepository()

    fun getLoopInstructions(): List<Instruction> {
        val instructionsOperations = repository.getInstructionsOperations()
        val acc = instructionsOperations[accInstr]!!
        val jmp = instructionsOperations[jmpInstr]!!
        val nop = instructionsOperations[nopInstr]!!

        return listOf(
            Instruction(nopInstr, 0, nop),
            Instruction(accInstr, 1, acc),
            Instruction(jmpInstr, 4, jmp),
            Instruction(accInstr, 3, acc),
            Instruction(jmpInstr, -3, jmp),
            Instruction(accInstr, -99, acc),
            Instruction(accInstr, 1, acc),
            Instruction(jmpInstr, -4, jmp),
            Instruction(accInstr, 6, acc)
        )
    }

    fun getValidInstructions(): List<Instruction> {
        val instructionsOperations = repository.getInstructionsOperations()
        val acc = instructionsOperations[accInstr]!!
        val jmp = instructionsOperations[jmpInstr]!!
        val nop = instructionsOperations[nopInstr]!!

        return listOf(
            Instruction(nopInstr, 0, nop),
            Instruction(accInstr, 1, acc),
            Instruction(jmpInstr, 4, jmp),
            Instruction(accInstr, 3, acc),
            Instruction(jmpInstr, -3, jmp),
            Instruction(accInstr, -99, acc),
            Instruction(accInstr, 1, acc),
            Instruction(jmpInstr, 2, jmp),
            Instruction(nopInstr, -4, nop),
            Instruction(accInstr, 6, acc)
        )
    }
}