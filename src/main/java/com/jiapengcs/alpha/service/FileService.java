package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.model.File;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface FileService {

    File upload(File file);

    void download(Integer fid);

    String getFilePath(Integer fid);

    void deleteFile();
}
