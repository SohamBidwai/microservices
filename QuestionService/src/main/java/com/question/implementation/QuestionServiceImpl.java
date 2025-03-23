package com.question.implementation;

import com.question.entities.Question;
import com.question.repository.QuestionRepository;
import com.question.services.QuestionResult.QuestionResultClinet;
import com.question.services.QuestionService;
import com.question.services.circuitBreaker.QuestionResultCircuitBreaker;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionResultClinet questionResultClinet;

    @Autowired
    private QuestionResultCircuitBreaker questionResultCircuitBreaker;

    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRepository.findAll();
    }

    @Override
    public Question get(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));
    }

    @Override
    public List<Question> getQuestioOfQuiz(Long quizid) {
        return questionRepository.findByQuizid(quizid);
    }

    @Override
    public Question getQWithAnswers(Long question_id) {

        Question question = questionRepository.findById(question_id).orElseThrow(() -> new RuntimeException("Question Not Found"));
        question.setQuestionResults(questionResultClinet.getAllResultOfQuestion((int)question.getQuestion_id()));

        return question;
    }

    @Override
    public List<Question> getAllQuestionAnswers() {

        //get all question's from DB
        //And used following question to fetch answer's against Question using stream API.
        List<Question> question = questionRepository.findAll();

        //Following code is execute without CircuitBreaker is used.
        /*
        List<Question> questionAnswerList = question.stream()
                .map(question1 -> {
                    question1.setQuestionResults(questionResultClinet.getAllResultOfQuestion((int) question1.getQuestion_id()));
                    return question1;
                }).collect(Collectors.toList());
        */

        //Following code execute when we Used CircuitBreaker
        List<Question> questionAnswerList = question.stream()
                .map(question1 -> {
                    question1.setQuestionResults(questionResultCircuitBreaker.getAllResultOfQuestion((int) question1.getQuestion_id()));
                    return question1;
                }).collect(Collectors.toList());

        return questionAnswerList;
    }
}
