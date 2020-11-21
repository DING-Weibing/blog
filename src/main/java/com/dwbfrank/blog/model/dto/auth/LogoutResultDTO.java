package com.dwbfrank.blog.model.dto.auth;

import com.dwbfrank.blog.model.dto.ResultDTO;

import java.io.Serializable;

public class LogoutResultDTO extends ResultDTO implements Serializable {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static LogoutResultDTO getSuccessfulResult() {
        LogoutResultDTO logoutResultDTO = new LogoutResultDTO();
        logoutResultDTO.setStatus(ResultStatus.OK);
        logoutResultDTO.msg = "注销成功";
        return logoutResultDTO;
    }

    public static LogoutResultDTO getFailureResult() {
        LogoutResultDTO logoutResultDTO = new LogoutResultDTO();
        logoutResultDTO.setStatus(ResultStatus.FAIL);
        logoutResultDTO.msg = "用户尚未登录";
        return logoutResultDTO;
    }
}
