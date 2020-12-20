package task11.converter

import task11.seat.state.SeatState

interface SeatConverter {

    fun convertToSeat(row: Int, column: Int, symbol: Char): SeatState
}