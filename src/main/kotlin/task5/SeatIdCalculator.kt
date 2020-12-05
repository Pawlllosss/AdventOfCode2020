package task5

class SeatIdCalculator {

    fun calculateSeatId(airplaneSeat: AirplaneSeat): Long {
        return ((airplaneSeat.row shl 3) + airplaneSeat.column).toLong()
    }
}