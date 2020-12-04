package task4.part2.validator.field

import task4.part2.validator.YearRangeValidator

class BirthYearValidator(
    private val minYear: Int,
    private val maxYear: Int,
    private val yearValidator: YearRangeValidator
) : FieldValidator {

    override val key: String
        get() = "byr"

    override fun isFieldValid(fields: Map<String, String>): Boolean {
        val birthYear = fields[key] ?: return false

        return yearValidator.isValidYearWithinRange(birthYear, minYear, maxYear)
    }
}