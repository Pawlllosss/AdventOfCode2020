package task1.part1

class ExpenseReportSolver {

    fun findExpensesMultiplication(expenses: List<Long>, targetSum: Long): Long? {
        val maximumExpense = getMaximumExpense(expenses)
        val sortedAndFilteredExpenses = sortAndFilterExpensesList(expenses, targetSum)
        val spottedExpenses = HashSet<Long>()


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

    private fun getMaximumExpense(expenses: List<Long>) = expenses.max() ?: Long.MAX_VALUE

    private fun sortAndFilterExpensesList(expenses: List<Long>, targetSum: Long): List<Long> {
        return expenses.sorted()
            .filter { expense -> expense <= targetSum }
    }

    private fun isTooSmallExpenseToGetTargetSum(
        expense: Long,
        maximumExpense: Long,
        targetSum: Long
    ) = expense + maximumExpense < targetSum

    private fun isPossibleToGetTargetSum(
        spottedExpenses: Set<Long>,
        remaining: Long
    ) = spottedExpenses.contains(remaining)
}