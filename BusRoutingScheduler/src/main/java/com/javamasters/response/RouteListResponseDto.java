package com.javamasters.response;

import com.javamasters.model.RouteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * @Author: subhag.jain
 * date: 04/12/23
 * project: BusRoutingScheduler
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class RouteListResponseDto extends CoreResponseDto {
    private List<RouteEntity> routes;
}
