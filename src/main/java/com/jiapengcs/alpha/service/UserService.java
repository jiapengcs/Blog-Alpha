package com.jiapengcs.alpha.service;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface UserService {

    void register();

    void login(String username, String password);

    void logout();

    /**
     * whether the given username exists in database
     * called when register or login
     * @param username
     * @return
     */
    boolean exists(String username);
}
