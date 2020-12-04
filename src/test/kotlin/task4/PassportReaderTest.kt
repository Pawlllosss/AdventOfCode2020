package task4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PassportReaderTest {

    private val passportReader = PassportReader()

    @Test
    fun shouldReturnAllPassportsWithinFile() {
        // GIVEN
        val passportsPath = "src/test/kotlin/task4/resource/passports.txt"
        val expectedPassports = getExpectedPassports()

        // WHEN
        val passports: List<Passport> = passportReader.getPassports(passportsPath)

        // THEN
        assertThat(passports).isEqualTo(expectedPassports)
    }

    private fun getExpectedPassports(): List<Passport> {
        val passportFields1 = mapOf(
            Pair("eyr", "2028"),
            Pair("iyr", "2016"),
            Pair("byr", "1995"),
            Pair("ecl", "oth"),
            Pair("pid", "543685203"),
            Pair("hcl", "#c0946f"),
            Pair("cid", "252")
        )
        val passportFields2 = mapOf(
            Pair("hcl", "#733820"),
            Pair("hgt", "155cm"),
            Pair("iyr", "2013"),
            Pair("byr", "1989"),
            Pair("pid", "728471979"),
            Pair("ecl", "grn"),
            Pair("eyr", "2022")
        )
        val passportFields3 = mapOf(
            Pair("hgt", "171cm"),
            Pair("iyr", "2013"),
            Pair("pid", "214368857"),
            Pair("hcl", "#cfa07d"),
            Pair("ecl", "grn"),
            Pair("eyr", "2028"),
            Pair("byr", "1986")
        )
        val expectedPassports = listOf(
            Passport(passportFields1),
            Passport(passportFields2),
            Passport(passportFields3)
        )
        return expectedPassports
    }
}