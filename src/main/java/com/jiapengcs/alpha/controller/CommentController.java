package com.jiapengcs.alpha.controller;

import com.jiapengcs.alpha.model.Comment;
import com.jiapengcs.alpha.service.CommentService;
import com.jiapengcs.alpha.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    public List<Comment> findAll() {
        return commentService.get();
    }
}
