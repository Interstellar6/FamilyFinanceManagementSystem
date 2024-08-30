package org.interstellar.familyfinancemanagement.controller;

import org.interstellar.familyfinancemanagement.entity.UserLogin.User;
import org.interstellar.familyfinancemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    public UserService userService;

    @GetMapping("/hello")
    public String hello(){
        System.out.println("Hello");
        return "hello";
    }

    @GetMapping("get-user")
    public List<User> getUser(){
        List<User>  users = userService.getAllUsers();
        System.out.println(users);
        return users;
    }


}

