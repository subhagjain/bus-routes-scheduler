package com.javamasters.service.impl;

import com.javamasters.dao.BusDaoService;
import com.javamasters.dao.RouteDaoService;
import com.javamasters.exceptions.ValidationException;
import com.javamasters.model.BusEntity;
import com.javamasters.model.RouteEntity;
import com.javamasters.request.RouteRequestDto;
import com.javamasters.response.RouteListResponseDto;
import com.javamasters.response.RouteResponseDto;
import com.javamasters.service.LocationService;
import com.javamasters.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 * @Author: subhag.jain
 * date: 03/12/23
 * project: BusRoutingScheduler
 */

@Service
public class RouteServiceImpl implements RouteService {
    @Autowired
    RouteDaoService routeDaoService;
    @Autowired
    BusDaoService busDaoService;
    @Autowired
    LocationService locationService;

    @Override
    public RouteResponseDto createRoute(RouteRequestDto routeRequestDto) {
        validateCreateRouteRequest(routeRequestDto);
        RouteEntity routeEntity = getRouteEntity(routeRequestDto);
        RouteEntity savedRouteEntity = routeDaoService.createRoute(routeEntity);
        return RouteResponseDto.builder()
                .route(savedRouteEntity)
                .operationSuccessful(true)
                .message("Route created successfully")
                .build();
    }


    @Override
    public RouteResponseDto getRoute(String routeId) {
        RouteEntity routeEntity = routeDaoService.getRoute(routeId);
        return RouteResponseDto.builder()
                .route(routeEntity)
                .operationSuccessful(true)
                .message("Route fetched successfully")
                .build();
    }

    @Override
    public RouteResponseDto updateRoute(String id, RouteRequestDto routeRequestDto) {
        RouteEntity routeEntity = getRouteEntity(id, routeRequestDto);
        validateUpdateRouteRequest(routeEntity);
        RouteEntity route = routeDaoService.updateRoute(routeEntity);
        return RouteResponseDto.builder()
                .route(route)
                .operationSuccessful(true)
                .message("Route updated successfully")
                .build();
    }


    @Override
    public RouteResponseDto deleteRoute(String routeId) {
        routeDaoService.deleteRoute(routeId);
        return RouteResponseDto.builder()
                .operationSuccessful(true)
                .message("Route deleted successfully")
                .build();
    }

    @Override
    public RouteListResponseDto getAllRoutesOfBus(String busRegNumber) {
        Optional<BusEntity> busEntity = busDaoService.findBusByRegNumber(busRegNumber);
        String busId;
        if (busEntity.isPresent())
            busId = busEntity.get().getId();
        else
            throw new ValidationException("Bus with reg number " + busRegNumber + " does not exist");
        List<RouteEntity> routeEntities = routeDaoService.getAllRoutesByBusId(busId);
        return RouteListResponseDto.builder()
                .routes(routeEntities)
                .operationSuccessful(true)
                .message("Routes fetched successfully")
                .build();
    }

    private void validateCreateRouteRequest(RouteRequestDto routeRequestDto) {
        busDaoService.getBus(routeRequestDto.getBusId());
        checkLocation(routeRequestDto.getSource());
        checkLocation(routeRequestDto.getDestination());
        List<RouteEntity> routeEntities = routeDaoService.getAllRoutesByBusId(routeRequestDto.getBusId());
        if (routeRequestDto.getStartTime().isAfter(routeRequestDto.getEndTime()) || routeRequestDto.getStartTime().equals(routeRequestDto.getEndTime())) {
            throw new ValidationException("Start time cannot be after/equal to end time");
        }

        boolean conflictExists = routeEntities.stream().anyMatch(existingRoute ->
                existingRoute.getWeekday().name().equals(routeRequestDto.getWeekday()) &&
                        ((timeEqualOrAfter(routeRequestDto.getStartTime(), existingRoute.getStartTime()) && timeEqualOrBefore(routeRequestDto.getStartTime(), existingRoute.getEndTime())) ||
                                (timeEqualOrAfter(routeRequestDto.getEndTime(), existingRoute.getStartTime()) && timeEqualOrBefore(routeRequestDto.getEndTime(), existingRoute.getEndTime())))
        );
        if (conflictExists) {
            throw new ValidationException("Route already exists for the given time slot");
        }

    }

    private void checkLocation(String location) {
        if (!locationService.locationExists(location)) {
            throw new ValidationException("Location " + location + "does not exist");
        }
    }

    private boolean timeEqualOrAfter(LocalTime a, LocalTime b) {
        return a.equals(b) || a.isAfter(b);
    }

    private boolean timeEqualOrBefore(LocalTime a, LocalTime b) {
        return a.equals(b) || a.isBefore(b);
    }

    private void validateUpdateRouteRequest(RouteEntity routeEntity) {
        busDaoService.getBus(routeEntity.getBusId());
        checkLocation(routeEntity.getSource());
        checkLocation(routeEntity.getDestination());
        List<RouteEntity> routeEntities = routeDaoService.getAllRoutesByBusId(routeEntity.getBusId());
        boolean conflictExists = routeEntities.stream().anyMatch(existingRoute ->
                (!existingRoute.getId().equals(routeEntity.getId())) &&
                        existingRoute.getWeekday().equals(routeEntity.getWeekday()) &&
                        ((routeEntity.getStartTime().isAfter(existingRoute.getStartTime()) && routeEntity.getStartTime().isBefore(existingRoute.getEndTime())) ||
                                (routeEntity.getEndTime().isAfter(existingRoute.getStartTime()) && routeEntity.getEndTime().isBefore(existingRoute.getEndTime())))
        );
        if (conflictExists) {
            throw new ValidationException("Route already exists for the given time slot");
        }
    }

    private RouteEntity getRouteEntity(String id, RouteRequestDto routeRequestDto) {
        return RouteEntity.builder()
                .id(id)
                .busId(routeRequestDto.getBusId())
                .source(routeRequestDto.getSource())
                .destination(routeRequestDto.getDestination())
                .startTime(routeRequestDto.getStartTime())
                .endTime(routeRequestDto.getEndTime())
                .weekday(DayOfWeek.valueOf(routeRequestDto.getWeekday()))
                .build();
    }

    private RouteEntity getRouteEntity(RouteRequestDto routeRequestDto) {
        return RouteEntity.builder()
                .busId(routeRequestDto.getBusId())
                .source(routeRequestDto.getSource())
                .destination(routeRequestDto.getDestination())
                .startTime(routeRequestDto.getStartTime())
                .endTime(routeRequestDto.getEndTime())
                .weekday(DayOfWeek.valueOf(routeRequestDto.getWeekday()))
                .build();
    }
}
