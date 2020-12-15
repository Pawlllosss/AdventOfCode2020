package task11.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import task11.FloorPlanReader
import task11.SeatConverter
import task11.StableFloorPlanFinder

internal class StableStateIntegrationTest {

    private val floorPlanPath = "src/test/kotlin/task11/resource/FloorPlanExample.txt"

    private val seatConverter = SeatConverter()
    private val floorPlanReader = FloorPlanReader(seatConverter)
    private val stableFloorPlanFinder = StableFloorPlanFinder()

    @Test
    fun shouldReadFloorPlanFromFileAndReturnNumberOfOccupiedSeatsWhenFloorPlanIsStable() {
        val floorPlan = floorPlanReader.getFloorPlan(floorPlanPath)
        val occupiedSeats = stableFloorPlanFinder.countOccupiedSeatsWhenStableState(floorPlan)
        assertThat(occupiedSeats).isEqualTo(37)
    }
}