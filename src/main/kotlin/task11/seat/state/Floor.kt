package task11.seat.state

import task11.FloorPlan

class Floor: SeatState {

    companion object{
        val symbol = '.'
    }

    override val symbol: Char
        get() = '.'

    override fun nextState(floorPlan: FloorPlan): SeatState {
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }
}