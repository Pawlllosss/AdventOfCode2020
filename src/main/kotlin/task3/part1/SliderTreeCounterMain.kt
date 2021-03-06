package task3.part1

import task3.SliderTreeSolver

fun main() {
    val treeMapPath = "src/main/kotlin/task3/resource/input"
    val sliderTreeCounter = SliderTreeSolver()
    val slidesXY = setOf(Pair(3, 1))
    println(sliderTreeCounter.countSpottedTreesProduct(treeMapPath, slidesXY))
}