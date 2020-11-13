package com.dwbfrank.blog.controller;

import com.dwbfrank.blog.model.dto.RegisterResult;
import com.dwbfrank.blog.service.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;


@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @Inject
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/register")
    public RegisterResult register(@RequestParam(name = "username") String username, @RequestParam(name = "password") String password) {
        return authService.register(username, password);
    }

    @PostMapping("/login")
    public String login() {
        return authService.login("frank", "123").getPassword();
    }
}
