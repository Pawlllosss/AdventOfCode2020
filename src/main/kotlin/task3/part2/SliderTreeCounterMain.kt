package task3.part2

import task3.SliderTreeSolver

fun main() {
    val treeMapPath = "src/main/kotlin/task3/resource/input"
    val sliderTreeCounter = SliderTreeSolver()
    val slidesXY = setOf(
        Pair(1, 1),
        Pair(3, 1),
        Pair(5, 1),
        Pair(7, 1),
        Pair(1, 2))
    println(sliderTreeCounter.countSpottedTreesProduct(treeMapPath, slidesXY))
}