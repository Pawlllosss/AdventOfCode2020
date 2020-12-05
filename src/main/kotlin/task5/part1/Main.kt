package task5.part1

import task5.BoardingPassConverter
import task5.BoardingPassReader
import task5.SeatIdCalculator

fun main() {
    val passesPath = "src/main/kotlin/task5/resource/input"
    val boardingPassConverter = BoardingPassConverter()
    val boardingPassReader = BoardingPassReader(boardingPassConverter)
    val boardingPasses = boardingPassReader.getBoardingPasses(passesPath, 128, 8)
    val seatIdCalculator = SeatIdCalculator()
    val biggestSeatId = boardingPasses.map(seatIdCalculator::calculateSeatId)
        .max()
    println(biggestSeatId)
}