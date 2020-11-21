package com.dwbfrank.blog.model.dto.auth;


import com.dwbfrank.blog.model.dto.Converter;
import com.dwbfrank.blog.model.dto.ResultDTO;
import com.dwbfrank.blog.model.entity.Login;
import com.fasterxml.jackson.annotation.JsonInclude;

public class LoginResultDTO extends ResultDTO {
    private boolean isLogin;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AuthData data;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public AuthData getData() {
        return data;
    }

    public void setData(AuthData data) {
        this.data = data;
    }

    public static LoginResultDTO getLoggedInResult(Login login) {
        LoginResultDTO loginResult = new LoginResultDTO();
        loginResult.setStatus(ResultStatus.OK);
        loginResult.isLogin = true;
        AuthData authData = Converter.Login2AuthData(login);
        loginResult.setData(authData);
        return loginResult;
    }


    public static LoginResultDTO getNotLoggedInResult() {
        LoginResultDTO loginResult = new LoginResultDTO();
        loginResult.setStatus(ResultStatus.OK);
        loginResult.isLogin = false;
        return loginResult;
    }
}
