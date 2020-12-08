package task8

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccumulatorCounterTest {

    private val counter = AccumulatorCounter()
    private val repository = InstructionRepository()

    @Test
    fun shouldReturnAccumulatorBeforeEnteringInfiniteLoop() {
        // GIVEN
        val instructions = getLoopInstructions()

        // WHEN
        val accumulator = counter.countUntilLoopOrEnd(instructions)

        // THEN
        assertThat(accumulator).isEqualTo(5)
    }

    @Test
    fun shouldReturnAccumulatorAfterProceedingAllInstructions() {
        // GIVEN
        val instructions = getValidInstructions()

        // WHEN
        val accumulator = counter.countUntilLoopOrEnd(instructions)

        // THEN
        assertThat(accumulator).isEqualTo(8)
    }

    private fun getLoopInstructions(): List<Instruction> {
        val instructionsOperations = repository.getInstructionsOperations()
        val acc = instructionsOperations["acc"]!!
        val jmp = instructionsOperations["jmp"]!!
        val nop = instructionsOperations["nop"]!!

        return listOf(
            Instruction(0, nop),
            Instruction(1, acc),
            Instruction(4, jmp),
            Instruction(3, acc),
            Instruction(-3, jmp),
            Instruction(-99, acc),
            Instruction(1, acc),
            Instruction(-4, jmp),
            Instruction(6, acc)
        )
    }

    private fun getValidInstructions(): List<Instruction> {
        val instructionsOperations = repository.getInstructionsOperations()
        val acc = instructionsOperations["acc"]!!
        val jmp = instructionsOperations["jmp"]!!
        val nop = instructionsOperations["nop"]!!

        return listOf(
            Instruction(0, nop),
            Instruction(1, acc),
            Instruction(4, jmp),
            Instruction(3, acc),
            Instruction(-3, jmp),
            Instruction(-99, acc),
            Instruction(1, acc),
            Instruction(2, jmp),
            Instruction(0, nop),
            Instruction(6, acc)
        )
    }
}