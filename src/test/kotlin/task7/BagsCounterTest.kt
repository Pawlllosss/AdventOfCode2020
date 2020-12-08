package task7

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BagsCounterTest {

    private val parentBagsCounter = BagsCounter()

    @Test
    fun shouldCountParentBags() {
        // GIVEN
        val bagsParentHierarchy = mapOf(
            "shiny gold" to setOf(
                "bright white" to 1,
                "muted yelow" to 2
            ),
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
        val count = parentBagsCounter.countParentBags(bagColor, bagsParentHierarchy)

        // THEN
        assertThat(count).isEqualTo(4)
    }

    @Test
    fun shouldCountChildrenBagsRequiredInBag1() {
        // GIVEN
        val bagsParentHierarchy = mapOf(
            "shiny gold" to setOf(
                "dark olive" to 1,
                "vibrant plum" to 2
            ),
            "bright white" to setOf(
                "shiny gold" to 1
            ),
            "vibrant plum" to setOf(
                "faded blue" to 5,
                "dotted black" to 6
            ),
            "dark olive" to setOf(
                "faded blue" to 3,
                "dotted black" to 4
            ),
            "pink" to setOf(
                "navy blue" to 13
            )
        )
        val bagColor = "shiny gold"

        // WHEN
        val count = parentBagsCounter.countChildBagsRequiredInBag(bagColor, bagsParentHierarchy)

        // THEN
        assertThat(count).isEqualTo(32)
    }

    @Test
    fun shouldCountChildrenBagsRequiredInBag2() {
        // GIVEN
        val bagsParentHierarchy = mapOf(
            "shiny gold" to setOf(
                "dark red" to 2
            ),
            "dark red" to setOf(
                "dark orange" to 2
            ),
            "dark orange" to setOf(
                "dark yellow" to 2
            ),
            "dark yellow" to setOf(
                "dark green" to 2
            ),
            "dark green" to setOf(
                "dark blue" to 2
            ),
            "dark blue" to setOf(
                "dark violet" to 2
            )
        )
        val bagColor = "shiny gold"

        // WHEN
        val count = parentBagsCounter.countChildBagsRequiredInBag(bagColor, bagsParentHierarchy)

        // THEN
        assertThat(count).isEqualTo(126)
    }
}