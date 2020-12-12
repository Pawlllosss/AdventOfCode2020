package task10

class JoltDifferenceCounter {

    fun countDifferencesByJoltDifference(jolts: List<Long>, maxDifference: Long = 3): Map<Long, Long> {
        val sortedJoltsWithOutletAndDevice = getSortedJoltsWithOutletAndDevice(jolts, maxDifference)
        val differenceByJolt = prepareDifferenceByJolt(maxDifference)

        for ((index, referenceJolt) in sortedJoltsWithOutletAndDevice.withIndex()) {
            if (index == sortedJoltsWithOutletAndDevice.size - 1) {
                break
            }
            val nextIndex = index + 1
            val nextJolt = sortedJoltsWithOutletAndDevice[nextIndex]

            val joltDifference = nextJolt - referenceJolt
            if (joltDifference <= maxDifference) {
                differenceByJolt.computeIfPresent(joltDifference) { _, count -> count + 1 }
            }
        }

        return differenceByJolt
    }

    private fun getSortedJoltsWithOutletAndDevice(
        jolts: List<Long>,
        maxDifference: Long
    ): List<Long> {
        val sortedJolts = ArrayList<Long>(jolts.sorted())
        val outletJolts: Long = 0
        sortedJolts.add(0, outletJolts)
        val deviceJolts = sortedJolts.last() + maxDifference
        sortedJolts.add(deviceJolts)

        return sortedJolts
    }

    private fun prepareDifferenceByJolt(maxDifference: Long): MutableMap<Long, Long> {
        val differenceByJolt = HashMap<Long, Long>()
        (1..maxDifference).forEach { difference -> differenceByJolt[difference] = 0 }

        return differenceByJolt
    }
}