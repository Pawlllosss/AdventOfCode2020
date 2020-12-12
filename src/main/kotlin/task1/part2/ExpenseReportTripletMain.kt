package task1.part2

import reader.NumbersReader

fun main() {
    val expensesFileName = "src/main/kotlin/task1/resource/input"
    val expenseReportReader = NumbersReader()
    val expenses = expenseReportReader.getNumbers(expensesFileName)
    val targetSum = 2020L
    val expenseReportTripletSolver = ExpenseReportTripletSolver()
    val expensesMultiplication: Long? = expenseReportTripletSolver.findExpensesMultiplication(expenses, targetSum)
    println(expensesMultiplication)
}
