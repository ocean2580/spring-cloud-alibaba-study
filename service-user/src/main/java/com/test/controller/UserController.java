package com.test.controller;


import com.test.User;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@RefreshScope   //添加此注解就能实现自动刷新了
public class UserController {

    @Resource
    private UserService userService;

    @Value("${text.txt}")
    private String txt;

    @GetMapping("/txt")
    public String getTxt() {

        return this.txt;
    }

    @GetMapping("/{uid}")
    public User findUserById(@PathVariable("uid") int uid) {

        return userService.getUserById(uid);
    }

    @RequestMapping("/remain/{uid}")
    public int userRemain(@PathVariable("uid") int uid){
        return userService.getRemain(uid);
    }

    @RequestMapping("/borrow/{uid}")
    public boolean userBorrow(@PathVariable("uid") int uid){
        int remain = userService.getRemain(uid);
        return userService.setRemain(uid, remain - 1);
    }

}
