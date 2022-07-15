package com.online.taxi.response;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/18 - 07 - 18 - 22:40
 * @Description: com.online.taxi.response
 * @version: 1.0
 */
@Data
public class DriverRegistResponse {
    private String accessToken ;

    private String phoneNumber;

    private Integer gerder;

    private String driverName;

    private Integer checkStatus;

    private String headImg;

    private Integer driverId;

    private String jpushId;

    private String workStatus;
}
