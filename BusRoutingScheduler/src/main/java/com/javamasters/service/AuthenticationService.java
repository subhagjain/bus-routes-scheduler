package com.javamasters.service;

import com.javamasters.request.AuthRequestDto;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @Author: subhag.jain
 * date: 06/12/23
 * project: BusRoutingScheduler
 */
public interface AuthenticationService {
    String generateToken(AuthRequestDto authRequestDto);

    void isAuthenticated(HttpServletRequest request);
}
