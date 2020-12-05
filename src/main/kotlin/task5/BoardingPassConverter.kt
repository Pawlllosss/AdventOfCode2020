package task5

import java.lang.IllegalArgumentException
import kotlin.math.ceil
import kotlin.math.log2

class BoardingPassConverter {

    fun convertBinaryPartitioningToBoardingPass(spacePartitioning: String, rows: Int, columns: Int): BoardingPass {
        val rowBits = ceil(log2(rows.toDouble())).toInt()
        val columnBits = ceil(log2(columns.toDouble())).toInt()

        if (spacePartitioning.length != rowBits + columnBits) {
            throw IllegalArgumentException("Space partitioning pattern has not valid size for given representation")
        }

        val rowPattern = spacePartitioning.substring(0, rowBits)
        val row = convertRowPattern(rowPattern)
        val columnPattern = spacePartitioning.substring(rowBits)
        val column = convertColumnPattern(columnPattern)

        return BoardingPass(row, column)
    }

    private fun convertRowPattern(rowPattern: String): Int {
        return rowPattern.map {
            RowBinary.valueOf(it.toString()).value
        }.reduce { number, bit -> number shl 1 or bit }
    }

    private fun convertColumnPattern(columnPattern: String): Int {
        return columnPattern.map {
            ColumnBinary.valueOf(it.toString()).value
        }.reduce { number, bit -> number shl 1 or bit }
    }
}