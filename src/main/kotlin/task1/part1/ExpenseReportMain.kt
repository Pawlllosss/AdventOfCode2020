package task1.part1

import reader.NumbersReader

fun main() {
    val expensesFileName = "src/main/kotlin/task1/resource/input"
    val expenseReportReader = NumbersReader()
    val expenses = expenseReportReader.getNumbers(expensesFileName)
    val targetSum = 2020L
    val expenseReportSolver = ExpenseReportSolver()
    val expensesMultiplication: Long? = expenseReportSolver.findExpensesMultiplication(expenses, targetSum)
    println(expensesMultiplication)
}
