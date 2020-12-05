package task5.part2

import task5.AirplaneSeat
import task5.AirplaneSeatConverter
import task5.AirplaneSeatReader
import task5.SeatIdCalculator

fun main() {
    val seatsPath = "src/main/kotlin/task5/resource/input"
    val airplaneSeatConverter = AirplaneSeatConverter()
    val airplaneSeatReader = AirplaneSeatReader(airplaneSeatConverter)
    val rows = 128
    val columns = 8
    val airplaneSeats = airplaneSeatReader.getBoardingPasses(seatsPath, rows, columns)
    val emptySeatsFinder = EmptySeatsFinder()
    val emptySeatsFilter = EmptySeatsFilter()
    val seatIdCalculator = SeatIdCalculator()
    val emptySeats = emptySeatsFinder.findEmptySeats(HashSet<AirplaneSeat>(airplaneSeats), rows, columns)
    val existingEmptySeats = emptySeatsFilter.filterNotExistingAtTheFrontAndBack(emptySeats)
    existingEmptySeats.map(seatIdCalculator::calculateSeatId)
        .forEach(::println)
}