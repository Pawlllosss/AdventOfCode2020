package task11.converter

import task11.seat.state.EmptySeat
import task11.seat.state.Floor
import task11.seat.state.OccupiedSeat
import task11.seat.state.SeatState

class SeatAdjacentConverter: SeatConverter {

    override fun convertToSeat(row: Int, column: Int, symbol: Char): SeatState {
        val coordinates = row to column

        return when (symbol) {
            OccupiedSeat.symbol -> {
                OccupiedSeat(coordinates)
            }
            EmptySeat.symbol -> {
                EmptySeat(coordinates)
            }
            Floor.symbol -> {
                Floor()
            }
            else -> throw IllegalArgumentException("Unrecognised seat state")
        }
    }
}