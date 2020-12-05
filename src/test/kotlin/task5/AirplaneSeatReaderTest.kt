package task5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AirplaneSeatReaderTest {

    private val airplaneSeatConverter = AirplaneSeatConverter()
    private val airplaneSeatReader = AirplaneSeatReader(airplaneSeatConverter)

    @Test
    fun shouldReturnAllBoardingPassesWithinFile() {
        // GIVEN
        val airplaneSeatsPath = "src/test/kotlin/task5/resource/airplaneSeats.txt"
        val rows = 128
        val columns = 8

        // WHEN
        val airplaneSeats: List<AirplaneSeat> = airplaneSeatReader.getBoardingPasses(airplaneSeatsPath, rows, columns)

        // THEN
        assertThat(airplaneSeats).containsExactly(
            AirplaneSeat(32, 0),
            AirplaneSeat(16, 7),
            AirplaneSeat(15, 2)
        )
    }
}