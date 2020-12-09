package task8.part2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import task8.AccumulatorCounter
import task8.InstructionRepository
import task8.InstructionsTestUtils

internal class InstructionFixerTest {

    private val accumulatorCounter = AccumulatorCounter()
    private val instructionRepository = InstructionRepository()
    private val instructionFixer = InstructionFixer(accumulatorCounter, instructionRepository)

    @Test
    fun shouldReturnAccumulatorCounterOfExecutedFixedInstructions() {
        // GIVEN
        val instructions = InstructionsTestUtils.getLoopInstructions()

        // WHEN
        val accumulator = instructionFixer.getAccumulatorOfFixedInstructions(instructions)

        // THEN
        Assertions.assertThat(accumulator).isEqualTo(8)
    }
}