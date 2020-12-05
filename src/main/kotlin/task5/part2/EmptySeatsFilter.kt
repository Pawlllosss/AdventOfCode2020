package task5.part2

import task5.AirplaneSeat
import java.lang.IllegalStateException

class EmptySeatsFilter {

    // it's based on assumption that there are ALWAYS not existing seats at the front and back (according to task description)
    fun filterNotExistingAtTheFrontAndBack(emptySeats: Set<AirplaneSeat>): Set<AirplaneSeat> {
        val seatsByRow = emptySeats.groupBy { it.row }
        val sortedRows = seatsByRow.keys
            .sorted()
        val existingRows = getExistingRows(sortedRows)

        return existingRows.flatMap { row -> seatsByRow[row] ?: throw IllegalStateException() }.toSet()
    }

    private fun getExistingRows(sortedRows: List<Int>): List<Int> {
        val filteredFrontRows = filterFrontRows(sortedRows)
        return filterBackRows(filteredFrontRows)
    }

    private fun filterFrontRows(sortedRows: List<Int>): List<Int> {
        var start = true
        var checked = false
        var previous = sortedRows[0]
        val filteredFrontRows = ArrayList<Int>()

        for (row in sortedRows) {
            if (start) {
                start = false
                continue
            }
            if (!checked && row - 1 == previous) {
                previous = row
            } else if (!checked) {
                checked = true
            }

            if (checked) {
                filteredFrontRows.add(row)
            }
        }

        return filteredFrontRows
    }

    private fun filterBackRows(sortedRows: List<Int>): List<Int> {
        var start = true
        var checked = false
        var previous = sortedRows[sortedRows.size - 1]
        val filteredBackRows = ArrayList<Int>()

        for (row in sortedRows.asReversed()) {
            if (start) {
                start = false
                continue
            }
            if (!checked && row + 1 == previous) {
                previous = row
            } else if (!checked) {
                checked = true
            }

            if (checked) {
                filteredBackRows.add(row)
            }
        }
        return filteredBackRows
    }
}