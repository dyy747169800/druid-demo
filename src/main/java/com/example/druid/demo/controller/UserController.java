package com.example.druid.demo.controller;

import com.example.druid.demo.domain.User;
import com.example.druid.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 段杨宇
 * @create 2019-04-16 19:03
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list(){
        return userService.selectList(null);
    }
}
