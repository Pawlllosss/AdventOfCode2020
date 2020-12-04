package task4.part2.validator.field

interface FieldValidator {

    val key: String

    fun isFieldValid(fields: Map<String, String>): Boolean
}