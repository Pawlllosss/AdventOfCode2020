package task11.seat.state

import task11.FloorPlan

class EmptySeat(private val seatCoordinates: Pair<Int, Int>): SeatState {

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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EmptySeat

        if (seatCoordinates != other.seatCoordinates) return false

        return true
    }

    override fun hashCode(): Int {
        return seatCoordinates.hashCode()
    }
}