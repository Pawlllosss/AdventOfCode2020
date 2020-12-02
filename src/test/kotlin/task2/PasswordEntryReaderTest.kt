package task2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PasswordEntryReaderTest {

    private val fileName = "src/test/kotlin/task2/resource/examplePasswordEntries.txt"
    private val passwordEntryReader = PasswordEntryReader()

    @Test
    fun shouldReturnListOfPasswordEntries() {
        // WHEN
        val entries = passwordEntryReader.getEntries(fileName)

        // THEN
        assertThat(entries)
            .containsExactly(
                PasswordEntry(PasswordPolicy(1, 5, 'k'), "kkkkhkkkkkkkkkk"),
                PasswordEntry(PasswordPolicy(5, 7, 'k'), "blkqhtxfgktdkxzkksk"),
                PasswordEntry(PasswordPolicy(15, 16, 'x'), "xxxxxxxxxxxxxxlf"))
    }
}