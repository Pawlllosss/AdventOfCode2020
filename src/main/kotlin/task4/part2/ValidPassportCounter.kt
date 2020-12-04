package task4.part2

import task4.Passport
import task4.PassportRequiredFieldValidator
import task4.part2.validator.field.FieldValidator

class ValidPassportCounter(
    private val passportRequiredFieldValidator: PassportRequiredFieldValidator,
    private val fieldValidators: Set<FieldValidator>
) {

    fun countCorrectPassports(passports: List<Passport>): Int {
        return passports.filter { passport -> passportRequiredFieldValidator.isValid(passport) }
            .filter { passport ->
                fieldValidators.all { validator -> validator.isFieldValid(passport.fields) }
            }
            .count()
    }
}