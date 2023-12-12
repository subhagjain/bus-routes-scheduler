package com.javamasters.controller;

import com.javamasters.request.RouteRequestDto;
import com.javamasters.response.CoreResponseDto;
import com.javamasters.service.RouteService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: subhag.jain
 * date: 03/12/23
 * project: BusRoutingScheduler
 */

@RestController
public class RouteController extends BaseController {

    @Autowired
    RouteService routeService;

    @PostMapping("/route")
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<CoreResponseDto> createRoute(@Valid @RequestBody RouteRequestDto route) {
        return ResponseEntity.ok(routeService.createRoute(route));

    }

    @GetMapping("/route/{id}")
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<CoreResponseDto> getRoute(String id) {

        return ResponseEntity.ok(routeService.getRoute(id));

    }

    @PutMapping("/route/{id}")
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<CoreResponseDto> updateRoute(String id, @RequestBody @Valid RouteRequestDto route) {
        return ResponseEntity.ok(routeService.updateRoute(id, route));

    }

    @DeleteMapping("/route/{id}")
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<CoreResponseDto> deleteRoute(String id) {

        return ResponseEntity.ok(routeService.deleteRoute(id));

    }

    @GetMapping("/route")
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<CoreResponseDto> getAllRoutesOfBus(@RequestParam String busRegNumber) {

        return ResponseEntity.ok(routeService.getAllRoutesOfBus(busRegNumber));

    }

}
