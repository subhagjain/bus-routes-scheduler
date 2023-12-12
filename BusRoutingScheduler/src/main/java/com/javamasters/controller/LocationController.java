package com.javamasters.controller;

import com.javamasters.model.LocationEntity;
import com.javamasters.service.LocationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: subhag.jain
 * date: 12/12/23
 * project: BusRoutingScheduler
 */

@RestController
public class LocationController extends BaseController {
    @Autowired
    LocationService locationService;

    @GetMapping("/locations")
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<List<LocationEntity>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }
}
