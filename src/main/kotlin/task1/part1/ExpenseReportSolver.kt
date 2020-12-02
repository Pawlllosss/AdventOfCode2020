package task1.part1

class ExpenseReportSolver {

    fun findExpensesMultiplication(expenses: List<Int>, targetSum: Int): Int? {
        val maximumExpense = getMaximumExpense(expenses)
        val sortedAndFilteredExpenses = sortAndFilterExpensesList(expenses, targetSum)
        val spottedExpenses = HashSet<Int>()


        for (expense in sortedAndFilteredExpenses) {
            if (isTooSmallExpenseToGetTargetSum(expense, maximumExpense, targetSum)) {
                continue
            }

            val remainingSum = targetSum - expense
            if (isPossibleToGetTargetSum(spottedExpenses, remainingSum)) {
                return expense * remainingSum
            }
            spottedExpenses.add(expense)
        }

        return null
    }

    private fun getMaximumExpense(expenses: List<Int>) = expenses.max() ?: Int.MAX_VALUE

    private fun sortAndFilterExpensesList(expenses: List<Int>, targetSum: Int): List<Int> {
        return expenses.sorted()
            .filter { expense -> expense <= targetSum }
    }

    private fun isTooSmallExpenseToGetTargetSum(
        expense: Int,
        maximumExpense: Int,
        targetSum: Int
    ) = expense + maximumExpense < targetSum

    private fun isPossibleToGetTargetSum(
        spottedExpenses: Set<Int>,
        remaining: Int
    ) = spottedExpenses.contains(remaining)
}