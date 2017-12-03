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
public class Content implements Serializable {

    @Id
    @GeneratedValue
    private Long cid;

    private String contentKey;

    private String title;

    private String thumbImage;

    private String content;

    private String editType;

    private String format;

    private Timestamp createTime;

    private Timestamp updateTime;

    private String status;

    private Integer hits;

    public Content() {
    }

    public Content(String contentKey, String title, String thumbImage, String content, String editType,
                   String format, Timestamp createTime, Timestamp updateTime, String status, Integer hits) {
        this.contentKey = contentKey;
        this.title = title;
        this.thumbImage = thumbImage;
        this.content = content;
        this.editType = editType;
        this.format = format;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.hits = hits;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getContentKey() {
        return contentKey;
    }

    public void setContentKey(String contentKey) {
        this.contentKey = contentKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEditType() {
        return editType;
    }

    public void setEditType(String editType) {
        this.editType = editType;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
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

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "Content{" +
                "cid=" + cid +
                ", contentKey='" + contentKey + '\'' +
                ", title='" + title + '\'' +
                ", thumbImage='" + thumbImage + '\'' +
                ", content='" + content + '\'' +
                ", editType='" + editType + '\'' +
                ", format='" + format + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status='" + status + '\'' +
                ", hits=" + hits +
                '}';
    }
}
