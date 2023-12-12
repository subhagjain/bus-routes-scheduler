package com.javamasters.controller;

import com.javamasters.request.BusRequestDto;
import com.javamasters.response.CoreResponseDto;
import com.javamasters.service.BusService;
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
public class BusController extends BaseController {

    @Autowired
    private BusService busService;

    @PostMapping("/bus")
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<CoreResponseDto> createBus(@Valid @RequestBody BusRequestDto busRequestDto) {
        return ResponseEntity.ok(busService.addBus(busRequestDto));
    }

    @GetMapping("/bus/{id}")
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<CoreResponseDto> getBus(@PathVariable String id) {
        return ResponseEntity.ok(busService.getBus(id));
    }

    @PutMapping("/bus/{id}")
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<CoreResponseDto> updateBus(@PathVariable String id,
                                                     @RequestBody @Valid BusRequestDto busRequestDto) {
        return ResponseEntity.ok(busService.updateBus(id, busRequestDto));
    }

    @DeleteMapping("/bus/{id}")
    @SecurityRequirement(name = "Authorization")
    public ResponseEntity<CoreResponseDto> deleteBus(String id) {
        return ResponseEntity.ok(busService.deleteBus(id));
    }

}
