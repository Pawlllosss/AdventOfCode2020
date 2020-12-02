package task2.part1

import task2.PasswordEntry

class PasswordEntryCounter(private val passwordEntryValidator: PasswordEntryValidator) {

    fun countCorrectPasswords(passwordEntries: List<PasswordEntry>): Int {
        return passwordEntries.filter { entry -> passwordEntryValidator.isValid(entry) }
            .count()
    }
}