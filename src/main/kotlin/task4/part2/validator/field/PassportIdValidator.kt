package task4.part2.validator.field

import task4.part2.validator.NumberValidator

class PassportIdValidator(private val numberValidator: NumberValidator): FieldValidator {

    private val requiredLength = 9

    override val key: String
        get() = "pid"

    override fun isFieldValid(fields: Map<String, String>): Boolean {
        val passportId = fields[key] ?: return false
        return numberValidator.isNumberWithProperLength(passportId, requiredLength)
    }
}