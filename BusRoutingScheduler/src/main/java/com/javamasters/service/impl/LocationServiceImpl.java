package com.javamasters.service.impl;

import com.javamasters.dao.LocationDaoService;
import com.javamasters.model.LocationEntity;
import com.javamasters.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: subhag.jain
 * date: 12/12/23
 * project: BusRoutingScheduler
 */

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    LocationDaoService locationDaoService;

    @Override
    public List<LocationEntity> getAllLocations() {
        return locationDaoService.getAllLocations();
    }

    @Override
    public boolean locationExists(String locationId) {
        return locationDaoService.getLocationByName(locationId).isPresent();
    }
}
