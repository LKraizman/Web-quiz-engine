package engine.model

data class QuizResponse(
    var id: Int,
    var title: String?,
    var text: String?,
    var options: ArrayList<String>
) {
    constructor(quiz: Quiz): this(quiz.quizId, quiz.title, quiz.text, quiz.options) {
    }
}