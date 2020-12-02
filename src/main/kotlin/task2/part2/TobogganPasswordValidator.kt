package task2.part2

import task2.PasswordEntry
import task2.PasswordValidator

class TobogganPasswordValidator : PasswordValidator {

    override fun isValid(passwordEntry: PasswordEntry): Boolean {
        val (policy, password) = passwordEntry
        val (pos1, pos2, checkedCharacter) = policy
        val position1 = pos1 - 1
        val position2 = pos2 - 1

        return (password[position1] == checkedCharacter) xor (password[position2] == checkedCharacter)
    }
}