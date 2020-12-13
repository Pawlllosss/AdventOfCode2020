package task10.part2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import task10.JoltTestUtils

internal class AdapterPossibleConfigurationCounterTest {

    private val configurationCounter = AdapterPossibleConfigurationCounter()

    @Test
    fun shouldReturnNumberOfPossibleConfigurations1() {
        // GIVEN
        val jolts = JoltTestUtils.getJoltsSet()

        // WHEN
        val possibleConfigurations = configurationCounter.countPossibleConfigurations(jolts)

        // THEN
        assertThat(possibleConfigurations).isEqualTo(19208)
    }

    @Test
    fun shouldReturnNumberOfPossibleConfigurations2() {
        // GIVEN
        val jolts = JoltTestUtils.getLessJoltsSet()

        // WHEN
        val possibleConfigurations = configurationCounter.countPossibleConfigurations(jolts)

        // THEN
        assertThat(possibleConfigurations).isEqualTo(8)
    }
}