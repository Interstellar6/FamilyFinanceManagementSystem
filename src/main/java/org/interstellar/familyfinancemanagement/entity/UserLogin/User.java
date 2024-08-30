package org.interstellar.familyfinancemanagement.entity.entity;

import cn.dev33.satoken.stp.StpUtil;
import lombok.Data;

import static org.interstellar.satokenlearn.entity.DefaultUser.DEFAULT_USERS;
import static org.interstellar.satokenlearn.entity.DefaultUser.USER_NOT_FOUND;

/**
 * @author interstellar
 */
@Data
public class User {

    private String id;
    private String username;
    private String password;
    private boolean isAdmin;


    public User(String id, String username, String password ,boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public static boolean containUser(String username) {
        for (User user : DEFAULT_USERS) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containUser(String username, String password) {
        for (User user : DEFAULT_USERS) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static User getUserByUsername(String username) {
        for (User user : DEFAULT_USERS) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return USER_NOT_FOUND;
    }

    public static User getUserById(String id) {
        for (User user : DEFAULT_USERS) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return USER_NOT_FOUND;
    }


    public static User getUserByUsernameAndPassword(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return DefaultUser.USER_BLANK;
        }

        else if (!User.containUser(username)) {
            return DefaultUser.USER_NOT_FOUND;
        }

        else if (!User.containUser(username,password)) {
            return DefaultUser.USER_WRONG_PASSWORD;
        }

        else{
            StpUtil.login(username);
            return User.getUserByUsername(username);
        }
    }


}
