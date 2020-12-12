package task9

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FaultyXmasElementFinderTest {

    private val faultyElementFinder = FaultyXmasElementFinder()

    @Test
    fun shouldReturnFirstFaultyElement() {
        // GIVEN
        val elements: List<Long> = ElementsTestUtils.getFaultyElements()

        // WHEN
        val faultyElement = faultyElementFinder.findFirst(elements, 5)

        // THEN
        assertThat(faultyElement).isEqualTo(127)
    }

    @Test
    fun shouldReturnNullIfFaultElementWasNotFound() {
        // GIVEN
        val elements: List<Long> = ElementsTestUtils.getCorrectElements()

        // WHEN
        val faultyElement = faultyElementFinder.findFirst(elements, 5)

        // THEN
        assertThat(faultyElement).isNull()
    }
}