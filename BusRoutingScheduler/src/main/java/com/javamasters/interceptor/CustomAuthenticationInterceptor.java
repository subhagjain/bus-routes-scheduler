package com.javamasters.interceptor;

import com.javamasters.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Author: subhag.jain
 * date: 11/12/23
 * project: BusRoutingScheduler
 */
@Component
public class CustomAuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    AuthenticationService authenticationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        authenticationService.isAuthenticated(request);
        return true;
    }
}
