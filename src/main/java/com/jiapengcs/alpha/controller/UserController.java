package com.jiapengcs.alpha.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.controller.wrapper.ResponseResultWrapper;
import com.jiapengcs.alpha.exception.AuthException;
import com.jiapengcs.alpha.model.User;
import com.jiapengcs.alpha.service.impl.UserServiceImpl;
import com.jiapengcs.alpha.util.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
@RestController
@EnableLog
@ResponseResultWrapper
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public void register(@RequestBody User user, HttpServletRequest request) throws IOException {
        userService.register(user);
    }

    @PostMapping("/login")
    public void login(@RequestBody JSONObject user, HttpServletRequest request) {
        String username = user.getString("username");
        String password = user.getString("password");
        if (userService.login(username, password)) {
            HttpSession session = request.getSession();
            session.setAttribute(Constants.SESSION_ADMIN, username);
        } else {
            throw new AuthException("Check your username and password!");
        }
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute(Constants.SESSION_ADMIN);
    }
}
