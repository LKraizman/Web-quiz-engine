package engine.model

data class QuizRequest (
    val title: String,
    val text: String,
    val options: ArrayList<String>,
    var answer: ArrayList<Int>?
)