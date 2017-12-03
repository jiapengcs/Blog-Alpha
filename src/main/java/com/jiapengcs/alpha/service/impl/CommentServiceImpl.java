package com.jiapengcs.alpha.service.impl;

import com.jiapengcs.alpha.aspect.email.EnableEmail;
import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.exception.DataAccessException;
import com.jiapengcs.alpha.repository.CommentRepository;
import com.jiapengcs.alpha.model.Comment;
import com.jiapengcs.alpha.repository.ContentRepository;
import com.jiapengcs.alpha.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/24
 */
@Service
@EnableLog
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository repository;

    @Autowired
    private ContentRepository contentRepository;

    @EnableEmail
    @Override
    public Comment saveComment(Comment comment) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        comment.setCreateTime(timestamp);
        comment.setUpdateTime(timestamp);
        return repository.save(comment);
    }

    @Override
    public void deleteComment(Long coid) throws DataAccessException {
        if (!repository.exists(coid)) {
            throw new DataAccessException("Comment does not exist!");
        }
        repository.delete(coid);
    }

    @Override
    public Comment updateComment(Comment comment) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        comment.setUpdateTime(timestamp);
        return repository.save(comment);
    }

    @Override
    public Comment getComment(Long coid) {
        return repository.findOne(coid);
    }

    @Override
    public List<Comment> listAllComments() {
        return repository.findAll();
    }

    @Override
    public Page<Comment> listAllCommentsByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Comment> listCommentsOfContent(Long cid) throws DataAccessException {
        if (!contentRepository.exists(cid)) {
            throw new DataAccessException("Query comments failed, content does not exist!");
        }
        return repository.findAllByCid(cid);
    }
}
