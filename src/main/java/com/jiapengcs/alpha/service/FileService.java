package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.model.File;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface FileService {

    File saveFile(File file);

    void deleteFile(Long fid);

    File updateFile(File file);

    void getFile(Long fid);

    List<File> listAllFiles();

    Page<File> listAllFilesByPage(Pageable pageable);
}
