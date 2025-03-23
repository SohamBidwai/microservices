package com.quiz.implementation;

import com.quiz.entities.Quiz;
import com.quiz.repository.QuizRepository;
import com.quiz.services.QuizService;
import com.quiz.services.circuitBreaker.QuestionServiceCircuitBreaker;
import com.quiz.services.question.QuestionClient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class QuizServiceImplementation implements QuizService {

    @Autowired
    private QuestionClient questionClient;

    //@Autowired
    private QuizRepository quizRepository;

    //another way to inject is constructor injection of above Autowired.
    //comment @Autowired annotation and uncomment below statement.

    @Autowired
    private QuestionServiceCircuitBreaker questionServiceCircuitBreaker;

    public QuizServiceImplementation(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz add(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz getQuizQId(Long id) {
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));
    }

    @Override
    public List<Quiz> get() {

        List<Quiz> newQuizList = quizRepository.findAll();

        List<Quiz> quizQuestion = newQuizList.stream()
                .map(quiz -> {
                    quiz.setQuizQuestions(questionServiceCircuitBreaker.getAllQuestionsOfQuiz(quiz.getId()));
                    return quiz;
                }).collect(Collectors.toList());

        return quizQuestion;
    }

    @Override
    public Quiz get(Long id) {
        //below line meaning is that if we found data so data will be return, otherwise will throw an exception.
        Quiz quizQuestion = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz Not Found"));
        quizQuestion.setQuizQuestions(questionClient.getAllQuestionOfQuiz(quizQuestion.getId()));
        return quizQuestion;
    }
}
