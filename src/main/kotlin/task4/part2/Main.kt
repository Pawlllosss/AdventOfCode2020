package task4.part2

import task4.PassportFieldsRepository
import task4.PassportReader
import task4.PassportRequiredFieldValidator
import task4.part2.validator.NumberValidator
import task4.part2.validator.RangeValidator
import task4.part2.validator.YearRangeValidator
import task4.part2.validator.field.*

fun main() {
    val fieldsRepository = PassportFieldsRepository()
    val validator = PassportRequiredFieldValidator(fieldsRepository)
    val fieldValidators = getFieldValidators()
    val passportCounter = ValidPassportCounter(validator, fieldValidators)
    val passportsPath = "src/main/kotlin/task4/resource/input"
    val passportReader = PassportReader()
    val passports = passportReader.getPassports(passportsPath)
    println(passportCounter.countCorrectPassports(passports))

}

fun getFieldValidators(): Set<FieldValidator> {
    val numberValidator = NumberValidator()
    val yearValidator = YearRangeValidator(numberValidator)
    return setOf(
        BirthYearValidator(1920, 2002, yearValidator),
        IssueYearValidator(2010, 2020, yearValidator),
        ExpirationYearValidator(2020, 2030, yearValidator),
        HeightValidator(RangeValidator()),
        HairColorValidator(),
        EyeColorValidator(),
        PassportIdValidator(numberValidator)
    )
}
