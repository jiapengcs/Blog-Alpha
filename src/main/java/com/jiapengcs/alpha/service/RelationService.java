package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.model.Relation;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface RelationService {

    Relation saveRelation(Relation relation);

    void deleteRelation(Long rid);

    boolean exists(Long cid, Long mid);

    List<Long> listMidsByCid(Long cid);

    List<Long> listCidsByMid(Long mid);
}
