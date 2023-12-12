package com.javamasters.controller;

import com.javamasters.request.AuthRequestDto;
import com.javamasters.response.AuthResponse;
import com.javamasters.response.CoreResponseDto;
import com.javamasters.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: subhag.jain
 * date: 06/12/23
 * project: BusRoutingScheduler
 */
@RestController
public class AuthenticationController extends BaseController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/authenticate")
    public ResponseEntity<CoreResponseDto> createAuthenticationToken(@RequestBody AuthRequestDto authRequestDto) {
        final String jwt = authenticationService.generateToken(authRequestDto);
        return ResponseEntity.ok(AuthResponse.builder()
                .jwtToken(jwt)
                .operationSuccessful(true)
                .message("Authentication Successful!")
                .build());
    }

}
