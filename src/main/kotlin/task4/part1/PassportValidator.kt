package task4.part1

import task4.Passport
import task4.PassportFieldsRepository

class PassportValidator(passportFieldsRepository: PassportFieldsRepository) {

    private val requiredFields: Set<String> = passportFieldsRepository.getRequiredFields()

    fun containsMandatoryFields(passport: Passport): Boolean {
        val passportFields = passport.fields
        val fieldNames: Set<String> = passportFields.keys

        return fieldNames.containsAll(requiredFields)
    }
}