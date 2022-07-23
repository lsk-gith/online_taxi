package com.online.taxi.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/23 - 07 - 23 - 16:22
 * @Description: com.online.taxi.request
 * @version: 1.0
 */
@Data
public class DistanceRequest {
    private String originLongitude;

    private String originLatitude;

    private String destinationLongitude;

    private String destinationLatitude;
}
