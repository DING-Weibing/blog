package com.dwbfrank.blog.model.dto;

import com.dwbfrank.blog.model.domain.Login;

import java.io.Serializable;

public class RegisterInfo implements Serializable {
    private Login login;
    private String status;
    private String msg;

    public RegisterInfo() {
    }

    public Login getBlogUser() {
        return login;
    }

    public void setBlogUser(Login login) {
        this.login = login;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
