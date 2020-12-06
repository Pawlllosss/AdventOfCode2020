package task6.part2

import task6.AnswersCounter
import task6.GroupReader

fun main() {
    val groupsPath = "src/main/kotlin/task6/resource/input"
    val groupReader = GroupReader()
    val answersCounter = AnswersCounter()
    val groups = groupReader.getGroups(groupsPath)
    val confirmedQuestions = groups.map(answersCounter::countQuestionsConfirmedByEveryoneWithinGroup)
        .sum()
    println(confirmedQuestions)
}
