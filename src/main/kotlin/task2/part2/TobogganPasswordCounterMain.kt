package task2.part2

import task2.PasswordEntryCounter
import task2.PasswordEntryReader

fun main() {
    val fileName = "src/main/kotlin/task2/resource/input"
    val passwordReader = PasswordEntryReader()
    val passwords = passwordReader.getEntries(fileName)
    val passwordCounter = PasswordEntryCounter(TobogganPasswordValidator())
    println(passwordCounter.countCorrectPasswords(passwords))
}
