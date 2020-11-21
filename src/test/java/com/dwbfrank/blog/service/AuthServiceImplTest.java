package com.dwbfrank.blog.service;

import com.dwbfrank.blog.dao.AuthDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class AuthServiceImplTest {
    @Mock
    private AuthDao authDao;
    @Mock
    private PasswordEncoder passwordEncoder;


    @Test
    void register() {
        assertTrue(true);
    }
}