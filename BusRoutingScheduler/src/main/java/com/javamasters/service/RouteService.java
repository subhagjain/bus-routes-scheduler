package com.javamasters.service;

import com.javamasters.request.RouteRequestDto;
import com.javamasters.response.RouteListResponseDto;
import com.javamasters.response.RouteResponseDto;

/**
 * @Author: subhag.jain
 * date: 03/12/23
 * project: BusRoutingScheduler
 */
public interface RouteService {
    RouteResponseDto createRoute(RouteRequestDto routeRequestDto);

    RouteResponseDto getRoute(String routeId);

    RouteResponseDto updateRoute(String id, RouteRequestDto routeRequestDto);

    RouteResponseDto deleteRoute(String routeId);

    RouteListResponseDto getAllRoutesOfBus(String busRegNumber);
}
