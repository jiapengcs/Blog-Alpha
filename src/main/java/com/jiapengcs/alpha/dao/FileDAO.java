package com.jiapengcs.alpha.dao;

import com.jiapengcs.alpha.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface FileDAO extends JpaRepository<File, Integer> {
}
