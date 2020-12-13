package task10.part2

class AdapterConfigurationsCounter {

    fun countConfigurations(sortedJolts: List<Long>, target: Long = sortedJolts.max() ?: 0, maxDifference: Long = 3): Long {
        val configurationsByJolt = prepareConfigurationsByJolt(target)

        for (jolt in sortedJolts) {
            for (previousJolt in jolt - maxDifference until jolt) {
                val previousJoltConfigurations = configurationsByJolt.getOrDefault(previousJolt, 0)
                configurationsByJolt
                    .computeIfPresent(jolt) { _, configurations -> configurations + previousJoltConfigurations }
            }
        }

        return configurationsByJolt.getOrDefault(target, 0)
    }

    private fun prepareConfigurationsByJolt(target: Long): MutableMap<Long, Long> {
        val configurationsByJolt = mutableMapOf(0L to 1L)
        (1 .. target).forEach { jolt -> configurationsByJolt[jolt] = 0 }

        return configurationsByJolt
    }
}