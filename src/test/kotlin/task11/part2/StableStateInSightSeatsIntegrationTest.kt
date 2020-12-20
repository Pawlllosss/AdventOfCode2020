package task11.part2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import task11.FloorPlanReader
import task11.StableFloorPlanFinder
import task11.converter.SeatInSightConverter

internal class StableStateInSightSeatsIntegrationTest {

    private val floorPlanPath = "src/test/kotlin/task11/resource/FloorPlanExample.txt"

    private val seatConverter = SeatInSightConverter()
    private val floorPlanReader = FloorPlanReader(seatConverter)
    private val stableFloorPlanFinder = StableFloorPlanFinder()

    @Test
    fun shouldReadFloorPlanFromFileAndReturnNumberOfOccupiedSeatsWhenFloorPlanIsStable() {
        val floorPlan = floorPlanReader.getFloorPlan(floorPlanPath)
        val occupiedSeats = stableFloorPlanFinder.countOccupiedSeatsWhenStableState(floorPlan)
        assertThat(occupiedSeats).isEqualTo(26)
    }
}