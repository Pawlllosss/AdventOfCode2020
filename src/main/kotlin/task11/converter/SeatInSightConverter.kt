package task11.converter

import task11.seat.state.EmptySeat
import task11.seat.state.EmptySeatInSightAware
import task11.seat.state.Floor
import task11.seat.state.OccupiedSeat
import task11.seat.state.OccupiedSeatInSightAware
import task11.seat.state.SeatState

class SeatInSightConverter: SeatConverter {

    override fun convertToSeat(row: Int, column: Int, symbol: Char): SeatState {
        val coordinates = row to column

        return when (symbol) {
            OccupiedSeat.symbol -> {
                OccupiedSeatInSightAware(coordinates)
            }
            EmptySeat.symbol -> {
                EmptySeatInSightAware(coordinates)
            }
            Floor.symbol -> {
                Floor()
            }
            else -> throw IllegalArgumentException("Unrecognised seat state")
        }
    }
}