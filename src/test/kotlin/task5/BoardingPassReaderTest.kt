package task5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BoardingPassReaderTest {

    private val boardingPassConverter = BoardingPassConverter()
    private val boardingPassReader = BoardingPassReader(boardingPassConverter)

    @Test
    fun shouldReturnAllBoardingPassesWithinFile() {
        // GIVEN
        val boardingPassesPath = "src/test/kotlin/task5/resource/boardingPasses.txt"
        val rows = 128
        val columns = 8

        // WHEN
        val boardingPasses: List<BoardingPass> = boardingPassReader.getBoardingPasses(boardingPassesPath, rows, columns)

        // THEN
        assertThat(boardingPasses).containsExactly(
            BoardingPass(32, 0),
            BoardingPass(16, 7),
            BoardingPass(15, 2)
        )
    }
}