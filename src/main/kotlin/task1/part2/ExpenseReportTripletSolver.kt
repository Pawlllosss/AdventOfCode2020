package task1.part2

class ExpenseReportTripletSolver {

    fun findExpensesMultiplication(expenses: List<Long>, targetSum: Long): Long? {
        val maximumExpense = getMaximumExpense(expenses)
        val sortedAndFilteredExpenses = sortAndFilterExpensesList(expenses, targetSum)
        val existingSums = HashMap<Long, Pair<Long, Long>>()

        for ((index1, expense1) in sortedAndFilteredExpenses.withIndex()) {
            if (isTooSmallExpenseToGetTargetSum(expense1, maximumExpense, targetSum)) {
                continue
            }
            if (isTooBigExpenseToGetTargetSum(expense1, targetSum)) {
                return null
            }

            for (index2 in index1 + 2 until sortedAndFilteredExpenses.size) {
                val expense2 = sortedAndFilteredExpenses[index2 - 1]
                val expense3 = sortedAndFilteredExpenses[index2]
                val currentSum = expense1 + expense2
                existingSums[currentSum] = Pair(expense1, expense2)

                val remainingToTargetSum = targetSum - expense3
                if (isPossibleToGetTargetSum(existingSums, remainingToTargetSum)) {
                    return calculateTargetSums(existingSums, remainingToTargetSum, expense3)
                }
            }
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
    ) = expense + 2 * maximumExpense < targetSum

    private fun isTooBigExpenseToGetTargetSum(expense: Long, targetSum: Long) = 3 * expense > targetSum

    private fun isPossibleToGetTargetSum(
        sums: Map<Long, Pair<Long, Long>>,
        remaining: Long
    ) = sums.contains(remaining)

    private fun calculateTargetSums(
        sums: HashMap<Long, Pair<Long, Long>>,
        remaining: Long,
        expense1: Long
    ): Long {
        val (expense2, expense3) = sums[remaining]!!
        return expense1 * expense2 * expense3
    }
}