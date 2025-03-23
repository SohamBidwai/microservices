package com.question.services;

import com.question.entities.Question;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuestionService {

    Question add(Question question);

    List<Question> get();

    Question get(Long id);

    List<Question> getQuestioOfQuiz(Long quizid);

    Question getQWithAnswers(Long question_id);

    List<Question> getAllQuestionAnswers();

}
