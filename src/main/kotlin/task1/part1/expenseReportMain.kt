package task1.part1

import task1.ExpenseReportReader

fun main() {
    val expensesFileName = "src/main/kotlin/task1/resource/input"
    val expenseReportReader = ExpenseReportReader()
    val expenses = expenseReportReader.getExpenses(expensesFileName)
    val targetSum = 2020
    val expenseReportSolver = ExpenseReportSolver()
    val expensesMultiplication: Int? = expenseReportSolver.findExpensesMultiplication(expenses, targetSum)
    println(expensesMultiplication)
}
