package task4.part2.validator.field

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import task4.part2.validator.NumberValidator
import task4.part2.validator.YearRangeValidator

internal class BirthYearValidatorTest {

    @Test
    fun shouldReturnFalseWhenBirthYearFieldDoesNotExist() {
        // GIVEN
        val numberValidator = NumberValidator()
        val validator = BirthYearValidator(1900, 2000, YearRangeValidator(numberValidator))
        val fields = mapOf(Pair("bry", "test"))

        // WHEN
        val result = validator.isFieldValid(fields)

        // THEN
        assertThat(result).isFalse()
    }
}