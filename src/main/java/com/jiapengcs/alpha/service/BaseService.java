package com.jiapengcs.alpha.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/24
 */
public interface BaseService<T> {

    /**
     * insert or update a record
     * Spring Data JPA will automatically execute insert or update operation,
     * which depends on whether the record has the value of primary key.
     * @param record
     * @param <S>
     * @return
     */
    <S extends T> S save(S record);

    /**
     * insert or update a collection of records
     * @param records
     * @param <S>
     * @return
     */
    <S extends T> List<S> save(Iterable<S> records);

    /**
     * select single one record by id
     * @param id
     * @return
     */
    T findOne(Integer id);

    /**
     * check whether a record exists by id
     * @param id
     * @return
     */
    boolean exists(Integer id);

    /**
     * select all records(not recommended, consider paging query first)
     * @return
     */
    List<T> findAll();

    /**
     * select a batch of records by ids
     * @param ids
     * @return
     */
    List<T> findAll(Iterable<Integer> ids);

    /**
     * get the number of records
     * @return
     */
    long count();

    /**
     * delete a record by id
     * @param id
     */
    void delete(Integer id);

    /**
     * delete a record by the given instance
     * @param record
     */
    void delete(T record);

    /**
     * delete a batch of records by the given instances
     * @param records
     */
    void delete(Iterable<? extends T> records);

    /**
     * delete all records
     */
    void deleteAll();

    /**
     * return all the records after sorting
     * @param sort
     * @return
     */
    List<T> findAll(Sort sort);

    /**
     * paging query
     * @param pageable
     * @return
     */
    Page<T> findAll(Pageable pageable);
}
