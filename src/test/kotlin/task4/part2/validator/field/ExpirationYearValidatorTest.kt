package task4.part2.validator.field

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import task4.part2.validator.NumberValidator
import task4.part2.validator.YearRangeValidator

internal class ExpirationYearValidatorTest {

    @Test
    fun shouldReturnFalseWhenExpirationYearFieldDoesNotExist() {
        // GIVEN
        val numberValidator = NumberValidator()
        val validator = ExpirationYearValidator(1900, 2000, YearRangeValidator(numberValidator))
        val fields = mapOf(Pair("iii", "test"))

        // WHEN
        val result = validator.isFieldValid(fields)

        // THEN
        Assertions.assertThat(result).isFalse()
    }

}