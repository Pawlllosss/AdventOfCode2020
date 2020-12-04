package task4.part2.validator.field

class HairColorValidator : FieldValidator {

    private val regex = Regex("#[a-f|0-9]{6}")

    override val key: String
        get() = "hcl"

    override fun isFieldValid(fields: Map<String, String>): Boolean {
        val color = fields[key] ?: return false

        return color.matches(regex)
    }
}