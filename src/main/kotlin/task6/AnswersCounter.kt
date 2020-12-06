package task6

class AnswersCounter {

    fun countQuestionsConfirmedWithinGroup(group: Group): Int {
        val groupAnswers: List<Answers> = group.groupAnswers
        val confirmedQuestions = groupAnswers.flatMap(Answers::confirmedQuestions)
            .toSet()

        return confirmedQuestions.size
    }
}