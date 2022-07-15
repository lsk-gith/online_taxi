package com.lsk.apipassager.feign.response;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: lsk
 * @Date: 2022/7/15 - 07 - 15 - 23:14
 * @Description: com.lsk.apipassager.feign.response
 * @version: 1.0
 */
@Data
public class PassengerUserInfo {
    private Long id;

    private Date registerDate;

    private String passengerPhone;

    private String passengerName;

    private Byte passengerGender;

    private Byte userState;

    private Date createTime;

    private Date updateTime;
}
