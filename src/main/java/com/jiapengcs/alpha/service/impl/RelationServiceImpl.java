package com.jiapengcs.alpha.service.impl;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.exception.DataAccessException;
import com.jiapengcs.alpha.model.Relation;
import com.jiapengcs.alpha.repository.RelationRepository;
import com.jiapengcs.alpha.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-7
 */
@Service
@EnableLog
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationRepository repository;

    @Override
    public Relation saveRelation(Relation relation) {
        if (exists(relation.getCid(), relation.getMid())) {
            throw new DataAccessException("Relation already exists!");
        }
        return repository.save(relation);
    }

    @Override
    public void deleteRelation(Long rid) {
        if (!repository.exists(rid)) {
            throw new DataAccessException("Relation does not exist!");
        }
        repository.delete(rid);
    }

    @Override
    public boolean exists(Long cid, Long mid) {
        Relation relation = repository.findByCidAndMid(cid, mid);
        return (relation != null);
    }

    @Override
    public List<Long> listMidsByCid(Long cid) {
        return repository.findMidsByCid(cid);
    }

    @Override
    public List<Long> listCidsByMid(Long mid) {
        return repository.findCidsByMid(mid);
    }
}
