package task4.part2.validator.field

import task4.part2.validator.YearRangeValidator

class IssueYearValidator(
    private val minYear: Int,
    private val maxYear: Int,
    private val yearValidator: YearRangeValidator
) : FieldValidator {

    override val key: String
        get() = "iyr"

    override fun isFieldValid(fields: Map<String, String>): Boolean {
        val issueYear = fields[key] ?: return false

        return yearValidator.isValidYearWithinRange(issueYear, minYear, maxYear)
    }
}