package task4.part2.validator.field

import task4.part2.validator.YearRangeValidator

class ExpirationYearValidator(
    private val minYear: Int,
    private val maxYear: Int,
    private val yearValidator: YearRangeValidator
) : FieldValidator {

    override val key: String
        get() = "eyr"

    override fun isFieldValid(fields: Map<String, String>): Boolean {
        val expirationYear = fields[key] ?: return false

        return yearValidator.isValidYearWithinRange(expirationYear, minYear, maxYear)
    }
}