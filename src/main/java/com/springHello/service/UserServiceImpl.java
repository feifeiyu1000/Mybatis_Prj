package com.springHello.service;

import com.springHello.bean.User;
import com.springHello.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mar1 on 2/9/17.
 */
@Service
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

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user =  userMapper.loadUserByUsername(username);
        if(user == null) throw new UsernameNotFoundException("User not found");
        return user;
    }
}
