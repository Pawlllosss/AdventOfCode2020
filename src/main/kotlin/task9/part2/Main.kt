package task9.part2

import reader.NumbersReader
import task9.ContiguousNumbersFinder
import task9.FaultyXmasElementFinder

fun main() {
    val messagesPath = "src/main/kotlin/task9/resource/input"
    val numbersReader = NumbersReader()
    val faultyXmasElementFinder = FaultyXmasElementFinder()
    val contiguousNumbersFinder = ContiguousNumbersFinder()
    val messages = numbersReader.getNumbers(messagesPath)
    faultyXmasElementFinder.findFirst(messages)?.let {
        val contiguousNumbers = contiguousNumbersFinder.findElementsThatSumUp(messages, it)
        val smallest = contiguousNumbers.min()!!
        val largest = contiguousNumbers.max()!!

        println(smallest + largest)
    }
}