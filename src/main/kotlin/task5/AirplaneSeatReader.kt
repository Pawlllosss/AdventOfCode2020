package task5

import utils.FileUtils
import java.io.BufferedReader

class AirplaneSeatReader(val airplaneSeatConverter: AirplaneSeatConverter) {

    fun getBoardingPasses(seatsPath: String, rows: Int, columns: Int): List<AirplaneSeat> {
        val bufferedReader = FileUtils.getBufferedReader(seatsPath)
        return readBoardingPassesFromFile(bufferedReader, rows, columns)
    }

    private fun readBoardingPassesFromFile(
        bufferedReader: BufferedReader,
        rows: Int,
        columns: Int
    ): List<AirplaneSeat> {
        val seats = ArrayList<AirplaneSeat>()
        bufferedReader.useLines { lines ->
            lines.forEach {
                val airplaneSeat = airplaneSeatConverter.convertBinaryPartitioningToBoardingPass(it, rows, columns)
                seats.add(airplaneSeat)
            }
        }
        return seats
    }
}