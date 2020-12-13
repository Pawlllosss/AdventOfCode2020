package task10.part1

class JoltDifferenceCounter {

    fun countDifferencesByJoltDifference(sortedJolts: List<Long>, maxDifference: Long = 3): Map<Long, Long> {
        val differenceByJolt = prepareDifferenceByJolt(maxDifference)

        for ((index, referenceJolt) in sortedJolts.withIndex()) {
            if (index == sortedJolts.size - 1) {
                break
            }
            val nextIndex = index + 1
            val nextJolt = sortedJolts[nextIndex]

            val joltDifference = nextJolt - referenceJolt
            if (joltDifference <= maxDifference) {
                differenceByJolt.computeIfPresent(joltDifference) { _, count -> count + 1 }
            }
        }

        return differenceByJolt
    }

    private fun prepareDifferenceByJolt(maxDifference: Long): MutableMap<Long, Long> {
        val differenceByJolt = HashMap<Long, Long>()
        (1..maxDifference).forEach { difference -> differenceByJolt[difference] = 0 }

        return differenceByJolt
    }
}