package task4.part2.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class NumberValidatorTest {

    private val numberValidator = NumberValidator()

    @ParameterizedTest
    @CsvSource(
        "1995, 4, true",
        "x11, 2, false",
        "11, 2, true",
        "aaa, 3, false"
    )
    fun shouldValidateIfStringIsNumberWithProperLength(input: String, requiredLength: Int, result: Boolean) {
        // WHEN
        val valid = numberValidator.isNumberWithProperLength(input, requiredLength)

        // THEN
        assertThat(valid).isEqualTo(result)
    }
}