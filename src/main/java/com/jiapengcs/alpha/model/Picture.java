package com.jiapengcs.alpha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-4
 */
@Entity
public class Picture implements Serializable {

    @Id
    @GeneratedValue
    private Long pid;

    private String subject;

    private String location;

    private String description;

    private String filePath;

    private String cdnPath;

    private Timestamp filmTime;

    private Timestamp uploadTime;

    public Picture() {
    }

    public Picture(String subject, String location, String description, Timestamp filmTime) {
        this.subject = subject;
        this.location = location;
        this.description = description;
        this.filmTime = filmTime;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getCdnPath() {
        return cdnPath;
    }

    public void setCdnPath(String cdnPath) {
        this.cdnPath = cdnPath;
    }

    public Timestamp getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(Timestamp filmTime) {
        this.filmTime = filmTime;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pid=" + pid +
                ", subject='" + subject + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", filePath='" + filePath + '\'' +
                ", cdnPath='" + cdnPath + '\'' +
                ", filmTime=" + filmTime +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
