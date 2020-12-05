package task5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class AirplaneSeatConverterTest {

    @ParameterizedTest
    @CsvSource(
        "FBFBBFFRLR, 128, 8, 44, 5",
        "BFBBFFRLR, 55, 7, 44, 5",
        "BBFBBFFRLR, 128, 8, 108, 5",
        "BBFBBFFRL, 128, 4, 108, 2"
    )
    fun shouldValidateIfEyeColorIsCorrect(
        spacePartitioning: String,
        rows: Int,
        columns: Int,
        expectedRow: Int,
        expectedColumn: Int
    ) {
        // GIVEN
        val converter = AirplaneSeatConverter()

        // WHEN
        val airplaneSeat = converter.convertBinaryPartitioningToBoardingPass(spacePartitioning, rows, columns)

        // THEN
        val expectedBoardingPass = AirplaneSeat(expectedRow, expectedColumn)
        assertThat(airplaneSeat).isEqualTo(expectedBoardingPass)
    }
}