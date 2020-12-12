package task9

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class XmasElementValidatorTest {

    private val elementValidator = XmasElementValidator()

    @Test
    fun shouldReturnTrueWhenElementsThatSumUpExists() {
        // GIVEN
        val elements: Set<Long> = setOf(
            -1,
            1,
            15,
            5,
            -3,
            3
        )
        val newElement = 0L

        // WHEN
        val valid = elementValidator.isValidElement(elements, newElement)

        // THEN
        assertThat(valid).isTrue()
    }

    @Test
    fun shouldReturnFalseWhenElementsThatSumUpDoesNotExist() {
        // GIVEN
        val elements: Set<Long> = setOf(
            -1,
            0,
            15,
            5,
            -3
        )
        val newElement = 13L

        // WHEN
        val valid = elementValidator.isValidElement(elements, newElement)

        // THEN
        assertThat(valid).isFalse()
    }

    @Test
    fun shouldReturnFalseWhenEmptySet() {
        // GIVEN
        val elements: Set<Long> = emptySet()
        val newElement = 13L

        // WHEN
        val valid = elementValidator.isValidElement(elements, newElement)

        // THEN
        assertThat(valid).isFalse()
    }
}