package task11

import task11.seat.state.OccupiedSeat

class StableFloorPlanFinder {

    private val previousStates = HashSet<FloorPlan>()

    fun countOccupiedSeatsWhenStableState(floorPlan: FloorPlan): Int {
        var nextFloorPlan = floorPlan
        while (!floorPlanIsStable(nextFloorPlan)) {
            previousStates.add(nextFloorPlan)
            nextFloorPlan = nextFloorPlan.getNextState()
        }

        return countOccupiedSeats(nextFloorPlan)
    }

    private fun floorPlanIsStable(floorPlan: FloorPlan) = previousStates.contains(floorPlan)

    private fun countOccupiedSeats(floorPlan: FloorPlan): Int =
        floorPlan.seats.sumBy { it.count { seatState -> seatState.symbol == OccupiedSeat.symbol } }
}