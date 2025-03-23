package com.result.repository;

import com.result.entities.QuestionResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionResultRepository extends JpaRepository<QuestionResult, Integer> {
    List<QuestionResult> findByQuestionid(int questionid);
}
