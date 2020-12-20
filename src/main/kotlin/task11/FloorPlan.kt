package task11

import task11.seat.state.Floor
import task11.seat.state.SeatState

data class FloorPlan(val seats: List<List<SeatState>>) {

    private val maxCoordinates: Pair<Int, Int>

    init {
        val maxRow = seats.size - 1
        val maxColumn = if (maxRow >= 0) seats[0].size - 1 else -1
        maxCoordinates = maxRow to maxColumn
    }

    fun getNextState(): FloorPlan {
        val seatsInNextState = seats.map {
            it.map { state -> state.nextState(this) }
        }

        return FloorPlan(seatsInNextState)
    }

    fun getAdjacentSeats(coordinates: Pair<Int, Int>): List<SeatState> {
        val directions = Direction.values()

        return directions.map { direction -> direction.moveToNext(coordinates) }
            .filter { coords -> isInBounds(coords, maxCoordinates) }
            .map(this::getSeat)
    }

    fun getSeatsInSight(coordinates: Pair<Int, Int>): List<SeatState> {
        val directions = Direction.values()

        return directions.mapNotNull {
            direction ->
            getSeatInSightOrNull(coordinates, direction)
        }
    }

    private fun isInBounds(coordinates: Pair<Int, Int>, maxCoordinates: Pair<Int, Int>): Boolean {
        val (row, column) = coordinates
        val (maxRow, maxColumn) = maxCoordinates

        if (isInBounds(row, maxRow) && isInBounds(column, maxColumn)) {
            return true
        }

        return false
    }

    private fun isInBounds(value: Int, maxValue: Int) = value in 0..maxValue

    private fun getSeat(coordinates: Pair<Int, Int>): SeatState {
        val (row, column) = coordinates
        return seats[row][column]
    }

    private fun getSeatInSightOrNull(
        coordinates: Pair<Int, Int>,
        direction: Direction
    ): SeatState? {
        var nextCoordinates = direction.moveToNext(coordinates)

        while (isInBounds(nextCoordinates, maxCoordinates)) {
            val seat = getSeat(nextCoordinates)

            if (seat.symbol != Floor.symbol) {
                return seat
            }
            nextCoordinates = direction.moveToNext(nextCoordinates)
        }

        return null
    }

    override fun toString(): String {
        val floorPlanStringBuilder = StringBuilder()
        for (row in seats) {
            val seatsInRow = row.map { seat -> seat.symbol }
            floorPlanStringBuilder.appendln(seatsInRow)
        }

        return floorPlanStringBuilder.toString()
    }
}