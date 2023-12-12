package com.javamasters.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author: subhag.jain
 * date: 06/12/23
 * project: BusRoutingScheduler
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AuthResponse extends CoreResponseDto {
    private String jwtToken;
}
