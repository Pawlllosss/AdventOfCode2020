package task11.seat.state

import task11.FloorPlan

class EmptySeat(private val seatCoordinates: Pair<Int, Int>): SeatState {

    companion object {
        val symbol = 'L'
    }

    override val symbol: Char
        get() = EmptySeat.symbol

    override fun nextState(floorPlan: FloorPlan): SeatState {
        val adjacentSeatsCoordinates = floorPlan.getAdjacentSeatsCoordinates(seatCoordinates)
        val anyAdjacentSeatOccupied = adjacentSeatsCoordinates.map(floorPlan::getSeat)
            .any(this::isOccupied)

        return if (anyAdjacentSeatOccupied) this else OccupiedSeat(seatCoordinates)
    }

    private fun isOccupied(it: SeatState) = it.symbol == OccupiedSeat.symbol
}