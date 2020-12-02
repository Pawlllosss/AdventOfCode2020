package task2

import java.io.BufferedReader
import java.io.File

class PasswordEntryReader {

    fun getEntries(passwordsFileName: String): List<PasswordEntry> {
        val bufferedReader = getBufferedReader(passwordsFileName)
        return readEntriesFromFile(bufferedReader)
    }

    private fun getBufferedReader(name: String) = File(name).inputStream().bufferedReader()

    private fun readEntriesFromFile(bufferedReader: BufferedReader): ArrayList<PasswordEntry> {
        val entries = ArrayList<PasswordEntry>()
        bufferedReader.useLines { lines ->
            lines.forEach {
                val entry = convertToPasswordEntry(it)
                entries.add(entry)
            }
        }
        return entries
    }

    private fun convertToPasswordEntry(entry: String): PasswordEntry {
        val passwordEntryParts = entry.split(" ").toTypedArray()
        val occurrencesPart = passwordEntryParts[0]
        val (min, max) = getMinimumAndMaxOccurrences(occurrencesPart)
        val checkedCharacterPart = passwordEntryParts[1]
        val checkedCharacter = getCheckedCharacter(checkedCharacterPart)
        val password = passwordEntryParts[2]
        val passwordPolicy = PasswordPolicy(min, max, checkedCharacter)

        return PasswordEntry(passwordPolicy, password)
    }

    private fun getMinimumAndMaxOccurrences(mixMaxOccurrences: String): Pair<Int, Int> {
        val (min, max) = mixMaxOccurrences.split("-")
        return Pair(min.toInt(), max.toInt())
    }

    private fun getCheckedCharacter(character: String): Char = character[0]
}