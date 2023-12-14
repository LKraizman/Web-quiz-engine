package engine.model

data class QuizRequest (
    var title: String,
    var text: String,
    var options: ArrayList<String>,
    var answer: Int
)