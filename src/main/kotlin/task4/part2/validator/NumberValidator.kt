package task4.part2.validator

class NumberValidator {

    fun isNumberWithProperLength(possibleNumber: String, requiredLength: Int): Boolean {
        val convertedNumber = possibleNumber.toIntOrNull()
        return when(convertedNumber) {
            null -> false
            else -> possibleNumber.length == requiredLength
        }
    }
}