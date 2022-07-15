package com.online.taxi.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/18 - 07 - 18 - 22:45
 * @Description: com.online.taxi.request
 * @version: 1.0
 */
@Data
public class DriverWorkStatusRequest {
    private Integer id;

    private Integer workStatus;

    private Integer csWorkStatus;

    private Integer isFollowing;

    private Integer status;

    private Double longitude;

    private Double latitude;

    private String city;

    private Double speed;

    private Double accuracy;

    private Double direction;

    private Double height;

    private Integer locationType;

    private String phoneNum;
}
