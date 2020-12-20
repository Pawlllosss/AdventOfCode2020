package task11.seat.state

import task11.FloorPlan

data class EmptySeatInSightAware(private val seatCoordinates: Pair<Int, Int>): SeatState {

    companion object {
        const val symbol = 'L'
    }

    override val symbol: Char
        get() = EmptySeat.symbol

    override fun nextState(floorPlan: FloorPlan): SeatState {
        val seatsInSight = floorPlan.getSeatsInSight(seatCoordinates)
        val anySeatInSightOccupied = seatsInSight.any(this::isOccupied)

        return if (anySeatInSightOccupied) this else OccupiedSeatInSightAware(seatCoordinates)
    }

    private fun isOccupied(it: SeatState) = it.symbol == OccupiedSeat.symbol
}