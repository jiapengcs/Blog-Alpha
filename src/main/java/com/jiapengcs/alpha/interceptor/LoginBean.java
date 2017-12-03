package com.jiapengcs.alpha.interceptor;

import java.io.Serializable;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
public class LoginBean implements Serializable {

    private String username;

    private String password;

    public LoginBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
