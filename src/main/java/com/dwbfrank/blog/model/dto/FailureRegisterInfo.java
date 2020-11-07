package com.dwbfrank.blog.model.dto;

public class FailureRegisterInfo extends RegisterInfo {
    public FailureRegisterInfo(String msg) {
        setStatus("fail");
        setMsg(msg);
    }
}
