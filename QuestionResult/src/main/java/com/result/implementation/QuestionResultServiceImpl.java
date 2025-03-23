package com.result.implementation;

import com.result.entities.QuestionResult;
import com.result.repository.QuestionResultRepository;
import com.result.services.QuestionResultService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class QuestionResultServiceImpl implements QuestionResultService {

    @Autowired
    private QuestionResultRepository questionResultRepository;

    @Override
    public QuestionResult add(QuestionResult questionResult) {
        return questionResultRepository.save(questionResult);
    }

    @Override
    public QuestionResult getById(int id) {
        return questionResultRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Override
    public List<QuestionResult> get() {
        return questionResultRepository.findAll();
    }

    @Override
    public List<QuestionResult> getAllResultOfQuestion(int questionid) {
        System.out.println(questionid);
        return questionResultRepository.findByQuestionid(questionid);
    }

}
