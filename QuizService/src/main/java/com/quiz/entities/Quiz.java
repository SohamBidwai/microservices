package com.quiz.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
/*@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor*/
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="quiz_title")
    private String quizTitle;

    //this transient variable avoid DB relationship
    transient private List<Question> quizQuestions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public List<Question> getQuizQuestions() {
        return quizQuestions;
    }

    public void setQuizQuestions(List<Question> quizQuestions) {
        this.quizQuestions = quizQuestions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", quizTitle='" + quizTitle + '\'' +
                '}';
    }

    public Quiz() {
    }
}
