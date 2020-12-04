package utils

import java.io.File

object FileUtils {
    fun getBufferedReader(filePath: String) = File(filePath).inputStream().bufferedReader()
}