package task5.part1

import task5.AirplaneSeatConverter
import task5.AirplaneSeatReader
import task5.SeatIdCalculator

fun main() {
    val seatsPath = "src/main/kotlin/task5/resource/input"
    val airplaneSeatConverter = AirplaneSeatConverter()
    val airplaneSeatReader = AirplaneSeatReader(airplaneSeatConverter)
    val airplaneSeats = airplaneSeatReader.getBoardingPasses(seatsPath, 128, 8)
    val seatIdCalculator = SeatIdCalculator()
    val biggestSeatId = airplaneSeats.map(seatIdCalculator::calculateSeatId)
        .max()
    println(biggestSeatId)
}