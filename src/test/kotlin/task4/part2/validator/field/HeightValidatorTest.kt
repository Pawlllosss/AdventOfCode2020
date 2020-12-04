package task4.part2.validator.field

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import task4.part2.validator.RangeValidator

internal class HeightValidatorTest {

    @ParameterizedTest
    @CsvSource(
        "150cm, true",
        "193cm, true",
        "149cm, false",
        "194cm, false",
        "z4cm, false",
        "59in, true",
        "76in, true",
        "58in, false",
        "77in, false",
        "z7in, false",
        "eee, false",
        "15, false",
        "1500, false"
    )
    fun shouldValidateIfHeightIsCorrect(height: String, result: Boolean) {
        // GIVEN
        val validator = HeightValidator(RangeValidator())
        val fields = mapOf(
            Pair("hgt", height),
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
        val validator = HeightValidator(RangeValidator())
        val fields = mapOf(Pair("htt", "test"))

        // WHEN
        val result = validator.isFieldValid(fields)

        // THEN
        assertThat(result).isFalse()
    }
}