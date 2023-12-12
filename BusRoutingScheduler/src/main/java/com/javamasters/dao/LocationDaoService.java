package com.javamasters.dao;

import com.javamasters.model.LocationEntity;

import java.util.List;
import java.util.Optional;

/**
 * @Author: subhag.jain
 * date: 12/12/23
 * project: BusRoutingScheduler
 */
public interface LocationDaoService {
    Optional<LocationEntity> getLocationByName(String locationName);

    List<LocationEntity> getAllLocations();

}
