package task8

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccumulatorCounterTest {

    private val counter = AccumulatorCounter()
    private val repository = InstructionRepository()

    @Test
    fun shouldReturnAccumulatorBeforeEnteringInfiniteLoop() {
        // GIVEN
        val instructions = InstructionsTestUtils.getLoopInstructions()

        // WHEN
        val (accumulator, completed) = counter.countUntilLoopOrEnd(instructions)

        // THEN
        assertThat(accumulator).isEqualTo(5)
        assertThat(completed).isEqualTo(false)
    }

    @Test
    fun shouldReturnAccumulatorAfterProceedingAllInstructions() {
        // GIVEN
        val instructions = InstructionsTestUtils.getValidInstructions()

        // WHEN
        val (accumulator, completed) = counter.countUntilLoopOrEnd(instructions)

        // THEN
        assertThat(accumulator).isEqualTo(8)
        assertThat(completed).isEqualTo(true)
    }
}