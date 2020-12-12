package task9

class FaultyXmasElementFinder {

    private val elementValidator = XmasElementValidator()

    fun findFirst(elements: List<Long>, preambleLength: Int = 25): Long? {
        val previousElements = elements.take(preambleLength).toHashSet()
        var lastElementIndex = 0

        for (element in elements.drop(preambleLength)) {
            if (!elementValidator.isValidElement(previousElements, element)) {
                return element
            }

            previousElements.add(element)
            previousElements.remove(elements[lastElementIndex])
            lastElementIndex++
        }

        return null
    }
}