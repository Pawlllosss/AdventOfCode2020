package task5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class BoardingPassConverterTest {

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
        val converter = BoardingPassConverter()

        // WHEN
        val boardingPass = converter.convertBinaryPartitioningToBoardingPass(spacePartitioning, rows, columns)

        // THEN
        val expectedBoardingPass = BoardingPass(expectedRow, expectedColumn)
        assertThat(boardingPass).isEqualTo(expectedBoardingPass)
    }
}