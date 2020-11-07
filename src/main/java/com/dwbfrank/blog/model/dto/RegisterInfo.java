package com.dwbfrank.blog.model.dto;

import com.dwbfrank.blog.model.domain.Login;

import java.io.Serializable;

public abstract class RegisterInfo implements Serializable {
    private String status;
    private String msg;

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

    public static RegisterInfo getSuccessfulRegisterInfo(Login login) {
        SuccessfulRegisterInfo successfulRegisterInfo = new SuccessfulRegisterInfo(login.getId(), login.getAccount(), "http://avatar.com/1.png", login.getUpdatedAt(), login.getCreatedAt());
        successfulRegisterInfo.setStatus("ok");
        successfulRegisterInfo.setMsg("注册成功");
        return successfulRegisterInfo;
    }

    public static RegisterInfo getFailureRegisterInfo(String msg) {
        return new FailureRegisterInfo(msg);
    }
}
