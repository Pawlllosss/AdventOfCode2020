package task9

internal class XmasElementValidator {

    fun isValidElement(elements: Set<Long>, newElement: Long): Boolean {
        return elements.map { element -> newElement - element }.any(elements::contains)
    }
}