package task3.part1

import task3.MapGridElement
import utils.FileUtils

class SliderTreeCounter {

    fun countSpottedTrees(forrestMapPath: String): Int {
        val bufferedReader = FileUtils.getBufferedReader(forrestMapPath)
        var started = true
        var xMax = 0
        var x = 0
        var spottedTrees = 0
        bufferedReader.useLines { lines ->
            lines.forEach {
                if (started) {
                    started = false
                    xMax = it.length
                } else if (hasSpottedTree(it, x)) {
                    spottedTrees++
                }

                x += 3
                if (isOutsideOfX(x, xMax)) {
                    x -= xMax
                }
            }
        }

        return spottedTrees
    }

    private fun hasSpottedTree(yPosElements: String, x: Int) =
        yPosElements[x] == MapGridElement.Tree.gridCharacter

    private fun isOutsideOfX(x: Int, xMax: Int) = x >= xMax
}