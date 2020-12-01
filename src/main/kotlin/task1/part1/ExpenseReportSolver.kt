package task1.part1

class ExpenseReportSolver {

    fun findExpensesMultiplication(expenses: List<Int>, targetSum: Int): Int? {
        val maximumExpense = expenses.max() ?: Int.MAX_VALUE
        val sortedAndFilteredExpenses = sortAndFilterExpensesList(expenses, targetSum)

        for ((index1, expense1) in sortedAndFilteredExpenses.withIndex()) {
            if (tooSmallExpenseToGetTargetSum(expense1, maximumExpense, targetSum)) {
                continue
            }
            if (tooBigExpenseToGetTargetSum(expense1, targetSum)) {
                return null
            }

            for (index2 in index1 + 1 until sortedAndFilteredExpenses.size) {
                val expense2 = sortedAndFilteredExpenses[index2]

                if (tooBigExpensesToGetTargetSum(expense1, expense2, targetSum)) {
                    break
                }
                if (expense1 + expense2 == targetSum) {
                    return expense1 * expense2
                }
            }
        }

        return null
    }

    private fun sortAndFilterExpensesList(expenses: List<Int>, targetSum: Int): List<Int> {
        return expenses.sorted()
            .filter { expense -> expense <= targetSum }
    }

    private fun tooSmallExpenseToGetTargetSum(
        expense: Int,
        maximumExpense: Int,
        targetSum: Int
    ) = expense + maximumExpense < targetSum

    private fun tooBigExpenseToGetTargetSum(expense1: Int, targetSum: Int) = 2 * expense1 > targetSum

    private fun tooBigExpensesToGetTargetSum(
        expense1: Int,
        expense2: Int,
        targetSum: Int
    ) = expense1 + expense2 > targetSum
}