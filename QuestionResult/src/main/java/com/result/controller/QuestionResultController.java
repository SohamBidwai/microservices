package com.result.controller;

import com.result.entities.QuestionResult;
import com.result.services.QuestionResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questionresult")
public class QuestionResultController {

    @Autowired
    private QuestionResultService questionResultService;

    @PostMapping("/addResult")
    public QuestionResult addResult(@RequestBody QuestionResult questionResult){
        return questionResultService.add(questionResult);
    }

    @GetMapping
    public List<QuestionResult> get(){
        return questionResultService.get();
    }

    @GetMapping("/getByResultId/{resultid}")
    public QuestionResult getByResultId(@PathVariable int resultid){
        return questionResultService.getById(resultid);
    }

    @GetMapping("/getAllResultOfQuestion/{questionid}")
    public List<QuestionResult> getAllResultOfQuestion(@PathVariable int questionid){
        return questionResultService.getAllResultOfQuestion(questionid);
    }

}
