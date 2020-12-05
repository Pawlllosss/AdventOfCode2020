package task5.part2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import task5.AirplaneSeat

internal class EmptySeatsFilterTest {

    private val emptySeatsFilter = EmptySeatsFilter()

    @Test
    fun shouldListEmptySeats() {
        // GIVEN
        val emptySeats = getEmptySeats()

        // WHEN
        val existingEmptySeats = emptySeatsFilter.filterNotExistingAtTheFrontAndBack(emptySeats)

        // THEN
        val expectedEmptySeats = getExpectedExistingEmptySeats()
        assertThat(existingEmptySeats).isEqualTo(expectedEmptySeats)
    }

    private fun getEmptySeats(): Set<AirplaneSeat> {
        return setOf(
            AirplaneSeat(0, 1),
            AirplaneSeat(0, 3),
            AirplaneSeat(1, 0),
            AirplaneSeat(1, 1),
            AirplaneSeat(1, 2),
            AirplaneSeat(4, 2),
            AirplaneSeat(7, 2),
            AirplaneSeat(7, 3),
            AirplaneSeat(8, 0),
            AirplaneSeat(8, 1),
            AirplaneSeat(8, 2),
            AirplaneSeat(8, 3)
        )
    }

    private fun getExpectedExistingEmptySeats(): Set<AirplaneSeat> {
        return setOf(
            AirplaneSeat(4, 2)
        )
    }
}