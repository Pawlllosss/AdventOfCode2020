package task4

import utils.FileUtils
import java.io.BufferedReader

class PassportReader {

    fun getPassports(passportsPath: String): List<Passport> {
        val bufferedReader = FileUtils.getBufferedReader(passportsPath)
        return readEntriesFromFile(bufferedReader)
    }

    private fun readEntriesFromFile(bufferedReader: BufferedReader): List<Passport> {
        val passports = ArrayList<Passport>()
        var passportFields = HashMap<String, String>()
        bufferedReader.useLines { lines ->
            lines.forEach {
                if (it.isBlank()) {
                    val newPassport = Passport(passportFields)
                    passports.add(newPassport)
                    passportFields = HashMap()
                } else {
                    val convertedFields = convertToPassportFields(it)
                    passportFields.putAll(convertedFields)
                }
            }
        }
        val newPassport = Passport(passportFields)
        passports.add(newPassport)

        return passports
    }

    private fun convertToPassportFields(entry: String): Map<String, String> {
        val fields = entry.split(" ").toTypedArray()
        return fields.map {
            val (key, value) = it.split(":")
            Pair(key, value)
        }.associateBy(keySelector = { it.first }, valueTransform = { it.second })
    }
}