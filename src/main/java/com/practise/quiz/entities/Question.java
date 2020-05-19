package com.practise.quiz.entities;

import com.practise.quiz.dto.QuestionDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "content", nullable = false, length = 65535)
    private String content;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private List<Answer> answers = new ArrayList<>();

    public Question() {
    }

    public Question(String content) {
        this.content = content;
    }

    public Question(String content, List<Answer> answers) {
        this.content = content;
        this.answers = answers;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", answers=" + answers +
                '}';
    }

    public QuestionDto toDto(){
        return new QuestionDto(id, content, answers);
    }
}
