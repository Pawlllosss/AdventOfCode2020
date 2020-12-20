package task11.seat.state

import task11.FloorPlan

data class EmptySeat(private val seatCoordinates: Pair<Int, Int>): SeatState {

    companion object {
        const val symbol = 'L'
    }

    override val symbol: Char
        get() = EmptySeat.symbol

    override fun nextState(floorPlan: FloorPlan): SeatState {
        val adjacentSeats = floorPlan.getAdjacentSeats(seatCoordinates)
        val anyAdjacentSeatOccupied = adjacentSeats.any(this::isOccupied)

        return if (anyAdjacentSeatOccupied) this else OccupiedSeat(seatCoordinates)
    }

    private fun isOccupied(it: SeatState) = it.symbol == OccupiedSeat.symbol
}