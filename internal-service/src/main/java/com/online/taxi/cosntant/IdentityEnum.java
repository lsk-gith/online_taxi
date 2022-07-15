package com.online.taxi.cosntant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 21:59
 * @Description: com.online.taxi.cosntant
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
public enum IdentityEnum implements CodeEnum{
    /**
     * 乘客
     */
    PASSENGER(1, "乘客"),

    /**
     * 司机
     */
    DRIVER(2, "司机"),

    /**
     * 车机
     */
    CAR_SCREEN(3, "车机"),

    /**
     * 大屏
     */
    LARGE_SCREEN(4, "大屏"),

    /**
     *
     */
    OTHER(9, "其他身份");
    private final int code;
    private final String value;
}
