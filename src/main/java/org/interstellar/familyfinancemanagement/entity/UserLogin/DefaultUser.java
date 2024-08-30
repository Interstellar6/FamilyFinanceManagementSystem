package org.interstellar.familyfinancemanagement.entity.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * @author interstellar
 */
public class DefaultUser {
    public static final List<User> DEFAULT_USERS;

    public static final User USER_NOT_FOUND=(new User("-1", "用户未找到", "未找到", false));
    public static final User USER_NOT_LOGIN=(new User("-2", "用户未登录", "未登录", false));
    public static final User USER_BLANK=(new User("-3", "用户账号密码不能为空", "账号或密码为空", false));
    public static final User USER_WRONG_PASSWORD=(new User("-4", "密码错误", "密码错误", false));

    static {
        DEFAULT_USERS = new ArrayList<>();
        DEFAULT_USERS.add(new User("0", "admin", "admin", true));
        DEFAULT_USERS.add(new User("1", "1", "1", false));
        DEFAULT_USERS.add(new User("2", "user2", "2", false));
        DEFAULT_USERS.add(new User("3", "user3", "3", false));
        DEFAULT_USERS.add(new User("4", "user4", "4", false));
        DEFAULT_USERS.add(new User("5", "zhang", "123456", false));
        DEFAULT_USERS.add(new User("6", "6", "123456", false));
        // 可以继续添加更多User对象

    }


}
