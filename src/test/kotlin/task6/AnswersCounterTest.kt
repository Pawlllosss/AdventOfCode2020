package task6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AnswersCounterTest {

    private val answersCounter = AnswersCounter()

    @Test
    fun shouldCountConfirmedQuestionsWithinGroup() {
        // GIVEN
        val group = getGroup()

        // WHEN
        val confirmedQuestions = answersCounter.countQuestionsConfirmedWithinGroup(group)

        // THEN
        val expectedCount = 6
        assertThat(confirmedQuestions).isEqualTo(expectedCount)
    }

    private fun getGroup(): Group {
        return Group(
            listOf(
                Answers(setOf('a', 'b', 'z')),
                Answers(setOf('a', 'c', 'z')),
                Answers(setOf('d', 'b', 'x'))
            )
        )
    }
}