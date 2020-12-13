package task10.part1

import reader.NumbersReader
import task10.JoltInputConverter

fun main() {
    val joltsPath = "src/main/kotlin/task10/resource/input"
    val numbersReader = NumbersReader()
    val jolts = numbersReader.getNumbers(joltsPath)
    val joltInputMaintainer = JoltInputConverter()
    val differenceCounter = JoltDifferenceCounter()
    val sortedJoltsWithOutletAndDevice = joltInputMaintainer.getSortedJoltsWithOutletAndDevice(jolts)
    val countByJoltDifference = differenceCounter.countDifferencesByJoltDifference(sortedJoltsWithOutletAndDevice)
    val result = countByJoltDifference.let {
        val differencesByOne: Long = it.getOrDefault(1, 0)
        val differencesByThree: Long = it.getOrDefault(3, 0)
        differencesByOne * differencesByThree
    }
    println(result)
}