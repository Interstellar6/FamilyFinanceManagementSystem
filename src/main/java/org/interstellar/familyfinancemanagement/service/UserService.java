package org.interstellar.familyfinancemanagement.service;


import cn.dev33.satoken.stp.StpUtil;
import org.interstellar.familyfinancemanagement.entity.Asset;
import org.interstellar.familyfinancemanagement.entity.Result;
import org.interstellar.familyfinancemanagement.entity.UserLogin.DefaultUser;
import org.interstellar.familyfinancemanagement.entity.UserLogin.User;
import org.interstellar.familyfinancemanagement.entity.UserLogin.UserSessionResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.interstellar.familyfinancemanagement.entity.UserLogin.DefaultUser.DEFAULT_USERS;
import static org.interstellar.familyfinancemanagement.entity.UserLogin.DefaultUser.USER_NOT_FOUND;

/**
 * @author interstellar
 */
public interface UserService {

    public boolean containUser(String username);

    public boolean containUser(String username, String password);

    public User getUserByUsername(String username);

    public User getUserById(String id);

    public User getUserByUsernameAndPassword(String username, String password);

    public Result<UserSessionResponse> login(String username, String password);


    @Transactional(rollbackFor = Exception.class)
    boolean addUser(User user);

    @Transactional(rollbackFor = Exception.class)
    User register(String username, String password, boolean isAdmin);

    @Transactional(rollbackFor = Exception.class)
    boolean updateUser(User user);

    @Transactional(rollbackFor = Exception.class)
    boolean deleteUser(Integer userId);

    User getUserById(Integer userId);

    List<User> getAllUsers();



}
