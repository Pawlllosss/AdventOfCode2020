package task11.part2

import task11.FloorPlanReader
import task11.StableFloorPlanFinder
import task11.converter.SeatInSightConverter

fun main() {
    val floorPlanPath = "src/main/kotlin/task11/resource/input"
    val seatConverter = SeatInSightConverter()
    val floorPlanReader = FloorPlanReader(seatConverter)
    val stableFloorPlanFinder = StableFloorPlanFinder()
    val floorPlan = floorPlanReader.getFloorPlan(floorPlanPath)
    println(stableFloorPlanFinder.countOccupiedSeatsWhenStableState(floorPlan))
}