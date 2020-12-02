package task2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import task2.part1.PasswordOccurrenceValidator

internal class PasswordEntryCounterTest {

    private val passwordEntryValidator = PasswordOccurrenceValidator()
    private val passwordEntryCounter = PasswordEntryCounter(passwordEntryValidator)

    @Test
    fun shouldCountCorrectPasswords() {
        // GIVEN
        val entry1 = PasswordEntry(PasswordPolicy(0, 2, 'z'), "ssdszz")
        val entry2 = PasswordEntry(PasswordPolicy(0, 2, 'z'), "ssds")
        val entry3 = PasswordEntry(PasswordPolicy(3, 5, 'a'), "aaa")
        val entry4 = PasswordEntry(PasswordPolicy(3, 5, 'a'), "aaaaaa")
        val entry5 = PasswordEntry(PasswordPolicy(1, 1, 'a'), "abcabc")
        val entries = listOf(entry1, entry2, entry3, entry4, entry5)

        // WHEN
        val result = passwordEntryCounter.countCorrectPasswords(entries)

        // THEN
        assertThat(result).isEqualTo(3)
    }
}