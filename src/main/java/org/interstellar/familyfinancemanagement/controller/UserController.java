package org.interstellar.familyfinancemanagement.controller;

import org.interstellar.familyfinancemanagement.entity.Result;
import org.interstellar.familyfinancemanagement.entity.UserLogin.User;
import org.interstellar.familyfinancemanagement.entity.UserLogin.UserSessionResponse;
import org.interstellar.familyfinancemanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(originPatterns = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("get-user")
    public List<User> getUser(){
        List<User> users = userService.getAllUsers();
        System.out.println(users);
        return users;
    }

    @GetMapping("/login")
    public Result<UserSessionResponse> login(@RequestParam String username, @RequestParam String password) {
        System.err.println(username + password);

        return userService.login(username, password);
    }

    @PostMapping("/login")
    public Result<UserSessionResponse> login2(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @PostMapping("/register")
    public User register(@RequestParam String username, @RequestParam String password, @RequestParam boolean isAdmin) {
        return userService.register(username, password, isAdmin);
    }

    @PostMapping("/add")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/update")
    public boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PostMapping("/delete")
    public boolean deleteUser(@RequestParam Integer userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping("/getById/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }
}
