package com.quiz.services.question;

import com.quiz.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//Following URL belongs to QuestionService[Means QuestionService Run on Port:9092]
@FeignClient(url = "http://localhost:9094", value = "Question-Client")
//@FeignClient(name = "QUESTIONSERVICE")
public interface QuestionClient {

    /* This QuestionClient it's implementation class automatically generate ,
    with the help of spring-cloud-starter-openfeign dependency */

    //this API create in Question service Controller class.
    //To Fetch this Q List we need to define Q List variable in Quiz Entity.
    @GetMapping("/question/getQuizQuestion/{quizid}")
    List<Question> getAllQuestionOfQuiz(@PathVariable Long quizid);

    //For above Generic List<Question>, we create Question Entity,
    //Only difference is that we not any annotation that relation with DB.

}
