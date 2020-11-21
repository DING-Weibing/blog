package com.dwbfrank.blog.model.dto;

public abstract class ResultDTO {
    private ResultStatus status;

    public String getStatus() {
        return status.status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    protected enum ResultStatus {
        OK("ok"),
        FAIL("fail");
        private final String status;

        ResultStatus(String status) {
            this.status = status;
        }
    }
}
