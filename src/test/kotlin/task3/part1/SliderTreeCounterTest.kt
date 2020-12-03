package task3.part1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class SliderTreeCounterTest {

    private val sliderTreeCounter = SliderTreeCounter()

    @ParameterizedTest
    @CsvSource(
        "src/test/kotlin/task3/resource/TreeMap1.txt, 7",
        "src/test/kotlin/task3/resource/TreeMapOneLine.txt, 0"
    )
    fun shouldReturnTreeOccurrences(treeMapPath: String, expectedTrees: Int) {
        // WHEN
        val trees = sliderTreeCounter.countSpottedTrees(treeMapPath)

        // THEN
        assertThat(trees).isEqualTo(expectedTrees)
    }
}