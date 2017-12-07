package com.jiapengcs.alpha.repository;

import com.jiapengcs.alpha.model.Meta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface MetaRepository extends BaseRepository<Meta, Long> {

    Meta findByMetaTypeAndMetaName(String metaType, String metaName);

    List<Meta> findAllByMetaType(String metaType);
}
