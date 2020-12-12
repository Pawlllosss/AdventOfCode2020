package task9

class ContiguousNumbersFinder {

    // based on assumption that there's no negative elements in input
    fun findElementsThatSumUp(elements: List<Long>, targetSum: Long): List<Long> {
        val contiguousElements = ArrayList<Long>()
        var sum = 0L
        var first = 0
        var last = 0

        while (last < elements.size) {
            if (sum == targetSum) {
                return contiguousElements
            }

            if (sum > targetSum) {
                sum -= elements[first]
                contiguousElements.removeAt(0)
                first++
            } else {
                val lastElement = elements[last]
                sum += lastElement
                last++
                contiguousElements.add(lastElement)
            }
        }

        return if (targetSum == sum) contiguousElements else emptyList()
    }
}