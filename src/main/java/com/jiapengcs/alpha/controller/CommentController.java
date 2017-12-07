package com.jiapengcs.alpha.controller;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.exception.ParameterException;
import com.jiapengcs.alpha.model.Comment;
import com.jiapengcs.alpha.service.CommentService;
import com.jiapengcs.alpha.controller.wrapper.ResponseResultWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/24
 */
@RestController
@EnableLog
@ResponseResultWrapper
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/comment")
    public Comment save(@RequestBody Comment comment, HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");
        comment.setVisitorIp(ip);
        comment.setUserAgent(userAgent);
        return commentService.saveComment(comment);
    }

    @DeleteMapping("/comment/{coid}")
    public void delete(@PathVariable Long coid, HttpServletRequest request) {
        commentService.deleteComment(coid);
    }

    @GetMapping("/comment/{coid}")
    public Comment get(@PathVariable Long coid, HttpServletRequest request) {
        return commentService.getComment(coid);
    }

    @GetMapping("/comment")
    public List<Comment> list() {
        return commentService.listAllComments();
    }

    @GetMapping("/comment/page")
    public Page<Comment> page(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, HttpServletRequest request) {
        PageRequest pageRequest = new PageRequest(page, size);
        return commentService.listAllCommentsByPage(pageRequest);
    }
}
