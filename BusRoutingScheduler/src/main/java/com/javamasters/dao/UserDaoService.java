package com.javamasters.dao;

import com.javamasters.model.UserEntity;

/**
 * @Author: subhag.jain
 * date: 11/12/23
 * project: BusRoutingScheduler
 */
public interface UserDaoService {
    UserEntity findByUsername(String username);
}
