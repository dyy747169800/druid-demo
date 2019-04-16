package com.example.druid.demo.service.impl;

import com.example.druid.demo.base.service.impl.BaseServiceImpl;
import com.example.druid.demo.dao.UserDao;
import com.example.druid.demo.domain.User;
import com.example.druid.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 段杨宇
 * @create 2019-04-16 16:04
 **/
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao,User> implements UserService {

}
