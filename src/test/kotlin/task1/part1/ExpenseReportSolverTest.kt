package task1.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class ExpenseReportSolverTest {

    private val expenses = listOf(
        5,
        7,
        113,
        10,
        434
    )
    private val expenseReportSolver = ExpenseReportSolver()

    @ParameterizedTest
    @CsvSource(
        "12, 35",
        "118, 565",
        "444, 4340",
        "1,",
        "666,"
    )
    fun shouldReturnMultiplicationResultOfTargetSum(targetSum: Int, multiplicationResult: Int?) {
        // WHEN
        val multiplication = expenseReportSolver.findExpensesMultiplication(expenses, targetSum)

        // THEN
        assertThat(multiplication).isEqualTo(multiplicationResult)
    }
}