package com.question.controller;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/save")
    public Question saveQuestion(@RequestBody Question question){
        return questionService.add(question);
    }

    @GetMapping
    public List<Question> get(){
        return questionService.get();
    }

    @GetMapping("/getQuestion/{id}")
    public Question get(@PathVariable long id){
        return questionService.get(id);
    }

    //get all question of specific quiz id.
    @GetMapping("/getQuizQuestion/{quizid}")
    public List<Question> getQuizQuestion(@PathVariable long quizid){
        return questionService.getQuestioOfQuiz(quizid);
    }

    //get All Answers of Specific Question
    @GetMapping("/answers/{question_id}")
    public Question getAllAnswersOfSpecificQuestion(@PathVariable long question_id){
        return questionService.getQWithAnswers(question_id);
    }

    @GetMapping("/answers")
    public List<Question> getAllAnswersAgainstAllQuestion(){
        return questionService.getAllQuestionAnswers();
    }


}
