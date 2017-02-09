package com.springHello.service;

import com.springHello.bean.User;
import com.springHello.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by mar1 on 2/9/17.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public User findUserWithRoleById(Long id) {
        return userMapper.findUserWithRoleById(id);
    }
}
