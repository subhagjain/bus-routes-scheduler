package com.javamasters.service;

import com.javamasters.model.LocationEntity;

import java.util.List;

/**
 * @Author: subhag.jain
 * date: 12/12/23
 * project: BusRoutingScheduler
 */
public interface LocationService {
    List<LocationEntity> getAllLocations();

    boolean locationExists(String locationId);
}
