package com.javamasters.model;

import com.javamasters.enums.BusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Author: subhag.jain
 * date: 03/12/23
 * project: BusRoutingScheduler
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "buses")
@Builder
public class BusEntity {
    @Id
    private String id;
    private String busRegNumber;
    private String busName;
    private BusType busType;

}
