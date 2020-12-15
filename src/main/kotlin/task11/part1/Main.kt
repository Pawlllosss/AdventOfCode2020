package task11.part1

import task11.FloorPlanReader
import task11.SeatConverter
import task11.StableFloorPlanFinder

fun main() {
    val floorPlanPath = "src/main/kotlin/task11/resource/input"
    val seatConverter = SeatConverter()
    val floorPlanReader = FloorPlanReader(seatConverter)
    val stableFloorPlanFinder = StableFloorPlanFinder()
    val floorPlan = floorPlanReader.getFloorPlan(floorPlanPath)
    println(stableFloorPlanFinder.countOccupiedSeatsWhenStableState(floorPlan))
}