package com.online.taxi.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 17:16
 * @Description: com.online.taxi.request
 * @version: 1.0
 */
@Data
public class UpdateDriverAddressRequest {
    private Integer id;

    private String phoneNumber;

    private String addressLongitude;

    private String addressLatitude;

    private String address;
}
