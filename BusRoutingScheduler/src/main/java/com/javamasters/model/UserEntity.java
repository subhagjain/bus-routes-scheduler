package com.javamasters.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author: subhag.jain
 * date: 11/12/23
 * project: BusRoutingScheduler
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users")
@Builder
public class UserEntity {
    @Id
    private String id;
    private String username;
    private String password;
    private boolean admin;
}
