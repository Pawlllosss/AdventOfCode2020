package task4.part2.validator.field

enum class HeightUnitSystem(val unitSystem: String, val minimum: Int, val maximum: Int) {
    CENTIMETER("cm", 150, 193),
    INCH("in", 59, 76)
}