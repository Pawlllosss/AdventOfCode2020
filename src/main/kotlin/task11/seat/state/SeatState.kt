package task11.seat.state

import task11.FloorPlan

interface SeatState {

    val symbol: Char

    fun nextState(floorPlan: FloorPlan): SeatState
}