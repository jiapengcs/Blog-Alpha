package com.jiapengcs.alpha.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-2
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {

    /**
     * insert or update a record, which depends on whether the record contains a primary key
     * @param record
     * @param <S>
     * @return
     */
    <S extends T> S save(S record);

    /**
     * insert or update a batch of records
     * @param records
     * @param <S>
     * @return
     */
    <S extends T> List<S> save(Iterable<S> records);

    /**
     * delete a record
     * @param id the primary key
     */
    void delete(ID id);

    /**
     * delete a batch of records
     * @param records
     */
    void delete(Iterable<? extends T> records);

    /**
     * select a record by the given id
     * @param id the primary key
     * @return
     */
    T findOne(ID id);

    /**
     * select all of the records
     * @return
     */
    List<T> findAll();

    /**
     * return all the records after sorting
     * @param sort the sorting rule
     * @return
     */
    List<T> findAll(Sort sort);

    /**
     * select records by the given batch of ids
     * @param ids the given batch of primary keys
     * @return
     */
    List<T> findAll(Iterable<ID> ids);

    /**
     * select all of the records by paging query(includes sorting query)
     * @param pageable
     * @return
     */
    Page<T> findAll(Pageable pageable);

    /**
     * determine whether the record for the given id exists
     * @param id the primary key
     * @return
     */
    boolean exists(ID id);

    /**
     * return the number of all records
     * @return
     */
    long count();
}
