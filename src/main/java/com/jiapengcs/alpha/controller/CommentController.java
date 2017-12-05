package com.jiapengcs.alpha.controller;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.exception.PermissionException;
import com.jiapengcs.alpha.model.Comment;
import com.jiapengcs.alpha.service.CommentService;
import com.jiapengcs.alpha.controller.wrapper.ResponseResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/24
 */
@RestController
@RequestMapping("/comment")
@EnableLog
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/test")
    public String test(@RequestParam() Comment comment, HttpServletRequest request) throws PermissionException {
        String string = "";
        System.out.println(string);
//        throw new PermissionException("Please login before this operation!");
        return "hello, world";
    }

    @RequestMapping("/get")
    @ResponseResultWrapper
    public Comment get(HttpServletRequest request) {
        Comment comment = new Comment(2L, "Jiapeng", "jiapeng@gmail.com", "http://jiapengcs.com",
                "127.0.0.1", "Chrome", "Nice article!", 0L, "public");
        return comment;
    }

    @RequestMapping("/page")
    @ResponseResultWrapper
    public Page<Comment> page(HttpServletRequest request) {
        PageRequest pageRequest = new PageRequest(0, 10);
        return commentService.listAllCommentsByPage(pageRequest);
    }

    @RequestMapping("/list")
    @ResponseResultWrapper
    public List<Comment> list(HttpServletRequest request) {
        return commentService.listAllComments();
    }

    @RequestMapping("/error")
    public void error(HttpServletRequest request) throws Exception {
        throw new Exception();
    }

    @RequestMapping("/exception")
    public void exception(@RequestParam String test, HttpServletRequest request) throws PermissionException {
        throw new PermissionException("permission exception");
    }

    @RequestMapping("/save")
    public Comment save(HttpServletRequest request) {
        Comment comment = new Comment(2L, "Jiapeng", "jiapeng@gmail.com", "http://jiapengcs.com",
                "127.0.0.1", "Chrome", "You are cool, man!", 0L, "public");
        return commentService.saveComment(comment);
    }
}
