package task4.part1

import task4.Passport
import task4.PassportRequiredFieldValidator

class ValidPassportCounter(private val passportRequiredFieldValidator: PassportRequiredFieldValidator) {

    fun countCorrectPassports(passports: List<Passport>): Int {
        return passports.filter { passport -> passportRequiredFieldValidator.isValid(passport) }
            .count()
    }
}