package engine.controller

import engine.model.GameResult
import engine.model.Quiz
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController

@RequestMapping("/api/quiz")
class QuizController {
    @GetMapping
    fun quizRequest(): Quiz {
        val title = "The Porsche Logo"
        val text = "What is depicted on the Porsche logo?"
        val optionsList = ArrayList<String>()
        optionsList.add("Horse")
        optionsList.add("Bull")
        optionsList.add("Elephant")
        optionsList.add("Eagle")
        return Quiz(title, text, optionsList)
    }

    @PostMapping
    fun quizCheck(@RequestParam("answer") answer: Int): GameResult{
        return if (answer != 2) {
            val fail = false
            val failFeedback = "Wrong answer! Please, try again."
            GameResult(fail, failFeedback)
        } else {
            val success = true
            val successFeedback = "Congratulations, you're right!"
            GameResult(success, successFeedback)
        }
    }
}