package task2.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import task2.PasswordEntry
import task2.PasswordPolicy

internal class PasswordOccurrenceValidatorTest {

    private val passwordEntryValidator = PasswordOccurrenceValidator()

    @ParameterizedTest
    @CsvSource(
        "0, 2, z, ssdszz, true",
        "0, 2, z, ssds, true",
        "3, 5, a, aaa, true",
        "3, 5, a, aaaaaa, false",
        "1, 1, a, abcabc, false"
    )
    fun shouldValidateBasedOnOccurrencePolicy(min: Int, max: Int, character: Char, password: String, valid: Boolean) {
        // GIVEN
        val passwordEntry = PasswordEntry(PasswordPolicy(min, max, character), password)

        // WHEN
        val result = passwordEntryValidator.isValid(passwordEntry)

        // THEN
        assertThat(result).isEqualTo(valid)
    }
}