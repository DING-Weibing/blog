package com.dwbfrank.blog.controller;

import com.dwbfrank.blog.model.dto.auth.BasicLogin;
import com.dwbfrank.blog.model.dto.auth.LoginResultDTO;
import com.dwbfrank.blog.model.dto.auth.LogoutResultDTO;
import com.dwbfrank.blog.model.dto.auth.UserResultDTO;
import com.dwbfrank.blog.model.entity.Login;
import com.dwbfrank.blog.service.AuthService;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("")
    public LoginResultDTO auth() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!name.equals("anonymousUser")) {
            Login login = authService.getUser(name);
            return LoginResultDTO.getLoggedInResult(login);
        }
        return LoginResultDTO.getNotLoggedInResult();
    }


    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping("/register")
    public UserResultDTO register(@RequestBody BasicLogin basicLogin) {
        return authService.register(basicLogin.getUsername(), basicLogin.getPassword());
    }

    @PostMapping("/login")
    public UserResultDTO login(@RequestBody BasicLogin basicLogin) {
        return authService.login(basicLogin);
    }

    @GetMapping("/logout")
    public LogoutResultDTO logout() {
        if (auth().isLogin()) {
            authService.logout();
            return LogoutResultDTO.getSuccessfulResult();
        }
        return LogoutResultDTO.getFailureResult();
    }
}
