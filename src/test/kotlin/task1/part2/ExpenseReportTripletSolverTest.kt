package task1.part2

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class ExpenseReportTripletSolverTest {

    private val expenses = listOf(
        5,
        7,
        113,
        10,
        434
    )
    private val expenseReportSolver = ExpenseReportTripletSolver()

    @ParameterizedTest
    @CsvSource(
        "125, 3955",
        "22, 350",
        "449, 21700",
        "1,",
        "666666,"
    )
    fun shouldReturnMultiplicationResultOfTargetSum(targetSum: Int, multiplicationResult: Int?) {
        // WHEN
        val multiplication = expenseReportSolver.findExpensesMultiplication(expenses, targetSum)

        // THEN
        Assertions.assertThat(multiplication).isEqualTo(multiplicationResult)
    }
}