package task6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnswersCounterTest {

    private val answersCounter = AnswersCounter()

    @Test
    fun shouldCountQuestionsConfirmedByAnyoneWithinGroup() {
        // GIVEN
        val group = getGroup()

        // WHEN
        val confirmedQuestions = answersCounter.countQuestionsConfirmedByAnyoneWithinGroup(group)

        // THEN
        val expectedCount = 6
        assertThat(confirmedQuestions).isEqualTo(expectedCount)
    }

    @Test
    fun shouldCountQuestionsConfirmedByEveryoneWithinGroup() {
        // GIVEN
        val group = getGroup()

        // WHEN
        val confirmedQuestions = answersCounter.countQuestionsConfirmedByEveryoneWithinGroup(group)

        // THEN
        val expectedCount = 2
        assertThat(confirmedQuestions).isEqualTo(expectedCount)
    }

    private fun getGroup(): Group {
        return Group(
            listOf(
                Answers(setOf('a', 'b', 'z')),
                Answers(setOf('a', 'b', 'c', 'z')),
                Answers(setOf('a', 'd', 'b', 'x'))
            )
        )
    }
}