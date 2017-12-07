package com.jiapengcs.alpha.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.exception.DataAccessException;
import com.jiapengcs.alpha.model.Attachment;
import com.jiapengcs.alpha.repository.AttachmentRepository;
import com.jiapengcs.alpha.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/12/7
 */
@Service
@EnableLog
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentRepository repository;

    @Override
    public Attachment saveAttachment(Attachment attachment) {
        attachment.setUploadTime(new Timestamp(System.currentTimeMillis()));
        return repository.save(attachment);
    }

    @Override
    public void deleteAttachment(Long fid) {
        if (!repository.exists(fid)) {
            throw new DataAccessException("Attachment does not exist!");
        }
        repository.delete(fid);
    }

    @Override
    public Attachment updateAttachment(Long fid, JSONObject params) {
        Attachment attachment = repository.findOne(fid);
        if (attachment == null) {
            throw new DataAccessException("Attachment does not exist!");
        }
        attachment.setFileName(params.getString("fileName") != null ? params.getString("fileName") : attachment.getFileName());
        attachment.setFileType(params.getString("fileType") != null ? params.getString("fileType") : attachment.getFileType());
        return repository.save(attachment);
    }

    @Override
    public Attachment getAttachment(Long fid) {
        return repository.findOne(fid);
    }

    @Override
    public List<Attachment> listAllAttachments() {
        return repository.findAll();
    }

    @Override
    public Page<Attachment> listAllAttachmentsByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Long getFilesTotalSize() {
        List<Long> fileSizes = repository.findAllFileSizes();
        Long total = 0L;
        for (Long fileSize : fileSizes) {
            total += fileSize;
        }
        return total;
    }

    @Override
    public Long getFilesNumber() {
        return repository.count();
    }
}
