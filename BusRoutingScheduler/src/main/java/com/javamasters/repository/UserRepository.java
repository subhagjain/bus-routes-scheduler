package com.javamasters.repository;

import com.javamasters.model.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author: subhag.jain
 * date: 11/12/23
 * project: BusRoutingScheduler
 */
@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
    Optional<UserEntity> findByUsername(String username);
}
