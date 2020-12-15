package task11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import task11.seat.state.EmptySeat
import task11.seat.state.Floor
import task11.seat.state.OccupiedSeat

internal class FloorPlanTest {

    @Test
    fun shouldReturnAdjacentSeats() {
        // GIVEN
        val seatsMatrix = listOf(
            listOf(EmptySeat(0 to 0), OccupiedSeat(0 to 1), OccupiedSeat(0 to 2)),
            listOf(Floor(), EmptySeat(1 to 1), EmptySeat(1 to 2)),
            listOf(EmptySeat(2 to 0), OccupiedSeat(2 to 1), OccupiedSeat(2 to 2))
        )
        val floorPlan = FloorPlan(seatsMatrix)

        // WHEN
        val adjacentCoordinates = floorPlan.getAdjacentSeatsCoordinates(0 to 0)

        // THEN
        assertThat(adjacentCoordinates).containsExactly(
            0 to 1,
            1 to 0,
            1 to 1
        )
    }
}