package com.jiapengcs.alpha.dao;

import com.jiapengcs.alpha.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface CommentDAO extends Repository<Comment, Integer> {

    Comment findByVisitorName(String vistorName);
}
