package task4.part2.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class YearRangeValidatorTest {

    private val yearValidator = YearRangeValidator(NumberValidator())

    @ParameterizedTest
    @CsvSource(
        "1995, 1900, 1995, true",
        "x11, 10, 2020, false",
        "2001, 1900, 2000, false",
        "1899, 1900, 2000, false"
    )
    fun shouldValidateIfStringIsYearWithinRange(input: String, minYear: Int, maxYear: Int, result: Boolean) {
        // WHEN
        val valid = yearValidator.isValidYearWithinRange(input, minYear, maxYear)

        // THEN
        assertThat(valid).isEqualTo(result)
    }
}