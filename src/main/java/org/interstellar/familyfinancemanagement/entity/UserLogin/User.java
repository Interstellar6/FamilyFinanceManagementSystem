package org.interstellar.familyfinancemanagement.entity.UserLogin;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import static org.interstellar.familyfinancemanagement.entity.UserLogin.DefaultUser.DEFAULT_USERS;
import static org.interstellar.familyfinancemanagement.entity.UserLogin.DefaultUser.USER_NOT_FOUND;


/**
 * @author interstellar
 */
@AllArgsConstructor
@Data
@TableName("user")
public class User {

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private boolean isAdmin;
    private Integer familyMemberId;


    public User(Integer id, String username, String password ,boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.familyMemberId =null;
    }

    public User(String username, String password, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }


    public static boolean containDefaultUser(String username) {
        for (User user : DEFAULT_USERS) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containDefaultUser(String username, String password) {
        for (User user : DEFAULT_USERS) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static User getDefaultUserByUsername(String username) {
        for (User user : DEFAULT_USERS) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return USER_NOT_FOUND;
    }

    public static User getDefaultUserById(Integer id) {
        for (User user : DEFAULT_USERS) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return USER_NOT_FOUND;
    }

    public static User getDefaultUserByUsernameAndPassword(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return DefaultUser.USER_BLANK;
        }

        else if (!User.containDefaultUser(username)) {
            return USER_NOT_FOUND;
        }

        else if (!User.containDefaultUser(username,password)) {
            return DefaultUser.USER_WRONG_PASSWORD;
        }

        else{
            StpUtil.login(username);
            return User.getDefaultUserByUsername(username);
        }
    }


}
