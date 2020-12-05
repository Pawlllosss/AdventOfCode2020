package task5.part2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import task5.AirplaneSeat

internal class EmptySeatsFinderTest {

    private val emptySeatsFinder = EmptySeatsFinder()

    @Test
    fun shouldListEmptySeats() {
        // GIVEN
        val takenSeats = getTakenSeats()

        // WHEN
        val emptySeats = emptySeatsFinder.findEmptySeats(takenSeats, 3, 4)

        // THEN
        val expectedEmptySeats = getExpectedEmptySeats()
        assertThat(emptySeats).isEqualTo(expectedEmptySeats)
    }

    private fun getTakenSeats(): Set<AirplaneSeat> {
        return setOf(
            AirplaneSeat(0, 1),
            AirplaneSeat(0, 3),
            AirplaneSeat(1, 0),
            AirplaneSeat(1, 1),
            AirplaneSeat(1, 2)
        )
    }

    private fun getExpectedEmptySeats(): Set<AirplaneSeat> {
        return setOf(
            AirplaneSeat(0, 0),
            AirplaneSeat(0, 2),
            AirplaneSeat(1, 3),
            AirplaneSeat(2, 0),
            AirplaneSeat(2, 1),
            AirplaneSeat(2, 2),
            AirplaneSeat(2, 3)
        )
    }
}