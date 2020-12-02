package task2

interface PasswordValidator {

    fun isValid(passwordEntry: PasswordEntry): Boolean
}