package com.javamasters.service.impl;

import com.javamasters.dao.BusDaoService;
import com.javamasters.enums.BusType;
import com.javamasters.exceptions.ValidationException;
import com.javamasters.model.BusEntity;
import com.javamasters.request.BusRequestDto;
import com.javamasters.response.BusResponseDto;
import com.javamasters.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: subhag.jain
 * date: 03/12/23
 * project: BusRoutingScheduler
 */

@Service
public class BusServiceImpl implements BusService {
    @Autowired
    private BusDaoService busDaoService;

    @Override
    public BusResponseDto getBus(String id) {
        BusEntity busEntity = busDaoService.getBus(id);
        return BusResponseDto.builder()
                .bus(busEntity)
                .operationSuccessful(true)
                .message("Bus fetched successfully")
                .build();
    }

    @Override
    public BusResponseDto addBus(BusRequestDto busRequestDto) {
        BusEntity busEntity = getBusEntity(busRequestDto);
        busDuplicateCheck(busEntity);
        BusEntity savedBusEntity = busDaoService.saveBus(busEntity);
        return BusResponseDto.builder()
                .bus(savedBusEntity)
                .operationSuccessful(true)
                .message("Bus saved successfully")
                .build();
    }

    @Override
    public BusResponseDto updateBus(String id, BusRequestDto busRequestDto) {
        BusEntity busEntity = getBusEntity(id, busRequestDto);
        busDuplicateCheck(busEntity);
        BusEntity updatedBusEntity = busDaoService.updateBus(busEntity);
        return BusResponseDto.builder()
                .bus(updatedBusEntity)
                .operationSuccessful(true)
                .message("Bus updated successfully")
                .build();
    }

    @Override
    public BusResponseDto deleteBus(String id) {
        busDaoService.deleteBus(id);
        return BusResponseDto.builder()
                .operationSuccessful(true)
                .message("Bus deleted successfully")
                .build();


    }

    private void busDuplicateCheck(BusEntity busEntity) {
        if (busDaoService.findBusByRegNumber(busEntity.getBusRegNumber()).isPresent()) {
            throw new ValidationException("Bus with reg number : " + busEntity.getBusRegNumber() + " already exists");
        }
    }

    private BusEntity getBusEntity(BusRequestDto busRequestDto) {
        return BusEntity.builder()
                .busRegNumber(busRequestDto.getBusRegNumber())
                .busName(busRequestDto.getBusName())
                .busType(BusType.valueOf(busRequestDto.getBusType()))
                .build();
    }

    private BusEntity getBusEntity(String id, BusRequestDto busRequestDto) {
        return BusEntity.builder()
                .id(id)
                .busRegNumber(busRequestDto.getBusRegNumber())
                .busName(busRequestDto.getBusName())
                .busType(BusType.valueOf(busRequestDto.getBusType()))
                .build();
    }

}
