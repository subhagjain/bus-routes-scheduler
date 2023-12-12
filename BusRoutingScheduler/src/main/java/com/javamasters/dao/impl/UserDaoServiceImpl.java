package com.javamasters.dao.impl;

import com.javamasters.dao.UserDaoService;
import com.javamasters.exceptions.RecordNotFoundException;
import com.javamasters.model.UserEntity;
import com.javamasters.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: subhag.jain
 * date: 11/12/23
 * project: BusRoutingScheduler
 */

@Service
public class UserDaoServiceImpl implements UserDaoService {
    public static final String ADMIN = "admin";
    public static final String USER = "user";

    @Autowired
    UserRepository userRepository;

    public UserDaoServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        if (userRepository.findByUsername(ADMIN).isEmpty())
            userRepository.save(UserEntity.builder().username(ADMIN).password(ADMIN).admin(true).build());
        if (userRepository.findByUsername(USER).isEmpty())
            userRepository.save(UserEntity.builder().username(USER).password(USER).admin(false).build());
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RecordNotFoundException("User with username " + username + " not found"));
    }
}
