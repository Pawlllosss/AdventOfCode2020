package task3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class SliderTreeSolverTest {

    private val sliderTreeCounter = SliderTreeSolver()

    @ParameterizedTest
    @CsvSource(
        "src/test/kotlin/task3/resource/TreeMap1.txt, 7, 3, 1",
        "src/test/kotlin/task3/resource/TreeMap1.txt, 1, 2, 3",
        "src/test/kotlin/task3/resource/TreeMapOneLine.txt, 0, 3, 1"
    )
    fun shouldReturnTreeOccurrences(treeMapPath: String, expectedTrees: Long, xStep: Int, yStep: Int) {
        // WHEN
        val trees = sliderTreeCounter.countSpottedTreesProduct(treeMapPath, setOf(Pair(xStep, yStep)))

        // THEN
        assertThat(trees).isEqualTo(expectedTrees)
    }
}