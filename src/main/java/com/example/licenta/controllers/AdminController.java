package com.example.licenta.controllers;

import com.example.licenta.entities.SubjectEntity;
import com.example.licenta.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/api/admin/addSubject")
    public ModelAndView addSubject(
            @RequestParam("title") String title,
            @RequestParam("professor") String professor,
            @RequestParam("description") String description,
            @RequestParam("seats") int seats) {
        ModelAndView modelAndView = new ModelAndView();

        SubjectEntity subject = new SubjectEntity(title, professor, description, seats);
        adminService.addSubject(subject);

        modelAndView.setViewName("redirect:/api/users/admin"); // Redirecționează înapoi către pagina de admin
        return modelAndView;
    }
}
