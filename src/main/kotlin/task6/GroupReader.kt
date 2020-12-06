package task6

import utils.FileUtils
import java.io.BufferedReader

class GroupReader {

    fun getGroups(groupsPath: String): List<Group> {
        val bufferedReader = FileUtils.getBufferedReader(groupsPath)
        return readGroups(bufferedReader)
    }

    private fun readGroups(bufferedReader: BufferedReader): List<Group> {
        val groups = ArrayList<Group>()
        var collectedAnswers = ArrayList<Answers>()
        bufferedReader.useLines { lines ->
            lines.forEach {
                if (it.isBlank()) {
                    val group = Group(collectedAnswers)
                    groups.add(group)
                    collectedAnswers = ArrayList()
                } else {
                    val answers = convertAnswers(it)
                    collectedAnswers.add(answers)
                }
            }
        }
        val group = Group(collectedAnswers)
        groups.add(group)

        return groups
    }

    private fun convertAnswers(answersInput: String): Answers {
        val answersSet = answersInput.toCharArray().toSet()
        return Answers(answersSet)
    }

}