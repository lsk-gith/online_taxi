package com.online.taxi.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 17:53
 * @Description: com.online.taxi.accountservice.request
 * @version: 1.0
 */
@Data
public class GetTokenRequest {
    private String phoneNum;

    private String verifyCode;

    private Integer id;

    private Integer type;

    private Integer identityStatus;

    private String equipType;

    private Double longitude;

    private Double latitude;

    private Double speed;

    private Double accuracy;

    private Double direction;

    private Double height;

    private String city;

    private String token;

    private String registerSource;

    private String marketChannel;
}
