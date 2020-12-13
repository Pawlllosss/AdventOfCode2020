package task10

internal class JoltInputMaintainer {

    fun getSortedJoltsWithOutletAndDevice(
        jolts: List<Long>,
        maxDifference: Long = 3
    ): List<Long> {
        val sortedJolts = ArrayList<Long>(jolts.sorted())
        val outletJolts: Long = 0
        sortedJolts.add(0, outletJolts)
        val deviceJolts = sortedJolts.last() + maxDifference
        sortedJolts.add(deviceJolts)

        return sortedJolts
    }
}