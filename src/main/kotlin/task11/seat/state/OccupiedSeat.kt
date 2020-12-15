package task11.seat.state

import task11.FloorPlan

class OccupiedSeat(private val seatCoordinates: Pair<Int, Int>): SeatState {

    companion object{
        val symbol = '#'
    }

    override val symbol: Char
        get() = OccupiedSeat.symbol

    override fun nextState(floorPlan: FloorPlan): SeatState {
        var occupiedSeats = 0
        val adjacentSeatsCoordinates = floorPlan.getAdjacentSeatsCoordinates(seatCoordinates)
        adjacentSeatsCoordinates.map(floorPlan::getSeat)
            .forEach {
                if (isOccupied(it)) {
                    occupiedSeats++
                }
            }

        return if (occupiedSeats >= 4) EmptySeat(seatCoordinates) else this
    }

    private fun isOccupied(it: SeatState) = it.symbol == OccupiedSeat.symbol

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OccupiedSeat

        if (seatCoordinates != other.seatCoordinates) return false

        return true
    }

    override fun hashCode(): Int {
        return seatCoordinates.hashCode()
    }


}