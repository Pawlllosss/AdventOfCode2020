package task1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExpenseReportReaderTest {

    private val fileName = "src/test/kotlin/task1/resource/exampleExpenseReport.txt"
    private val expenseReportReader = ExpenseReportReader()

    @Test
    fun shouldReturnListOfExpenses() {
        // WHEN
        val expenses = expenseReportReader.getExpenses(fileName)

        // THEN
        assertThat(expenses).containsExactly(143, 654645, 1212, 54564)
    }
}