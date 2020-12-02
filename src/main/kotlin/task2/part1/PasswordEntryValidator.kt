package task2.part1

import task2.PasswordEntry

class PasswordEntryValidator {

    fun isValid(passwordEntry: PasswordEntry): Boolean {
        val (policy, password) = passwordEntry
        val (minUse, maxUse, checkedCharacter) = policy

        val checkedCount = password.count { c -> c == checkedCharacter }
        return checkedCount in minUse..maxUse
    }
}