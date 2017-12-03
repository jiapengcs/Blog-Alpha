package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.model.Meta;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface MetaService {

    Meta saveMeta(Meta meta);

    void deleteMeta(Long mid);

    Meta updateMeta(Meta meta);

    Meta getMeta(Long mid);

    List<Meta> listAllMetas();

    List<Meta> listMetasByType(String metaType);

    List<Meta> listMetasByCid(Long cid);
}
