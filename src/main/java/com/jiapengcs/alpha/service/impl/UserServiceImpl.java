package com.jiapengcs.alpha.service.impl;

import com.jiapengcs.alpha.aspect.log.EnableLog;
import com.jiapengcs.alpha.exception.AuthException;
import com.jiapengcs.alpha.exception.PermissionException;
import com.jiapengcs.alpha.model.User;
import com.jiapengcs.alpha.repository.UserRepository;
import com.jiapengcs.alpha.service.UserService;
import com.jiapengcs.alpha.util.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 17-12-5
 */
@Service
@EnableLog
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public void register(User user) throws IOException {
        if (registered()) {
            throw new AuthException("You have already registered!");
        } else {
            generateRegisterLock();
        }
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        user.setCreateTime(timestamp);
        user.setUserRole(Constants.USER_ROLE_ADMIN);
        repository.save(user);
    }

    @Override
    public boolean login(String username, String password) {
        User user = repository.findByUsernameAndPassword(username, password);
        if (user != null) {
            // set login time
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            user.setLastLogin(timestamp);
            repository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public void logout() {
    }

    @Override
    public boolean exists(String username) {
        User user = repository.findByUsername(username);
        return (user != null);
    }

    /**
     * whether or not registered
     * A lock file named "register.lock" will generated in root path after register, which could avoid duplicate register.
     * If we forget password, just remove this file and register again.
     * @return
     */
    private boolean registered() {
        File file = new File(Constants.LOCK_FILE);
        return file.exists();
    }

    /**
     * generate "register.lock" in root path to avoid duplicate register
     */
    private void generateRegisterLock() throws IOException {
        FileWriter writer = new FileWriter(Constants.LOCK_FILE);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        writer.write(String.format("Blog Alpha\nTimestamp: %s\n", timestamp));
        writer.write(Constants.LOCK_INFO);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        UserServiceImpl userService = new UserServiceImpl();
        userService.generateRegisterLock();
    }
}
