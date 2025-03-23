package com.question.services.circuitBreaker;

import com.question.entities.QuestionResult;
import com.question.services.QuestionResult.QuestionResultClinet;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionResultCircuitBreaker {

    @Autowired
    private QuestionResultClinet questionResultClient;

    @CircuitBreaker(name = "questionResultService", fallbackMethod = "questionResultFallback")
    public List<QuestionResult> getAllResultOfQuestion(int questionid) {
        return questionResultClient.getAllResultOfQuestion(questionid);
    }

    public List<QuestionResult> questionResultFallback(int questionid, Exception e) {
        System.out.println("Fallback triggered: QuestionResult Service is Down...!" + e.getMessage());
        return Collections.emptyList(); // Return an empty list instead of null
    }

}
