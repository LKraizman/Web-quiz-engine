package engine.controller

import engine.model.GameResult
import engine.model.QuizRequest
import engine.model.QuizResponse
import engine.service.QuizService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class QuizController(private val quizService: QuizService) {

////    @GetMapping("/quiz")
////    fun quizRequest(): Quiz {
////        val title = "The Porsche Logo"
////        val text = "What is depicted on the Porsche logo?"
////        val optionsList = ArrayList<String>()
////        optionsList.add("Horse")
////        optionsList.add("Bull")
////        optionsList.add("Elephant")
////        optionsList.add("Eagle")
////        return Quiz(quizId + 1, title, text, optionsList)
////    }
//
//    @PostMapping("/quiz")
//    fun quizCheck(@RequestParam("answer") answer: Int): GameResult{
//        return if (answer != 2) {
//            val fail = false
//            val failFeedback = "Wrong answer! Please, try again."
//            GameResult(fail, failFeedback)
//        } else {
//            val success = true
//            val successFeedback = "Congratulations, you're right!"
//            GameResult(success, successFeedback)
//        }
//    }

    @PostMapping("/quizzes")
    fun addNewQuiz(@RequestBody newQuiz: QuizRequest): QuizResponse{
        return quizService.saveNewQuiz(newQuiz)
    }

    @GetMapping("/quizzes")
    fun findAllQuizzes(): ArrayList<QuizResponse>{
        return quizService.getAllQuizzes()
    }

    @GetMapping("/quizzes/{id}")
    fun getQuizById(@PathVariable id: Int): QuizResponse{
        return quizService.findQuizById(id)
    }

    @PostMapping("/quizzes/{id}/solve")
    fun quizCheck(@PathVariable id: Int, @RequestParam("answer") answer: Int): GameResult{
        return quizService.checkQuizAnswer(id, answer)
    }
}