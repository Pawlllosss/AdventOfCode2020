package task3

import utils.FileUtils

class SliderTreeSolver {

    fun countSpottedTreesProduct(forrestMapPath: String, slidesXY: Set<Pair<Int, Int>>): Long {
        val bufferedReader = FileUtils.getBufferedReader(forrestMapPath)
        val sliderCounters = slidesXY.map { xyTactic ->
            SliderTreeCounter(xyTactic)
        }
        bufferedReader.useLines { lines ->
            lines.forEach {
                sliderCounters.forEach { counter -> counter.calculateNextPosition(it) }
            }
        }

        return calculateSpottedTreesProduct(sliderCounters)
    }

    private fun calculateSpottedTreesProduct(sliderCounters: List<SliderTreeCounter>): Long {
        return sliderCounters.map { counter -> counter.spottedTrees }
            .reduce { spotted, result -> result * spotted }
    }
}