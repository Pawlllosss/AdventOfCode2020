package task11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import task11.converter.SeatAdjacentConverter
import task11.seat.state.EmptySeat
import task11.seat.state.Floor
import task11.seat.state.OccupiedSeat

internal class FloorPlanReaderTest {

    private val seatConverter = SeatAdjacentConverter()
    private val floorPlanReader = FloorPlanReader(seatConverter)

    @Test
    fun shouldReturnFloorPlanFromFile() {
        // GIVEN
        val floorPlanPath = "src/test/kotlin/task11/resource/FloorPlan.txt"

        // WHEN
        val floorPlan = floorPlanReader.getFloorPlan(floorPlanPath)

        // THEN
        val expectedFloorPlan = getExpectedFloorPlan()
        assertThat(floorPlan).isEqualTo(expectedFloorPlan)
    }

    private fun getExpectedFloorPlan(): FloorPlan {
        val seatsMatrix = listOf(
            listOf(Floor(), OccupiedSeat(0 to 1), OccupiedSeat(0 to 2)),
            listOf(Floor(), OccupiedSeat(1 to 1), EmptySeat(1 to 2)),
            listOf(EmptySeat(2 to 0), OccupiedSeat(2 to 1), OccupiedSeat(2 to 2))
        )
        return FloorPlan(seatsMatrix)
    }
}