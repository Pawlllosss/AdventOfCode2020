package task4.part1

import task4.Passport

class ValidPassportCounter(private val passportValidator: PassportValidator) {

    fun countCorrectPassports(passports: List<Passport>): Int {
        return passports.filter { passport -> passportValidator.containsMandatoryFields(passport) }
            .count()
    }
}