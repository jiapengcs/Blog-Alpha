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
public class Option implements Serializable {

    @Id
    @GeneratedValue
    private Long oid;

    private String optionKey;

    private String optionValue;

    private Timestamp createTime;

    private Timestamp expireTime;

    private String remark;

    public Option() {
    }

    public Option(String optionKey, String optionValue, Timestamp createTime, Timestamp expireTime, String remark) {
        this.optionKey = optionKey;
        this.optionValue = optionValue;
        this.createTime = createTime;
        this.expireTime = expireTime;
        this.remark = remark;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getOptionKey() {
        return optionKey;
    }

    public void setOptionKey(String optionKey) {
        this.optionKey = optionKey;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Option{" +
                "oid=" + oid +
                ", optionKey='" + optionKey + '\'' +
                ", optionValue='" + optionValue + '\'' +
                ", createTime=" + createTime +
                ", expireTime=" + expireTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}
