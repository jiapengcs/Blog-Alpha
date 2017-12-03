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
public class Meta implements Serializable {

    @Id
    @GeneratedValue
    private Long mid;

    private String metaType;

    private String metaName;

    private Timestamp createTime;

    private String remark;

    public Meta() {
    }

    public Meta(String metaType, String metaName, Timestamp createTime, String remark) {
        this.metaType = metaType;
        this.metaName = metaName;
        this.createTime = createTime;
        this.remark = remark;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public String getMetaType() {
        return metaType;
    }

    public void setMetaType(String metaType) {
        this.metaType = metaType;
    }

    public String getMetaName() {
        return metaName;
    }

    public void setMetaName(String metaName) {
        this.metaName = metaName;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "mid=" + mid +
                ", metaType='" + metaType + '\'' +
                ", metaName='" + metaName + '\'' +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
