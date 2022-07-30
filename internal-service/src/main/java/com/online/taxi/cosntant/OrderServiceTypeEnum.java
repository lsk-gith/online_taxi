package com.online.taxi.cosntant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: lsk
 * @Date: 2022/7/30 - 07 - 30 - 16:02
 * @Description: com.online.taxi.cosntant
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
public enum OrderServiceTypeEnum {
    /**
     * 实时订单
     */
    REAL_TIME(1,"实时订单"),

    /**
     * 预约订单
     */
    MAKE_AN_APPOINTMENT(2,"预约订单"),

    /**
     * 接机
     */
    PICK_UP(3,"接机"),

    /**
     * 送机
     */
    SEND_MACHINE(4,"送机"),

    /**
     * 半日租
     */
    CHARTERED_CAR(5,"半日租"),
    /**
     * 全日租
     */
    THROUGHOUT_THE_DAY(6,"全日租");

    private int code;
    private String value;
}
