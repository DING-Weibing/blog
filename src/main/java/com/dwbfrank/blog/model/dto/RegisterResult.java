package com.dwbfrank.blog.model.dto;

import com.dwbfrank.blog.model.entity.Login;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.Instant;

public class RegisterResult extends Result implements Serializable {
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Data data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private static class Data implements Serializable {
        private long id;
        private String username;
        private String avatar;
        private Instant updatedAt;
        private Instant createdAt;

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public Instant getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Instant updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Instant getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Instant createdAt) {
            this.createdAt = createdAt;
        }
    }

    private RegisterResult() {
    }

    public static RegisterResult getSuccessfulRegisterResult(String msg, Login login) {
        RegisterResult registerResult = new RegisterResult();
        registerResult.setStatus(ResultStatus.OK);
        registerResult.setMsg(msg);
        if (login == null) {
            registerResult.setData(null);
        } else {
            Data data = new Data();
            data.id = login.getId();
            data.username = login.getAccount();
            data.avatar = "https://blog-server.hunger-valley.com/avatar/69.jpg";
            data.updatedAt = login.getUpdatedAt();
            data.createdAt = login.getCreatedAt();
            registerResult.setData(data);
        }
        return registerResult;
    }

    public static RegisterResult getFailureRegisterResult(String msg) {
        RegisterResult registerResult = new RegisterResult();
        registerResult.setStatus(ResultStatus.FAIL);
        registerResult.setMsg(msg);
        return registerResult;
    }
}
