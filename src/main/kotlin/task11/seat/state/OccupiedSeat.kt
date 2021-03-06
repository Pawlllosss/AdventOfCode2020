package task11.seat.state

import task11.FloorPlan

data class OccupiedSeat(private val seatCoordinates: Pair<Int, Int>): SeatState {

    companion object{
        const val symbol = '#'
    }

    override val symbol: Char
        get() = OccupiedSeat.symbol

    override fun nextState(floorPlan: FloorPlan): SeatState {
        var occupiedSeats = 0
        val adjacentSeats = floorPlan.getAdjacentSeats(seatCoordinates)
        adjacentSeats
            .forEach {
                if (isOccupied(it)) {
                    occupiedSeats++
                }
            }

        return if (occupiedSeats >= 4) EmptySeat(seatCoordinates) else this
    }

    private fun isOccupied(it: SeatState) = it.symbol == OccupiedSeat.symbol
}