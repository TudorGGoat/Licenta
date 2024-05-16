package com.example.licenta.controllers;

import com.example.licenta.entities.SubjectEntity;
import com.example.licenta.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    private final SubjectRepository subjectRepository;

    @Autowired
    public UserController(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @GetMapping("/api/users/user")
    public ModelAndView showSubjects() {
        ModelAndView modelAndView = new ModelAndView("user");
        List<SubjectEntity> subjects = subjectRepository.findAll();
        modelAndView.addObject("subjects", subjects);
        return modelAndView;
    }
}
