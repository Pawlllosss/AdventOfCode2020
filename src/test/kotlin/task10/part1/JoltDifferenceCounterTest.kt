package task10.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import task10.JoltTestUtils

internal class JoltDifferenceCounterTest {

    private val joltDifferenceCounter = JoltDifferenceCounter()

    @Test
    fun shouldReturnCountOfDifferencesGroupedByJolts1() {
        // GIVEN
        val jolts = JoltTestUtils.getJolts()

        // WHEN
        val countByJolts = joltDifferenceCounter.countDifferencesByJoltDifference(jolts)

        // THEN
        assertThat(countByJolts).containsKeys(1, 3)
        assertThat(countByJolts).containsValues(22, 10)
    }

    @Test
    fun shouldReturnCountOfDifferencesGroupedByJolts2() {
        // GIVEN
        val jolts = JoltTestUtils.getLessJolts()

        // WHEN
        val countByJolts = joltDifferenceCounter.countDifferencesByJoltDifference(jolts)

        // THEN
        assertThat(countByJolts).containsKeys(1, 3)
        assertThat(countByJolts).containsValues(7, 5)
    }
}