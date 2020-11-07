package com.dwbfrank.blog.model.dto;

import java.io.Serializable;
import java.time.Instant;

public class SuccessfulRegisterInfo extends RegisterInfo {
    private final Data data;

    public Data getData() {
        return data;
    }

    protected SuccessfulRegisterInfo(long id, String username, String avatar, Instant updatedAt, Instant createdAt) {
        setStatus("ok");
        setMsg("注册成功");
        this.data = new Data(id, username, avatar, updatedAt, createdAt);
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

        private Data(long id, String username, String avatar, Instant updatedAt, Instant createdAt) {
            this.id = id;
            this.username = username;
            this.avatar = avatar;
            this.updatedAt = updatedAt;
            this.createdAt = createdAt;
        }
    }
}
