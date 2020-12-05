package task5

import java.lang.IllegalArgumentException
import kotlin.math.ceil
import kotlin.math.log2

class AirplaneSeatConverter {

    fun convertBinaryPartitioningToBoardingPass(spacePartitioning: String, rows: Int, columns: Int): AirplaneSeat {
        val rowBits = ceil(log2(rows.toDouble())).toInt()
        val columnBits = ceil(log2(columns.toDouble())).toInt()

        if (spacePartitioning.length != rowBits + columnBits) {
            throw IllegalArgumentException("Space partitioning pattern has not valid size for given representation")
        }

        val rowPattern = spacePartitioning.substring(0, rowBits)
        val row = convertRowPattern(rowPattern)
        val columnPattern = spacePartitioning.substring(rowBits)
        val column = convertColumnPattern(columnPattern)

        return AirplaneSeat(row, column)
    }

    private fun convertRowPattern(rowPattern: String): Int {
        return rowPattern.map {
            RowBinary.valueOf(it.toString()).value
        }.reduce(constructBinaryNumber())
    }

    private fun convertColumnPattern(columnPattern: String): Int {
        return columnPattern.map {
            ColumnBinary.valueOf(it.toString()).value
        }.reduce(constructBinaryNumber())
    }

    private fun constructBinaryNumber() = { number: Int, bit: Int -> number shl 1 or bit }
}