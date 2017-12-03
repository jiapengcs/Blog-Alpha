package com.jiapengcs.alpha.controller.wrapper;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-2
 */
public class ResponseResult {

    private int status;

    private String message;

    private String path;

    private Object data;

    public ResponseResult() {
    }

    public ResponseResult(int status, String message, String path, Object data) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.data = data;
    }

    public ResponseResult(int status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }

    public ResponseResult(String path, Object data) {
        this.status = 2000;
        this.message =
        this.path = path;
        this.data = data;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", path='" + path + '\'' +
                ", data=" + data +
                '}';
    }
}
