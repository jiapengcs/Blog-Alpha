package com.jiapengcs.alpha.service.impl;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.service.FileTransferService;
import org.springframework.stereotype.Service;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/7
 */
@Service
@EnableLog
public class LocalFileTransferServiceImpl implements FileTransferService {

    @Override
    public String upload() {
        return null;
    }

    @Override
    public void download() {

    }
}
