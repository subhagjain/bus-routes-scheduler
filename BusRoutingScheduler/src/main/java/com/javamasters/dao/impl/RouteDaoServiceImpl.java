package com.javamasters.dao.impl;

import com.javamasters.dao.RouteDaoService;
import com.javamasters.exceptions.RecordNotFoundException;
import com.javamasters.model.RouteEntity;
import com.javamasters.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: subhag.jain
 * date: 03/12/23
 * project: BusRoutingScheduler
 */

@Service
public class RouteDaoServiceImpl implements RouteDaoService {
    @Autowired
    RouteRepository routeRepository;

    @Override
    public RouteEntity createRoute(RouteEntity routeEntity) {
        return routeRepository.save(routeEntity);
    }

    public RouteEntity getRoute(String routeId) {
        return routeRepository.findById(routeId).orElseThrow(() -> new RecordNotFoundException("Route with id " + routeId + " not found"));
    }

    public void deleteRoute(String routeId) {
        getRoute(routeId);
        routeRepository.deleteById(routeId);

    }

    public RouteEntity updateRoute(RouteEntity routeEntity) {
        getRoute(routeEntity.getId());
        return routeRepository.save(routeEntity);
    }

    @Override
    public List<RouteEntity> getAllRoutesByBusId(String busId) {
        return routeRepository.findAllByBusId(busId);
    }


}
