package com.javamasters.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * @Author: subhag.jain
 * date: 11/12/23
 * project: BusRoutingScheduler
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteRequestDto {
    @NotBlank(message = "Bus Id cannot be empty")
    private String busId;

    @NotBlank(message = "Source cannot be empty")
    private String source;

    @NotBlank(message = "Destination cannot be empty")
    private String destination;

    //    @NotBlank(message = "Start Time cannot be empty")
    private LocalTime startTime;

    //    @NotBlank(message = "End Time cannot be empty")
    private LocalTime endTime;

    @Pattern(regexp = "MONDAY|TUESDAY|WEDNESDAY|THURSDAY|FRIDAY|SATURDAY|SUNDAY", message = "Weekday should be one of MONDAY|TUESDAY|WEDNESDAY|THURSDAY|FRIDAY|SATURDAY|SUNDAY")
    private String weekday;
}
