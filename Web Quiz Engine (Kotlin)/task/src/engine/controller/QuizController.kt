package engine.controller

import engine.service.QuizService
import engine.model.GameResult
import engine.model.QuizAnswerRequest
import engine.model.QuizRequest
import engine.model.QuizResponse
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class QuizController(private val quizService: QuizService) {


    @PostMapping("/quizzes")
    @Validated
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
    fun quizCheck(@PathVariable id: Int,
                  @RequestBody answer: QuizAnswerRequest?): GameResult{
        return quizService.checkQuizAnswer(id, answer)
    }
}