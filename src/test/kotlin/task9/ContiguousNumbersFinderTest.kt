package task9

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContiguousNumbersFinderTest {

    private val contiguousNumbersFinder = ContiguousNumbersFinder()

    @Test
    fun shouldReturnContiguousNumbers() {
        // GIVEN
        val elements = ElementsTestUtils.getFaultyElements()
        val targetSum: Long = 127

        // WHEN
        val contiguousElements = contiguousNumbersFinder.findElementsThatSumUp(elements, targetSum)

        // THEN
        assertThat(contiguousElements).containsExactly(15, 25, 47, 40)
        assertThat(contiguousElements.sum()).isEqualTo(targetSum)
    }

    @Test
    fun shouldReturnEmptyListForEmptyInput() {
        // GIVEN
        val elements = emptyList<Long>()

        // WHEN
        val contiguousElements = contiguousNumbersFinder.findElementsThatSumUp(elements, 127)

        // THEN
        assertThat(contiguousElements).isEqualTo(emptyList<Long>())
    }
}