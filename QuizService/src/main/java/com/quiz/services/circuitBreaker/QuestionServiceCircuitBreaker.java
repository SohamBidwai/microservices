package com.quiz.services.circuitBreaker;

import com.quiz.entities.Question;
import com.quiz.services.question.QuestionClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionServiceCircuitBreaker {

    @Autowired
    private QuestionClient questionClient;

    @CircuitBreaker(name = "quizQuestions", fallbackMethod = "ifQuestionNotFound")
    public List<Question> getAllQuestionsOfQuiz(long quizId){
        return questionClient.getAllQuestionOfQuiz(quizId);
    }

    public List<Question> ifQuestionNotFound(long quizId, Exception e) {
        System.out.println("Fallback triggered: Question Service is Down...!" + e.getMessage());
        return Collections.emptyList(); // Return an empty list instead of null
    }

}
