package com.javamasters.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: subhag.jain
 * date: 04/12/23
 * project: BusRoutingScheduler
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusRequestDto {
    @NotEmpty(message = "Bus Reg Number cannot be empty")
    private String busRegNumber;

    @NotEmpty(message = "Bus Name cannot be empty")
    private String busName;


    @Pattern(regexp = "ORDINARY|DELUXE", message = "Bus Type must be either ORDINARY or DELUXE")
    private String busType;
}
