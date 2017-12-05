package com.jiapengcs.alpha.service;

import com.jiapengcs.alpha.BlogAlphaApplicationTests;
import com.jiapengcs.alpha.model.User;
import com.jiapengcs.alpha.util.constant.Constants;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-5
 */
public class UserServiceTest extends BlogAlphaApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    @Transactional
    public void registerTest() throws IOException {
        File file = new File(Constants.LOCK_FILE);
        if (file.exists()) {
            Assert.assertTrue(file.delete());
        }
        User user = new User("jiapeng", "123456", "Jasper", "jiapeng@qq.com", "www.jiapengcs.com");
        userService.register(user);
        Assert.assertTrue(file.exists());
    }

    @Test
    public void loginTest() {
        Assert.assertFalse(userService.login("jiapeng", "123456789"));
        Assert.assertTrue(userService.login("jiapeng", "123456"));
    }
}
