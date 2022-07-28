package com.online.taxi.cosntant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Auther: lsk
 * @Date: 2022/7/28 - 07 - 28 - 22:50
 * @Description: com.online.taxi.cosntant
 * @version: 1.0
 */
@Getter
@AllArgsConstructor
public enum EnableDisableEnum implements CodeEnum{
    ENABLE(0,"未启用"),
    DISABLE(1, "启用");
    private int code;
    private String value;
}
