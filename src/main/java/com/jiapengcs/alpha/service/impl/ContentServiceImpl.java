package com.jiapengcs.alpha.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.exception.DataAccessException;
import com.jiapengcs.alpha.model.Content;
import com.jiapengcs.alpha.repository.CommentRepository;
import com.jiapengcs.alpha.repository.ContentRepository;
import com.jiapengcs.alpha.service.ContentService;
import com.jiapengcs.alpha.util.random.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-6
 */
@Service
@EnableLog
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentRepository repository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Content saveContent(Content content) {
        String contentKey;
        do {
            contentKey = RandomUtil.getRandomString(16);
        } while (repository.findByContentKey(contentKey) != null);
        content.setContentKey(contentKey);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        content.setCreateTime(timestamp);
        content.setUpdateTime(timestamp);
        content.setHits(0);
        return repository.save(content);
    }

    @Override
    public void deleteContent(Long cid) {
        if (!repository.exists(cid)) {
            throw new DataAccessException("Content does not exist!");
        }
        repository.delete(cid);
        commentRepository.deleteAllByCid(cid);
    }

    @Override
    public Content updateContent(Long cid, JSONObject params) {
        Content temp = getContent(cid);
        if (temp == null) {
            throw new DataAccessException("Content does not exists!");
        }
        temp.setTitle(params.getString("title") != null ? params.getString("title") : temp.getTitle());
        temp.setThumbImage(params.getString("thumbImage") != null ? params.getString("thumbImage") : temp.getThumbImage());
        temp.setContent(params.getString("content") != null ? params.getString("content") : temp.getContent());
        temp.setEditType(params.getString("editType") != null ? params.getString("editType") : temp.getEditType());
        temp.setFormat(params.getString("format") != null ? params.getString("format") : temp.getFormat());
        temp.setStatus(params.getString("status") != null ? params.getString("status") : temp.getStatus());
        temp.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return repository.save(temp);
    }

    @Override
    public Content getContent(Long cid) {
        return repository.findOne(cid);
    }

    @Override
    public List<Content> listAllContents() {
        return repository.findAll();
    }

    @Override
    public Page<Content> listAllContentsByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Content> listContentsByCids(List<Long> cids) {
        return repository.findAll(cids);
    }

    @Override
    public Page<Content> listContentsByCidsByPage(List<Long> cids, Pageable pageable) {
        Specification<Content> specification = new Specification<Content>() {
            @Override
            public Predicate toPredicate(Root<Content> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.in(root.get("cid")).value(cids);
            }
        };
        return repository.findAll(specification, pageable);
    }

    @Override
    public void increaseHits(Long cid) {
        repository.increaseHits(cid);
    }
}
