package com.jiapengcs.alpha.service;

import com.alibaba.fastjson.JSONObject;
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

    /**
     * delete a content and its comments
     * @param cid
     */
    void deleteContent(Long cid);

    Content updateContent(Long cid, JSONObject params);

    Content getContent(Long cid);

    List<Content> listAllContents();

    Page<Content> listAllContentsByPage(Pageable pageable);

    List<Content> listContentsByCids(List<Long> cids);

    Page<Content> listContentsByCidsByPage(List<Long> cids, Pageable pageable);

    /**
     * increase hits number
     * @param cid
     */
    void increaseHits(Long cid);
}
