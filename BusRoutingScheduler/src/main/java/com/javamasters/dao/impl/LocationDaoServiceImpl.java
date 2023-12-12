package com.javamasters.dao.impl;

import com.javamasters.dao.LocationDaoService;
import com.javamasters.model.LocationEntity;
import com.javamasters.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Author: subhag.jain
 * date: 12/12/23
 * project: BusRoutingScheduler
 */

@Service
public class LocationDaoServiceImpl implements LocationDaoService {
    @Autowired
    LocationRepository locationRepository;

    public LocationDaoServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
        if (locationRepository.count() == 0) {
            locationRepository.save(new LocationEntity("Delhi"));
            locationRepository.save(new LocationEntity("Mumbai"));
            locationRepository.save(new LocationEntity("Bangalore"));
            locationRepository.save(new LocationEntity("Chennai"));
            locationRepository.save(new LocationEntity("Kolkata"));
            locationRepository.save(new LocationEntity("Hyderabad"));
            locationRepository.save(new LocationEntity("Pune"));
            locationRepository.save(new LocationEntity("Ahmedabad"));
            locationRepository.save(new LocationEntity("Jaipur"));
            locationRepository.save(new LocationEntity("Surat"));
            locationRepository.save(new LocationEntity("Kanpur"));
            locationRepository.save(new LocationEntity("Lucknow"));
            locationRepository.save(new LocationEntity("Nagpur"));
            locationRepository.save(new LocationEntity("Patna"));
            locationRepository.save(new LocationEntity("Indore"));
            locationRepository.save(new LocationEntity("Vadodara"));
            locationRepository.save(new LocationEntity("Bhopal"));
            locationRepository.save(new LocationEntity("Coimbatore"));
            locationRepository.save(new LocationEntity("Ludhiana"));
            locationRepository.save(new LocationEntity("Kochi"));
            locationRepository.save(new LocationEntity("Visakhapatnam"));
            locationRepository.save(new LocationEntity("Agra"));
            locationRepository.save(new LocationEntity("Varanasi"));
            locationRepository.save(new LocationEntity("Madurai"));
            locationRepository.save(new LocationEntity("Meerut"));
            locationRepository.save(new LocationEntity("Nashik"));
            locationRepository.save(new LocationEntity("Jabalpur"));

        }

    }


    @Override
    public Optional<LocationEntity> getLocationByName(String locationName) {
        return locationRepository.findByLocationName(locationName);
    }

    @Override
    public List<LocationEntity> getAllLocations() {
        return locationRepository.findAllSorted();
    }
}
