package com.jiapengcs.alpha.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
@Entity
public class Relation implements Serializable {

    @Id
    private Integer cid;

    @Id
    private Integer mid;

    public Relation() {
    }

    public Relation(Integer cid, Integer mid) {
        this.cid = cid;
        this.mid = mid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "cid=" + cid +
                ", mid=" + mid +
                '}';
    }
}
