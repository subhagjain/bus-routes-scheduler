package com.javamasters.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * @Author: subhag.jain
 * date: 03/12/23
 * project: BusRoutingScheduler
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "routes")
@Builder
public class RouteEntity {
    @Id
    private String id;

    private String busId;

    private String source;

    private String destination;

    private LocalTime startTime;

    private LocalTime endTime;

    private DayOfWeek weekday;
}
