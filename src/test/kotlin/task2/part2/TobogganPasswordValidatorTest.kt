package task2.part2

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import task2.PasswordEntry
import task2.PasswordPolicy

internal class TobogganPasswordValidatorTest {

    private val passwordEntryValidator = TobogganPasswordValidator()

    @ParameterizedTest
    @CsvSource(
        "1, 2, z, ssdszz, false",
        "1, 3, z, sszd, true",
        "1, 3, a, aaa, false",
        "3, 5, a, aaaaaa, false",
        "1, 6, a, cbcaba, true"
    )
    fun shouldValidateBasedOnExcludingCharacters(pos1: Int, pos2: Int, character: Char, password: String, valid: Boolean) {
        // GIVEN
        val passwordEntry = PasswordEntry(PasswordPolicy(pos1, pos2, character), password)

        // WHEN
        val result = passwordEntryValidator.isValid(passwordEntry)

        // THEN
        Assertions.assertThat(result).isEqualTo(valid)
    }
}