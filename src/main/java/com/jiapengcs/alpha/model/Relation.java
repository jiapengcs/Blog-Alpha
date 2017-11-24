package com.jiapengcs.alpha.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
@Entity
@IdClass(Relation.CidMidMap.class)
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

    /**
     * to solve the union primary key problem
     * equals() and hashCode() ought to be override
     */
    public static class CidMidMap implements Serializable {

        private Integer cid;

        private Integer mid;

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
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            CidMidMap that = (CidMidMap) o;

            return cid.equals(that.cid) && mid.equals(that.mid);
        }

        @Override
        public int hashCode() {
            int result = cid.hashCode();
            result = 31 * result + mid.hashCode();
            return result;
        }
    }
}
