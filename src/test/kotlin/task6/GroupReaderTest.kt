package task6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupReaderTest {

    private val groupReader = GroupReader()

    @Test
    fun shouldReturnAllGroupsWithinFile() {
        // GIVEN
        val groupsPath = "src/test/kotlin/task6/resource/groups.txt"

        // WHEN
        val groups: List<Group> = groupReader.getGroups(groupsPath)

        // THEN
        val expectedGroups = getExpectedGroups()
        assertThat(groups).isEqualTo(expectedGroups)
    }

    private fun getExpectedGroups(): List<Group> {
        return listOf(
            Group(
                listOf(
                    Answers(setOf('q', 't', 'm', 'd', 'w', 's')),
                    Answers(setOf('s', 'q', 'w', 'd')),
                    Answers(setOf('p'))
                )
            ),
            Group(
                listOf(
                    Answers(setOf('d', 'x', 'g', 'i', 'e', 'k', 'u')),
                    Answers(setOf('d', 'h', 'n'))
                )
            )
        )

    }

}