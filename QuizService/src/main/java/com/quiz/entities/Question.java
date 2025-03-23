package com.quiz.entities;

public class Question {

    private long question_id;
    private long quizid;
    private String question;

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

    public Question(long question_id, String question, long quiz_id) {
        this.question_id = question_id;
        this.question = question;
        this.quizid = quizid;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question_id=" + question_id +
                "quizid=" + quizid +
                ", question='" + question + '\'' +
                '}';
    }

}
