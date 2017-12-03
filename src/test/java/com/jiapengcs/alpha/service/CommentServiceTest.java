package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.BlogAlphaApplicationTests;
import com.jiapengcs.alpha.exception.DataAccessException;
import com.jiapengcs.alpha.model.Comment;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-1
 */
public class CommentServiceTest extends BlogAlphaApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentServiceTest.class);

    @Autowired
    private CommentService commentService;

    @Test
    @Transactional
    public void saveCommentTest() {
        Comment comment = new Comment(2L, "Jiapeng", "jiapeng@gmail.com", "http://jiapengcs.com",
                "127.0.0.1", "Chrome", "Nice article!", 0L, "public");
        Comment newComment = commentService.saveComment(comment);
        Assert.assertTrue(newComment != null);
    }

    @Test
    @Transactional
    public void deleteCommentTest() throws DataAccessException {
        commentService.deleteComment(2L);
    }

    @Test
    public void updateCommentTest() {
        Comment comment = commentService.getComment(2L);
        Comment newComment = commentService.updateComment(comment);
        Assert.assertTrue(newComment != null);
    }

    @Test
    public void getCommentTest() {
        Comment comment = commentService.getComment(2L);
        Assert.assertTrue(comment != null);
    }

    @Test
    public void listAllCommentsTest() {
        List<Comment> comments = commentService.listAllComments();
        Assert.assertTrue(comments != null);
    }

    @Test
    public void listAllCommentsByPageTest() {
        Pageable pageable = new PageRequest(2, 2);
        Page<Comment> page = commentService.listAllCommentsByPage(pageable);
        Assert.assertTrue(page != null);
    }

    @Test
    public void listCommentsOfContentTest() throws DataAccessException {
        List<Comment> comments = commentService.listCommentsOfContent(2L);
        Assert.assertTrue(comments != null);
    }
}
