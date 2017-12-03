package com.jiapengcs.alpha.util.constant;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-2
 */
public enum ResponseCode {

    SUCCESS(2000, "success"),
    FORBIDDEN(4003, "forbidden"),
    NOT_FOUND(4004, "not found"),
    ERROR(5000, "error");

    private int status;

    private String message;

    ResponseCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseCode{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
