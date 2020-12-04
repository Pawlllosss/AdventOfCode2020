package task4

import task4.Passport
import task4.PassportFieldsRepository

class PassportRequiredFieldValidator(passportFieldsRepository: PassportFieldsRepository) {

    private val requiredFields: Set<String> = passportFieldsRepository.getRequiredFields()

    fun isValid(passport: Passport): Boolean {
        val passportFields = passport.fields
        val fieldNames: Set<String> = passportFields.keys

        return fieldNames.containsAll(requiredFields)
    }
}