package com.javamasters.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author: subhag.jain
 * date: 03/12/23
 * project: BusRoutingScheduler
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CoreResponseDto {
    private Boolean operationSuccessful;
    private String message;
}
