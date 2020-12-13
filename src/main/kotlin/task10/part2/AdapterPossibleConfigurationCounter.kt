package task10.part2

class AdapterPossibleConfigurationCounter {

    fun countPossibleConfigurations(jolts: Set<Long>, target: Long = jolts.max() ?: 0): Long {
        if (target < 0 || !jolts.contains(target)) {
            return 0
        } else if (target == 0L) {
            return 1
        }

        // TODO: make it more generic
        return countPossibleConfigurations(jolts, target - 1) + countPossibleConfigurations(jolts, target - 2) + countPossibleConfigurations(jolts, target - 3)
    }
}