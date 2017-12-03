package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.model.Content;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface ContentService {

    Content saveContent(Content content);

    void deleteContent(Long cid);

    Content updateContent(Content content);

    Content getContent(Long cid);

    List<Content> listAllContents();

    Page<Content> listAllContentsByPage(Pageable pageable);

    Page<Content> listContentsByMidByPage(Long mid, Pageable pageable);

    void setEditType(Long cid, String editType);

    void setStatus(Long cid, String status);
}
