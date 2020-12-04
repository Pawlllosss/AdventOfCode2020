package task4.part2.validator

class RangeValidator {

    fun isNumberWithinRange(possibleNumber: String, min: Int, max: Int): Boolean {
        return when(val convertedNumber = possibleNumber.toIntOrNull()) {
            null -> false
            else -> convertedNumber in min..max
        }
    }
}
