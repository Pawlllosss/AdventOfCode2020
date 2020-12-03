package task3.part1

fun main() {
    val treeMapPath = "src/main/kotlin/task3/resource/input"
    val sliderTreeCounter = SliderTreeCounter()
    println(sliderTreeCounter.countSpottedTrees(treeMapPath))
}