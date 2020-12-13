package task10.part2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import task10.JoltTestUtils

internal class AdapterConfigurationsCounterTest {

    private val configurationCounter = AdapterConfigurationsCounter()

    @Test
    fun shouldReturnNumberOfPossibleConfigurations1() {
        // GIVEN
        val jolts = JoltTestUtils.getJolts()

        // WHEN
        val possibleConfigurations = configurationCounter.countConfigurations(jolts)

        // THEN
        assertThat(possibleConfigurations).isEqualTo(19208)
    }

    @Test
    fun shouldReturnNumberOfPossibleConfigurations2() {
        // GIVEN
        val jolts = JoltTestUtils.getLessJolts()

        // WHEN
        val possibleConfigurations = configurationCounter.countConfigurations(jolts)

        // THEN
        assertThat(possibleConfigurations).isEqualTo(8)
    }
}