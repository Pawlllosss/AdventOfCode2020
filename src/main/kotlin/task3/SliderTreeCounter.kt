package task3

class SliderTreeCounter(xyStep: Pair<Int, Int>) {
    private var started = true
    private var xMax = 0
    private var x = 0
    private var y = 0
    private val xStep = xyStep.first
    private val yStep = xyStep.second
    var spottedTrees: Long = 0
        get() = field
        private set(value) {
            field = value
        }


    fun calculateNextPosition(elements: String) {
        if (started) {
            started = false
            xMax = elements.length
        } else if (canMoveInX(y, yStep)) {
            x += xStep

            if (isOutsideOfX(x, xMax)) {
                x -= xMax
            }

            if (hasSpottedTree(elements, x)) {
                spottedTrees++
            }
        }
        y++
    }

    private fun hasSpottedTree(yPosElements: String, x: Int) =
        yPosElements[x] == MapGridElement.Tree.gridCharacter

    private fun canMoveInX(y: Int, yStep: Int) = y % yStep == 0

    private fun isOutsideOfX(x: Int, xMax: Int) = x >= xMax
}