package com.jiapengcs.alpha.service.impl;

import com.jiapengcs.alpha.dao.CommentDAO;
import com.jiapengcs.alpha.model.Comment;
import com.jiapengcs.alpha.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/24
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {

    @Autowired
    private CommentDAO commentDAO;

    @Override
    public Comment findByVistorName(String vistorName) {
        return commentDAO.findByVisitorName(vistorName);
    }
}
