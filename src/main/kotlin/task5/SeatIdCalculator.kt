package task5

class SeatIdCalculator {

    fun calculateSeatId(boardingPass: BoardingPass): Long {
        return ((boardingPass.row shl 3) + boardingPass.column).toLong()
    }
}