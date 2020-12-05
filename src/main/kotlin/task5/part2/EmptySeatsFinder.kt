package task5.part2

import task5.AirplaneSeat

class EmptySeatsFinder {

    fun findEmptySeats(takenSeats: Set<AirplaneSeat>, rows: Int, columns: Int): Set<AirplaneSeat> {
        val possibleSeats: Set<AirplaneSeat> = generatePossibleSeats(rows, columns)

        return possibleSeats subtract takenSeats
    }

    private fun generatePossibleSeats(rows: Int, columns: Int): Set<AirplaneSeat> {
        return (0 until rows).flatMap { row -> createSeatsWithinRow(columns, row) }.toSet()
    }

    private fun createSeatsWithinRow(columns: Int, row: Int): Set<AirplaneSeat> {
        return (0 until columns).map { column ->
            AirplaneSeat(row, column)
        }.toSet()
    }
}