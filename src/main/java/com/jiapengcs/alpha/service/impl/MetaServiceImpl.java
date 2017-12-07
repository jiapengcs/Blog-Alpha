package com.jiapengcs.alpha.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.exception.DataAccessException;
import com.jiapengcs.alpha.model.Meta;
import com.jiapengcs.alpha.repository.MetaRepository;
import com.jiapengcs.alpha.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/6
 */
@Service
@EnableLog
public class MetaServiceImpl implements MetaService {

    @Autowired
    private MetaRepository repository;

    @Override
    public Meta saveMeta(Meta meta) {
        Meta m = repository.findByMetaTypeAndMetaName(meta.getMetaType(), meta.getMetaName());
        if (m != null) {
            throw new DataAccessException("Meta already exists!");
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        meta.setCreateTime(timestamp);
        return repository.save(meta);
    }

    @Override
    public void deleteMeta(Long mid) {
        if (!repository.exists(mid)) {
            throw new DataAccessException("Meta does not exists!");
        }
        repository.delete(mid);
    }

    @Override
    public Meta updateMeta(Long mid, JSONObject params) {
        Meta meta = getMeta(mid);
        if (meta == null) {
            throw new DataAccessException("Meta does not exists!");
        }
        meta.setMetaName(params.getString("metaName"));
        return repository.save(meta);
    }

    @Override
    public Meta getMeta(Long mid) {
        return repository.findOne(mid);
    }

    @Override
    public List<Meta> listMetasByType(String metaType) {
        return repository.findAllByMetaType(metaType);
    }

    @Override
    public List<Meta> listMetasByMids(List<Long> mids) {
        return repository.findAll(mids);
    }
}
