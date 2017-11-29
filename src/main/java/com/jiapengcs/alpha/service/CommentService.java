package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.model.Comment;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface CommentService {

    Comment saveComment(Comment comment);

    void deleteComment(Integer coid);

    Comment updateComment(Comment comment);

    Comment getComment(Integer coid);

    List<Comment> getAllComment();
}
