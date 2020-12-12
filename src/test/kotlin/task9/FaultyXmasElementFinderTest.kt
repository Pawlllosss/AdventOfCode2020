package task9

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FaultyXmasElementFinderTest {

    private val faultyElementFinder = FaultyXmasElementFinder()

    @Test
    fun shouldReturnFirstFaultyElement() {
        // GIVEN
        val elements: List<Long> = listOf(
            35,
            20,
            15,
            25,
            47,
            40,
            62,
            55,
            65,
            95,
            102,
            117,
            150,
            182,
            127
        )

        // WHEN
        val faultyElement = faultyElementFinder.findFirst(elements, 5)

        // THEN
        assertThat(faultyElement).isEqualTo(127)
    }

    @Test
    fun shouldReturnNullIfFaultElementWasNotFound() {
        // GIVEN
        val elements: List<Long> = listOf(
            35,
            20,
            15,
            25,
            47,
            40,
            62,
            55,
            65,
            95,
            102,
            117,
            150,
            182
        )

        // WHEN
        val faultyElement = faultyElementFinder.findFirst(elements, 5)

        // THEN
        assertThat(faultyElement).isNull()
    }
}