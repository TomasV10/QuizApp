package com.practise.quiz.controllers;


import Services.QuestionService;
import com.practise.quiz.dto.QuestionDto;
import com.practise.quiz.entities.Question;
import com.practise.quiz.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;


    @GetMapping("/question")
    public String test(Model model){
        getListOfQuestions(model);
        return "questions";
    }

    @PostMapping(value = "/submit")
    public ModelAndView submit(HttpServletRequest request, Model model){
        int score = 0;
        String []questionIds = request.getParameterValues("questionId");
        for (String questionId : questionIds){
            int answerIdCorrect = questionService.findAnswerIdCorrect(Integer.parseInt(questionId));
            if(answerIdCorrect == Integer.parseInt(request.getParameter(questionId))){
                score++;
            }
        }
        model.addAttribute("score", score);
        getListOfQuestions(model);
        return new ModelAndView("result");
    }

    private void getListOfQuestions(Model model) {
        List<Question> questions = (List<Question>) questionRepository.findAll();
        List<QuestionDto> questionsDtoList = listOfQuestionsToDto(questions);
        model.addAttribute("questions", questionsDtoList);
    }

    private List<QuestionDto> listOfQuestionsToDto(List<Question>questions){
        return questions.stream()
                .map(qe -> qe.toDto())
                .collect(Collectors.toList());
    }



}

