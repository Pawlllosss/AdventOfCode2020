package task4.part2.validator.field

import task4.part2.validator.RangeValidator

class HeightValidator(private val rangeValidator: RangeValidator) : FieldValidator {

    override val key: String
        get() = "hgt"

    override fun isFieldValid(fields: Map<String, String>): Boolean {
        val height = fields[key] ?: return false
        val heightLength = height.length
        val unitStartPosition = heightLength - 2
        val unit = height.substring(unitStartPosition, heightLength)
        val possibleHeight = height.substring(0, unitStartPosition)
        return when {
            isFromUnitSystem(unit, HeightUnitSystem.CENTIMETER) -> {
                isValidHeightWithinUnitSystem(possibleHeight, HeightUnitSystem.CENTIMETER)
            }
            isFromUnitSystem(unit, HeightUnitSystem.INCH) -> {
                isValidHeightWithinUnitSystem(possibleHeight, HeightUnitSystem.INCH)
            }
            else -> {
                false
            }
        }
    }

    private fun isFromUnitSystem(unit: String, heightUnitSystem: HeightUnitSystem) = unit == heightUnitSystem.unitSystem

    private fun isValidHeightWithinUnitSystem(possibleHeight: String, heightUnitSystem: HeightUnitSystem): Boolean =
        rangeValidator.isNumberWithinRange(possibleHeight, heightUnitSystem.minimum, heightUnitSystem.maximum)
}