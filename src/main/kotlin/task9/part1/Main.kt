package task9.part1

import reader.NumbersReader
import task9.FaultyXmasElementFinder

fun main() {
    val messagesPath = "src/main/kotlin/task9/resource/input"
    val numbersReader = NumbersReader()
    val faultyXmasElementFinder = FaultyXmasElementFinder()
    val messages = numbersReader.getNumbers(messagesPath)
    println(faultyXmasElementFinder.findFirst(messages))
}