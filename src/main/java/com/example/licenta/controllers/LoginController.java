package com.example.licenta.controllers;

import com.example.licenta.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;
    private boolean isAuthenticated = false;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/api/users/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password) {
        String redirectPath = loginService.login(email, password);
        if (redirectPath.equals("/api/users/user") || redirectPath.equals("/api/users/admin")) {
            isAuthenticated = true;
        }
        return "redirect:" + redirectPath;
    }



    @GetMapping("/api/users/admin")
    public String adminPage() {
        if (isAuthenticated) {
            return "admin";
        } else {
            return "redirect:/login";
        }
    }
}
