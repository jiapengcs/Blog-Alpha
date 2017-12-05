package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.model.User;

import java.io.IOException;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface UserService {

    /**
     * the blog system currently supports single-user only
     */
    void register(User user) throws IOException;

    /**
     * check username and password, then set session
     * @param username
     * @param password
     */
    boolean login(String username, String password);

    /**
     * remove session
     */
    void logout();

    /**
     * whether the given username exists in database
     * called when register or login
     * @param username
     * @return
     */
    boolean exists(String username);
}
