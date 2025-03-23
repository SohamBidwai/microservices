package com.quiz.repository;

import com.quiz.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<entity, entity id type>

public interface QuizRepository extends JpaRepository<Quiz, Long> {



}
