package com.springHello.mapper;

import com.springHello.bean.User;

import java.util.List;

/**
 * Created by root on 1/26/17.
 */
public interface UserMapper {
    List<User> findAllUser();
}
