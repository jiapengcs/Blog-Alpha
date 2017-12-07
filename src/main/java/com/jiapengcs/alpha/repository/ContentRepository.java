package com.jiapengcs.alpha.repository;

import com.jiapengcs.alpha.model.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface ContentRepository extends BaseRepository<Content, Long> {

    /**
     * increase hits number
     * @param cid
     */
    @Modifying
    @Transactional
    @Query(value = "update Content c set c.hits=c.hits+1 where c.cid=?1")
    void increaseHits(Long cid);

    Content findByContentKey(String contentKey);
}
