package task4.part2.validator.field

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class EyeColorValidatorTest {

    @ParameterizedTest
    @CsvSource(
        "amb, true",
        "blu, true",
        "brn, true",
        "gry, true",
        "grn, true",
        "hzl, true",
        "oth, true",
        "cpc, false",
        "eee, false"
    )
    fun shouldValidateIfStringIsYearWithinRange(color: String, result: Boolean) {
        // GIVEN
        val validator = EyeColorValidator()
        val fields = mapOf(
            Pair("ecl", color),
            Pair("redHerring", "test")
        )

        // WHEN
        val valid = validator.isFieldValid(fields)

        // THEN
        assertThat(valid).isEqualTo(result)
    }

    @Test
    fun shouldReturnFalseWhenEyeColorFieldDoesNotExist() {
        // GIVEN
        val validator = EyeColorValidator()
        val fields = mapOf(Pair("col", "test"))

        // WHEN
        val result = validator.isFieldValid(fields)

        // THEN
        assertThat(result).isFalse()
    }
}