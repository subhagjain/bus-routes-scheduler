package com.javamasters.dao.impl;

import com.javamasters.dao.BusDaoService;
import com.javamasters.exceptions.RecordNotFoundException;
import com.javamasters.model.BusEntity;
import com.javamasters.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: subhag.jain
 * date: 03/12/23
 * project: BusRoutingScheduler
 */
@Service
public class BusDaoServiceImpl implements BusDaoService {
    @Autowired
    BusRepository busRepository;

    @Override
    public BusEntity saveBus(BusEntity busEntity) {
        return busRepository.save(busEntity);
    }

    @Override
    public BusEntity getBus(String busId) {
        return busRepository.findById(busId).orElseThrow(() -> new RecordNotFoundException("Bus with id : " + busId + " not found"));
    }

    @Override
    public void deleteBus(String busId) {
        getBus(busId);
        busRepository.deleteById(busId);
    }

    @Override
    public BusEntity updateBus(BusEntity busEntity) {
        getBus(busEntity.getId());
        return busRepository.save(busEntity);

    }

    @Override
    public Optional<BusEntity> findBusByRegNumber(String busRegNumber) {
        return busRepository.findByBusRegNumber(busRegNumber);
    }

}
