package task5

import utils.FileUtils
import java.io.BufferedReader

class BoardingPassReader(val boardingPassConverter: BoardingPassConverter) {

    fun getBoardingPasses(boardingPassesPath: String, rows: Int, columns: Int): List<BoardingPass> {
        val bufferedReader = FileUtils.getBufferedReader(boardingPassesPath)
        return readBoardingPassesFromFile(bufferedReader, rows, columns)
    }

    private fun readBoardingPassesFromFile(
        bufferedReader: BufferedReader,
        rows: Int,
        columns: Int
    ): List<BoardingPass> {
        val passes = ArrayList<BoardingPass>()
        bufferedReader.useLines { lines ->
            lines.forEach {
                val boardingPass = boardingPassConverter.convertBinaryPartitioningToBoardingPass(it, rows, columns)
                passes.add(boardingPass)
            }
        }
        return passes
    }
}