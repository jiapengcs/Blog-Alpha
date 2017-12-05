package com.jiapengcs.alpha.repository;

import com.jiapengcs.alpha.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Jiapeng
 * @version V1.0
 * date: 2017/11/23
 */
public interface UserRepository extends BaseRepository<User, Long> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);
}
