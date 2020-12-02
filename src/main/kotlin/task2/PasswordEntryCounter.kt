package task2

class PasswordEntryCounter(private val passwordValidator: PasswordValidator) {

    fun countCorrectPasswords(passwordEntries: List<PasswordEntry>): Int {
        return passwordEntries.filter { entry -> passwordValidator.isValid(entry) }
            .count()
    }
}