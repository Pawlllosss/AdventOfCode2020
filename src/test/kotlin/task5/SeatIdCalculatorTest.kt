package task5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class SeatIdCalculatorTest {

    private val seatIdCalculator = SeatIdCalculator()

    @ParameterizedTest
    @CsvSource(
        "44, 5, 357",
        "70, 7, 567",
        "14, 7, 119",
        "102, 4, 820"
    )
    fun shouldCalculateSeatId(row: Int, column: Int, expectedId: Long) {
        // GIVEN
        val boardingPass = BoardingPass(row, column)

        // WHEN
        val seatId = seatIdCalculator.calculateSeatId(boardingPass)

        // THEN
        assertThat(seatId).isEqualTo(expectedId)
    }
}