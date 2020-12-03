package task1

import utils.FileUtils
import java.io.BufferedReader

class ExpenseReportReader {

    fun getExpenses(expensesFileName: String): List<Int> {
        val bufferedReader = FileUtils.getBufferedReader(expensesFileName)
        return readExpensesFromFile(bufferedReader)
    }

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