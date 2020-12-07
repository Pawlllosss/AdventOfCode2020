package task7

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ParentBagsCounterTest {

    private val parentBagsCounter = ParentBagsCounter()

    @Test
    fun shouldCountParentBags() {
        // GIVEN
        val bagsHierarchy = mapOf(
            "shiny gold" to setOf(
                "bright white" to 1,
                "muted yelow" to 2),
            "bright white" to setOf(
                "dark orange" to 3,
                "light red" to 2
            ),
            "muted yelow" to setOf(
                "dark orange" to 3,
                "light red" to 1
            ),
            "dark olive" to setOf(
                "shiny gold" to 1
            ),
            "pink" to setOf(
                "navy blue" to 13
            )

        )
        val bagColor = "shiny gold"

        // WHEN
        val count = parentBagsCounter.countParentBags(bagColor, bagsHierarchy)

        // THEN
        assertThat(count).isEqualTo(4)
    }
}