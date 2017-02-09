package com.springHello.service;

import com.springHello.bean.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by mar1 on 2/9/17.
 */
public interface UserService extends UserDetailsService {
    List<User> findAllUser();
    User findUserWithRoleById(Long id);
    UserDetails findUserByUsername(String username);
}
