package task11

import task11.seat.state.SeatState
import utils.FileUtils
import java.io.BufferedReader

class FloorPlanReader(private val seatConverter: SeatConverter) {

    fun getFloorPlan(floorPlanPath: String): FloorPlan {
        val bufferedReader = FileUtils.getBufferedReader(floorPlanPath)
        return readFloorPlanFromFile(bufferedReader)
    }

    private fun readFloorPlanFromFile(bufferedReader: BufferedReader): FloorPlan {
        val seatsMatrix = ArrayList<List<SeatState>>()
        var rowNumber = 0
        bufferedReader.useLines { lines ->
            lines.forEach {
                val seatsRow = it.mapIndexed { columnNumber, symbol ->
                    seatConverter.convertToSeat(
                        rowNumber,
                        columnNumber,
                        symbol
                    )
                }
                seatsMatrix.add(seatsRow)
                rowNumber++
            }
        }

        return FloorPlan(seatsMatrix)
    }
}