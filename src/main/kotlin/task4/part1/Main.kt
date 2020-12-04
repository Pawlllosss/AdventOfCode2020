package task4.part1

import task4.PassportFieldsRepository
import task4.PassportReader

fun main() {
    val fieldsRepository = PassportFieldsRepository()
    val validator = PassportValidator(fieldsRepository)
    val passportCounter = ValidPassportCounter(validator)
    val passportsPath = "src/main/kotlin/task4/resource/input"
    val passportReader = PassportReader()
    val passports = passportReader.getPassports(passportsPath)
    println(passportCounter.countCorrectPassports(passports))
}