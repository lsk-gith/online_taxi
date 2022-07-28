package com.online.taxi.dto.map.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/28 - 07 - 28 - 22:15
 * @Description: com.online.taxi.dto.map.request
 * @version: 1.0
 */
@Data
public class RouteRequest {
    private String vehicleId;

    private String city;

    private Long startTime;

    private Long endTime;

    private String correction;
}
