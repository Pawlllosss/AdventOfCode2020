package task10.part2

class AdapterPossibleConfigurationCounter {

    private val possibleConfigurations = HashMap<Long, Long>()

    fun countPossibleConfigurations(jolts: Set<Long>, target: Long = jolts.max() ?: 0, maxDifference: Long = 3): Long {
        possibleConfigurations.clear()

        return count(jolts, target, maxDifference)
    }

    private fun count(jolts: Set<Long>, target: Long, maxDifference: Long): Long {
        if (target < 0 || !jolts.contains(target)) {
            return 0
        } else if (target == 0L) {
            return 1
        }

        var sum = 0L

        for (jolt in target - maxDifference until target) {
            sum += countPossibleConfigurations(jolts, jolt)
        }

        return sum
    }
}