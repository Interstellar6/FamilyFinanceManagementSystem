package org.interstellar.familyfinancemanagement.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.interstellar.familyfinancemanagement.entity.UserLogin.User;
import org.interstellar.familyfinancemanagement.entity.UserLogin.UserSessionResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/default-user/")
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class DefaultLoginController {

    // 测试登录，浏览器访问： http://192.168.188.8:8080/login?username=1&password=1
    @GetMapping("login")
    public UserSessionResponse login(String username, String password) {
        User user = User.getDefaultUserByUsernameAndPassword(username,password);
        if(user.getId()>=0){
            StpUtil.login(username);
            return new UserSessionResponse(StpUtil.getTokenValue(),user.getId(), username, user.isAdmin());
        } else {
            return new UserSessionResponse("-1",user.getId(), username,
                    user.getId(),  user.isAdmin(),
                    user.getUsername());
        }

    }

    // 测试登录，浏览器访问： http://192.168.188.8:8080/login?username=1&password=1
    @PostMapping("login")
    public UserSessionResponse login2(String username, String password) {
        User user = User.getDefaultUserByUsernameAndPassword(username,password);
        if(user.getId()>=0){
            StpUtil.login(username);
            return new UserSessionResponse(StpUtil.getTokenValue(),user.getId(),username, user.isAdmin());
        } else {
            return new UserSessionResponse("-1",user.getId(), username,
                    user.getId()
                    , user.isAdmin(), user.getUsername());
        }

    }

}
