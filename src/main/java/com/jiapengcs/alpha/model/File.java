package com.jiapengcs.alpha.model;

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
public class File implements Serializable {

    @Id
    @GeneratedValue
    private Long fid;

    private String fileName;

    private String fileType;

    private String filePath;

    private Long fileSize;

    private Timestamp uploadTime;

    public File() {
    }

    public File(String fileName, String fileType, String filePath, Long fileSize, Timestamp uploadTime) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
        this.fileSize = fileSize;
        this.uploadTime = uploadTime;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }

    @Override
    public String toString() {
        return "File{" +
                "fid=" + fid +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileSize=" + fileSize +
                ", uploadTime=" + uploadTime +
                '}';
    }
}
