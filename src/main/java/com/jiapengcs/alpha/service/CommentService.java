package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.exception.DataAccessException;
import com.jiapengcs.alpha.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface CommentService {

    Comment saveComment(Comment comment);

    void deleteComment(Long coid) throws DataAccessException;

    Comment updateComment(Comment comment);

    Comment getComment(Long coid);

    List<Comment> listAllComments();

    /**
     * return all comments by paging query
     * @param pageable pageable params, include page(start from 0) and size,
     *                 eg: (0, 10) means return 10 pieces of data of first page.
     * @return
     */
    Page<Comment> listAllCommentsByPage(Pageable pageable);

    /**
     * return all comments of the given content, contains all root comments and each's child-comments.
     * @param cid the content id
     * @return
     */
    List<Comment> listCommentsOfContent(Long cid) throws DataAccessException;
}
