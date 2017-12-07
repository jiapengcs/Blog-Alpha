package com.jiapengcs.alpha.service;

import com.alibaba.fastjson.JSONObject;
import com.jiapengcs.alpha.model.Meta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface MetaService {

    Meta saveMeta(Meta meta);

    void deleteMeta(Long mid);

    Meta updateMeta(Long mid, JSONObject params);

    Meta getMeta(Long mid);

    List<Meta> listMetasByType(String metaType);

    List<Meta> listMetasByMids(List<Long> mids);
}
