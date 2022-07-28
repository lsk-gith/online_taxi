package com.online.taxi.dto.map.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/26 - 07 - 26 - 22:04
 * @Description: com.online.taxi.dto.map.request
 * @version: 1.0
 */
@Data
public class DistanceRequest {
    private String originLongitude;

    private String originLatitude;

    private String destinationLongitude;

    private String destinationLatitude;
}
