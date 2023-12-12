package com.javamasters.service;

import com.javamasters.model.UserEntity;
import com.javamasters.request.AuthRequestDto;

/**
 * @Author: subhag.jain
 * date: 06/12/23
 * project: BusRoutingScheduler
 */
public interface UserService {
    UserEntity findAndValidateUser(AuthRequestDto username);

    UserEntity findByUsername(String username);
}
