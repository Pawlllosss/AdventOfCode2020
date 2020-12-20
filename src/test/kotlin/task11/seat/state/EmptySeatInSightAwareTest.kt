package task11.seat.state

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import task11.FloorPlan

internal class EmptySeatInSightAwareTest {

    @Test
    fun shouldReturnEmptySeatIfAnySeatInSightIsOccupied() {
        // GIVEN
        val emptySeat = EmptySeat(0 to 0)
        val seatsMatrix = listOf(
            listOf(EmptySeatInSightAware(0 to 0), OccupiedSeatInSightAware(0 to 1), OccupiedSeatInSightAware(0 to 2)),
            listOf(emptySeat, EmptySeatInSightAware(1 to 1), OccupiedSeatInSightAware(1 to 2)),
            listOf(EmptySeatInSightAware(2 to 0), OccupiedSeatInSightAware(2 to 1), OccupiedSeatInSightAware(2 to 2))
        )
        val floorPlan = FloorPlan(seatsMatrix)

        // WHEN
        val nextState = emptySeat.nextState(floorPlan)

        // THEN
        Assertions.assertThat(nextState is EmptySeat).isTrue()
    }

    @Test
    fun shouldReturnOccupiedStateIfNoAdjacentSeatIsOccupied() {
        // GIVEN
        val middleSeat = OccupiedSeat(1 to 1)
        val seatsMatrix = listOf(
            listOf(Floor(), Floor(), Floor()),
            listOf(Floor(), middleSeat, EmptySeat(1 to 2)),
            listOf(EmptySeat(2 to 0), EmptySeat(2 to 1), EmptySeat(2 to 2))
        )
        val floorPlan = FloorPlan(seatsMatrix)

        // WHEN
        val nextState = middleSeat.nextState(floorPlan)

        // THEN
        Assertions.assertThat(nextState is OccupiedSeat).isTrue()
    }
}