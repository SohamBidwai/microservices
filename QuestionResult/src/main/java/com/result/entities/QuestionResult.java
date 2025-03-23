package com.result.entities;

import jakarta.persistence.*;

@Entity
public class QuestionResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_id")
    private int resultid;

    @Column(name = "result")
    private String result;

    @Column(name = "question_id")
    private int questionid;

    public int getResultid() {
        return resultid;
    }

    public void setResultid(int resultid) {
        this.resultid = resultid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public QuestionResult(int questionid, String result, int resultid) {
        this.questionid = questionid;
        this.result = result;
        this.resultid = resultid;
    }

    @Override
    public String toString() {
        return "QuestionResult{" +
                "resultid=" + resultid +
                ", result='" + result + '\'' +
                ", questionid=" + questionid +
                '}';
    }

    public QuestionResult() {
    }
}
