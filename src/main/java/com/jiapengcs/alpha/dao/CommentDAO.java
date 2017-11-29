package com.jiapengcs.alpha.dao;

import com.jiapengcs.alpha.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface CommentDAO extends JpaRepository<Comment, Integer> {

    Comment findByVisitorName(String vistorName);
}
