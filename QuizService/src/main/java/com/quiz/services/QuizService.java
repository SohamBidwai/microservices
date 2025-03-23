package com.quiz.services;

import com.quiz.entities.Quiz;

import java.util.List;


//A class that implements this QuizService will be annotated as @Service

public interface QuizService {

    //It's implementation file is under implementation package

    Quiz add(Quiz quiz);

    List<Quiz> getAllQuiz();

    Quiz getQuizQId(Long id);

    List<Quiz> get();

    Quiz get(Long id);

}
