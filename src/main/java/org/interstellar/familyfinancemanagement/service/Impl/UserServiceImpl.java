package org.interstellar.familyfinancemanagement.service.Impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.interstellar.familyfinancemanagement.entity.Result;
import org.interstellar.familyfinancemanagement.entity.UserLogin.User;
import org.interstellar.familyfinancemanagement.entity.UserLogin.UserSessionResponse;
import org.interstellar.familyfinancemanagement.mapper.UserMapper;
import org.interstellar.familyfinancemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author interstellar
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean containUser(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return this.userMapper.selectCount(queryWrapper) > 0;
    }

    @Override
    public boolean containUser(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).eq("password", password);
        return this.userMapper.selectCount(queryWrapper) > 0;
    }

    @Override
    public User getUserByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return this.userMapper.selectOne(queryWrapper);
    }

    @Override
    public User getUserById(String id) {
        return this.userMapper.selectById(id);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username).eq("password", password);
        return this.userMapper.selectOne(queryWrapper);
    }

    @Override
    public Result<UserSessionResponse> login(String username, String password) {
        User user = getUserByUsernameAndPassword(username,password);
        if(user.getId()>=0){
            StpUtil.login(username);
            UserSessionResponse userSessionResponse = new UserSessionResponse(StpUtil.getTokenValue(), user.getId(), username, user.isAdmin());
            return Result.success(userSessionResponse);
        } else {
            UserSessionResponse userSessionResponse = new UserSessionResponse("-1", user.getId(), username,
                    user.getId(), user.isAdmin(),
                    user.getUsername());
            return Result.fail(user.getUsername());
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User register(String username, String password, boolean isAdmin) {
        User user = getUserByUsername(username);
        if (user != null ) {
            throw new RuntimeException("User already exists");
        }

        user = new User(username, password, isAdmin);
        userMapper.insert(user);
        return getUserByUsernameAndPassword(username,password);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(User user) {
        return userMapper.updateById(user) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteUser(Integer userId) {
        return userMapper.deleteById(userId) > 0;
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public List<User> getAllUsers(){
        // 从数据库中得到所有用户信息
        return userMapper.selectList(null);
    }


}
