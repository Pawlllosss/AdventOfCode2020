package task4.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import task4.Passport
import task4.PassportFieldsRepository

internal class PassportValidatorTest {

    private val passportFieldsRepository = PassportFieldsRepository()
    private val passportValidator = PassportValidator(passportFieldsRepository)

    @Test
    fun shouldReturnTrueWhenPassportContainsAllMandatoryFields() {
        // GIVEN
        val passportFields = mapOf(
            Pair("byr", "1990"),
            Pair("iyr", "2011"),
            Pair("eyr", "2025"),
            Pair("hgt", "177"),
            Pair("hcl", "red"),
            Pair("ecl", "blue"),
            Pair("pid", "1000500100900"),
            Pair("cid", "PL")
        )
        val passport = Passport(passportFields)

        // WHEN
        val result = passportValidator.containsMandatoryFields(passport)

        // THEN
        assertThat(result).isTrue()
    }

    @Test
    fun shouldReturnFalseWhenPassportDoesNotContainAllMandatoryFields() {
        // GIVEN
        val passportFields = mapOf(
            Pair("byr", "1990"),
            Pair("iyr", "2011"),
            Pair("eyr", "2025"),
            Pair("pid", "1000500100900"),
            Pair("pwd", "test"),
            Pair("cid", "PL")
        )
        val passport = Passport(passportFields)

        // WHEN
        val result = passportValidator.containsMandatoryFields(passport)

        // THEN
        assertThat(result).isFalse()
    }
}