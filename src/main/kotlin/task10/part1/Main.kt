package task10.part1

import reader.NumbersReader
import task10.JoltDifferenceCounter

fun main() {
    val joltsPath = "src/main/kotlin/task10/resource/input"
    val numbersReader = NumbersReader()
    val jolts = numbersReader.getNumbers(joltsPath)
    val differenceCounter = JoltDifferenceCounter()
    val countByJoltDifference = differenceCounter.countDifferencesByJoltDifference(jolts)
    val result = countByJoltDifference.let {
        val differencesByOne: Long = it.getOrDefault(1, 0)
        val differencesByThree: Long = it.getOrDefault(3, 0)
        differencesByOne * differencesByThree
    }
    println(result)
}