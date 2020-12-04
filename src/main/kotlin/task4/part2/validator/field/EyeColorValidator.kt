package task4.part2.validator.field

class EyeColorValidator : FieldValidator {

    private val allowedColors = setOf(
        "amb",
        "blu",
        "brn",
        "gry",
        "grn",
        "hzl",
        "oth"
    )

    override val key: String
        get() = "ecl"

    override fun isFieldValid(fields: Map<String, String>): Boolean {
        val color = fields[key] ?: return false

        return allowedColors.contains(color)
    }
}