package task11.seat.state

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import task11.FloorPlan

internal class OccupiedSeatTest {

    @Test
    fun shouldReturnEmptySeatIfFourOrMoreAdjacentSeatsAreOccupied() {
        // GIVEN
        val middleSeat = OccupiedSeat(1 to 1)
        val seatsMatrix = listOf(
            listOf(Floor(), OccupiedSeat(0 to 1), OccupiedSeat(0 to 2)),
            listOf(Floor(), middleSeat, EmptySeat(1 to 2)),
            listOf(EmptySeat(2 to 0), OccupiedSeat(2 to 1), OccupiedSeat(2 to 2))
        )
        val floorPlan = FloorPlan(seatsMatrix)

        // WHEN
        val nextState = middleSeat.nextState(floorPlan)

        // THEN
        assertThat(nextState is EmptySeat).isTrue()
    }

    @Test
    fun shouldReturnOccupiedSeatIfLessThanFourAdjacentSeatsAreOccupied() {
        // GIVEN
        val middleSeat = OccupiedSeat(1 to 1)
        val seatsMatrix = listOf(
            listOf(Floor(), OccupiedSeat(0 to 1), OccupiedSeat(0 to 2)),
            listOf(Floor(), middleSeat, EmptySeat(1 to 2)),
            listOf(EmptySeat(2 to 0), EmptySeat(2 to 1), OccupiedSeat(2 to 2))
        )
        val floorPlan = FloorPlan(seatsMatrix)

        // WHEN
        val nextState = middleSeat.nextState(floorPlan)

        // THEN
        assertThat(nextState is OccupiedSeat).isTrue()
    }
}