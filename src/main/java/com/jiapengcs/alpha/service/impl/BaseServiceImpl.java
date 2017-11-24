package com.jiapengcs.alpha.service.impl;

import com.jiapengcs.alpha.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

//    @Autowired
    private JpaRepository<T, Integer> baseDAO;

    @Override
    public <S extends T> S save(S record) {
        return baseDAO.save(record);
    }

    @Override
    public <S extends T> List<S> save(Iterable<S> records) {
        return baseDAO.save(records);
    }

    @Override
    public T findOne(Integer id) {
        return baseDAO.findOne(id);
    }

    @Override
    public boolean exists(Integer id) {
        return baseDAO.exists(id);
    }

    @Override
    public List<T> findAll() {
        return baseDAO.findAll();
    }

    @Override
    public List<T> findAll(Iterable<Integer> ids) {
        return baseDAO.findAll(ids);
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void delete(T record) {

    }

    @Override
    public void delete(Iterable<? extends T> records) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<T> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return null;
    }
}
