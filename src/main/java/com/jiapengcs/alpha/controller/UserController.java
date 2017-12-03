package com.jiapengcs.alpha.controller;

import com.jiapengcs.alpha.interceptor.LoginBean;
import com.jiapengcs.alpha.util.constant.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-3
 */
@RestController
@RequestMapping("/admin")
public class UserController {

    @RequestMapping("/login")
    public void login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        System.out.println("****** login ******");
        session.setAttribute(Constants.SESSION_ADMIN, new LoginBean(username, password));
    }

    @RequestMapping("/logout")
    public void logout(HttpSession session) {
        System.out.println("****** logout ******");
        session.removeAttribute(Constants.SESSION_ADMIN);
    }

    @RequestMapping("/index")
    public LoginBean index(HttpSession session) {
        System.out.println("****** index ******");
        LoginBean loginBean = (LoginBean) session.getAttribute(Constants.SESSION_ADMIN);
        System.out.println(loginBean);
        return loginBean;
    }
}
