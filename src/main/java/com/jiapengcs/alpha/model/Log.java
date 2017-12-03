package com.jiapengcs.alpha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
@Entity
public class Log implements Serializable {

    @Id
    @GeneratedValue
    private Long lid;

    private String uri;

    private String method;

    private String args;

    private String ip;

    private String exception;

    private String message;

    private Long cost;

    private Timestamp logTime;

    public Log() {
    }

    public Log(String uri, String method, String args, String ip, String exception, String message, Long cost, Timestamp logTime) {
        this.uri = uri;
        this.method = method;
        this.args = args;
        this.ip = ip;
        this.exception = exception;
        this.message = message;
        this.cost = cost;
        this.logTime = logTime;
    }

    public Long getLid() {
        return lid;
    }

    public void setLid(Long lid) {
        this.lid = lid;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Timestamp getLogTime() {
        return logTime;
    }

    public void setLogTime(Timestamp logTime) {
        this.logTime = logTime;
    }

    @Override
    public String toString() {
        return "error{" +
                "uri='" + uri + '\'' +
                ", method='" + method + '\'' +
                ", args='" + args + '\'' +
                ", ip='" + ip + '\'' +
                ", exception='" + exception + '\'' +
                ", message='" + message + '\'' +
                ", cost=" + cost +
                ", logTime=" + logTime +
                '}';
    }
}
