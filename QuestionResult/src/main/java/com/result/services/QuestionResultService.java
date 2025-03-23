package com.result.services;

import com.result.entities.QuestionResult;

import java.util.List;

public interface QuestionResultService {

    QuestionResult add(QuestionResult questionResult);

    QuestionResult getById(int id);

    List<QuestionResult> get();

    List<QuestionResult> getAllResultOfQuestion(int questionid);
}
