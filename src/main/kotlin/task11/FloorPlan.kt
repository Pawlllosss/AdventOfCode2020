package task11

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

    fun getSeat(coordinates: Pair<Int, Int>): SeatState {
        val (row, column) = coordinates
        return seats[row][column]
    }

    fun getAdjacentSeats(coordinates: Pair<Int, Int>): List<SeatState> {
        val (row, column) = coordinates

        return listOf(
            row - 1 to column - 1,
            row - 1 to column,
            row - 1 to column + 1,
            row to column - 1,
            row to column + 1,
            row + 1 to column - 1,
            row + 1 to column,
            row + 1 to column + 1)
            .filter { coords -> isInBounds(coords, maxCoordinates) }
            .map(this::getSeat)
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
}