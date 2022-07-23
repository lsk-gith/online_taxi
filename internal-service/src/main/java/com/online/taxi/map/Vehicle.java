package com.online.taxi.map;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 16:06
 * @Description: com.online.taxi.map
 * @version: 1.0
 */
@Data
public class Vehicle {
    private String vehicleId;

    private String longitude;

    private String latitude;

    private String distance;
}
