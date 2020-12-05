package task4.part2.validator.field

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class HairColorValidatorTest {

    @ParameterizedTest
    @CsvSource(
        "'#aaaaaa', true",
        "'#434434', true",
        "4343433, false",
        "434341, false",
        "1, false"
    )
    fun shouldValidateIfEyeColorIsCorrect(color: String, result: Boolean) {
        // GIVEN
        val validator = HairColorValidator()
        val fields = mapOf(
            Pair("hcl", color),
            Pair("redHerring", "test")
        )

        // WHEN
        val valid = validator.isFieldValid(fields)

        // THEN
        Assertions.assertThat(valid).isEqualTo(result)
    }

    @Test
    fun shouldReturnFalseWhenEyeColorFieldDoesNotExist() {
        // GIVEN
        val validator = HairColorValidator()
        val fields = mapOf(Pair("not", "test"))

        // WHEN
        val result = validator.isFieldValid(fields)

        // THEN
        Assertions.assertThat(result).isFalse()
    }
}