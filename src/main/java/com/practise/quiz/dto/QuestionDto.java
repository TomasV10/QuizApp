package com.practise.quiz.dto;

import com.practise.quiz.entities.Answer;

import java.util.ArrayList;
import java.util.List;

public class QuestionDto {
    private Integer id;
    private String content;
    private List<Answer> answers = new ArrayList<>();

    public QuestionDto() {
    }

    public QuestionDto(Integer id, String content, List<Answer> answers) {
        this.id = id;
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

}
