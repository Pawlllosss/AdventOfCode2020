package task7

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LuggageRuleReaderTest {

    private val luggageRuleConverter = LuggageRuleConverter()
    private val luggageRuleReader = LuggageRuleReader(luggageRuleConverter)

    @Test
    fun shouldReturnAllLuggageRulesWithinFile() {
        // GIVEN
        val luggageRulesPath = "src/test/kotlin/task7/resource/luggageRules.txt"

        // WHEN
        val luggageRules: List<LuggageRule> = luggageRuleReader.getLuggageRules(luggageRulesPath)

        // THEN
        assertThat(luggageRules).containsExactly(
            LuggageRule(
                "light red", setOf(
                    Pair("bright white", 1),
                    Pair("muted yellow", 2)
                )
            ),
            LuggageRule(
                "dark orange", setOf(
                    Pair("bright white", 3),
                    Pair("muted yellow", 4)
                )
            ),
            LuggageRule(
                "bright white", setOf(
                    Pair("shiny gold", 1)
                )
            )
        )
    }
}