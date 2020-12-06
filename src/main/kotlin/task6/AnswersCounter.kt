package task6

class AnswersCounter {

    fun countQuestionsConfirmedByAnyoneWithinGroup(group: Group): Int {
        val groupAnswers: List<Answers> = group.groupAnswers
        val answeredByAnyone = groupAnswers.flatMap(Answers::confirmedQuestions)
            .toSet()

        return answeredByAnyone.size
    }

    fun countQuestionsConfirmedByEveryoneWithinGroup(group: Group): Int {
        val groupAnswers: List<Answers> = group.groupAnswers
        val answeredByEveryone = groupAnswers.map(Answers::confirmedQuestions)
            .reduce { everyoneAnswers, answers -> everyoneAnswers.intersect(answers) }

        return answeredByEveryone.size
    }
}