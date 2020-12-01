package task1.part1

import java.io.BufferedReader
import java.io.File

class ExpenseReportReader {

    fun getExpenses(expensesFileName: String): List<Int> {
        val bufferedReader = getBufferedReader(expensesFileName)
        return readExpensesFromFile(bufferedReader)
    }

    private fun getBufferedReader(expensesFileName: String) =
        File(expensesFileName).inputStream().bufferedReader()

    private fun readExpensesFromFile(bufferedReader: BufferedReader): ArrayList<Int> {
        val expenses = ArrayList<Int>()
        bufferedReader.useLines { lines ->
            lines.forEach {
                val expense = it.toInt()
                expenses.add(expense)
            }
        }
        return expenses
    }
}