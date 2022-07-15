package com.online.taxi.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 22:09
 * @Description: com.online.taxi.accountservice.response
 * @version: 1.0
 */
@Data
public class PassengerRegistResponse {
    private String status;

    private String accessToken ;

    private String phoneNum;

    private Byte gender;

    private Integer id;

    private String passengerName;

    private BigDecimal balance;

    private String headImg;

    private String jpushId;

    private int lastLoginMethod;

    private Date LastLoginTime;

    private Integer isContact;

    private Integer isShare;

    private String sharingTime;

    private Long birthday;

    private Integer isNewer;
}
