package com.jiapengcs.alpha.service.impl;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.model.Log;
import com.jiapengcs.alpha.repository.LogRepository;
import com.jiapengcs.alpha.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
@Service
@EnableLog
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository repository;

    @Override
    public Page<Log> listAllLogsByPage(Pageable pageable) {
        Page<Log> page = repository.findAll(pageable);
        return page;
    }
}
