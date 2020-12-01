package task1.part2

class ExpenseReportTripletSolver {

    fun findExpensesMultiplication(expenses: List<Int>, targetSum: Int): Int? {
        val maximumExpense = getMaximumExpense(expenses)
        val sortedAndFilteredExpenses = sortAndFilterExpensesList(expenses, targetSum)
        val existingSums = HashMap<Int, Pair<Int, Int>>()

        for ((index1, expense1) in sortedAndFilteredExpenses.withIndex()) {
            if (tooSmallExpenseToGetTargetSum(expense1, maximumExpense, targetSum)) {
                continue
            }
            if (tooBigExpenseToGetTargetSum(expense1, targetSum)) {
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

    private fun getMaximumExpense(expenses: List<Int>) = expenses.max() ?: Int.MAX_VALUE

    private fun sortAndFilterExpensesList(expenses: List<Int>, targetSum: Int): List<Int> {
        return expenses.sorted()
            .filter { expense -> expense <= targetSum }
    }

    private fun tooSmallExpenseToGetTargetSum(
        expense: Int,
        maximumExpense: Int,
        targetSum: Int
    ) = expense + 2 * maximumExpense < targetSum

    private fun tooBigExpenseToGetTargetSum(expense: Int, targetSum: Int) = 3 * expense > targetSum

    private fun isPossibleToGetTargetSum(
        sums: HashMap<Int, Pair<Int, Int>>,
        remaining: Int
    ) = sums.contains(remaining)

    private fun calculateTargetSums(
        sums: HashMap<Int, Pair<Int, Int>>,
        remaining: Int,
        expense1: Int
    ): Int {
        val (expense2, expense3) = sums[remaining]!!
        return expense1 * expense2 * expense3
    }
}