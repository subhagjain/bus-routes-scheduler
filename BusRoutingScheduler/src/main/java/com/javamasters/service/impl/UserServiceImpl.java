package com.javamasters.service.impl;

import com.javamasters.dao.UserDaoService;
import com.javamasters.exceptions.AuthenticationException;
import com.javamasters.model.UserEntity;
import com.javamasters.request.AuthRequestDto;
import com.javamasters.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: subhag.jain
 * date: 06/12/23
 * project: BusRoutingScheduler
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDaoService userDaoService;

    @Override
    public UserEntity findAndValidateUser(AuthRequestDto authRequestDto) {
        UserEntity userEntity = userDaoService.findByUsername(authRequestDto.getUsername());
        if (userEntity.getPassword().equals(authRequestDto.getPassword())) {
            return userEntity;
        }
        throw new AuthenticationException("Invalid username/password supplied");
    }

    public UserEntity findByUsername(String username) {
        return userDaoService.findByUsername(username);
    }
}