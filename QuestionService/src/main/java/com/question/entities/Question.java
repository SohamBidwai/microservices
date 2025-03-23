package com.question.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private long question_id;


    //If we want to create custom method in JPA repository, so we need to use same variable name as parameter of that method.
    //And also used same variable name in that method name append at the end.
    //Example: findByQuizid(Long quizid) variable name is quizid only convert first letter in Camelcase

    @Column(name = "quiz_id")
    private long quizid;

    @Column(name = "question")
    private String question;

    transient private List<QuestionResult> questionResults;

    public List<QuestionResult> getQuestionResults() {
        return questionResults;
    }

    public void setQuestionResults(List<QuestionResult> questionResults) {
        this.questionResults = questionResults;
    }

    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(long question_id) {
        this.question_id = question_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public long getQuizid() {
        return quizid;
    }

    public void setQuizid(long quizid) {
        this.quizid = quizid;
    }

    public Question() {
    }

    public Question(long question_id, long quizid, String question, List<QuestionResult> questionResults) {
        this.question_id = question_id;
        this.quizid = quizid;
        this.question = question;
        this.questionResults = questionResults;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                ", quizid=" + quizid +
                ", question='" + question + '\'' +
                ", questionResults=" + questionResults +
                '}';
    }
}
