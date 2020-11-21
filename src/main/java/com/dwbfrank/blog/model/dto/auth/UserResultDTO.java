package com.dwbfrank.blog.model.dto.auth;

import com.dwbfrank.blog.model.dto.Converter;
import com.dwbfrank.blog.model.dto.ResultDTO;
import com.dwbfrank.blog.model.entity.Login;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

public class UserResultDTO extends ResultDTO implements Serializable {
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private AuthData data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public AuthData getData() {
        return data;
    }

    public void setData(AuthData data) {
        this.data = data;
    }

    private UserResultDTO() {
    }

    public static UserResultDTO getSuccessfulRegisterResult(String msg, Login login) {
        UserResultDTO userResult = new UserResultDTO();
        userResult.setStatus(ResultStatus.OK);
        userResult.setMsg(msg);
        if (login == null) {
            userResult.setData(null);
        } else {
            userResult.setData(Converter.Login2AuthData(login));
        }
        return userResult;
    }

    public static UserResultDTO getFailureRegisterResult(String msg) {
        UserResultDTO userResult = new UserResultDTO();
        userResult.setStatus(ResultStatus.FAIL);
        userResult.setMsg(msg);
        return userResult;
    }
}
