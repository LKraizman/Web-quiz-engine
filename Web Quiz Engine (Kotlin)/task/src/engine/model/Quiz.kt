package engine.model


data class Quiz (
    var quizId: Int,
    var title: String,
    var text: String,
    var options: ArrayList<String>,
    var answer: Int
)