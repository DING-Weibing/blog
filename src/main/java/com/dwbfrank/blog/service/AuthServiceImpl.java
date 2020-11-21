package com.dwbfrank.blog.service;

import com.dwbfrank.blog.dao.AuthDao;
import com.dwbfrank.blog.dao.DaoFactory;
import com.dwbfrank.blog.model.dto.auth.BasicLogin;
import com.dwbfrank.blog.model.dto.auth.UserResultDTO;
import com.dwbfrank.blog.model.entity.Login;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;


@Service
public class AuthServiceImpl implements AuthService, UserDetailsService {

    private final AuthDao authDao;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Inject
    public AuthServiceImpl(DaoFactory daoFactory, PasswordEncoder passwordEncoder, @Lazy AuthenticationManager authenticationManager) {
        authDao = daoFactory.getUserDao();
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public UserResultDTO register(String username, String password) {
        if (username == null || username.isEmpty()) {
            return UserResultDTO.getFailureRegisterResult("用户名不可为空");
        }
        if (username.length() > 15) {
            return UserResultDTO.getFailureRegisterResult("用户名不得超过15个字符");
        }
        if (hasInvalidCharacter(username)) {
            return UserResultDTO.getFailureRegisterResult("只能是字母数字下划线中文");
        }
        if (isAlreadyRegistered(username)) {
            return UserResultDTO.getFailureRegisterResult("用户名已被注册");
        }

        Login login = new Login();
        login.setAccount(username);
        login.setPassword(passwordEncoder.encode(password));
        if (authDao.createAccount(login)) {
            login = authDao.getLoginByAccount(login.getAccount());
            return UserResultDTO.getSuccessfulRegisterResult("注册成功", login);
        } else {
            return UserResultDTO.getFailureRegisterResult("注册失败");
        }
    }

    @Override
    public UserResultDTO login(BasicLogin basicLogin) {
        UserDetails userDetails;
        try {
            userDetails = loadUserByUsername(basicLogin.getUsername());
        } catch (UsernameNotFoundException e) {
            return UserResultDTO.getFailureRegisterResult("未注册用户");
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, basicLogin.getPassword(), userDetails.getAuthorities());
        try {
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException e) {
            return UserResultDTO.getFailureRegisterResult("密码错误");
        }
        return UserResultDTO.getSuccessfulRegisterResult("登陆成功", null);
    }

    private boolean hasInvalidCharacter(String username) {
        String regex = "^[\\u4e00-\\u9fa5_a-zA-Z0-9]+$";
        return !username.matches(regex);
    }

    private boolean isAlreadyRegistered(String username) {
        return authDao.getLoginByAccount(username) != null;
    }


    @Override
    public void logout() {
        SecurityContextHolder.clearContext();
    }

    @Override
    public Login getUser(String username) {
        return authDao.getLoginByAccount(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = authDao.getLoginByAccount(username);
        if (login == null) {
            throw new UsernameNotFoundException("not found");
        }
        String password = login.getPassword();
        return User.withUsername(username).password(password).authorities(new ArrayList<>()).build();
    }
}
