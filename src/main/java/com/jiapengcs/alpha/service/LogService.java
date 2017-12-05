package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.model.Log;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
public interface LogService {

    /**
     * get all error logs by paging query
     * @param pageable
     * @return
     */
    Page<Log> listAllLogsByPage(Pageable pageable);
}
