package com.jiapengcs.alpha.service;

import com.alibaba.fastjson.JSONObject;
import com.jiapengcs.alpha.model.Attachment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface AttachmentService {

    Attachment saveAttachment(Attachment attachment);

    void deleteAttachment(Long fid);

    Attachment updateAttachment(Long fid, JSONObject params);

    Attachment getAttachment(Long fid);

    List<Attachment> listAllAttachments();

    Page<Attachment> listAllAttachmentsByPage(Pageable pageable);

    Long getFilesTotalSize();

    Long getFilesNumber();
}
