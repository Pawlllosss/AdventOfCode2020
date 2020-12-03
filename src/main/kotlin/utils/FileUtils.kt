package utils

import java.io.File

class FileUtils {
    companion object {
        fun getBufferedReader(filePath: String) = File(filePath).inputStream().bufferedReader()
    }
}