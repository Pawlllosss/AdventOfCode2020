package task4

class PassportFieldsRepository {

    private val requiredFields = setOf(
        "byr",
        "iyr",
        "eyr",
        "hgt",
        "hcl",
        "ecl",
        "pid"
    )

    private val optionalFields = setOf("cid")

    fun getRequiredFields() = requiredFields

    fun getOptionalFields() = optionalFields
}