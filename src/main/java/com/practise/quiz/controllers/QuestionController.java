package com.practise.quiz.controllers;

import com.practise.quiz.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;


    @GetMapping("/question")
    public String test(Model model){
        model.addAttribute("questions", questionRepository.findAll());
        System.out.println(questionRepository.findAll());
        return "questions";
    }
}

