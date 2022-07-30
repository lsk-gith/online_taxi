package com.online.taxi.cosntant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: lsk
 * @Date: 2022/7/30 - 07 - 30 - 17:36
 * @Description: com.online.taxi.cosntant
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
public enum ChargingCategoryEnum implements CodeEnum{
    /**
     * 预估订单: 0
     */
    Forecast(0, "预约"),

    /**
     * 结算订单: 1
     */
    Settlement(1, "结算"),

    /**
     * 实时订单: 2
     */
    RealTime(2, "实时");

    private int code;
    private String name;
}
