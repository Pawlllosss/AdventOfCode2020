package task2.part1

import task2.PasswordEntry
import task2.PasswordValidator

class PasswordOccurrenceValidator: PasswordValidator {

    override fun isValid(passwordEntry: PasswordEntry): Boolean {
        val (policy, password) = passwordEntry
        val (minUse, maxUse, checkedCharacter) = policy

        val checkedCount = password.count { c -> c == checkedCharacter }
        return checkedCount in minUse..maxUse
    }
}