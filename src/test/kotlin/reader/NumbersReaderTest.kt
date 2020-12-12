package reader

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import reader.NumbersReader

internal class NumbersReaderTest {

    private val fileName = "src/test/kotlin/reader/resource/exampleExpenseReport.txt"
    private val expenseReportReader = NumbersReader()

    @Test
    fun shouldReturnListOfExpenses() {
        // WHEN
        val expenses = expenseReportReader.getNumbers(fileName)

        // THEN
        assertThat(expenses).containsExactly(143, 654645, 1212, 54564)
    }
}