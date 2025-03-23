package com.question.entities;

public class QuestionResult {

    private int resultid;

    private String result;

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
