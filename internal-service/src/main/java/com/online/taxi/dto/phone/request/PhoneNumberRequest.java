package com.online.taxi.dto.phone.request;

import lombok.Data;

/**
 * @Auther: lsk
 * @Date: 2022/7/28 - 07 - 28 - 22:23
 * @Description: com.online.taxi.dto.phone.request
 * @version: 1.0
 */
@Data
public class PhoneNumberRequest {
    /**
     * 司机电话
     */
    private String driverPhone;

    /**
     * 乘客电话
     */
    private String passengerPhone;

    /**
     * 订单开始时间
     * 绑定关系对应的失效时间-不能早于当前系统时间
     */
    private String expiration;

    /**
     * 绑定手机号ID
     */
    private String subsId;

    /**
     * 绑定的手机号
     */
    private String secretNo;
}
