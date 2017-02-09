package com.springHello.service;

import com.springHello.bean.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * Created by mar1 on 2/9/17.
 */
public interface UserService {
    List<User> findAllUser();
    User findUserWithRoleById(Long id);
    UserDetails loadUserByUsername(String username);
}
