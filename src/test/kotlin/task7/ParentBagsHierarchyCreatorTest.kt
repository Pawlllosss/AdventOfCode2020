package task7

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ParentBagsHierarchyCreatorTest {

    private val parentBagsHierarchyCreator = ParentBagsHierarchyCreator()

    @Test
    fun shouldCreateLuggageParentHierarchy() {
        // GIVEN
        val luggageRules = getLuggageRules()

        // WHEN
        val parentHierarchy = parentBagsHierarchyCreator.createParentHierarchy(luggageRules)

        // THEN
        assertThat(parentHierarchy.size).isEqualTo(7)
        assertThat(parentHierarchy["shiny gold"]?.size).isEqualTo(2)
    }

    @Test
    fun shouldCreateLuggageChildHierarchy() {
        // GIVEN
        val luggageRules = getLuggageRules()

        // WHEN
        val childHierarchy = parentBagsHierarchyCreator.createChildHierarchy(luggageRules)

        // THEN
        assertThat(childHierarchy.size).isEqualTo(7)
        val shinyGoldChildren = childHierarchy["shiny gold"]
        assertThat(shinyGoldChildren).isNotNull
        assertThat(shinyGoldChildren).containsExactlyInAnyOrder(
            "dark olive" to 1,
            "vibrant plum" to 2
        )
    }

    private fun getLuggageRules(): List<LuggageRule> {
        return listOf(
            LuggageRule(
                "light red", setOf(
                    "bright white" to 1,
                    "muted yellow" to 2
                )
            ),
            LuggageRule(
                "dark orange", setOf(
                    "bright white" to 3,
                    "muted yellow" to 4
                )
            ),
            LuggageRule(
                "bright white", setOf(
                    "shiny gold" to 1
                )
            ),
            LuggageRule(
                "muted yellow", setOf(
                    "shiny gold" to 2,
                    "faded blue" to 9
                )
            ),
            LuggageRule(
                "shiny gold", setOf(
                    "dark olive" to 1,
                    "vibrant plum" to 2
                )
            ),
            LuggageRule(
                "dark olive", setOf(
                    "faded blue" to 3,
                    "dotted black" to 4
                )
            ),
            LuggageRule(
                "vibrant plum olive", setOf(
                    "faded blue" to 5,
                    "dotted black" to 6
                )
            ),
            LuggageRule(
                "faded blue", setOf()
            ),
            LuggageRule(
                "dotted black", setOf()
            )
        )
    }
}