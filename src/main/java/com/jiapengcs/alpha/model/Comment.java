package com.jiapengcs.alpha.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
@Entity
public class Comment implements Serializable {

    @Id
    @GeneratedValue
    private Integer coid;

    private Integer cid;

    private String visitorName;

    @Email
    private String visitorEmail;

    @URL
    private String visitorUrl;

    private String visitorIp;

    private String userAgent;

    private String comment;

    private Integer replyTo;

    private Integer root;

    private Timestamp createTime;

    private Timestamp updateTime;

    private String status;

    public Comment() {
    }

    public Comment(Integer cid, String visitorName, String visitorEmail, String visitorUrl, String visitorIp, String userAgent,
                   String comment, Integer replyTo, Integer root, Timestamp createTime, Timestamp updateTime, String status) {
        this.cid = cid;
        this.visitorName = visitorName;
        this.visitorEmail = visitorEmail;
        this.visitorUrl = visitorUrl;
        this.visitorIp = visitorIp;
        this.userAgent = userAgent;
        this.comment = comment;
        this.replyTo = replyTo;
        this.root = root;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public Integer getCoid() {
        return coid;
    }

    public void setCoid(Integer coid) {
        this.coid = coid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getVisitorEmail() {
        return visitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;
    }

    public String getVisitorUrl() {
        return visitorUrl;
    }

    public void setVisitorUrl(String visitorUrl) {
        this.visitorUrl = visitorUrl;
    }

    public String getVisitorIp() {
        return visitorIp;
    }

    public void setVisitorIp(String visitorIp) {
        this.visitorIp = visitorIp;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(Integer replyTo) {
        this.replyTo = replyTo;
    }

    public Integer getRoot() {
        return root;
    }

    public void setRoot(Integer root) {
        this.root = root;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "coid=" + coid +
                ", cid=" + cid +
                ", visitorName='" + visitorName + '\'' +
                ", visitorEmail='" + visitorEmail + '\'' +
                ", visitorUrl='" + visitorUrl + '\'' +
                ", visitorIp='" + visitorIp + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", comment='" + comment + '\'' +
                ", replyTo=" + replyTo +
                ", root=" + root +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status='" + status + '\'' +
                '}';
    }
}
