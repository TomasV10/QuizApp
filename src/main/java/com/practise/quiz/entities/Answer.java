package com.practise.quiz.entities;

import com.practise.quiz.dto.AnswerDto;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "content", nullable = false, length = 65535)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
    @Column(name = "correct", nullable = false)
    private boolean correct;

    public Answer() {
    }

    public Answer(Question question, String content,  boolean correct) {
        this.content = content;
        this.question = question;
        this.correct = correct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", correct=" + correct +
                '}';
    }

    public AnswerDto toDto(){
        return new AnswerDto(id, content, question, correct);
    }
}
