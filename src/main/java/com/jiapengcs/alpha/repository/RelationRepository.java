package com.jiapengcs.alpha.repository;

import com.jiapengcs.alpha.model.Relation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface RelationRepository extends BaseRepository<Relation, Long> {

    Relation findByCidAndMid(Long cid, Long mid);

    @Query(value = "select mid from Relation r where r.cid=?1")
    List<Long> findMidsByCid(Long cid);

    @Query(value = "select cid from Relation r where r.mid=?1")
    List<Long> findCidsByMid(Long mid);
}
