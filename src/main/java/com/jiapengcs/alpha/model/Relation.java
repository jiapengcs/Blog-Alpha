package com.jiapengcs.alpha.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
@Entity
public class Relation implements Serializable {

    @Id
    @GeneratedValue
    private Long rid;

    @NotNull
    private Long cid;

    @NotNull
    private Long mid;

    public Relation() {
    }

    public Relation(Long cid, Long mid) {
        this.cid = cid;
        this.mid = mid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "rid=" + rid +
                ", cid=" + cid +
                ", mid=" + mid +
                '}';
    }
}
