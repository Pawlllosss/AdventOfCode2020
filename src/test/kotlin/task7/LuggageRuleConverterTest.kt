package task7

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LuggageRuleConverterTest {

    private val luggageRuleConverter = LuggageRuleConverter()

    @Test
    fun shouldConvertSentenceToLuggageRule() {
        // GIVEN
        val sentence = "vibrant plum bags contain 1 dark olive bag, 6 dotted black bags."

        // WHEN
        val rule = luggageRuleConverter.convertToLuggageRule(sentence)

        // THEN
        val expectedParentColor = "vibrant plum"
        val expectedChildBags = setOf(
            "dark olive" to 1,
            "dotted black" to 6
        )
        assertThat(rule.parentColor).isEqualTo(expectedParentColor)
        assertThat(rule.childBags).isEqualTo(expectedChildBags)
    }

    @Test
    fun shouldConvertSentenceToLuggageRuleWithoutChildBags() {
        // GIVEN
        val sentence = "dotted black bags contain no other bags."

        // WHEN
        val rule = luggageRuleConverter.convertToLuggageRule(sentence)

        // THEN
        val expectedParentColor = "dotted black"
        val expectedChildBags = setOf<Pair<String, Int>>()
        assertThat(rule.parentColor).isEqualTo(expectedParentColor)
        assertThat(rule.childBags).isEqualTo(expectedChildBags)
    }
}