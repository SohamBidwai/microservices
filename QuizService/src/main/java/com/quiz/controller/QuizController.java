package com.quiz.controller;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private QuizService quizService;

    //constructor injection


    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/save")
    public Quiz createQuiz(@RequestBody Quiz quiz){
        System.out.println(quiz.toString());
        return quizService.add(quiz);
    }

    @GetMapping("/getAllQuiz")
    public List<Quiz> getAllQuiz(){
        return quizService.getAllQuiz();
    }

    @GetMapping("/getQuizQId/{id}")
    public Quiz getQuizQId(@PathVariable Long id){
        return quizService.getQuizQId(id);
    }

    @GetMapping
    public List<Quiz> get(){
        return quizService.get();
    }

    @GetMapping("/getById/{id}")
    public Quiz specificQuiz(@PathVariable Long id){
        return quizService.get(id);
    }

    @GetMapping("/currentUser")
    public String getLoggedUser(Principal principal){
        return principal.getName();
    }

}
