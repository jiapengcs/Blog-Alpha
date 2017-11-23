package com.jiapengcs.alpha.service.impl;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public abstract class BaseService {

    private JpaRepository baseDAO;

    public List get() {
        return baseDAO.findAll();
    }
}
