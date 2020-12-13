package task10.part2

import reader.NumbersReader
import task10.JoltInputConverter

fun main() {
    val joltsPath = "src/main/kotlin/task10/resource/input"
    val numbersReader = NumbersReader()
    val jolts = numbersReader.getNumbers(joltsPath)
    val joltInputConverter = JoltInputConverter()
    val configurationsCounter = AdapterConfigurationsCounter()
    val sortedJoltsWithOutletAndDevice = joltInputConverter.getSortedJoltsWithOutletAndDevice(jolts)
    val possibleConfigurations = configurationsCounter.countConfigurations(sortedJoltsWithOutletAndDevice)
    println(possibleConfigurations)
}