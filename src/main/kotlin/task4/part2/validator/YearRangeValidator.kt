package task4.part2.validator

class YearRangeValidator(private val numberValidator: NumberValidator) {

    private val numberOfDigits = 4

    fun isValidYearWithinRange(possibleYear: String, minYear: Int, maxYear: Int): Boolean {
        val isProperNumber = numberValidator.isNumberWithProperLength(possibleYear, numberOfDigits)

        return if (isProperNumber) isYearInRange(possibleYear, minYear, maxYear) else false
    }

    private fun isYearInRange(year: String, minYear: Int, maxYear: Int) = year.toInt() in minYear..maxYear
}