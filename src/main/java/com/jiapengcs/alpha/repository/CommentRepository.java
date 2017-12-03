package com.jiapengcs.alpha.repository;

import com.jiapengcs.alpha.model.Comment;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface CommentRepository extends BaseRepository<Comment, Long> {

    /**
     * find all comments of the given content, contains all root comments and each's child-comments.
     * @param cid the content id
     * @return
     */
    List<Comment> findAllByCid(Long cid);
}
