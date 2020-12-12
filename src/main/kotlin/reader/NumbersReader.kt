package reader

import utils.FileUtils
import java.io.BufferedReader

class NumbersReader {

    fun getNumbers(path: String): List<Long> {
        val bufferedReader = FileUtils.getBufferedReader(path)
        return readNumbersFromFile(bufferedReader)
    }

    private fun readNumbersFromFile(bufferedReader: BufferedReader): List<Long> {
        val numbers = ArrayList<Long>()
        bufferedReader.useLines { lines ->
            lines.forEach {
                val number = it.toLong()
                numbers.add(number)
            }
        }
        return numbers
    }
}