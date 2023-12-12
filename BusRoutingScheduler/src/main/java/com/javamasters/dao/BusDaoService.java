package com.javamasters.dao;

import com.javamasters.model.BusEntity;

import java.util.Optional;

/**
 * @Author: subhag.jain
 * date: 03/12/23
 * project: BusRoutingScheduler
 */
public interface BusDaoService {
    BusEntity saveBus(BusEntity busEntity);

    BusEntity getBus(String busId);

    void deleteBus(String busId);

    BusEntity updateBus(BusEntity busEntity);

    Optional<BusEntity> findBusByRegNumber(String busRegNumber);
}
