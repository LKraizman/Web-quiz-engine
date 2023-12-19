package engine.model

import jakarta.validation.Valid
import jakarta.validation.constraints.NotBlank


data class Quiz(
    var quizId: Int,
    var title: String,
    var text: String,
    var options: ArrayList<String>,
    var answer: ArrayList<Int>?
)